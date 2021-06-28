package com.retail.store.billing.service

import com.retail.store.billing.dto.BillCreateRequest
import com.retail.store.billing.model.Bill
import com.retail.store.billing.model.Category
import com.retail.store.billing.model.User
import com.retail.store.billing.model.UserType
import com.retail.store.billing.repository.BillRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.math.floor

@Service
class BillService {
@Autowired
private lateinit var billRepository: BillRepository
@Autowired
private lateinit var userService: UserService
@Autowired
private  lateinit var productService: ProductService
    fun getBills() : List<Bill>{
        return  billRepository.findAll()
    }
    fun getBillById(id:Long) : Bill {
        return  billRepository.getById(id)
    }
    fun delete(id: Long) : String {
        billRepository.deleteById(id)
        return  "Bill Deleted SuccessFully"
    }

    fun create(cart: BillCreateRequest): Bill {
        val user = userService.getUserById(cart.userId)
        val (cartValue, cartGroceryValue) = getCartValue(cart)
        val  amountPayable = applyUserDiscount(cartValue, cartGroceryValue, user)
         val bill = Bill(0,userId = user.id, cartValue = cartValue, totalPayableAmount = amountPayable)
        return billRepository.save(bill)
    }
    fun getCartValue(cart: BillCreateRequest) : List<Double>{
        var cartValue  = 0.0
        var cartGroceryValue  = 0.0
        for (item in cart.cartList){
            val product = productService.getProductById(item.productId)
            val productValue = product.price * item.quantity
            cartValue+=productValue
            if (product.category == Category.GROCERY)
                cartGroceryValue+=productValue
        }
        return listOf(cartValue,cartGroceryValue)
    }

    fun applyUserDiscount(cartValue: Double, cartGroceryValue: Double, user: User): Double {
        var discountPercentage =0
        if (user.type == UserType.EMPLOYEE || user.type == UserType.AFFILIATE || user.isEligibleForDiscount()){
            discountPercentage= user.type.getDiscountPercentage()
        }
        println(discountPercentage)
        var discountValue = cartValue - cartGroceryValue
        discountValue = discountValue * discountPercentage / 100
        println(discountValue)
        val amountAfterUserDiscount = cartValue - discountValue
        println(amountAfterUserDiscount)
        return (amountAfterUserDiscount - floor(amountAfterUserDiscount / 100) * 5)

    }
}
package com.retail.store.billing

import com.retail.store.billing.dto.BillCreateRequest
import com.retail.store.billing.dto.CartItemCreateDto
import com.retail.store.billing.model.*
import com.retail.store.billing.service.BillService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock

import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime


@SpringBootTest
class BillingApplicationTests() {

	@Mock
	var cartItemList : MutableList<CartItemCreateDto>? = null
	@InjectMocks
	lateinit var billService : BillService

	@BeforeEach
	fun before(){
		var product1 = Product(1,"Laptop",Category.ELECTRONICS,1000.0)
		var product2 = Product(2,"Shirt",Category.GROCERY,100.0)
		var product3 = Product(3,"Rice",Category.FASHION,10.0)

		cartItemList = ArrayList()
		var item = CartItemCreateDto(1,1)
		(cartItemList as ArrayList<CartItemCreateDto>).add(item)

		item =  CartItemCreateDto(2,1)
		(cartItemList as ArrayList<CartItemCreateDto>).add(item)

		item =  CartItemCreateDto(3,1)
		(cartItemList as ArrayList<CartItemCreateDto>).add(item)
	}
	@Test
	fun contextLoads() {
	}

	@Test
	fun testEmployeeDiscount(){
		val user = User(1,"bhaskar","1234567890",UserType.EMPLOYEE)
		val billRequest = cartItemList?.let { BillCreateRequest(user.id, it) }
		if (billRequest != null) {
			val afterUserDiscount :Double = billService.applyUserDiscount(1110.0,100.0, user)
			Assertions.assertEquals(767.0,afterUserDiscount)
		}
	}

	@Test
	fun testAffiliateDiscount(){
		val user = User(2,"bhaskar","1234567890",UserType.AFFILIATE)
		val billRequest = cartItemList?.let { BillCreateRequest(user.id, it) }
		if (billRequest != null) {
			val afterUserDiscount :Double = billService.applyUserDiscount(1110.0,100.0, user)
			Assertions.assertEquals(959.0,afterUserDiscount)
		}
	}

	@Test
	fun testCustomerDiscount(){
		val user = User(2,"bhaskar","1234567890",UserType.CUSTOMER)
		val billRequest = cartItemList?.let { BillCreateRequest(user.id, it) }
		if (billRequest != null) {
			val afterUserDiscount :Double = billService.applyUserDiscount(1110.0,100.0, user)
			Assertions.assertEquals(1055.0,afterUserDiscount)
		}
	}

	@Test
	fun testOldCustomerDiscount(){
		val user = User(2,"bhaskar","1234567890",UserType.CUSTOMER)
		user.registeredAt= LocalDateTime.now().minusYears(3)
		val billRequest = cartItemList?.let { BillCreateRequest(user.id, it) }
		if (billRequest != null) {
			val afterUserDiscount :Double = billService.applyUserDiscount(1110.0,100.0, user)
			Assertions.assertEquals(1009.5,afterUserDiscount)
		}
	}


}

package com.retail.store.billing.dto

class BillCreateRequest (val userId:Long,val cartList: List<CartItemCreateDto>)
class CartItemCreateDto(val productId : Long,var quantity:Int)
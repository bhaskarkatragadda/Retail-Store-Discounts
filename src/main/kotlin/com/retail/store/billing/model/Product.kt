package com.retail.store.billing.model


import javax.persistence.*

@Entity
@Table
data class Product(
    @Id
    @GeneratedValue
    val id:Long,
    val name:String,
    val category: Category,
    val price:Double) {

}

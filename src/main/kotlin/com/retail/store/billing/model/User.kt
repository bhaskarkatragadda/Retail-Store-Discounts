package com.retail.store.billing.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
data class User(
    @Id
    @GeneratedValue
    var id:Long,
    val name:String,
    var phone:String,
    val type: UserType,
    var registeredAt:LocalDateTime = LocalDateTime.now()){
    fun isEligibleForDiscount() : Boolean {
        val currentDateTime = LocalDateTime.now().minusYears(2)
        return registeredAt.isBefore(currentDateTime) && (type == UserType.CUSTOMER)
    }
}
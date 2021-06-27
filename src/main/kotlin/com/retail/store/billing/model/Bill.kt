package com.retail.store.billing.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table
data class Bill(
    @Id
    @GeneratedValue
    val id:Long?,
    val userId:Long,
    val cartValue:Double,
    val totalPayableAmount:Double,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
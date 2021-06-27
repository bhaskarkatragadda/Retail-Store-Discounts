package com.retail.store.billing.repository

import com.retail.store.billing.model.Bill
import org.springframework.data.jpa.repository.JpaRepository

interface BillRepository: JpaRepository<Bill,Long>
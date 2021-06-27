package com.retail.store.billing.repository

import com.retail.store.billing.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product,Long>
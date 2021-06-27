package com.retail.store.billing.repository

import com.retail.store.billing.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User,Long>
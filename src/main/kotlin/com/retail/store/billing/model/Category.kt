package com.retail.store.billing.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

enum class Category {
    ELECTRONICS, FASHION, GROCERY, APPLIANCES, TOYS, BEAUTY, STATIONARY, OTHER
}


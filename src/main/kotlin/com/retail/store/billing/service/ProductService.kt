package com.retail.store.billing.service

import com.retail.store.billing.model.Product
import com.retail.store.billing.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService {
    @Autowired
    private lateinit var repository: ProductRepository

    fun getProducts(): List<Product>{
        return repository.findAll()
    }

    fun getProductById(id:Long) : Product {
        return repository.getById(id)
    }

    fun createProduct(product: Product) : String{
        repository.save(product)
        return  "Product Created Successfully"
    }

    fun deleteProduct(id:Long) : String{
        repository.deleteById(id)
        return  "Product Deleted Successfully"
    }
}
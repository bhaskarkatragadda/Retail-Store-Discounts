package com.retail.store.billing.controller

import com.retail.store.billing.model.Product
import com.retail.store.billing.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("products")
class ProductController {
    @Autowired
    private lateinit var service : ProductService

    @GetMapping("/getAll")
    fun getProducts() : List<Product>{
        return service.getProducts()
    }

    @GetMapping("/getById/{id}")
    fun getProductById(@PathVariable id: Long) : Product {
        return  service.getProductById(id)
    }

    @PostMapping("/create")
    fun create(@RequestBody product: Product) : String {
        service.createProduct(product)
        return  "Product Added Successfully"
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long) : String{
        service.deleteProduct(id)
        return  "Product Deleted Successfully"
    }

}
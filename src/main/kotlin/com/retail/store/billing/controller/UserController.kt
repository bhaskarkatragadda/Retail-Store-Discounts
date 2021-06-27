package com.retail.store.billing.controller

import com.retail.store.billing.model.User
import com.retail.store.billing.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users")
class UserController {
    @Autowired
    private lateinit var service : UserService

    @GetMapping("/test")
    fun test():String{
        return "HI"
    }
    @GetMapping("/getAll")
    fun getUsers():List<User>{
        return service.getUsers()
    }

    @GetMapping("/getById/{id}")
    fun getUserById(@PathVariable id: Long):User{
        return service.getUserById(id)
    }

    @PostMapping("/create")
    fun createUser(@RequestBody user:User):String{
        return service.createUser(user)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteUser(@PathVariable id: Long) :String{
        return service.deleteUser(id)
    }

}
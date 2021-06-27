package com.retail.store.billing.service


import com.retail.store.billing.model.User
import com.retail.store.billing.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    private lateinit var repository : UserRepository

    fun getUsers() : List<User>{
        return repository.findAll()
    }

    fun getUserById(id:Long) : User {
        return repository.getById(id)
    }

    fun createUser(user :User) : String{
        repository.save(user)
        return  "User Created Successfully"
    }

    fun deleteUser(id: Long) :String{
        repository.deleteById(id)
        return "User Deleted Successfully"
    }
}
package com.retail.store.billing.controller

import com.retail.store.billing.dto.BillCreateRequest
import com.retail.store.billing.model.Bill
import com.retail.store.billing.service.BillService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("bills")
class BillController {
    @Autowired
    private lateinit var service : BillService

    @GetMapping("/getAll")
    fun getBills() : List<Bill>{
        return service.getBills()
    }

    @GetMapping("/getById/{id}")
    fun getBillById(@PathVariable id: Long) : Bill {
        return  service.getBillById(id)
    }

    @PostMapping("/create")
    fun create(@RequestBody billRequest : BillCreateRequest) :Bill{
        return  service.create(billRequest)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long) : String{
        return service.delete(id)
    }
}
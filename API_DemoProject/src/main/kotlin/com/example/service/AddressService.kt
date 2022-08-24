package com.example.service

import com.example.model.Customers
import com.example.repositary.CustomerRepositary


class AddressService{

    private val customersRepositary= CustomerRepositary()

    suspend fun createCustomer(params: Customers): Customers?{
        return customersRepositary.createCustomer(params)
    }
    suspend fun getCustomers():List<Customers?>{
        return customersRepositary.getCustomers()
    }
    suspend fun getCustomerById(cust_id:Int):List<Customers?>{
        return customersRepositary.getCustomerById(cust_id)
    }

}
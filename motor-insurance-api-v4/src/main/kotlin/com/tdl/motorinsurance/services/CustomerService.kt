package com.tdl.motorinsurance.services

import com.tdl.motorinsurance.entities.Customer
import com.tdl.motorinsurance.model.CustomerDTO
import com.tdl.motorinsurance.repositaries.CustomerRepository

class CustomerService {

    private val customerRepository = CustomerRepository()

    suspend fun saveCustomer(params: CustomerDTO): Int {
        return customerRepository.saveCustomer(params)
    }

    suspend fun getCustomers(): List<Customer> {
        return customerRepository.getCustomers()
    }
}

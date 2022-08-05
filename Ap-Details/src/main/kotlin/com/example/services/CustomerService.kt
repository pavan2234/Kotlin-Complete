package com.example.services

import com.example.EntityBindings.Customer
import com.example.EntityBindings.Customers
import com.example.dbconfig.DatabaseConnection
import org.ktorm.dsl.from
import org.ktorm.dsl.map
import org.ktorm.dsl.select

interface CustomerService {
    fun customer():List<Customer>
    fun customerById():List<Customer>
}
class subCustomerService:CustomerService{

    val db= DatabaseConnection.database
    override fun customer(): List<Customer> {
        val Totalcustomers=db.from(Customers).select().
        map { row -> Customers.createEntity(row) }
        return  Totalcustomers
    }

    override fun customerById(): List<Customer> {
        TODO("Not yet implemented")
    }

}
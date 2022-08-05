package com.example.services

import com.example.EntityBinding.customers
import com.example.database.DatabaseConnection
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import me.liuwj.ktorm.dsl.insert

fun Application.inserting(){
    val db =DatabaseConnection.database
    routing {
        get("/insertintocustomer") {
            val customerdetails= call.receive<com.example.dataclass.customer>()
            val customerid = customerdetails.customerid
            val cust_hash=customerdetails.cust_hash
            val name=customerdetails.name
            val phone_number=customerdetails.phone_number
            val email=customerdetails.email
            val created_at=customerdetails.created_at
            val updated_at=customerdetails.updated_at
            db.insert(customers){
                set(it.customerid,customerid)
                set(it.cust_hash,cust_hash)
                set(it.name,name)
                set(it.phone_number,phone_number)
                set(it.email,email)
                set(it.created_at,created_at)
                set(it.updated_at,updated_at)
            }
        }
    }
}
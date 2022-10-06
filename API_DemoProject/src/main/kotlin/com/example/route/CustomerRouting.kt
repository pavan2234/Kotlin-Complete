package com.example.route

import com.example.entities.Customer
import com.example.model.Customers
import com.example.service.CustomerService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureCustomerRouting() {

    val customerService = CustomerService()

    routing {
        route("/api/v1/customer") {

            post("/createCustomer") {
                var params = call.receive<Customers>()
                params = customerService.createCustomer(params)!!
                call.respond(params)
            }

            get ("/getAllCustomers"){
                call.respond(customerService.getCustomers())
            }
/*
            get("/getCustomerById"){
                var params=call.receive<Customers>()
                params=customerService.getCustomerById(Customer.cust_id)!!
                call.respond(params)
            }*/
        }
    }
}

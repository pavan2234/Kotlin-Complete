/*
package com.example.route

import com.example.model.Address
import com.example.model.Customers
import com.example.service.AddressService
import com.example.service.CustomerService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureAddressRouting() {

    val AddressService = AddressService()

    routing {
        route("/api/v1/address") {

            post("/createAddress") {
                var params = call.receive<Address>()
                params = AddressService.createCustomer(params)!!
                call.respond(params)
            }

            get ("/getAllCustomers"){
                call.respond(customerService.getCustomers())
            }
*/
/*
            get("/getCustomerById"){
                var params=call.receive<Customers>()
                params=customerService.getCustomerById(Customer.cust_id)!!
                call.respond(params)
            }*//*

        }
    }
}*/

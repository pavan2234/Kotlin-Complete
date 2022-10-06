package com.tdl.motorinsurance.routings

import com.tdl.motorinsurance.model.CustomerDTO
import com.tdl.motorinsurance.services.CustomerService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureCustomerRouting() {

    val customerService = CustomerService()

    routing {
        route("/api/v1/Customer") {

            post("/saveCustomer") {
                var params = call.receive<CustomerDTO>()
                print(params)
                val noOfrowsAffected = customerService.saveCustomer(params)
                if (noOfrowsAffected == 0)
                    call.respond("Something wrong...!")
                else
                    call.respond(params)
            }

            get("/getCustomers") {
                call.respond(customerService.getCustomers())
            }
        }
    }
}




package com.tdl.motorinsurance.routings

import com.tdl.motorinsurance.model.AddressDTO
import com.tdl.motorinsurance.services.AddressService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureAddressRouting() {

    val addressService = AddressService()

    routing {
        route("/api/v1/Address") {

            post("/saveAddressWithCustomerandVehicle") {
                var params = call.receive<AddressDTO>()
                val noOfrowsAffected = addressService.saveAddressWithCustomerandVehicle(params)
                if (noOfrowsAffected == 0)
                    call.respond("No rows Affected..!")
                else
                    call.respond(params)
            }

            get("/getAddress") {
                call.respond(addressService.getAddress())
            }

            get ("/AddressByid"){
                var params=call.receive<AddressDTO>()
                call.respond(addressService.UpdateAddressById(params))
            }

            get("/getAddessWithCustomersandVehicle") {
                call.respond(addressService.getAddressWithCustomersandVehicle())
            }

            put ("/UpdateAddress"){
                var params=call.receive<AddressDTO>()
                val noOfrowsAffected=addressService.updateAddressWithCustomersandVehicle(params)
                if(noOfrowsAffected ==0)
                    call.respond(params)
                else
                    call.respond(params)
            }
            get ("/DeleteById"){
                val params=call.receive<AddressDTO>()
                val no=addressService.deleteById(params)
                if(no==0)
                    call.respond("Ur selection Id is not there in the table..")
                else
                    call.respond("Successfully deleted")
            }
        }
    }
}

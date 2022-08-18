package com.tdl.motorinsurance.routings

import com.tdl.motorinsurance.model.VehicleDTO
import com.tdl.motorinsurance.model.Vehicle_DerivedDTO
import com.tdl.motorinsurance.services.VehicleService
import com.tdl.motorinsurance.services.Vehicle_DerivedService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureVehicleRouting(){
    val vehicleService = VehicleService()

    routing {
        route("/api/v1/vehicle") {

            post("/saveVehicleWithCustomer") {
                var params = call.receive<VehicleDTO>()
                val noOfrowsAffected = vehicleService.saveVehicleWithCustomer(params)
                if (noOfrowsAffected == 0)
                    call.respond("No rows Affected..!")
                else
                    call.respond(params)
            }
            get("/getVehicle") {
                call.respond(vehicleService.getVehile())
            }

            get ("/VehicleByid"){
                var params=call.receive<VehicleDTO>()
                call.respond(vehicleService.UpdateVehicleById(params))
            }

            get("/getVehicleWithCustomers") {
                call.respond(vehicleService.getVehicleWithCustomers())
            }

            put ("/UpdateVehicle"){
                var params=call.receive<VehicleDTO>()
                val noOfrowsAffected=vehicleService.updateVehicleWithCustomers(params)
                if(noOfrowsAffected ==0)
                    call.respond(params)
                else
                    call.respond(params)
            }
            get ("/DeleteById"){
                val params=call.receive<VehicleDTO>()
                val no=vehicleService.deleteById(params)
                if(no==0)
                    call.respond("Ur selection Id is not there in the table..")
                else
                    call.respond("Successfully deleted")
            }
        }
    }
}
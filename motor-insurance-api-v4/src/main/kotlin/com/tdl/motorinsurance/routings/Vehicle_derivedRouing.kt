package com.tdl.motorinsurance.routings

import com.tdl.motorinsurance.model.Vehicle_DerivedDTO
import com.tdl.motorinsurance.services.Vehicle_DerivedService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureVehicle_DerivedRouting(){
    val vehicle_derivedService = Vehicle_DerivedService()

    routing {
        route("/api/v1/vehicle_derived") {

            post("/saveVehicle_derivedWithCustomer") {
                var params = call.receive<Vehicle_DerivedDTO>()
                val noOfrowsAffected = vehicle_derivedService.saveVehicle_deivedWithCustomer(params)
                if (noOfrowsAffected == 0)
                    call.respond("No rows Affected..!")
                else
                    call.respond(params)
            }
            get("/getVehicle_Derived") {
                call.respond(vehicle_derivedService.getVehile_Derived())
            }

            get ("/Vehicle_DerivedByid"){
                var params=call.receive<Vehicle_DerivedDTO>()
                call.respond(vehicle_derivedService.UpdateVehicle_derivedById(params))
            }

            get("/getVehicle_DerivedWithCustomers") {
                call.respond(vehicle_derivedService.getVehicle_derivedWithCustomers())
            }

            put ("/UpdateVehicle_Derived"){
                var params=call.receive<Vehicle_DerivedDTO>()
                val noOfrowsAffected=vehicle_derivedService.updateVehicle_derivedWithCustomers(params)
                if(noOfrowsAffected ==0)
                    call.respond(params)
                else
                    call.respond(params)
            }
            get ("/DeleteById"){
                val params=call.receive<Vehicle_DerivedDTO>()
                val no=vehicle_derivedService.deleteById(params)
                if(no==0)
                    call.respond("Ur selection Id is not there in the table..")
                else
                    call.respond("Successfully deleted")
            }
        }
    }
}
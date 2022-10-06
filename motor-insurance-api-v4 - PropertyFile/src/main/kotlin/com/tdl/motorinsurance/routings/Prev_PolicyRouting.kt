package com.tdl.motorinsurance.routings

import com.tdl.motorinsurance.model.Prev_PolicyDTO
import com.tdl.motorinsurance.services.Prev_policyService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.configurePrev_PolicyRouting() {

    val prev_PolicyService = Prev_policyService()

    routing {
        route("/api/v1/Prev_policy") {

            post("/savePrev_PolicyWithVehicle") {
                var params = call.receive<Prev_PolicyDTO>()
                val noOfrowsAffected = prev_PolicyService.savePrev_PolicyWithVehicle(params)
                if (noOfrowsAffected == 0)
                    call.respond("No rows Affected..!")
                else
                    call.respond(params)
            }

            get("/getPrev_policy") {
                call.respond(prev_PolicyService.getPrev_Policy())
            }

            get ("/Prev_policyByid"){
                var params=call.receive<Prev_PolicyDTO>()
                call.respond(prev_PolicyService.UpdatePrev_PolicyById(params))
            }

            get("/getPrev_policyWithVehicle") {
                call.respond(prev_PolicyService.getPrev_policyWithVehicle())
            }

            put ("/UpdatePrev_policy"){
                var params=call.receive<Prev_PolicyDTO>()
                val noOfrowsAffected=prev_PolicyService.updatePrev_PolicyWithVehicle(params)
                if(noOfrowsAffected ==0)
                    call.respond(params)
                else
                    call.respond(params)
            }
            get ("/DeleteById"){
                val params=call.receive<Prev_PolicyDTO>()
                val no=prev_PolicyService.deleteById(params)
                if(no==0)
                    call.respond("Ur selection Id is not there in the table..")
                else
                    call.respond("Successfully deleted")
            }

            get ("/getOnboarding"){
                var params=call.receive<Prev_PolicyDTO>()
                call.respond(prev_PolicyService.getOnboarding(params))
            }

        }
    }
}




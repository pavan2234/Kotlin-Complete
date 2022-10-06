package com.tdl.motorinsurance.routings

import com.tdl.motorinsurance.model.NomineeDTO
import com.tdl.motorinsurance.services.NomineeService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureNomineeRouting() {

    val nomineeService = NomineeService()

    routing {
        route("/api/v1/Nominee") {

            post("/saveNomineeWithCustomer") {
                var params = call.receive<NomineeDTO>()
                val noOfrowsAffected = nomineeService.saveNomineeWithCustomer(params)
                if (noOfrowsAffected == 0)
                    call.respond("No rows Affected..!")
                else
                    call.respond(params)
            }

            get("/getNominees") {
                call.respond(nomineeService.getNominees())
            }

            get ("/NomineeByid"){
                    var params=call.receive<NomineeDTO>()
                call.respond(nomineeService.UpdateNomineeById(params))
            }

            get("/getNomineesWithCustomers") {
                call.respond(nomineeService.getNomineesWithCustomers())
            }

            put ("/UpdateNominee"){
                var params=call.receive<NomineeDTO>()
                val noOfrowsAffected=nomineeService.updateNomineeWithCustomers(params)
                if(noOfrowsAffected ==0)
                    call.respond(params)
                else
                    call.respond(params)
            }
            get ("/DeleteById"){
                val params=call.receive<NomineeDTO>()
                val no=nomineeService.deleteById(params)
                if(no==0)
                    call.respond("Ur selection Id is not there in the table..")
                    else
                        call.respond("Successfully deleted")
            }


        }
    }
}




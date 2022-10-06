package com.example.routing

import com.example.model.PersonINDVDTO
import com.example.model_joins.personaldetailDTO
import com.example.service.personaldetailservice
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.personalrouting(){
    val personaldetailservice = personaldetailservice()

    routing {
        route("/api/route/college"){
            post("savePersonalDetails") {
                val params = call.receive<personaldetailDTO>()
                var effectedlines = personaldetailservice.savePersonalDetails(params)
                if (effectedlines == 0)
                    call.respond("No Data Inserted")
                else call.respond("----------------Data Inserted ---------------")
            }
            get ("getPersonalDetails"){
                call.respond(personaldetailservice.getPersonalDetails())
            }
            post("saveINDVPersonalDetails") {
                val params = call.receive<PersonINDVDTO>()
                var effectedlines = personaldetailservice.saveINDVPersonalDetails(params)
                if (effectedlines == 0)call.respond("No Data Inserted")
                else call.respond("----------------Data Inserted ---------------")
            }
            get ("getINDVPersonalDetails"){
                call.respond(personaldetailservice.getINDVPersonalDetails())
            }
        }
    }

}
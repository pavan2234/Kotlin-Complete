package com.example.routing

import com.example.model.busdetailDTO
import com.example.service.Busservice
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.busrouting(){
    val busser = Busservice()
    routing {
        route("/api/route/college"){
            post("/saveBusDetails") {
                val params = call.receive<busdetailDTO>()
                busser.saveBusDetails(params)
                call.respond("Data inserted")

            }
            get("/getBusDetails") {
                call.respond(busser.getBusDetails())
            }
        }
    }

}
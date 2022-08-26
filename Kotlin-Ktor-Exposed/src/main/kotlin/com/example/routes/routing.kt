package com.example.routes

import KaratesE.id
import com.example.model.karateDTO
import com.example.service.KarateService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.karateroute(){
    val KarateServ = KarateService()
    routing {
        post("/ExposedEntry") {
        var params = call.receive<karateDTO>()
            params = KarateServ.createDetails(params)!!
            call.respond(params)
        }
        get("/ExposedGetting") {
            call.respond(KarateServ.getDetails())
        }
        get("/ExposedGetBYId") {
            call.respond(KarateServ.getDetailsById(id))
        }
    }
}

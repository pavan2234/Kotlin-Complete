package com.example.routes

import com.example.model.karateDTO
import com.example.service.KarateService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.karateroute(){
    val KarateServ = KarateService()
    routing {
        post("/CustomerEntry") {
            val params = call.receive<karateDTO>()
            val count = KarateServ.CustomerEntry(params)
            call.respond(params)
            if(count==0)
                call.respond(status = HttpStatusCode.Conflict,"Nothing affected")
            else
                call.respond(params)
        }
        get("/getTraineeDetails") {
            call.respond(KarateServ.TraineeDetails())
        }
        get("/helloworld") {
            call.respond("Hello World")
        }
        put("/updateDetails") {
            var params = call.receive<karateDTO>()
            val count = KarateServ.UpdateDetails(params)
            call.respond(params)
            if(count==0)
                call.respond(status = HttpStatusCode.Conflict,"Nothing affected")
            else
                call.respond(params)
        }
        }
    }

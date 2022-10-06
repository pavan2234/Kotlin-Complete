package com.example.routing

import com.example.model.PlacementINDVDTO
import com.example.model_joins.placementDTO
import com.example.service.placementservice
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.placementrouting(){
    val placementservice = placementservice()
    routing {
        route("/api/route/college"){
            post("/savePlacementDetails") {
                val parmas = call.receive<placementDTO>()
                var effctedlines = placementservice.savePlacementDetails(parmas)
                if (effctedlines == 0 ) call.respond("NO Data Inserted")
                else call.respond("----------------Data Inserted ---------------")
            }
            get("/getPlacementDetails"){
                call.respond(placementservice.getPlacementDetails())
            }
            post("/saveINDVPlacementDetails") {
                val parmas = call.receive<PlacementINDVDTO>()
                var effctedlines = placementservice.saveINDVPlacementDetails(parmas)
                if (effctedlines == 0 ) call.respond("NO Data Inserted")
                else call.respond("----------------Data Inserted ---------------")
            }
            get("/getINDVPlacementDetails"){
                call.respond(placementservice.getINDVPlacementDetails())
            }
        }
    }
}
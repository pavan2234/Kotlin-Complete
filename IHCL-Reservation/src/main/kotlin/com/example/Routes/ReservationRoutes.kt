package com.example.Routes

import com.example.Entities.Reservation.restaurantId
import com.example.Repositories.subReservation
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.ReservationRouting(){
        routing {
            val subrepoobject = subReservation()
            get("/getTotalReservations") {
                call.respondText(subrepoobject.gettingReservations().toString())
            }
            get("/getReservationById") {
                call.respondText(subrepoobject.ReservationById(restaurantId = restaurantId).toString())
            }
        }
}
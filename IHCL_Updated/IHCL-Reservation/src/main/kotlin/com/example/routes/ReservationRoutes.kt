package com.example.routes

import com.example.model.ReservationsDTO
import com.example.repositories.ReservartionService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.ReservationRouting(){
    val ReservationServ = ReservartionService()
        routing {
            route("reser/table") {

                post("/saveReservation") {
                    var params = call.receive<ReservationsDTO>()
                    val noOfrowsAffected = ReservationServ.ReservationInserting(params)
                    call.respond(params)
                }
                get("/getReservation") {
                    call.respond(ReservationServ.getReservation())
                }
                put ("/UpdateReservation"){
                    var params=call.receive<ReservationsDTO>()
                    val noOfrowsAffected=ReservationServ.updateReservation(params)
                    if(noOfrowsAffected ==0)
                        call.respond(status = HttpStatusCode.Conflict,"No records effected..")
                    else

                        call.respond("$params")
                }
                get("DeleteById") {
                    var params = call.receive<ReservationsDTO>()
                    val noOfrowsAffected = ReservationServ.deleteReservationByID(params)
                    if (noOfrowsAffected==0)
                        call.respond(status = HttpStatusCode.Conflict,"No records effected..")
                    else
                        call.respond(status = HttpStatusCode.Conflict,"Successfully deleted...")
                }
                get("DeleteByName") {
                    val params = call.receive<ReservationsDTO>()
                    val count = ReservationServ.deleteByLastName(params)
                    if (count ==0)
                        call.respond("No records affected")
                    else
                        call.respond("Successfully deleted by last name")
                }
            }
        }
}
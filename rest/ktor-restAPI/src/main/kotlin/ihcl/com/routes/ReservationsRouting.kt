import ihcl.com.model.Reservations
import ihcl.com.service.ReservationsService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureReservationsRouting() {

    val reservationsService = ReservationsService()

    routing {
        route("/api/v1/reservations") {

            post("/makeReservation") {
                var params = call.receive<Reservations>()
                params = reservationsService.makeReservation(params)!!
                call.respond(params)
            }

            get("/getBookingHistory") {
                call.respond(reservationsService.getBookingHistory())
            }

            /*
            get("/getBookingHistoryByRestaurantId/{id?}") {
                val restaurantId = Integer.parseInt(
                    call.parameters["id"] ?: return@get call.respondText(
                        "Missing id",
                        status = HttpStatusCode.BadRequest
                    )
                )
                call.respond(reservationsService.getBookingHistoryByRestaurantId(restaurantId))
            }*/
        }
    }
}
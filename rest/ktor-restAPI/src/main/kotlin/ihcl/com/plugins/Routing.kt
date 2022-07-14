package ihcl.com.plugins

import configureReservationsRouting
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    configureReservationsRouting()
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}

package com.example.routing


import com.example.model.companyDTO
import com.example.service.companyservice
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.companyrouting() {
    val companyserve = companyservice()
    routing {
        route("/api/route/college") {
            post("/saveCompanyDetails") {
                val params = call.receive<companyDTO>()
                companyserve.saveCompanyDetails(params)
                call.respond("Data Inserted")
            }
            get("/getCompanyDetails") {
                call.respond(companyserve.getCompanyDetails())
            }
        }
    }
}

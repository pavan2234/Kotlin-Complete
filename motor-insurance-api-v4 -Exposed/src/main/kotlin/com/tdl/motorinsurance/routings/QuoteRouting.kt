package com.tdl.motorinsurance.routings

import com.tdl.motorinsurance.model.NomineeDTO
import com.tdl.motorinsurance.model.QuoteDTO
import com.tdl.motorinsurance.services.NomineeService
import com.tdl.motorinsurance.services.QuoteService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureQuoteRouting() {

    val quoteService = QuoteService()

    routing {
        route("/api/v1/Quote") {

            post("/saveQuote") {
                var params = call.receive<QuoteDTO>()
                val noOfrowsAffected = quoteService.saveQuote(params)
                if (noOfrowsAffected == 0)
                    call.respond("No rows Affected..!")
                else
                    call.respond(params)
            }

            get("/getquotes") {
                call.respond(quoteService.getQuotes())
            }


            get("/getquotessa") {
                call.respond(quoteService.getQuotess())
            }
        }
    }
}

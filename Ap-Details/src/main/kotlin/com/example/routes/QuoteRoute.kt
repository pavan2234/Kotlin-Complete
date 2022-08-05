package com.example.routes

import com.example.services.subOrderService
import com.example.services.subQuoteService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.ConfigureQuoteRoute() {
    routing {
        route("/api/v1/fs/mi") {
            get ("/GettingQuotes"){
                val subroute= subQuoteService()
                val onlyAddress=subroute.TotalQuotes()
                val gson = Gson()
                val gsonPretty = GsonBuilder().setPrettyPrinting().create()
                val respoceanswe = onlyAddress
                val jsonInput: String = gson.toJson(respoceanswe)
                val jsoninputPretty: String = gsonPretty.toJson(respoceanswe)
                println(jsoninputPretty)
                call.respondText(jsoninputPretty)
            }
            get ("/QuotesWithVehicleCustomerPre_Policy"){
                val subroute= subQuoteService()
                val onlyAddress=subroute.QuotesWithVehicleCustomerPre_Policy()
                val gson = Gson()
                val gsonPretty = GsonBuilder().setPrettyPrinting().create()
                val respoceanswe = onlyAddress
                val jsonInput: String = gson.toJson(respoceanswe)
                val jsoninputPretty: String = gsonPretty.toJson(respoceanswe)
                println(jsoninputPretty)
                call.respondText(jsoninputPretty)
            }
        }
    }
}
package com.example.routes

import com.example.services.subOrderService
import com.example.services.subPrev_PolicyService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.ConfigurePrev_PolicyRoute() {
    routing {
        route("/api/v1/fs/mi") {
            get ("/GettingPrev_Policys"){
                val subroute= subPrev_PolicyService()
                val onlyAddress=subroute.Prev_Policies()
                val gson = Gson()
                val gsonPretty = GsonBuilder().setPrettyPrinting().create()
                val respoceanswe = onlyAddress
                val jsonInput: String = gson.toJson(respoceanswe)
                val jsoninputPretty: String = gsonPretty.toJson(respoceanswe)
                println(jsoninputPretty)
                call.respondText(jsoninputPretty)
            }
            get ("/GettingPerv_PolicyWithVehicle"){
                val subroute= subPrev_PolicyService()
                val onlyAddress=subroute.Perv_PolicyWithVehicle()
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
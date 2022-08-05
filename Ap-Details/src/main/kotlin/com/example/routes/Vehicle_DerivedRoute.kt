package com.example.routes

import com.example.services.subOrderService
import com.example.services.subVehicle_DerivesService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.ConfigureVehicle_DerivedRoute() {
    routing {
        route("/api/v1/fs/mi") {
            get ("/GettingVehicleDerives"){
                val subroute= subVehicle_DerivesService()
                val onlyAddress=subroute.TotalVehicle_Derives()
                val gson = Gson()
                val gsonPretty = GsonBuilder().setPrettyPrinting().create()
                val respoceanswe = onlyAddress
                val jsonInput: String = gson.toJson(respoceanswe)
                val jsoninputPretty: String = gsonPretty.toJson(respoceanswe)
                println(jsoninputPretty)
                call.respondText(jsoninputPretty)
            }
            get ("/Vehicle_DerivedWithCustomer"){
                val subroute= subVehicle_DerivesService()
                val onlyAddress=subroute.Vehicle_DerivedWithCustomer()
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
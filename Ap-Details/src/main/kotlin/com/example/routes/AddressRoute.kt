package com.example.routes

import com.example.services.subAddressSrvice
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.ConfigureAddressRoute() {
    routing {
        route("/api/v1/fs/mi") {
            get ("/GettingAddress"){
                val subroute= subAddressSrvice()
                val onlyAddress=subroute.TotalAddress()
                val gson = Gson()
                val gsonPretty = GsonBuilder().setPrettyPrinting().create()
                val respoceanswe = onlyAddress
                val jsonInput: String = gson.toJson(respoceanswe)
                val jsoninputPretty: String = gsonPretty.toJson(respoceanswe)
                println(jsoninputPretty)
                call.respondText(jsoninputPretty)
            }
            get ("/GettingAddresswithCustomer"){
                val subroute= subAddressSrvice()
                val onlyAddress=subroute.Addresswithcustomer()
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

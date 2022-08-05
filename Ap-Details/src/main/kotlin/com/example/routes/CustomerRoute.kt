package com.example.routes

import com.example.services.SubvehicleService
import com.example.services.subCustomerService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.ConfigureCustomerRoute(){
    routing {
        route("/api/v1/fs/mi") {
            get ("/totalcustomers"){
                val subcustroute = subCustomerService()
                val customersgetting = subcustroute.customer()
                val gson = Gson()
                val gsonPretty = GsonBuilder().setPrettyPrinting().create()
                val respoceanswe = customersgetting
                val jsonInput: String = gson.toJson(respoceanswe)
                val jsoninputPretty: String = gsonPretty.toJson(respoceanswe)
                println(jsoninputPretty)
                call.respondText(jsoninputPretty)
            }
        }
    }
}
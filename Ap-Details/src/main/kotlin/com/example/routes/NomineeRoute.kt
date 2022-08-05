package com.example.routes

import com.example.services.subNomineeService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.ConfigureNomineRoute(){
    routing {
        route("/api/v1/fs/mi") {
            get("/totalNominees") {
                val answer= subNomineeService().Nominee()
                val gson= Gson()
                val gsonPretty= GsonBuilder().setPrettyPrinting().create()
                val respoceanswe=answer
                val jsonInput:String=gson.toJson(respoceanswe)
                val jsoninputPretty:String=gsonPretty.toJson(respoceanswe)
                println(jsoninputPretty)
                call.respondText(jsoninputPretty)
            }
        }
    }
}




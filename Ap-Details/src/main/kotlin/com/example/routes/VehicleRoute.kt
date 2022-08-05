package com.example.routes

import com.example.EntityBindings.Vehicles.reg_number
import com.example.services.SubvehicleService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.ConfigureVehicleRoute(){
    routing {
        route("/api/v1/fs/mi"){
            val subVehicleroute= SubvehicleService()
            get("/vehicle") {
                val answer= subVehicleroute.Vehicle()
                val gson=Gson()
                val gsonPretty=GsonBuilder().setPrettyPrinting().create()
                val respoceanswe=answer
                val jsonInput:String=gson.toJson(respoceanswe)
                val jsoninputPretty:String=gsonPretty.toJson(respoceanswe)
                println(jsoninputPretty)
                call.respondText(jsoninputPretty)
            }
            get("/vehicleByreg_number"){
                val answer1=subVehicleroute.VehicleByregNo(reg_number = reg_number)
                val gson=Gson()
                val gsonPretty=GsonBuilder().setPrettyPrinting().create()
                val respoceanswe=answer1
                val jsonInput:String=gson.toJson(respoceanswe)
                val jsoninputPretty:String=gsonPretty.toJson(respoceanswe)
                println(jsoninputPretty)
                call.respondText(jsoninputPretty)
            }
            get("/vehiclewithcustomer"){
                val answer2= subVehicleroute.VehicleWithCustomer()
                val gson=Gson()
                val gsonPretty=GsonBuilder().setPrettyPrinting().create()
                val respoceanswe=answer2
                val jsonInput:String=gson.toJson(respoceanswe)
                val jsoninputPretty:String=gsonPretty.toJson(respoceanswe)
                println(jsoninputPretty)
                call.respondText(jsoninputPretty)
            }
        }
    }
}
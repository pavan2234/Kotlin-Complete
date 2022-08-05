package com.example.routes

import com.example.EntityBinding.customers
import com.example.EntityBinding.vehicles.vehicleid
import com.example.repository.subrepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.routes(){
    val totaldetails = subrepository()
    val gson = Gson()
    val gsonbuild = GsonBuilder().setPrettyPrinting().create()
    routing {
        get("/getcustomers") {
            val customersgetting = totaldetails.getCustomers()
            val response = customersgetting
            val jsonInput: String = gson.toJson(response)//Prints in the string format
            val jsoninputbuild: String = gsonbuild.toJson(response)//creates a json buils type and prints as a json
            println(jsoninputbuild)
            call.respondText(jsoninputbuild)
        }
        get("/getvehicle") {
            val vehiclegetting = totaldetails.getVehicle()
            val response = vehiclegetting
            val jsonInput:String = gson.toJson(response)
            val jsonInputbuild:String = gsonbuild.toJson(response)
            println(jsonInputbuild)
            call.respondText(jsonInputbuild)

        }
        get("/getbycustomerid"){
            val customerid = totaldetails.getCustomerBYId(customerid = customers.customerid)
            val response = customerid
            val jsoninputbuild:String = gsonbuild.toJson(response)
            println(jsoninputbuild)
            call.respondText(jsoninputbuild)

        }
        get ("/getbyvehicleid"){
            val vehicleids = totaldetails.getVehicleById(vehicleid = vehicleid)
            val response = vehicleids
            val jsoninputbuild:String = gsonbuild.toJson(response)
            println(jsoninputbuild)
            call.respondText(jsoninputbuild)
        }
        get ("/getbyvehicleid2"){
            val vehicleids = totaldetails.getVehicleById(vehicleid = vehicleid)
            val jsoninputbuild:String = gsonbuild.toJson(vehicleids)
            println(jsoninputbuild)
            call.respondText(jsoninputbuild)
        }
    }
}
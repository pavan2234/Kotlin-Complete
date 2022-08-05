package com.example.routes

import com.example.entitybinding.Orders
import com.example.model.Order
import com.example.services.subAddressSrvice
import com.example.services.subOrderService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.lang.reflect.Type
import javax.sound.sampled.LineEvent


fun Application.ConfigureOrderRoute() {
    routing {
        route("/api/v1/fs/mi") {
            get ("/GettingOrders"){
                val subroute= subOrderService()
                val onlyAddress=subroute.Order()
                println(onlyAddress)
                val mainOrderRoute=onlyAddress
                val gson = Gson()
                val gsonPretty = GsonBuilder().setPrettyPrinting().create()
                val respoceanswe = mainOrderRoute
                val jsonInput: String = gson.toJson(respoceanswe)
                val jsoninputPretty: String = gsonPretty.toJson(respoceanswe)
                println(jsoninputPretty)
                call.respondText(jsoninputPretty)
            }
            get ("/OrderWithQuoteandCustomer"){
                val subroute= subOrderService()
                val onlyAddress=subroute.OrderWithQuoteandCustomer()
                val gson = Gson()
                val gsonPretty = GsonBuilder().setPrettyPrinting().create()
                val respoceanswe = onlyAddress
                val jsoninputPretty: String = gsonPretty.toJson(respoceanswe)
                println(jsoninputPretty)
                call.respondText(jsoninputPretty)
            }
        }
    }
}
/*suspend fun getOrderes():List<Order>{
    val subroute= subOrderService()
    val onlyAddress=subroute.Order()
    val collectionType: Type? =object :TypeToken<List<Order?>?>(){}.type
    val orders: List<com.example.entitybinding.Order> = Gson().fromJson(onlyAddress.toString()) as List<com.example.entitybinding.Order>
    return orders
}*/
/*
suspend fun getReservations(): List<Reservations> {
    val client = HttpClient()
    val response: HttpResponse = client.get("http://localhost:8080/getTotalReservations")
    val collectionType: Type = object : TypeToken<List<Reservations?>?>() {}.type
    val reservations: List<Reservations> = Gson()
        .fromJson(response.readText(), collectionType) as List<Reservations>
    client.close()
    return reservations
}*/
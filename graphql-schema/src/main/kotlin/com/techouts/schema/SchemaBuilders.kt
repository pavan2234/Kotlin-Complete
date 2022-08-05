package com.techouts.schema

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.techouts.model.CustomerDTO
import com.techouts.model.Guardian
import com.techouts.model.NomineeDTO
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.get
import io.ktor.client.statement.*
import io.ktor.http.*
import java.lang.reflect.Type

fun SchemaBuilder.NomineeSchema() {

    query("getNominee") {
        resolver {

            ->
            getCustomers()
        }
    }
}

/*fun SchemaBuilder.giftCardsSchema() {

    query("getGiftCards") {
        resolver {
            ->
            getGiftCards()
        }
    }
}*/


/*suspend fun getReservations(): List<GiftCards> {
    val client = HttpClient()
    val response: HttpResponse = client.get("http://0.0.0.0:8083/GiftCards")
    val collectionType: Type = object : TypeToken<List<GiftCards?>?>() {}.type
    val reservations: List<Reservations> = Gson()
        .fromJson(response.readText(), collectionType) as List<GiftCards>
    client.close()
    return reservations
}*/

/*suspend fun getGiftCards(): String {
    val client = HttpClient()
    val response: HttpResponse = client.get("http://localhost:8083/GiftCards")
    val collectionType: Type = object : TypeToken<List<GiftCards?>?>() {}.type
    val giftCards: List<GiftCards> = Gson()
        .fromJson(response.readText(), collectionType) as List<GiftCards>
    client.close()
    return response.readText()
}*/

suspend fun  getCustomers(): List<NomineeDTO> {
    val client= HttpClient()
    val response:HttpResponse=client.get<HttpResponse>("http://localhost:9090/api/v1/Nominee/getNominees")
   val collectionType: Type? =  object :TypeToken<List<NomineeDTO?>?>() {}.type
    val giftCards: List<NomineeDTO> = Gson()
        .fromJson(response.readText(), collectionType) as List<NomineeDTO>
    client.close()
    return giftCards
}
/*
val gson = Gson()
val gsonPretty = GsonBuilder().setPrettyPrinting().create()
val respoceanswe = customersgetting
val jsonInput: String = gson.toJson(respoceanswe)
val jsoninputPretty: String = gsonPretty.toJson(respoceanswe)
println(jsoninputPretty)
call.respond(jsoninputPretty)*/

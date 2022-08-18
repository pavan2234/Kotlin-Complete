package com.example

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.google.gson.Gson
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.util.*
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json

fun SchemaBuilder.Schema() {

    mutation("putReservation"){
        description="Put a reservation"
        resolver { ->
            //putReservation()
        }
    }
}

//suspend fun putReservation(): String{
//
//    val client = HttpClient(CIO)
//    val request : HttpRequest = client.post("http://0.0.0.0:8080/ReservationInserting")
//    println(request)
//    return request.toString()
//}
//Error: An Object type must define one or more fields. Found none on type CoroutineContext -------- when return type is HTTPRESPONSE
//When return type is String the error is with query









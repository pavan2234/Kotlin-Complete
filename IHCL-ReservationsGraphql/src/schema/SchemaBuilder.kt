package com.example.schema

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.example.repository.ReservartionRepo
import com.example.repository.subReservation
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

fun SchemaBuilder.schemas(){
    val schemaobj:ReservartionRepo= subReservation()
    query("GetData"){
        description="All the Reservations"
        resolver {
            -> getReservations()
        }
    }
//    mutation("InsertData"){
//        description ="Inserting all data"
//        resolver {
//          -> putReservations()
//        }
//    }

}
suspend fun getReservations(): String{
    val client = HttpClient(CIO)
    val response : HttpResponse = client.get("http://0.0.0.0:8080/getTotalReservations")
    println(response.readText())
    return response.readText()
}

//suspend fun putReservations(): HttpRequest {
////    val url = URL("http://0.0.0.0:8080/ReservationInserting")
////    val connection = url.openConnection()
////    val result = BufferedReader(InputStreamReader(connection.getInputStream())).use { inp->
////        var line:String?
////        while (inp.readLine().also { line = it } != null) {
////            println(line)
////        }
////    }
////    return result.toString()
//
//    val client = HttpClient(CIO)
//    val request :HttpRequest = client.post("http://0.0.0.0:8080/ReservationInserting")
//    println(request)
//    return request
//
//
//}


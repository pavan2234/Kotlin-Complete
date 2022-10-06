package com.example.Header

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

fun SchemaBuilder.schemas(){
    query("GetRtoLocation"){
        resolver {
            -> getLocation()
        }
    }
}
suspend fun main(){
    println(getLocation())
}

suspend fun getLocation(): HttpResponse {
    val client = HttpClient(CIO)
    val response : HttpResponse = client.get("https://SAMBHAVIT:t4aH4gW3xtNPiQj3zE_d@api.qa.sandbox-riskcovry.com/api/partner/motor/get_rto_locations")
//    headersOf("Partner-Code","SAMBHAVIT")
//    headersOf("Partner-Key","t4aH4gW3xtNPiQj3zE_d")


    return response
    println(response)
}
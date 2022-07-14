package com.example.com.eample.models

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class h {
    suspend fun myMethod (){
        val client= HttpClient(CIO)
        val responce: HttpResponse =client.get("http://0.0.0.0:8081/GiftCards")
        println(responce)
    }
}

package com.example.Client

import com.example.plugins.Employee
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.runBlocking


fun main(){
    runBlocking {
        val client = HttpClient(CIO){
          install(ContentNegotiation){
              json()
          }
        }
        val response: HttpResponse =client.get("http://localhost:8080/pavan"){
            contentType(ContentType.Application.Json)
            setBody(Employee(11,"mahesh","1879"))

        }
        //println(response.status)

        val stringbody:String = response.body()
        println("$stringbody")

        val bytearra:ByteArray = response.body()
        println("$bytearra")




    }

}
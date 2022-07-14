package com.example.file
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
import java.io.File
import java.io.FileWriter
import java.io.PrintStream

fun main() {
    runBlocking {
        val file = File("D:\\file.txt")
        val client = HttpClient(CIO) {
            install(ContentNegotiation){
                json()
            }
        }
        val response: HttpResponse = client.get("http://localhost:8080/pavan") {
                contentType(ContentType.Application.Json)
                setBody(file.writeText("pavan"  ))
                setBody(file.writeText("1869"))
        }
        println(response.bodyAsText())
        println(response.request.content)
        
    }

}
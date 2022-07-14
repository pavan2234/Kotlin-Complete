package com.example

import com.example.Demo2.Query
import com.example.Entity.Bind
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*


fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {

//  configureRouting()
//            Insert()
        // Print() //Prints the data from database with entity class
//           Query()
//            NewQuery()
        Bind()
    }.start(wait = true)
}

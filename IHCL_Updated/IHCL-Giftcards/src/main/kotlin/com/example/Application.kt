package com.example

import com.example.DataBaseConfiguration.DataBaseConnection
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import org.ktorm.database.Database

fun main() {
    embeddedServer(Netty, port = 8081, host = "0.0.0.0") {
        configureRouting()
        configureSerialization()
    connection= DataBaseConnection.init()
    }.start(wait = true)
}
var connection: Database? = null

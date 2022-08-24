package com.example

import com.example.DatabaseConfiguration.DatabaseConnection
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import org.ktorm.database.Database

fun main() {
    embeddedServer(Netty, port = 8090, host = "0.0.0.0") {
        configureSerialization()
        configureRouting()
        connection = DatabaseConnection.init()
    }.start(wait = true)
}
var connection: Database? = null
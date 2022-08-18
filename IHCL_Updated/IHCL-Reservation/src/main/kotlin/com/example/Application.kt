package com.example

import com.example.DatabaseConfiguration.DataBaseConnection
import com.example.plugins.configureRouting
import com.example.plugins.configureSerialization
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.ktorm.database.Database

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureSerialization()
        connection = DataBaseConnection.init()
    }.start(wait = true)
}
var connection: Database? = null

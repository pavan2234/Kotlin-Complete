package com.example

import com.example.databaseconfig.DatabaseFactory
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import org.ktorm.database.Database

fun main() {
    embeddedServer(Netty, port = 2234, host = "localhost") {
        configureSerialization()
        configureRouting()
        connection= DatabaseFactory.init()
    }.start(wait = true)
}
var connection:Database? = null

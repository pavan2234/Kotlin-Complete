package com.example

import com.example.DBConfig.initDB
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import org.ktorm.database.Database

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSerialization()
        configureRouting()
        initDB()
        connection = DBConfi
    }.start(wait = true)
}
var connection: Database? = null

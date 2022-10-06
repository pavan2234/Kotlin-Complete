package com.tdl.motorinsurance

import com.tdl.motorinsurance.dbconfig.DatabaseFactory
import com.tdl.motorinsurance.plugins.configureSerialization
import com.tdl.plugins.configureRouting
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.ktorm.database.Database

fun main() {
    embeddedServer(Netty, port = 9090, host = "localhost") {
        configureSerialization()
        configureRouting()
        connection = DatabaseFactory.init()
    }.start(wait = true)
}
var connection: Database? = null


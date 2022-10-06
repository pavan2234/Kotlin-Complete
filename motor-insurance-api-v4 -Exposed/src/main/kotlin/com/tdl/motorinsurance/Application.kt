package com.tdl.motorinsurance

import com.tdl.motorinsurance.dbconfig.DatabaseFactory
import com.tdl.motorinsurance.plugins.configureSerialization
import com.tdl.plugins.configureRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.defaultheaders.*
import org.ktorm.database.Database

fun main() {
    embeddedServer(Netty, port = 9090, host = "localhost") {
        configureSerialization()
        configureRouting()

        connection = DatabaseFactory.init()

        install(DefaultHeaders){
            header("Partner-Code","SAMBHAVIT")
            header("Partner-Key","t4aH4gW3xtNPiQj3zE_d")
        }

    }.start(wait = true)
}

var connection: Database? = null


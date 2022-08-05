package com.example

import com.apurebase.kgraphql.GraphQL
import com.example.com.Server.BruC
import com.example.com.org.grapql.schemaValues
import io.ktor.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
        install(GraphQL) {
            playground = true
            schema {
                schemaValues()
                BruC()
            }
        }
}


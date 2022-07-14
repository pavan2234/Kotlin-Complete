package com.example

import com.apurebase.kgraphql.GraphQL
import com.example.plugins.Schema
import io.ktor.application.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module() {
    install(GraphQL) {
        playground = true
        schema {
                Schema()
        }
    }
}


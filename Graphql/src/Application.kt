package com.example

import com.apurebase.kgraphql.GraphQL
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import javax.management.Query

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
//val obj:InterfaceEmployee=ClassEmployee()

    install(GraphQL) {
        playground = true
        schema {
           QuerySchema()
//            query("printing"){
//                resolver { ->
//                    obj.listEmployee()
//                }
//            }
        }
    }
}


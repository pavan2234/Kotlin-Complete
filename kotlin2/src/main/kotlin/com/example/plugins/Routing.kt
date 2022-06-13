package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.dsl.insert

fun Application.configureRouting() {
    val db=database.database
    routing {
        get("/pavan") {
            val userdetails = call.receive<StudentDetails>()
            val name = userdetails.name
            val password = userdetails.password

            db.insert(student){
                set(it.name,name)
                set(it.password,password)
            }
        }
    }
}

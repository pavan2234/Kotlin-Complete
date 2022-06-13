package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import me.liuwj.ktorm.dsl.insert

fun Application.configureRouting() {

    routing {
        val db = DatabaseConnection.database
        get("/kotlin") {
            val details = call.receive<StudentCredentials>()
            val name = details.name
            val password = details.encryptedpassword()

            db.insert(student){
                set(it.name,name)
                set(it.password,password)
            }
            call.respondText("Sucessfully inserted")
        }
    }
}

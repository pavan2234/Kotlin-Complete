package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.liuwj.ktorm.dsl.insert

fun Application.UserDetails(){
    val db=DatabaseConnection.database
    routing {
        get ("/registration"){
            val userDetails=call.receive<StudentCredentials>()

            val name=userDetails.name
            val password=userDetails.password

            db.insert(student){
                set(it.name,name)
                set(it.password,password)
            }
            call.respondText("Succesfully inserted")
        }
    }
}
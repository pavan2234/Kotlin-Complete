package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import me.liuwj.ktorm.dsl.from
import me.liuwj.ktorm.dsl.insert
import me.liuwj.ktorm.dsl.select

fun Application.configureRouting() {
    val db=DatabaseConnection.database
    routing {
        get("/pavan") {
            val userdetails = call.receive<StudentDetails>()
            val name = userdetails.name
            val password = userdetails.empid

            db.insert(student){
                set(it.name,name)
                set(it.empid,password)
            }
        }
        for(data in db.from(student).select()){
            println(data)
        }
    }
}

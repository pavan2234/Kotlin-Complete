package com.example.Routing

import com.example.module.DatabaseConnection.database
import com.example.module.EmployTable
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import me.liuwj.ktorm.dsl.from
import me.liuwj.ktorm.dsl.select

fun Application.Routing(){
    routing {
        get("Printing") {
         call.respondText("Success")
        }
        for (data in database.from(EmployTable).select()){
            println(data)
        }
    }
}
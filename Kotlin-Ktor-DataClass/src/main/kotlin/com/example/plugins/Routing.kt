package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import me.liuwj.ktorm.dsl.from
import me.liuwj.ktorm.dsl.insert
import me.liuwj.ktorm.dsl.map
import me.liuwj.ktorm.dsl.select
import me.liuwj.ktorm.entity.sequenceOf
import me.liuwj.ktorm.entity.toList

fun Application.configureRouting() {
    val db=DatabaseConnection.database
    routing {
        post("/pavan") {
            val userdetails = call.receive<StudentDetails>()
            val sno = userdetails.sno
            val name = userdetails.name
            val password = userdetails.empid

            db.insert(student){
                set(it.sno,sno)
                set(it.name,name)
                set(it.empid,password)
            }

            println(call.parameters.get("sno"))
        }
        get("/getdata") {
//            for(data in db.from(student).select()){
//                println(data)
//            }
            db.sequenceOf(student).toList()
        }

    }
}

package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import me.liuwj.ktorm.dsl.insert

fun Application.configureRouting() {
    val db = DatabaseConnection.database
    routing {
        get("/pavan"){
        val empdetails = call.receive<EmployeeCredentials>()
            val sno = empdetails.sno
            val name = empdetails.name
            val empid = empdetails.empid
            db.insert(employe){
                set(it.sno,sno)
                set(it.name,name)
                set(it.empid,empid)
        }
        }
    }
}

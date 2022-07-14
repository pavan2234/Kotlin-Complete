package com.example.plugins

import com.example.plugins.DatabaseConnection.database
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.liuwj.ktorm.dsl.insert
import java.io.File

fun Application.InsertData() {
    routing {
        get("/post") {
//            val file = File("D:\\file.txt")
//            file.createNewFile()
            val empdetails = call.receive<EmployeeCredentials>()
            val sno = empdetails.sno
            val name = empdetails.name
            val empid = empdetails.empid
            database.insert(employe){
                set(it.sno,sno)
                set(it.name,name)
                set(it.empid,empid)
            }
//            file.writeText(name)
//            file.writeText(empid)
        }

    }
}

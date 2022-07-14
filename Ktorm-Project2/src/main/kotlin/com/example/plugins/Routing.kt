package com.example.plugins

import com.example.DatabaseConnection
import com.example.Student
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import me.liuwj.ktorm.dsl.from
import me.liuwj.ktorm.dsl.insert
import me.liuwj.ktorm.dsl.select

fun Application.configureRouting() {
    val db=DatabaseConnection.database
    routing {
        get("/pavan") {
//           db.insert(Student){
//            //   set(it.id,1)
//                set(it.name,"Babu")
//                set(it.age,20)
//            }
//            call.respondText("Success")
            }
       /* for(data in db.from(Student).select()){
            println("${data[Student.name]}:${data[Student.age]}")
        }

*/
    }
}

package com.example.plugins

import com.example.DatabaseConnection.database
import com.example.NewStudent
import com.example.Student
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.liuwj.ktorm.dsl.from
import me.liuwj.ktorm.dsl.select
import java.sql.DriverManager.println

fun Application.Autheni(){
    routing {
        get {
            call.respondText("hii")
        }
        for(data in database.from(Student).select()){
            println("${data[Student.name]}")
        }
//        for(data in database.from(NewStudent).select()){
//            println("${data[NewStudent.name]}:${data[NewStudent.age]}")
//        }
    }
}
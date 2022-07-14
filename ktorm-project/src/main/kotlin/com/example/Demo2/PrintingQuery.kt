package com.example.Demo2

import com.example.Demo.Departments
import com.example.Demo.Departments.name
import com.example.database
import io.ktor.server.application.*
import io.ktor.server.routing.*
import me.liuwj.ktorm.dsl.from
import me.liuwj.ktorm.dsl.insertAndGenerateKey
import me.liuwj.ktorm.dsl.select
import java.sql.DriverManager.println

fun Application.Query(){
    routing {
        get {

        }
    }
//    for (data in database.from(Departments).select(name)){
//        println(data.get(name))
//    }
    for (row in database.from(Departments).select()) {
       val data = Departments.createEntity(row)
        val id: Int? = row[Departments.id]
        val name: String? = row[Departments.name]
        val loaction: String? = row[Departments.location]

        println("$data")
    }

}

package com.example.plugins

import com.example.plugins.DatabaseConnection.database
import io.ktor.server.application.*
import io.ktor.server.routing.*
import me.liuwj.ktorm.dsl.from
import me.liuwj.ktorm.dsl.select


fun Application.Printing(){
    routing {
        get {

        }
        for(data in database.from(Employee).select()){
            println("${data[Employee.sno]}:${data[Employee.name]}:${data[Employee.empid]}")
        }
    }
}
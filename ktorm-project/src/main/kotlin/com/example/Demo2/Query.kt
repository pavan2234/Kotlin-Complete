package com.example

import com.example.Demo.Departments
import io.ktor.server.application.*
import io.ktor.server.routing.*
import me.liuwj.ktorm.dsl.*
import java.sql.DriverManager.println

fun Application.NewQuery(){
    routing {
    for(qry in database.from(Departments).select(Departments.name)
        .where{ Departments.id eq 1 }.map { row -> Departments.createEntity(row) }) {
        println("$qry")
    }
    }
}

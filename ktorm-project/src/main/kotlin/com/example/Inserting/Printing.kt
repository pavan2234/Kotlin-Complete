package com.example

import com.example.Demo.Departments
import io.ktor.server.application.*
import me.liuwj.ktorm.dsl.*
import java.sql.DriverManager

fun Application.Print(){
    for (dataa in database.from(Departments).select().orderBy(Departments.id.desc()).map {
            row -> Departments.createEntity(row)
    })
    {
        DriverManager.println("$dataa")
    }
}
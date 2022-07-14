package com.example.Entity

import com.example.Demo.Employees
import com.example.database
import io.ktor.server.application.*
import me.liuwj.ktorm.dsl.*
import java.sql.DriverManager.println

fun Application.Bind(){
    val emm= database.from(Employees)
        .joinReferencesAndSelect()
        .orderBy(Employees.id.asc())
        .map { row -> Employees.createEntity(row) }
    emm.forEach { println("$it") }
}
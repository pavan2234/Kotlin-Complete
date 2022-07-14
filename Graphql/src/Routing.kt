package com.example

import com.example.data.DatabaseConnection.database
import com.example.model.Employee
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.routing.*
import me.liuwj.ktorm.dsl.from
import me.liuwj.ktorm.dsl.insert
import me.liuwj.ktorm.dsl.select

fun Application.Routing(){
    routing {
        get("/print") {
//            val empdetails = call.receive<Employee>()
//            val sno = empdetails.sno
//            val name = empdetails.name
//            val empid = empdetails.empid
//
//            val inserting = database.insert(EmployTable){
//                set(it.sno,sno)
//                set(it.name,name)
//                set(it.empid,empid)
//            }


        }
        for (data in database.from(EmployTable).select()){
        println(data)
    }
    }

}
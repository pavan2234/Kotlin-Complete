package com.example.plugins


import com.example.Demo.Departments
import com.example.database
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import me.liuwj.ktorm.dsl.*
import java.sql.DriverManager.println

fun Application.configureRouting() {
    val db = database
    routing {
        get("/ktorm") {

               db.insert(Departments){
                    set(it.name,"Babuj")
                    set(it.location, "Siddipet")
                }
                call.respondText("Success")

//            val t = Departments.aliased("t")
//            database
//                .from(t)
//                .select()
//                .groupBy(t.nam)
//                .having { avg(t.salary) gt 100.0 }
//                .forEach { row ->
//                    println("${row.getInt(1)}:${row.getDouble(2)}")
//
//        val data=db.from(Departments).select(name)
//        for (gettingData in data){
//                println("${gettingData[Departments.name]} : ${gettingData[Departments.location]}" )
//            println("${gettingData}")
//            println("${gettingData.getString("location")}")
            call.respondText("Hii")
        }
        println("Hellooo")
            for (data in database.from(Departments).select()) {
                println("${data[Departments.name]}:${data[Departments.location]}")
            }
        }

}

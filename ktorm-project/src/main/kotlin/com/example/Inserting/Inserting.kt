package com.example

import com.example.Demo.Departments
import io.ktor.server.application.*
import io.ktor.server.routing.*
import me.liuwj.ktorm.dsl.*
import java.sql.DriverManager.println

fun Application.Insert() {
    routing {
        get {

        }

    database.insert(Departments){ //Inserts the data
        set(it.name,"pavan")
        set(it.location,"Suryapet")
    }


        database.batchInsert(Departments){
            item {
                set(it.name,"laxman")
                set(it.location,"Ameerpet")
            }
            item {
                set(it.name,"Raju")
                set(it.location,"Ecil")
            }
        }

        database.update(Departments){ //Updates the data with a reference
            set(it.name,"pavan")
            set(it.location,"Suryapet")
            where { it.id eq 2 }
        }

        database.insertAndGenerateKey(Departments){
            set(it.name,"Vamshi Ravula")
            set(it.location,"Guntoor")
        }

        database.update(Departments){
            set(it.name,"RajuYadav")
            set(it.location,"ECIL")
            where { it.id eq 9 }
        }

        database.delete(Departments){it.id eq 13}
        for (dataa in database.from(Departments).select().orderBy(Departments.id.asc()).map { row -> Departments.createEntity(row) })
        {
            println("$dataa")
        }
    }
}
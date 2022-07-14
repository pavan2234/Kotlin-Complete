package com.example.plugins

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import me.liuwj.ktorm.dsl.from
import me.liuwj.ktorm.dsl.map
import me.liuwj.ktorm.dsl.select

fun SchemaBuilder.Schema(){
    val db = DatabaseConnection.database
    val outData = db.from(Employee).select().map { row ->Employee.createEntity(row)  }
    println(outData)
    query("EmployeeDetails"){
        resolver {
            ->outData
        }
    }
}
package com.example.module

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder

fun SchemaBuilder.EmploySchema(){
    val obj:EmployeeInterface=EmployeeRepository()
    query("Players"){
        resolver { ->
            obj.listEmployee()
        }
    }
}
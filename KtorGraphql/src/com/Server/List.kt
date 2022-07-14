package com.example.com.Server

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import io.ktor.application.*
import org.ktorm.dsl.from
import org.ktorm.dsl.map
import org.ktorm.dsl.select
fun SchemaBuilder.BruC(){
        val db = DataBaseConnection.database
        val dadta = db.from(employetableobj).select().map { row -> employetableobj.createEntity(row) }
        println("--------------->>>>>>>>")
        println(dadta)
        println("--------------->>>>>>>>")
        val EmployeeList = mutableListOf(dadta)
        println(EmployeeList)

        query("EmpDetails"){
                description="Hiiiii"
                resolver { ->
                        dadta
                        //EmployeeList
                }
        }/*
        mutation("EmpInserting"){
                description="Added Succesfully.."
                resolver { ->

                }
        }*/
    }


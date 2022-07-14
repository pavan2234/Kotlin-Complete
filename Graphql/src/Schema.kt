package com.example

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.example.model.Employee
import com.example.model.EmployeeInput

fun SchemaBuilder.QuerySchema(){
    val obj:InterfaceEmployee=ClassEmployee()
    mutation("CreateEmployee"){
        description="create new player"
        resolver {employinput:EmployeeInput->
            val details = Employee(employinput.sno,employinput.name,employinput.empid)
            obj.CreateEmployee(details)
            true
        }
    }
    query("Printing"){
        description="To print the list"
        resolver {->
            obj.listEmployee()
        }
    }
}
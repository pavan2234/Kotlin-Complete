package com.example

import com.example.data.DatabaseConnection.database
import com.example.*
import com.example.model.Employee
import io.ktor.routing.*

class ClassEmployee:InterfaceEmployee {
    override fun listEmployee(): List<Employee> {
        return
    }

    override fun CreateEmployee(emp: Employee){

    }

}
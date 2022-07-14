package com.example.module

import com.example.plugins.Employee

class EmployeeRepository:EmployeeInterface {
    override fun CreateEmployee(emp: Employee) {

    }
    override fun listEmployee(): List<Employee> {
        return emptyList()
    }
}
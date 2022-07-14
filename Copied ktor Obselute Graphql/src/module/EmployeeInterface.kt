package com.example.module

import com.example.plugins.Employee

interface EmployeeInterface {
    fun CreateEmployee(emp:Employee)
    fun listEmployee() : List<Employee>
}
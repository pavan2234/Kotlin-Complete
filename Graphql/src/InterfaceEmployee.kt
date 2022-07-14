package com.example

import com.example.model.Employee

interface InterfaceEmployee {
    fun CreateEmployee(emp:Employee)
    fun listEmployee() : List<Employee>

}
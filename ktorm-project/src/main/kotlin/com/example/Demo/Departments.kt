package com.example.Demo

import me.liuwj.ktorm.schema.*


object Departments: Table<Department>("department"){
    val id = int("id").primaryKey().bindTo { it.id }
    val name = varchar("name").bindTo { it.nam }
    val location = varchar("location").bindTo { it.locatio }
}
object Employees:Table<Employee>("employee"){
    val id = int("id").primaryKey().bindTo { it.id }
    val name = varchar("name").bindTo { it.name }
    val job = varchar("job").bindTo { it.job }
    val managerId = int("managerId").bindTo { it.managerId }
    val hireDate = date("hireDate").bindTo { it.hireDate }
    val salary = float("salary").bindTo { it.salary }
    val departmentId = int("departmentId").references(Departments){ it.departmentId}
}
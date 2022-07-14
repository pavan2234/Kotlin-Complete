package com.example.Demo

import me.liuwj.ktorm.entity.Entity
import java.time.LocalDate
import java.util.*


interface Employee:Entity<Employee> {
    companion object:Entity.Factory<Employee>()
    val id:Int
    val name:String
    val job:String
    val managerId:Int
    val hireDate:LocalDate
    val salary:Float
    val departmentId:Department
}
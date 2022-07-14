package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Employee(val sno:Int,val name:String,val empid:String)

data class EmployeeInput(val sno:Int,val name:String,val empid:String)

package com.example.plugins

import kotlinx.serialization.Serializable

@Serializable
data class EmployeeCredentials(val sno:Int,val name:String,val empid:String)
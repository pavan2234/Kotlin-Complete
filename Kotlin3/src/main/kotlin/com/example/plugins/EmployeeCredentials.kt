package com.example.plugins

import kotlinx.serialization.Serializable

@Serializable
data class EmployeeCredentials(val name:String,val empid:String)
package com.example.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Nominee(
    val id:Int,
    val cust_id:Int,
    val name:String,
    val relationship:String,
    val age:Int,
    val guardian_name:String,
    val guardian_relationShip:String,
    val created_at: String,
    val updated_at: String,

)
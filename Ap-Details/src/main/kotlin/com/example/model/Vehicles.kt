package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Vehicles(
    val veh_id:Int,
    val cust_id:Int,
    val reg_number:Int,
    val type:String,
    val make:String,
    val model:String,
    val variant:String,
    val reg_date:String,
    val engine_number:Int,
    val chassis_number:Int,
    val created_at:String,
    val updated_at:String,
)
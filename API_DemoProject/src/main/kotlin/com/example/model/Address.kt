package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Address(
    val id:Int,
    val cust_id:Int,
    val veh_id:Int,
    val addr_line1:String,
    val addr_line2:String,
    val pincode:Int,
    val created_at: String,
    val updated_at: String
)
package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Vehicle_Derived(
    val id:Int,
    val reg_number:Int,
    val cust_id:Int,
    val segment:String,
    val cubic_capacity:Int,
    val seating_capacity:Int,
    val purchase_date:String,
    val fuel:String,
    val body_type:String,
    val rto_name:String,
    val rto_group_code:String,
    val rto_zone:String
)

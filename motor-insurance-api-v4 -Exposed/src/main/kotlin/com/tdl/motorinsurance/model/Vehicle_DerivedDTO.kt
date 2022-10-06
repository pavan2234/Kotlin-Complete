package com.tdl.motorinsurance.model

data class Vehicle_DerivedDTO(
    val id:String,
    val reg_number:Int,
    val cust_id:String,
    val segment:String,
    val cubic_capacity:Int,
    val seating_capacity:Int,
    val purchase_date:String,
    val fuel:String,
    val body_type:String,
    val rto: RTO?,
    val customer: CustomerDTO
)

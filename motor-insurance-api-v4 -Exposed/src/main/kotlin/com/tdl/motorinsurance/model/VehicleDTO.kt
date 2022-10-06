package com.tdl.motorinsurance.model

data class VehicleDTO(
    val id:String,
    val cust_id:String,
    val reg_number:String,
    val type:String,
    val make:String,
    val model:String,
    val variant:String,
    val reg_date:String,
    val engine_number:String,
    val chassis_number:String,
    val created_at:String,
    val updated_at:String,
    val customer: CustomerDTO
)

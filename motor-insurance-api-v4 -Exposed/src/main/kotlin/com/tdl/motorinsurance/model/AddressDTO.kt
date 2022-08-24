package com.tdl.motorinsurance.model

data class AddressDTO(
    val id:String,
    val cust_id:String,
    val veh_id:String,
    val addr_line1:String,
    val addr_line2:String,
    val pincode:String,
    val created_at: String,
    val updated_at: String,
    val customer: CustomerDTO,
    val vehicle: VehicleDTO
)

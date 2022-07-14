package com.example.dataclass

import com.example.Interface.customer
import com.example.Interface.vehicle
import kotlinx.serialization.Serializable

@Serializable
data class address(
    val addressid:Int,
    val customerid: customer,
    val vehicleid: vehicle,
    val addr_line1:String,
    val addr_line2:String,
    val pincode:String,
    val created_at: customer,
    val updated_at: customer
)

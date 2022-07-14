package com.example.dataclass

import kotlinx.serialization.Serializable

@Serializable
data class customers(val customerid:Int,
                     val cust_hash:String,
                     val name:String,
                     val phone_number:String,
                     val email:String,
                     val created_at:String,
                     val updated_at:String)

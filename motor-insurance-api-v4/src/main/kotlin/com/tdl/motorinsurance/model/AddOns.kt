package com.tdl.motorinsurance.model

data class AddOns(
    val type: String,
    val price: Double,
    val policy_tenure:Int,
    val policy_type:String
)
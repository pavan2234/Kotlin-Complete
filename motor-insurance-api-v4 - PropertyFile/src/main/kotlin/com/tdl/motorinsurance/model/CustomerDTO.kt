package com.tdl.motorinsurance.model

data class CustomerDTO(
    val id: String,
    val cust_hash: String,
    val name: String,
    val phone_number: Int,
    val email: String,
    val created_at: String,
    val updated_at: String
)
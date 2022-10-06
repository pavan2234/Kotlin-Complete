package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Customers (
    val cust_id: Int,
    val cust_hash: String,
    val name: String,
    val phone_number: Int,
    val email: String,
    val created_at: String,
    val updated_at: String
)
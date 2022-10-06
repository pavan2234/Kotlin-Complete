package com.tdl.motorinsurance.model

data class NomineeDTO(
    val id: String,
    val cust_id: String,
    val name: String,
    val relationship: String,
    val age: Int,
    val guardian: Guardian?,
    val created_at: String,
    val updated_at: String,
    val customer: CustomerDTO
)
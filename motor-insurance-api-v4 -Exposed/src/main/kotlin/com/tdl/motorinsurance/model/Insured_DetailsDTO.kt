package com.tdl.motorinsurance.model

data class Insured_DetailsDTO(
    val nomineeId:String,
    val name:String,
    val email:String,
    val phone_Number:String,
    val nominee: NomineeDTO
)

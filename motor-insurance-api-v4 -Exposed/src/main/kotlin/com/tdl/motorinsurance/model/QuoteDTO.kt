package com.tdl.motorinsurance.model

data class QuoteDTO(
    val id:String,
    val veh_id:String,
    val cust_id:String,
    val prev_policy_id:String,
     val nominees:Nominees,
    val addr_id:String,
    val type:String,
    val insurer:String,
    val insurerr:InsurerQuoteIdentifier,
    val idv_details:IDVDetails,
    val add_ons:AddOns,
    val created_at:String,
    val updated_at:String,
    val customer: CustomerDTO,
    val vehicle: VehicleDTO,
    val prev_policy:Prev_PolicyDTO,
    val address:AddressDTO
)

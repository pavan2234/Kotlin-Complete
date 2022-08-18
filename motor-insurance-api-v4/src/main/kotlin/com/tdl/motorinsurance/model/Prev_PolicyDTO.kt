package com.tdl.motorinsurance.model


data class Prev_PolicyDTO(
    val id:String,
    val veh_id:String,
    val insurer_name:String,
    val policy_number:String,
    val is_expired:Boolean,
    val ncb_benfit:Ncb_Benifit?,
    val created_at:String,
    val updated_at:String,
    val vehicle: VehicleDTO
)

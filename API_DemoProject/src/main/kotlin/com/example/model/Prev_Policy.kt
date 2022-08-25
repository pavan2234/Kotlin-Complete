package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Prev_Policy(
    val id:Int,
    val veh_id:Int,
    val insurer_name:String,
    val policy_number:Int,
    val is_expired:String,
    val ncb_benefitClaimed_prev_year:String,
    val ncb_benefitPrev_ncb:Int,
    val ncb_benefitCurr_ncb:Int,
    val created_at:String,
    val updated_at:String
)

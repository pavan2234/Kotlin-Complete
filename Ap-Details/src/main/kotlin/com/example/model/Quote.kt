package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Quote(
    val id:Int,
    val veh_id:Int,
    val cust_id:Int,
    val prev_policy_id:Int,
    val nominees_id:Int,
    val nominees_percentage:Int,
    val addr_id:Int,
    val type:String,
    val insurer:String,
    val insurer_quote_identifier_quoteNumber:String,
    val insurer_quote_identifier_ref_Number:String,
    val insurer_quote_identifier_proposal_Number:String,
    val idv_detailbase_quote:Int,
    val idv_detailbase_idv:Int,
    val idv_detail_median_quote:Int,
    val idv_detail_median_idv:Int,
    val idv_detail_max_quote:Int,
    val idv_detail_max_idv:Int,
    val add_ons_type:String,
    val add_ons_price:String,
    val policy_tenure:Int,
    val policy_type:String,
    val created_at:String,
    val updated_at:String
)

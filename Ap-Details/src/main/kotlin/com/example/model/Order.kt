package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Order(
    val id:Int,
    val quote_id:Int,
    val cust_id:Int,
    val tcp_order_id:Int,
    val tcp_transaction_id:Int,
    val tcp_refund_id:Int,
    val policy_number:Int,
    val order_amount:Int,
    val status:String,
    val failure_code:String,
    val failure_reason:String,
    val created_at:String,
    val updated_at:String
)

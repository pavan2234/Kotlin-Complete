package com.example.entities

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Order : Table<Nothing>("orders"){
    val id=int("id").primaryKey()
    val quote_id=int("quote_id")
    val cust_id=int("cust_id")
    val tcp_order_id=int("tcp_order-id")
    val tcp_transaction_id=int("tcp_transaction_id")
    val tcp_refund_id=int("tcp_refund_id")
    val policy_number=int("policy_number")
    val order_amount=int("order_amount")
    val status=varchar("status")
    val failure_code=varchar("failure_code")
    val failure_reason=varchar("failure_reason")
    val created_at=varchar("created_at")
    val updated_at=varchar("updated_at")
}


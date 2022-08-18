package com.tdl.motorinsurance.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Order : Entity<Order> {
    val id: Int
    val quote_id: Int
    val cust_id: Int
    val tcp_order_id: Int
    val tcp_transaction_id: Int
    val tcp_refund_id: Int
    val policy_number: Int
    val order_amount: Int
    val status: String
    val failure_code: String
    val failure_reason: String
    val created_at: String
    val updated_at: String
    val customer: Customer
    val quote: Quote
}

object Orders : Table<Order>("order") {
    val id = varchar("id").primaryKey()
    val quote_id = varchar("quote_id")
    val cust_id = varchar("cust_id")
    val tcp_order_id = varchar("tcp_order_id")
    val tcp_transaction_id = varchar("tcp_transaction_id")
    val tcp_refund_id = varchar("tcp_refund_id")
    val policy_number = varchar("policy_number")
    val order_amount = int("order_amount")
    val status = varchar("status")
    val failure_code = varchar("failure_code")
    val failure_reason = varchar("failure_reason")
    val created_at = varchar("created_at")
    val updated_at = varchar("updated_at")
}
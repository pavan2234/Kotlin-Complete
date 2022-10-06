package com.example.entities

import org.jetbrains.exposed.sql.Table


object Order : Table("order"){
    val id=integer("id")
    val quote_id=integer("quote_id")
    val cust_id=integer("cust_id")
    val tcp_order_id=integer("tcp_order-id")
    val tcp_transaction_id=integer("tcp_transaction_id")
    val tcp_refund_id=integer("tcp_refund_id")
    val policy_number=integer("policy_number")
    val order_amount=integer("order_amount")
    val status=varchar("status",50)
    val failure_code=varchar("failure_code",50)
    val failure_reason=varchar("failure_reason",50)
    val created_at=varchar("created_at",50)
    val updated_at=varchar("updated_at",50)

    override val primaryKey=PrimaryKey(id)
}


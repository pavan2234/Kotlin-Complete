package com.example.entitybinding

import com.example.EntityBindings.Customer
import com.example.EntityBindings.Customers
import com.example.EntityBindings.Nominees.references
import com.example.entities.Order.primaryKey
import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Order:Entity<Order>{
    val id:Int
    val quote_id:Int
    val cust_id:Int
    val tcp_order_id:Int
    val tcp_transaction_id:Int
    val tcp_refund_id:Int
    val policy_number:Int
    val order_amount:Int
    val status:String
    val failure_code:String
    val failure_reason:String
    val created_at:String
    val updated_at:String
    val customer: Customer
    val quote:Quote

}
object Orders:Table<Order>("order"){
    val id=int("id").primaryKey().bindTo { it.id }
    val quote_id=int("quote_id").references(Quotes){it.quote}
    val cust_id=int("cust_id").references(Customers){it.customer}
    val tcp_order_id=int("tcp_order_id").bindTo { it.tcp_order_id }
    val tcp_transaction_id=int("tcp_transaction_id").bindTo { it.tcp_transaction_id }
    val tcp_refund_id=int("tcp_refund_id").bindTo { it.tcp_refund_id }
    val policy_number=int("policy_number").bindTo { it.policy_number}
    val order_amount=int("order_amount").bindTo { it.order_amount }
    val status=varchar("status").bindTo { it.status }
    val failure_code=varchar("failure_code").bindTo { it.failure_code }
    val failure_reason=varchar("failure_reason").bindTo { it.failure_reason }
    val created_at=varchar("created_at").bindTo { it.created_at }
    val updated_at=varchar("updated_at").bindTo { it.updated_at }
}
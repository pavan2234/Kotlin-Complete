package com.example.repositaries

import com.example.dbconfig.DatabaseConnection
import com.example.entitybinding.Orders
import com.example.model.Order
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.insert

fun Application.OrderConfigureRepo() {
    val db = DatabaseConnection.database
    routing {
        route("/api/v1/fs/mi") {
            get("/OrderdetailsInserting") {
                val orderdetails=call.receive<Order>()
                val id=orderdetails.id
                val quote_id=orderdetails.quote_id
                val cust_id=orderdetails.cust_id
                val tcp_order_id=orderdetails.tcp_order_id
                val tcp_transaction_id=orderdetails.tcp_transaction_id
                val tcp_refund_id=orderdetails.tcp_refund_id
                val policy_number=orderdetails.policy_number
                val order_amount=orderdetails.order_amount
                val status=orderdetails.status
                val failure_code=orderdetails.failure_code
                val failure_reason=orderdetails.failure_reason
                val created_at=orderdetails.created_at
                val updated_at=orderdetails.updated_at

                db.insert(Orders){
                    set(it.id,id)
                    set(it.quote_id,quote_id)
                    set(it.cust_id,cust_id)
                    set(it.tcp_order_id,tcp_order_id)
                    set(it.tcp_transaction_id,tcp_transaction_id)
                    set(it.tcp_refund_id,tcp_refund_id)
                    set(it.policy_number,policy_number)
                    set(it.order_amount,order_amount)
                    set(it.status,status)
                    set(it.failure_code,failure_code)
                    set(it.failure_reason,failure_reason)
                    set(it.created_at,created_at)
                    set(it.updated_at,updated_at)
                }
                call.respondText("Succesfully Inserted..")
            }
        }
    }
}


package com.example.EntityBinding

import com.example.Interface.customer
import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object customers:Table<customer>("customer") {
    val customerid=int("id").primaryKey().bindTo { it.customerid }
    val cust_hash = varchar("cust_hash").bindTo { it.cust_hash }
    val name=varchar("name").bindTo { it.name }
    val phone_number=varchar("phone_number").bindTo { it.phone_number }
    val email=varchar("email").bindTo { it.email }
    val created_at=varchar("created_at").bindTo { it.created_at }
    val updated_at=varchar("updated_at").bindTo { it.updated_at }
}
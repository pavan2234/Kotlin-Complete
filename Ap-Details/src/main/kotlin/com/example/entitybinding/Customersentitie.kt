package com.example.EntityBindings

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar



interface Customer : Entity<Customer> {
    val cust_id:Int
    val cust_hash: String
    val name: String
    val phone_number: String
    val email: String
    val created_at: String
    val updated_at: String
}

object Customers : Table<Customer>("customer"){
    val cust_id=int("cust_id").primaryKey().bindTo { it.cust_id }
    val cust_hash=varchar("cust_hash").bindTo { it.cust_hash }
    val name=varchar("name").bindTo { it.name }
    val phone_number=varchar("phone_number").bindTo { it.phone_number }
    val email=varchar("email").bindTo { it.email }
    val created_at=varchar("created_at").bindTo { it.created_at }
    val updated_at=varchar("updated_at").bindTo { it.updated_at }
}

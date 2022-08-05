package com.example.entities

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Customer : Table<Nothing>("customer"){
    val cust_id=int("cust_id").primaryKey()
    val cust_hash=varchar("cust_hash")
    val name=varchar("name")
    val phone_number=int("phone_number")
    val email=varchar("email")
    val created_at=varchar("created_at")
    val updated_at=varchar("updated_at")
}
package com.example.Entities

import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object customersentity:Table<Nothing>("customers"){
    val customerid=int("customerid").primaryKey()
    val cust_hash=varchar("cust_hash")
    val name=varchar("name")
    val phone_number=varchar("phone_number")
    val email=varchar("email")
    val created_at=varchar("created_at")
    val updated_at=varchar("updated_at")
}
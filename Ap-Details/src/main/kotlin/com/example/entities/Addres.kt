package com.example.entities

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Addres: Table<Nothing>("address"){
    val id =int("id").primaryKey()
    val cust_id=int("cust_id")
    val veh_id=int("veh_id")
    val addr_line1=varchar("addr_line1")
    val addr_line2=varchar("addr_line2")
    val pincode=int("pincode")
    val created_at=varchar("created_at")
    val updated_at=varchar("updated_at")
}
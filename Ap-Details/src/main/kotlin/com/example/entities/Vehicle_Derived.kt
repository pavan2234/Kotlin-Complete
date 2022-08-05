package com.example.entities

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


object Vehicle_Derived : Table<Nothing>("vehicle_derived"){
    val id=int("id").primaryKey()
    val reg_number=int("reg_number")
    val cust_id=int("cust_id")
    val segment=varchar("segment")
    val cubic_capacity=int("cubic_capacity")
    val seating_capacity=int("seating_capacity")
    val purchase_date=varchar("purchase_date")
    val fuel=varchar("fuel")
    val body_type=varchar("body_type")
    val rto_name=varchar("rto_name")
    val rto_group_code=varchar("rto_group_code")
    val rto_zone=varchar("rto_zone")
}
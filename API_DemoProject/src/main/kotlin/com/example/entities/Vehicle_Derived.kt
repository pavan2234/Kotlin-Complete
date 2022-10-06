package com.example.entities

import org.jetbrains.exposed.sql.Table


object Vehicle_Derived : Table("vehicle_derived"){
    val id=integer("id")
    val reg_number=integer("reg_number")
    val cust_id=integer("cust_id")
    val segment=varchar("segment",50)
    val cubic_capacity=integer("cubic_capacity")
    val seating_capacity=integer("seating_capacity")
    val purchase_date=varchar("purchase_date",50)
    val fuel=varchar("fuel",50)
    val body_type=varchar("body_type",50)
    val rto_name=varchar("rto_name",50)
    val rto_group_code=varchar("rto_group_code",50)
    val rto_zone=varchar("rto_zone",50)


    override val primaryKey=PrimaryKey(id)
}
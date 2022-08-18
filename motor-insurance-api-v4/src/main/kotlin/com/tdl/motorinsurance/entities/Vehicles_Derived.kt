package com.tdl.motorinsurance.entities

import com.tdl.motorinsurance.model.RTO
import org.ktorm.entity.Entity
import org.ktorm.jackson.json
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Vehicle_Derived : Entity<Vehicle_Derived> {
    val id: String
    val reg_number: Int
    val cust_id: Int
    val segment: String
    val cubic_capacity: Int
    val seating_capacity: Int
    val purchase_date: String
    val fuel: String
    val body_type: String
    val rto:RTO?
    val customer: Customer
}

object Vehicles_Derived : Table<Vehicle_Derived>("vehicle_derived") {
    val id = varchar("id").primaryKey().bindTo { it.id }
    val reg_number = int("reg_number").bindTo { it.reg_number }
    val cust_id = varchar("cust_id").references(Customers) { it.customer }
    val segment = varchar("segment").bindTo { it.segment }
    val cubic_capacity = int("cubic_capacity").bindTo { it.cubic_capacity }
    val seating_capacity = int("seating_capacity").bindTo { it.seating_capacity }
    val purchase_date = varchar("purchase_date").bindTo { it.purchase_date }
    val fuel = varchar("fuel").bindTo { it.fuel }
    val body_type = varchar("body_type").bindTo { it.body_type }
    val rto=json<RTO>("rto").bindTo { it.rto }
}

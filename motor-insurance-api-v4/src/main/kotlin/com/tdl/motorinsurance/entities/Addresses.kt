package com.tdl.motorinsurance.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.datetime
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Address : Entity<Address> {
    val id: String
    val cust_id: String
    val veh_id: String
    val addr_line1: String
    val addr_line2: String
    val pincode: String
    val created_at: String
    val updated_at: String
    val customer: Customer
    val vehicle: Vehicle
}

object Addresses : Table<Address>("address") {
    val id = varchar("id").primaryKey().bindTo { it.id }
    val cust_id = varchar("cust_id").references(Customers) { it.customer }
    val veh_id = varchar("veh_id").references(Vehicles) { it.vehicle }
    val addr_line1 = varchar("addr_line1").bindTo { it.addr_line1 }
    val addr_line2 = varchar("addr_line2").bindTo { it.addr_line2 }
    val pincode = varchar("pincode").bindTo { it.pincode }
    val created_at = varchar("created_at").bindTo { it.created_at }
    val updated_at = varchar("updated_at").bindTo { it.updated_at}
}
package com.tdl.motorinsurance.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Vehicle : Entity<Vehicle> {
    val id: String
    val cust_id: Int
    val reg_number: String
    val type: String
    val make: String
    val model: String
    val variant: String
    val reg_date: String
    val engine_number: String
    val chassis_number: String
    val created_at: String
    val updated_at: String
    val customer: Customer
}

object Vehicles : Table<Vehicle>("vehicle") {
    val id = varchar("id").primaryKey().bindTo { it.id }
    val cust_id = varchar("cust_id").references(Customers){it.customer}
    val reg_number = varchar("reg_number").bindTo { it.reg_number }
    val type = varchar("type").bindTo { it.type }
    val make = varchar("make").bindTo { it.make }
    val model = varchar("model").bindTo { it.model }
    val variant = varchar("variant").bindTo { it.variant }
    val reg_date = varchar("reg_date").bindTo { it.reg_date }
    val engine_number = varchar("engine_number").bindTo { it.engine_number }
    val chassis_number = varchar("chassis_number").bindTo { it.chassis_number }
    val created_at = varchar("created_at").bindTo { it.created_at }
    val updated_at = varchar("updated_at").bindTo { it.updated_at }

}
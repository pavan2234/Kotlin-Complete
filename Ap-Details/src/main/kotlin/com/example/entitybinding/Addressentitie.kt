package com.example.EntityBindings

import com.example.entities.Customer
import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Address : Entity<Address> {
    val id:Int
    val cust_id:Int
    val veh_id:Int
    val addr_line1:String
    val addr_line2:String
    val pincode:Int
    val created_at: String
    val updated_at: String
    val customer: com.example.EntityBindings.Customer
    val vehicle: com.example.EntityBindings.Vehicle
}
object Addres : Table<Address>("address") {
    val id =int("id").primaryKey().bindTo { it.id }
    val cust_id=int("cust_id").references(Customers){it.customer}
    val veh_id=int("veh_id").references(Vehicles){it.vehicle}
    val addr_line1=varchar("addr_line1").bindTo { it.addr_line1 }
    val addr_line2=varchar("addr_line2").bindTo { it.addr_line2 }
    val pincode=int("pincode").bindTo { it.pincode }
    val created_at=varchar("created_at").bindTo { it.created_at }
    val updated_at=varchar("updated_at").bindTo { it.updated_at }
}


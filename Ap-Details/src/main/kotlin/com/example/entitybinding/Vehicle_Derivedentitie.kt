    package com.example.entitybinding

import com.example.EntityBindings.Customer
import com.example.EntityBindings.Customers
import com.example.EntityBindings.Vehicle
import com.example.entities.Vehicle_Derived.primaryKey
import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Vehicle_Derived:Entity<Vehicle_Derived>{
    val id:Int
    val reg_number:Int
    val cust_id:Int
    val segment:String
    val cubic_capacity:Int
    val seating_capacity:Int
    val purchase_date:String
    val fuel:String
    val body_type:String
    val rto_name:String
    val rto_group_code:String
    val rto_zone:String
    val customer: Customer

}
object Vehicle_Derives:Table<Vehicle_Derived>("vehicle_derived"){
    val id=int("id").primaryKey().bindTo { it.id }
    val reg_number=int("reg_number").bindTo { it.reg_number }
    val cust_id=int("cust_id").references(Customers){it.customer}
    val segment=varchar("segment").bindTo { it.segment }
    val cubic_capacity=int("cubic_capacity").bindTo { it.cubic_capacity }
    val seating_capacity=int("seating_capacity").bindTo { it.seating_capacity }
    val purchase_date=varchar("purchase_date").bindTo { it.purchase_date }
    val fuel=varchar("fuel").bindTo { it.fuel }
    val body_type=varchar("body_type").bindTo { it.body_type }
    val rto_name=varchar("rto_name").bindTo { it.rto_name }
    val rto_group_code=varchar("rto_group_code").bindTo { it.rto_group_code }
    val rto_zone=varchar("rto_zone").bindTo { it.rto_zone }
}

package com.example.EntityBindings

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


interface Vehicle : Entity<Vehicle> {
    val veh_id:Int
    val cust_id:Int
    val reg_number:Int
    val type:String
    val make:String
    val model:String
    val variant:String
    val reg_date:String
    val engine_number:Int
    val chassis_number:Int
    val created_at:String
    val updated_at:String
    val customer: Customer
}

object Vehicles : Table<Vehicle>("vehicle"){
    val veh_id=int("veh_id").primaryKey().bindTo { it.veh_id }
    val cust_id=int("cust_id").references(Customers){it.customer}
    val reg_number=int("reg_number").bindTo { it.reg_number }
    val type=varchar("type").bindTo { it.type }
    val make=varchar("make").bindTo { it.make }
    val model=varchar("model").bindTo { it.model }
    val variant=varchar("variant").bindTo { it.variant }
    val reg_date=varchar("reg_date").bindTo { it.reg_date }
    val engine_number=int("engine_number").bindTo { it.engine_number }
    val chassis_number=int("chassis_number").bindTo { it.chassis_number }
    val created_at=varchar("created_at").bindTo { it.created_at }
    val updated_at=varchar("updated_at").bindTo { it.updated_at }

}

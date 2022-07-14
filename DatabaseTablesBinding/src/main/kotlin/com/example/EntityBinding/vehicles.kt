package com.example.EntityBinding

import com.example.Interface.vehicle
import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object vehicles:Table<vehicle>("vehicle") {
    val vehicleid=int("id").primaryKey().bindTo { it.vehicleid }
    val reg_number=varchar("reg_number").bindTo { it.reg_number }
    val customerid = varchar("customer_id").references(customers){it.customerid}
    val type=varchar("type").bindTo { it.type }
    val make=varchar("make").bindTo { it.make }
    val model=varchar("model").bindTo { it.model }
    val variant=varchar("variant").bindTo { it.variant }
    val reg_date=varchar("reg_date").bindTo { it.reg_date }
    val engine_number=varchar("engine_number").bindTo { it.engine_number }
    val chassis_number=varchar("chassis_number").bindTo { it.chassis_number }
    val created_at=varchar("created_at_ve").references(customers){it.created_at}
    val updated_at=varchar("updated_at_ve").references(customers){it.updated_at}

}
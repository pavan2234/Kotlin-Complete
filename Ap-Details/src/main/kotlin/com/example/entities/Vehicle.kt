package com.example.entities

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


object Vehicle : Table<Nothing>("vehicle"){
    val veh_id=int("veh_id").primaryKey()
    val cust_id=int("cust_id")
    val reg_number=int("reg_number")
    val type=varchar("type")
    val make=varchar("make")
    val model=varchar("model")
    val variant=varchar("variant")
    val reg_date=varchar("reg_date")
    val engine_number=int("engine_number")
    val chassis_number=int("chassis_number")
    val created_at=varchar("created_at")
    val updated_at=varchar("updated_at")
}

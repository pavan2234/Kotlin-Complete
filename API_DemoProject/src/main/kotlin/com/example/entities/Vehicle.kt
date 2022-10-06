package com.example.entities

import org.jetbrains.exposed.sql.Table


object Vehicle : Table("vehicle"){
    val veh_id=integer("veh_id")
    val cust_id=integer("cust_id")
    val reg_number=integer("reg_number")
    val type=varchar("type",50)
    val make=varchar("make",50)
    val model=varchar("model",50)
    val variant=varchar("variant",50)
    val reg_date=varchar("reg_date",50)
    val engine_number=integer("engine_number")
    val chassis_number=integer("chassis_number")
    val created_at=varchar("created_at",50)
    val updated_at=varchar("updated_at",50)

    override val primaryKey=PrimaryKey(veh_id)
}

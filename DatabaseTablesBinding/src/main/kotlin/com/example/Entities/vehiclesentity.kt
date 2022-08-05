package com.example.Entities

import com.example.EntityBinding.customers
import com.example.EntityBinding.vehicles
import com.example.EntityBinding.vehicles.created_at
import com.example.EntityBinding.vehicles.references
import com.example.EntityBinding.vehicles.updated_at
import com.example.Interface.customer
import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object vehiclesentity:Table<Nothing>("vehicle") {
    val vehicleid=int("vehicleid")
    val reg_number=varchar("reg_number")
    val customerid=varchar("customerid")
    val type=varchar("type")
    val make=varchar("make")
    val model=varchar("model")
    val variant=varchar("variant")
    val reg_date=varchar("reg_date")
    val engine_number=varchar("engine_number")
    val chassis_number=varchar("chassis_number")
    val created_at=varchar("created_at")
    val updated_at=varchar("updated_at")
}
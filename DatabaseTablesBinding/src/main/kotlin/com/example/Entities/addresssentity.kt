package com.example.Entities

import com.example.EntityBinding.addresss
import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object addresssentity:Table<Nothing>("address") {
    val addressid=int("addressid").primaryKey()
    val customerid=varchar("customerid")
    val vehicleid = varchar("vehicleid")
    val addr_line1=varchar("addr_line1")
    val addr_line2=varchar("addr_line2")
    val pincode=varchar("pincode")
    val created_at=varchar("created_at")
    val updated_at=varchar("updated_at")
}
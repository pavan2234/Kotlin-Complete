package com.example.entities

import org.jetbrains.exposed.sql.ForeignKeyConstraint
import org.jetbrains.exposed.sql.Table
import javax.swing.SpringLayout

object Addres :Table("address"){
    val id =integer("id")
    val cust_id=integer("cust_id")
    val veh_id=integer("veh_id")
    val addr_line1=varchar("addr_line1",50)
    val addr_line2=varchar("addr_line2",50)
    val pincode=integer("pincode")
    val created_at=varchar("created_at",50)
    val updated_at=varchar("updated_at",50)

    override val primaryKey=PrimaryKey(id)
}
package com.example.entities

import org.jetbrains.exposed.sql.Table


object Customer: Table("customer"){
    val cust_id= integer("cust_id")
    val cust_hash= varchar("cust_hash",50)
    val name= varchar("name",50)
    val phone_number=integer("phone_num")
    val email=varchar("email",50)
    val created_at=varchar("created_at",50)
    val updated_at=varchar("updated-at",50)

    override val primaryKey=PrimaryKey(cust_id)
}
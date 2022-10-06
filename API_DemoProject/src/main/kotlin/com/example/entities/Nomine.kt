package com.example.entities

import org.jetbrains.exposed.sql.Table


object Nomine: Table("nominee"){
    val id=integer("id")
    val cust_id=integer("cust_id")
    val name=varchar("name",50)
    val relationship=varchar("relationship",50)
    val age=integer("age")
    val guardian_name=varchar("guardian_name",50)
    val guardian_relationShip=varchar("guardian_relationShip",50)
    val created_at=varchar("customerCreated_At",50)
    val updated_at=varchar("customerUpdated_At",50)
    val maark=varchar("maark",50)

    override val primaryKey=PrimaryKey(id)
}
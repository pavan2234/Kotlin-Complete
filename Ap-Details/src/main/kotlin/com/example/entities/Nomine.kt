package com.example.entities

import kotlinx.serialization.json.Json
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


object Nomine: Table<Nothing>("nomine"){
    val id=int("id").primaryKey()
    val cust_id=int("cust_id")
    val name=varchar("name")
    val relationship=varchar("relationship")
    val age=int("age")
    val guardian_name=varchar("guardian_name")
    val guardian_relationShip=varchar("guardian_relationShip")
    val created_at=varchar("customerCreated_At")
    val updated_at=varchar("customerUpdated_At")
    val maark=varchar("maark")
}
package com.example.Entities

import com.example.Interface.nominee
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object nomineesentity: Table<Nothing>("nominee"){
    val nomineeid=int("nomineeid").primaryKey()
    val customertid=int("customerid")
    val name=varchar("name")
    val relationship=varchar("relationship")
    val age=int("age")
    val guardian_name=varchar("guardian_name")
    val guardian_relationShip=varchar("guardian_relationShip")
    val created_at=varchar("customerCreated_At")
    val updated_at=varchar("customerUpdated_At")
    val maark=varchar("maark")
}

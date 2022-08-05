package com.example.EntityBinding

import com.example.Interface.customer
import com.example.Interface.nominee
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


object nominees: Table<nominee>("nomine"){
    val nomineeid=int("nomineeid").primaryKey().bindTo { it.nomineeid }
    val customerid = int("customerid").references()
    val name=varchar("name").bindTo { it.name }
    val relationship=varchar("relationship").bindTo { it.relationship }
    val age=int("age").bindTo { it.age }
    val guardian_name=varchar("guardian_name").bindTo { it.guardian_name }
    val guardian_relationShip=varchar("guardian_relationShip").bindTo { it.guardian_relationShip }
    val created_at=varchar("created_at").bindTo { it.created_at }
    val updated_at=varchar("updated_at").bindTo { it.updated_at }
}
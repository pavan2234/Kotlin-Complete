package com.example.EntityBindings

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


interface Nominee : Entity<Nominee> {
    val id:Int
    val cust_id:Int
    val name:String
    val relationship:String
    val age:Int
    val guardian_name:String
    val guardian_relationShip:String
    val created_at: String
    val updated_at: String
    val customer:Customer
}

object Nominees:Table<Nominee>("nominee"){
    val id=int("id").primaryKey().bindTo { it.id }
    val cust_id=int("cust_id").references(Customers){it.customer}
    val name=varchar("name").bindTo { it.name }
    val relationship=varchar("relationship").bindTo { it.relationship }
    val age=int("age").bindTo { it.age }
    val guardian_name=varchar("guardian_name").bindTo { it.guardian_name }
    val guardian_relationShip=varchar("guardian_relationShip").bindTo { it.guardian_relationShip }
    val created_at=varchar("created_at").bindTo { it.created_at }
    val updated_at=varchar("updated_at").bindTo { it.updated_at }
}

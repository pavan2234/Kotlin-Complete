package com.tdl.motorinsurance.entities

import com.tdl.motorinsurance.model.Guardian
import org.ktorm.entity.Entity
import org.ktorm.jackson.json
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Nominee : Entity<Nominee> {
    val id: String
    val cust_id: String
    val name: String
    val relationship: String
    val age: Int
    val guardian: Guardian?
    val created_at: String
    val updated_at: String
    val customer: Customer
}

object Nominees : Table<Nominee>("nomine") {
    val id = varchar("id").primaryKey().bindTo { it.id }
    val cust_id = varchar("cust_id").references(Customers) { it.customer }
    val name = varchar("name").bindTo { it.name }
    val relationship = varchar("relationship").bindTo { it.relationship }
    val age = int("age").bindTo { it.age }
    val guardian = json<Guardian>("guardian").bindTo { it.guardian }
    val created_at = varchar("created_at").bindTo { it.created_at }
    val updated_at = varchar("updated_at").bindTo { it.updated_at }
}

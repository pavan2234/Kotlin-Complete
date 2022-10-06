package com.example.entity

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface placement:Entity<placement>{
    val id :Int
    val company_id:Int
    val noofstudents:String
    val passing_year:String
    val pack_age : String
    val location : String
    val wfh : String
    val company : company
}
object placements:Table<placement>("placements"){
    val id = int("id").primaryKey().bindTo { it.id }
    val company_id = int("company_id").references(companies){it.company}
    val noofstudents = varchar("noofstudents").bindTo { it.noofstudents }
    val passing_year = varchar("passing_year").bindTo { it.passing_year }
    val pack_age = varchar("pack_age").bindTo { it.pack_age }
    val location = varchar("location").bindTo { it.location }
    val wfh = varchar("wfh").bindTo { it.wfh }
}
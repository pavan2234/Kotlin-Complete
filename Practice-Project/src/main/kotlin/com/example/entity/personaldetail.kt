package com.example.entity

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface personaldetail:Entity<personaldetail>{
    val id: Int
    val name: String
    val dob: String
    val father: String
    val placement_id: Int
    val bus_id: Int
    val college_id :Int
    val company_id:Int
    val placement : placement
    val bus : busdetail
    val college : collegedetail
    val company : company

}
object persons:Table<personaldetail>("personaldetails"){
    val id = int("id").primaryKey().bindTo { it.id }
    val name = varchar("name").bindTo { it.name }
    val dob = varchar("dob").bindTo { it.dob }
    val father = varchar("father").bindTo { it.father }
    val placement_id = int("placement_id").references(placements){it.placement}
    val bus_id = int("bus_id").references(busdetails){it.bus}
    val college_id = int("college_id").references(collegedetails){it.college}
    val company_id = int("company_id").references(companies){it.company}
}
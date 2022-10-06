package com.example.entity

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface collegedetail:Entity<collegedetail>{
     val id :Int
     val name : String
     val affliated: String
     val location_id : Int
     val bus_id: Int
     val company_id:Int
     val location : location
     val bus : busdetail
     val company : company
}
 object collegedetails:Table<collegedetail>("collegedetails"){
      val id = int("id").primaryKey().bindTo { it.id }
      val name = varchar("name").bindTo { it.name }
      val affliated = varchar("affliated").bindTo { it.affliated }
      val bus_id = int("bus_id").references(busdetails){ it.bus}
      val company_id = int("company_id").references(companies){ it.company}
      val location_id = int("location_id").references(locations){ it.location}

 }
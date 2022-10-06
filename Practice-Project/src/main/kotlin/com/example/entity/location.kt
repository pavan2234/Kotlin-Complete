package com.example.entity

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface location: Entity<location>{
    val id:Int
    val road_no:String
    val colony:String
    val area :String
    val pincode:String
    val mobilenumber:String
}
object locations:Table<location>("location"){
    val id = int("id").primaryKey().bindTo { it.id }
    val road_no = varchar("road_no").bindTo { it.road_no }
    val colony = varchar("colony").bindTo { it.colony }
    val area = varchar("area").bindTo { it.area }
    val pincode = varchar("pincode").bindTo { it.pincode }
    val mobilenumber = varchar("mobilenumber").bindTo { it.mobilenumber }
}
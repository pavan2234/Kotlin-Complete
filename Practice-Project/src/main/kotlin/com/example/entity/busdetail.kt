package com.example.entity

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface busdetail:Entity<busdetail>{
    val id:Int
    val route :String
    val fee : String
    val capacity: String
    val time : String
}
object busdetails:Table<busdetail>("bus"){
    val id = int("id").primaryKey().bindTo { it.id }
    val route = varchar("route").bindTo { it.route }
    val fee = varchar("fee").bindTo { it.fee }
    val capacity = varchar("capacity").bindTo { it.capacity }
    val time = varchar("time").bindTo { it.time }
}

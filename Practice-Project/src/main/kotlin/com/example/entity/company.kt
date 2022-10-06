package com.example.entity

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


interface company: Entity<company> {
    val id : Int
    val name :String
    val location : String
    val package_offered:String
    val mnc_or_startup : String
    val bond:String
}
object companies:Table<company>("company"){
    val id = int("id").primaryKey().bindTo { it.id }
    val name = varchar("name").bindTo { it.name }
    val location = varchar("location").bindTo { it.location }
    val package_offered = varchar("package_offered").bindTo { it.package_offered }
    val mnc_or_startup = varchar("mnc_or_startup").bindTo { it.mnc_or_startup }
    val bond = varchar("bond").bindTo { it.bond }
}

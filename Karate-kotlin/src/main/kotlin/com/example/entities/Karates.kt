package com.example.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface karate:Entity<karate> {
        val id:Int
        val name:String
        val age:String
        val area:String
}

object Karates:Table<karate>("trainees"){
        val id = int("id").primaryKey().bindTo { it.id }
        val name = varchar("name").bindTo { it.name }
        val age = varchar("age").bindTo { it.age }
        val area = varchar("area").bindTo { it.area }
}
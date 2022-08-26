package com.example.entities

import org.jetbrains.exposed.sql.Table


object Kungfu: Table("kungfu"){
    val kungfu_id = integer("kungfu_id").uniqueIndex()
    val name = varchar("name",50)
    val age = varchar("age",50)
    val area = varchar("area",50)
}
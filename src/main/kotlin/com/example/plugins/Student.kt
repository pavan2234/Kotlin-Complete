package com.example.plugins

import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object student:Table<Nothing>("details"){
    val id=int("id").primaryKey()
    val name=varchar("name")
    val password =varchar("password")
}
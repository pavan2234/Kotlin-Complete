package com.example.module

import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object EmployTable:Table<Nothing>("details") {
    val sno=int("sno").primaryKey()
    val name =varchar("name")
    val empid = varchar("empid")
}
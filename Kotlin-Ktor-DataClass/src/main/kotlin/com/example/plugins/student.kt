package com.example.plugins

import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object student:Table<Nothing>("details") {
        val sno=int("id").primaryKey()
        val name=varchar("-name")
        val empid=varchar("password")
}
package com.example

import com.example.Student.primaryKey
import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object NewStudent:Table<Nothing>("student") {
    var id =int("id").primaryKey()
    var name = varchar("name")
    var age =int("age")
}
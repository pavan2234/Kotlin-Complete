package com.example

import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object Student :Table<Nothing>("students"){
        var id =int("id").primaryKey()
        var name = varchar("name")
        var age =int("age")
}
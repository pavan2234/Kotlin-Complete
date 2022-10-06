package com.example.Dummy

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Book:Entity<Book> {
    var id: Int
    val title: String
    val author: String
    val shopidb: Int
}

object Books:Table<Book>("books"){
    var id = int("id").primaryKey().bindTo { it.id }
    val title = varchar("title").bindTo { it.title }
    val author = varchar("author").bindTo { it.author }
    val shopidb = int("shopidb").bindTo { it.shopidb }
}
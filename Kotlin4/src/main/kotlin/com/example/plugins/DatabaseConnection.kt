package com.example.plugins

import me.liuwj.ktorm.database.Database

object DatabaseConnection {
    val url="jdbc:mysql://localhost:3306/pavan"
    val driver="com.mysql.cj.jdbc.Driver"
    val user="root"
    val password="root"
    val database= Database.connect(url,driver, user, password)
}
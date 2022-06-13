package com.example.plugins

import me.liuwj.ktorm.database.Database

object database {
    val Driver ="com.mysql.cj.jdbc.Driver"
    val url ="jdbc:mysql://localhost:3306/students"
    val username = "root"
    val password = "root"
    val database = Database.connect(url,Driver, username, password)
}
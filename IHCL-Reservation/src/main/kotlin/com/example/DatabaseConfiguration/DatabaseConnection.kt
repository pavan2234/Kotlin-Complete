package com.example.DatabaseConfiguration

import org.ktorm.database.Database

object DataBaseConnection {
    val url="jdbc:mysql://localhost:3306/ihcl"
    val driver="com.mysql.cj.jdbc.Driver"
    val user="root"
    val password="root"
    val database= Database.connect(url, driver, user, password)
}
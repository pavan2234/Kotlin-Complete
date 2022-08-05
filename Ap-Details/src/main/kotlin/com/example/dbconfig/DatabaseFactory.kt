package com.example.dbconfig

import org.ktorm.database.Database

object DatabaseConnection {
    val url="jdbc:mysql://localhost:3306/demoproject"
    val driver = "com.mysql.cj.jdbc.Driver"
    val user="root"
    val password="root"
    val database= Database.connect(url,driver, user, password)

}
val db=DatabaseConnection.database
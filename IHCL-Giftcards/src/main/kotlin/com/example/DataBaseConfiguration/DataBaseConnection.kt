package com.example.DataBaseConfiguration

import org.ktorm.database.Database

/*
object DatabaseConnection {
    val url="jdbc:mysql://localhost:3306/demoproject"
    val driver="com.mysql.cj.jdbc.Driver"
    val user="root"
    val password="techouts"
    val database= Database.connect(url,driver, user, password)
}*/
object DataBaseConnection {
    val url="jdbc:mysql://localhost:3306/ihcl"
    val driver="com.mysql.cj.jdbc.Driver"
    val user="root"
    val password="root"
    val database= Database.connect(url, driver, user, password)
}

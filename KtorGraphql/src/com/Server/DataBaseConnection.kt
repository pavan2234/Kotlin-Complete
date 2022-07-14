package com.example.com.Server

import org.ktorm.database.Database

object DataBaseConnection {
    val url="jdbc:mysql://localhost:3306/ktorservergraphql"
    val driver="com.mysql.cj.jdbc.Driver"
    val user="root"
    val password="techouts"
    val database= Database.connect(url,driver, user, password)
}
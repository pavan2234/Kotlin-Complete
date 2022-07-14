package com.example.database

import me.liuwj.ktorm.database.Database

object DatabaseConnection {
    val database = Database.connect(
        url="jdbc:mysql://localhost:3306/demoproject",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "root"
    )

}
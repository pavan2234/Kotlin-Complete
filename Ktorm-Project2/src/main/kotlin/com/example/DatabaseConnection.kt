package com.example

import me.liuwj.ktorm.database.Database

object DatabaseConnection {
    val database = Database.connect("jdbc:mysql://localhost:3306/office","com.mysql.cj.jdbc.Driver", user = "root", password = "root")
}
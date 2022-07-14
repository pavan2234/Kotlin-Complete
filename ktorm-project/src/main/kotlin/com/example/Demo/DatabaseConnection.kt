package com.example


import me.liuwj.ktorm.database.Database

    val database = Database.connect(
        url="jdbc:mysql://localhost:3306/pavan",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "root"
    )

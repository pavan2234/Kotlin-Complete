package com.example.hi

import com.example.Student
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println
import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.dsl.from
import me.liuwj.ktorm.dsl.select

fun main() {
    val database = Database.connect("jdbc:mysql://localhost:3306/pavan", user = "root", password = "root")

    for (row in database.from(Student).select()) {
        println(row[Student.name])
    }
}
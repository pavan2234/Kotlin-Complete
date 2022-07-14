package com.example.plugins

import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.dsl.QueryRowSet
import me.liuwj.ktorm.entity.sequenceOf
import me.liuwj.ktorm.schema.BaseTable
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object Employee: BaseTable<EmployeeDataClass>("details") {
        val sno=int("sno").primaryKey()
        val name=varchar("name")
        val empid=varchar("empid")

        override fun doCreateEntity(row: QueryRowSet, withReferences: Boolean)= EmployeeDataClass(
                sno = row[sno] ?: 0,
                name = row[name].toString(),
                empid = row[empid].toString(),
        )

}
val Database.Employe get() =this.sequenceOf(Employee)
package com.example.com.Server

import org.ktorm.database.Database
import org.ktorm.dsl.QueryRowSet
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.BaseTable
import org.ktorm.schema.int
import org.ktorm.schema.varchar


data class Employe(val id:Int,val name:String,val surname:String)
object  employetableobj: BaseTable<Employe>("ktorgraphql"){
    val id=int("id").primaryKey()
    val name=varchar("name")
    val surname=varchar("surname")
    override fun doCreateEntity(row: QueryRowSet, withReferences: Boolean)= Employe (
        id = row[id] ?: 0,
        name=row[name].toString(),
        surname=row[surname].toString(),
    )
}
val Database.Employe get() =this.sequenceOf(employetableobj)

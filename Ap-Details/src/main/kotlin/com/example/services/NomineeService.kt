package com.example.services

import com.example.EntityBindings.Nominee
import com.example.EntityBindings.Nominees
import com.example.EntityBindings.Vehicle
import com.example.dbconfig.DatabaseConnection
import org.ktorm.dsl.from
import org.ktorm.dsl.joinReferencesAndSelect
import org.ktorm.dsl.map
import org.ktorm.dsl.select
import org.ktorm.schema.Column

interface NomineeService {
    fun Nominee():List<Nominee>
    fun NomineesWithCustomers():List<Nominee>
}
class subNomineeService:NomineeService{

    val db=DatabaseConnection.database

    override fun Nominee(): List<Nominee> {
        val totalNominees=db.from(Nominees).select()
            .map { row -> Nominees.createEntity(row) }
        return totalNominees
    }

    override fun NomineesWithCustomers(): List<Nominee> {
        val nomineebyCustomers=db.from(Nominees).joinReferencesAndSelect()
            .map { row -> Nominees.createEntity(row) }
        return nomineebyCustomers
    }
}

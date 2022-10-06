package com.example.repository

import com.example.databaseconfig.DatabaseFactory
import com.example.entity.*
import com.example.model.*
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.*

class CollegeRepositoryINDV {
    fun saveINDVCollegeDetails(params: CollegeINDVDTO):Int{
        val db = DatabaseFactory.getConnection()
        val transaction = db.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        var effectedlines:Int
        try {
                effectedlines = db.insert(collegedetails) {
                    set(it.id, params.id)
                    set(it.name, params.name)
                    set(it.affliated, params.affliated)
                    set(it.location_id, params.location_id)
                    set(it.company_id, params.company_id)
                    set(it.bus_id, params.bus_id)
                }
                transaction.commit()
        }catch (e:Exception){
            transaction.rollback()
            e.printStackTrace()
            effectedlines = 0
        }finally {
            transaction.close()
        }
        return effectedlines
    }

    suspend fun getINDVCollegeDetails():List<CollegeINDVDTO>{
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(collegedetails).select().map { row -> collegedetails.createEntity(row)  }.map {
                CollegeINDVDTO(
                    it.id,
                    it.name,
                    it.affliated,
                    it.location.id,
                    it.bus.id,
                    it.company.id,
                )
            }
        }
    }

}
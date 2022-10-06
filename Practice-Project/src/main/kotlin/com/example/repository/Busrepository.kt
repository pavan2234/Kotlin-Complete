package com.example.repository

import com.example.databaseconfig.DatabaseFactory
import com.example.entity.busdetails
import com.example.model.busdetailDTO
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.*

class Busrepository{

    fun savebusdetails(params: busdetailDTO):Int {
            val databaseconnection = DatabaseFactory.getConnection()
            val transaction =
                databaseconnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
            var noofevents:Int
            try {
              noofevents=  databaseconnection.insert(busdetails) {
                    set(it.id, params.id)
                    set(it.route, params.route)
                    set(it.capacity, params.capacity)
                    set(it.fee, params.fee)
                    set(it.time, params.time)
              }
                transaction.commit()
            }catch (e:Exception){
                e.printStackTrace()
                noofevents = 0
            }finally {
                transaction.close()
            }
        return noofevents
    }

   suspend fun getbusdetails():List<busdetailDTO>{
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(busdetails).select().map {
                    row -> busdetails.createEntity(row) }.map {
                busdetailDTO(
                it.id,
                it.route,
                it.fee,
                it.capacity,
                it.time
                ) }
        }
   }
}
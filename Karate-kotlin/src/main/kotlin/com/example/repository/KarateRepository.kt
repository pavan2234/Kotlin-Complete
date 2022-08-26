package com.example.repository

import com.example.DatabaseConfiguration.DatabaseConnection
import com.example.entities.Karates
import com.example.entities.Karates.id
import com.example.entities.karate
import com.example.model.karateDTO
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.*

class KarateRepository {
    suspend fun CustomerEntry(params: karateDTO):Int{
        var count:Int
        val db = DatabaseConnection.getConnection()
        val transaction = db.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            count = db.insert(Karates){
                set(it.id,params.id)
                set(it.name,params.name)
                set(it.age,params.age)
                set(it.area,params.area)
            }
            transaction.commit()
        }catch (e:Exception){
            e.printStackTrace()
            count=0
        }finally {
            transaction.close()
        }

        return count
    }
//    suspend fun TraineeDetails():List<karate> {
//        return DatabaseConnection.dbQuery {
//            DatabaseConnection.getConnection().from(Karates).joinReferencesAndSelect()
//                .map { row -> Karates.createEntity(row) }
//                }
//        }
//    }
    suspend fun TraineeDetails():List<karateDTO> {
        return DatabaseConnection.dbQuery {
            DatabaseConnection.getConnection().from(Karates).joinReferencesAndSelect()
                .map { row -> Karates.createEntity(row) }.map {
                    karateDTO(
                        it.id,
                        it.name,
                        it.age,
                        it.area
                    )
                }
        }
    }
    suspend fun UpdateDetails(params: karateDTO):Int{
        var count:Int
        val db = DatabaseConnection.getConnection()
        val transaction = db.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            count = db.update(Karates){
                set(it.id,params.id)
                set(it.name,params.name)
                set(it.age,params.age)
                set(it.area,params.area)
            }
            transaction.commit()
        }catch (e:Exception){
            e.printStackTrace()
            count=0
        }finally {
            transaction.close()
        }

        return count
    }
}
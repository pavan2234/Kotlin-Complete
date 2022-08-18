package com.example.repositories

import com.example.DatabaseConfiguration.DataBaseConnection
import com.example.entities.Reservations
import com.example.entities.ReservationsI
import com.example.model.ReservationsDTO
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.*

class ReservationRepository {
    suspend fun ReservationInserting(params: ReservationsDTO): Int {
        var noOfRecordsAffected: Int
        val db = DataBaseConnection.getConnection()
        val transaction = db.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            noOfRecordsAffected = db.insert(Reservations) {
                set(it.restaurantId, params.restaurantId)
                set(it.reservationTime, params.reservationTime)
                set(it.reservationDate, params.reservationDate)
                set(it.noOfPeople, params.noOfPeople)
                set(it.customerId, params.customerId)
                set(it.lastName, params.lastName)
                set(it.firstName, params.firstName)
                set(it.reservationNotes, params.reservationNotes)
                set(it.mobile, params.mobile)
                set(it.landline, params.landline)
                set(it.email, params.email)
                set(it.interfaceId, params.interfaceId)
                set(it.occasion, params.occasion)
                set(it.eatNowFlag, params.eatNowFlag)
                set(it.sessionName, params.sessionName)
                set(it.sessionId, params.sessionId)
                set(it.sourceApp, params.sourceApp)
                set(it.packageName, params.packageName)
                set(it.tableNo, params.tableNo)
                set(it.tableStatus, params.tableStatus)
                set(it.waitListedFlag, params.waitListedFlag)
                set(it.strLocTitle, params.strLocTitle)

            }
            transaction.commit()
        } catch (e: Exception) {
            transaction.rollback()
            e.printStackTrace()
            noOfRecordsAffected = 0
        } finally {
            transaction.close()
        }
        return noOfRecordsAffected
    }


    suspend fun getReservation():List<ReservationsI> {
        return DataBaseConnection.dbQuery {
            DataBaseConnection.getConnection().from(Reservations).select()
                .map { row -> Reservations.createEntity(row) }
        }
    }

    suspend fun updateReservation(params: ReservationsDTO):Int{
        var noOfRecordsAffected: Int
        val db = DataBaseConnection.getConnection()
        val transaction = db.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            noOfRecordsAffected = db.update(Reservations) {
                set(it.restaurantId, params.restaurantId)
                set(it.reservationTime, params.reservationTime)
                set(it.reservationDate, params.reservationDate)
                set(it.noOfPeople, params.noOfPeople)
                set(it.customerId, params.customerId)
                set(it.lastName, params.lastName)
                set(it.firstName, params.firstName)
                set(it.reservationNotes, params.reservationNotes)
                set(it.mobile, params.mobile)
                set(it.landline, params.landline)
                set(it.email, params.email)
                set(it.interfaceId, params.interfaceId)
                set(it.occasion, params.occasion)
                set(it.eatNowFlag, params.eatNowFlag)
                set(it.sessionName, params.sessionName)
                set(it.sessionId, params.sessionId)
                set(it.sourceApp, params.sourceApp)
                set(it.packageName, params.packageName)
                set(it.tableNo, params.tableNo)
                set(it.tableStatus, params.tableStatus)
                set(it.waitListedFlag, params.waitListedFlag)
                set(it.strLocTitle, params.strLocTitle)
                where {
                    it.restaurantId eq params.restaurantId
                }

            }
            transaction.commit()
        } catch (e: Exception) {
            transaction.rollback()
            e.printStackTrace()
            noOfRecordsAffected = 0
        } finally {
            transaction.close()
        }
        return noOfRecordsAffected
    }

    suspend fun deleteReservationByID(params: ReservationsDTO):Int{
        var noOfRecordsAffected:Int
        val db  = DataBaseConnection.getConnection()
        val transaction= db.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            noOfRecordsAffected= db.delete(Reservations){
            it.restaurantId eq params.restaurantId
            }
            transaction.commit()
        }catch (e:Exception){
            e.printStackTrace()
            noOfRecordsAffected=0
        }finally {
            transaction.close()
        }
        return noOfRecordsAffected
    }

    suspend fun deleteByName(params: ReservationsDTO):Int{
        var count:Int
        val db = DataBaseConnection.getConnection()
        val transaction = db.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            count= db.delete(Reservations){
                it.lastName eq params.lastName
            }
            transaction.commit()
        }catch (e:Exception){
            e.printStackTrace()
            count=0
        }finally {
            transaction.close()
        }
        return  count


    }
}
package com.tdl.motorinsurance.repositaries

import com.tdl.motorinsurance.dbconfig.DatabaseFactory
import com.tdl.motorinsurance.entities.Customers
import com.tdl.motorinsurance.entities.Nominee
import com.tdl.motorinsurance.entities.Nominees
import com.tdl.motorinsurance.model.NomineeDTO
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.*

class NomineeRepository {

    suspend fun saveNomineeWithCustomer(params: NomineeDTO): Int {
        var noOfRecordsAffected: Int
        val dbConnection = DatabaseFactory.getConnection()
        val transaction =
            dbConnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            if (shouldRollback(params)) {
                dbConnection.insert(Customers) {
                    set(it.id, params.customer.id)
                    set(it.cust_hash, params.customer.cust_hash)
                    set(it.name, params.customer.name)
                    set(it.phone_number, params.customer.phone_number)
                    set(it.email, params.customer.email)
                    set(it.created_at, params.customer.created_at)
                    set(it.updated_at, params.customer.updated_at)
                }
                noOfRecordsAffected = dbConnection.insert(Nominees) {
                    set(it.id, params.id)
                    set(it.cust_id, params.cust_id)
                    set(it.name, params.name)
                    set(it.relationship, params.relationship)
                    set(it.age, params.age)
                    set(it.guardian, params.guardian)
                    set(it.created_at, params.created_at)
                    set(it.updated_at, params.updated_at)
                }
                transaction.commit()
            } else {
                transaction.rollback()
                noOfRecordsAffected = 0
            }
        } catch (e: Exception) {
            transaction.rollback()
            e.printStackTrace()
            noOfRecordsAffected = 0
        } finally {
            transaction.close()
        }
        return noOfRecordsAffected
    }

    fun shouldRollback(params: NomineeDTO): Boolean {
        if (params.cust_id == params.customer.id)
            return true
        else
            return false
    }


              /*-------------------------------------------------------*/


    suspend fun getNominees(): List<Nominee> {
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(Nominees).select()
                .map { row -> Nominees.createEntity(row) }
        }
    }


           /*-------------------------------------------------------*/


    suspend fun getNomineesWithCustomers(): List<Nominee> {
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(Nominees).joinReferencesAndSelect()
                .map { row -> Nominees.createEntity(row, withReferences = true) }
        }
    }

              /*-------------------------------------------------------*/

    suspend fun UpdatedNominee(params: NomineeDTO): Int {
        var noOfRecordsAffected: Int
        val dbConnection = DatabaseFactory.getConnection()
        val transaction =
            dbConnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            if (shouldrollback(params)) {
                dbConnection.update(Customers) {
                    set(it.id, params.customer.id)
                    set(it.cust_hash, params.customer.cust_hash)
                    set(it.name, params.customer.name)
                    set(it.phone_number, params.customer.phone_number)
                    set(it.email, params.customer.email)
                    set(it.created_at, params.customer.created_at)
                    set(it.updated_at, params.customer.updated_at)
                }
                noOfRecordsAffected = dbConnection.update(Nominees) {
                    set(it.id, params.id)
                    set(it.cust_id, params.cust_id)
                    set(it.name, params.name)
                    set(it.relationship, params.relationship)
                    set(it.age, params.age)
                    set(it.guardian, params.guardian)
                    set(it.created_at, params.created_at)
                    set(it.updated_at, params.updated_at)
                        where {
                            it.id eq params.id
                        }
                }
                transaction.commit()
            } else {
                transaction.rollback()
                noOfRecordsAffected = 0
            }
        } catch (e: Exception) {
            transaction.rollback()
            e.printStackTrace()
            noOfRecordsAffected = 0
        } finally {
            transaction.close()
        }
        return noOfRecordsAffected
    }

    fun shouldrollback(params: NomineeDTO): Boolean {
        if ( params.id == params.id )
            return true
        else
            return false
    }


            /*-------------------------------------------------------*/

    fun updatenomineById(params: NomineeDTO): Int {
        var data:Int=0
        val dbConnection = DatabaseFactory.getConnection()
        val transaction =
            dbConnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            val gettingdata=dbConnection.from(Nominees).select(Nominees.id).
            map { row -> Nominees.createEntity(row) }
             data = dbConnection.update(Nominees) {
                set(it.id, params.id)
                set(it.cust_id, params.cust_id)
                set(it.name, params.name)
                set(it.relationship, params.relationship)
                set(it.age, params.age)
                set(it.guardian, params.guardian)
                set(it.created_at, params.created_at)
                set(it.updated_at, params.updated_at)
                where {
                    it.id eq params.id

                }
            }
            transaction.commit()
        } catch (e: Exception) {
            e.printStackTrace()
        }finally {
            transaction.close()
        }
        return data
    }

              /*-------------------------------------------------------*/


    fun deleteBYid(params: NomineeDTO):Int{
        var data:Int=0
        val dbConnection = DatabaseFactory.getConnection()
        val transaction =
            dbConnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            data = dbConnection.delete(Nominees){
                it.id eq params.id
            }

            transaction.commit()
        } catch (e: Exception) {
            e.printStackTrace()
        }finally {
            transaction.close()
        }
        return data
    }

}

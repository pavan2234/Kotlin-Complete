package com.tdl.motorinsurance.repositaries

import com.tdl.motorinsurance.dbconfig.DatabaseFactory
import com.tdl.motorinsurance.entities.*
import com.tdl.motorinsurance.model.NomineeDTO
import com.tdl.motorinsurance.model.VehicleDTO
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.*

class VehicleRepositary {

    suspend fun saveVehicleWithCustomer(params: VehicleDTO): Int {
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
                noOfRecordsAffected = dbConnection.insert(Vehicles) {
                    set(it.id, params.id)
                    set(it.reg_number, params.reg_number)
                    set(it.type, params.type)
                    set(it.make, params.make)
                    set(it.model, params.model)
                    set(it.variant,params.variant)
                    set(it.reg_date,params.reg_date)
                    set(it.engine_number,params.engine_number)
                    set(it.chassis_number,params.chassis_number)
                    set(it.created_at, params.created_at)
                    set(it.updated_at, params.updated_at)
                    set(it.cust_id, params.cust_id)
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

    fun shouldRollback(params: VehicleDTO): Boolean {
        if (params.cust_id == params.customer.id)
            return true
        else
            return false
    }


    /*-------------------------------------------------------*/


    suspend fun getVehicles(): List<Vehicle> {
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(Vehicles).select()
                .map { row -> Vehicles.createEntity(row) }
        }
    }


    /*-------------------------------------------------------*/


    suspend fun getVehicleWithCustomers(): List<Vehicle> {
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(Vehicles).joinReferencesAndSelect()
                .map { row -> Vehicles.createEntity(row, withReferences = true) }
        }
    }

    /*-------------------------------------------------------*/

    suspend fun UpdatedVehicle(params: VehicleDTO): Int {
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
                noOfRecordsAffected = dbConnection.update(Vehicles) {
                    set(it.id, params.id)
                    set(it.cust_id, params.cust_id)
                    set(it.reg_number, params.reg_number)
                    set(it.type, params.type)
                    set(it.make, params.make)
                    set(it.model, params.model)
                    set(it.variant,params.variant)
                    set(it.reg_date,params.reg_date)
                    set(it.engine_number,params.engine_number)
                    set(it.chassis_number,params.chassis_number)
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

    fun shouldrollback(params: VehicleDTO): Boolean {
        if ( params.id == params.id )
            return true
        else
            return false
    }


    /*-------------------------------------------------------*/

    fun updateVehicleById(params: VehicleDTO): Int {
        var data:Int=0
        val dbConnection = DatabaseFactory.getConnection()
        val transaction =
            dbConnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            val gettingdata=dbConnection.from(Vehicles).select(Vehicles.id).
            map { row -> Vehicles.createEntity(row) }
            data = dbConnection.update(Vehicles) {
                set(it.id, params.id)
                set(it.cust_id, params.cust_id)
                set(it.reg_number, params.reg_number)
                set(it.type, params.type)
                set(it.make, params.make)
                set(it.model, params.model)
                set(it.variant,params.variant)
                set(it.reg_date,params.reg_date)
                set(it.engine_number,params.engine_number)
                set(it.chassis_number,params.chassis_number)
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


    fun deleteBYid(params: VehicleDTO):Int{
        var data:Int=0
        val dbConnection = DatabaseFactory.getConnection()
        val transaction =
            dbConnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            data = dbConnection.delete(Vehicles){
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
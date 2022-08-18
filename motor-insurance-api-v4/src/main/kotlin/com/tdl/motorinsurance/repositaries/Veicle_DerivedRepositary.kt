package com.tdl.motorinsurance.repositaries

import com.tdl.motorinsurance.dbconfig.DatabaseFactory
import com.tdl.motorinsurance.entities.*
import com.tdl.motorinsurance.model.NomineeDTO
import com.tdl.motorinsurance.model.Vehicle_DerivedDTO
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.*

class Veicle_DerivedRepositary {
    suspend fun saveVehicle_derivedWithCustomer(params: Vehicle_DerivedDTO): Int {
        var noOfRecordsAffected: Int
        val dbConnection = DatabaseFactory.getConnection()
        val transaction =
            dbConnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            if (shouldRollback(params)){
                dbConnection.insert(Customers) {
                    set(it.id, params.customer.id)
                    set(it.cust_hash, params.customer.cust_hash)
                    set(it.name, params.customer.name)
                    set(it.phone_number, params.customer.phone_number)
                    set(it.email, params.customer.email)
                    set(it.created_at, params.customer.created_at)
                    set(it.updated_at, params.customer.updated_at)
                }

                    noOfRecordsAffected = dbConnection.insert(Vehicles_Derived) {
                        set(it.id, params.id)
                        set(it.reg_number, params.reg_number)
                        set(it.cust_id, params.cust_id)
                        set(it.segment, params.segment)
                        set(it.cubic_capacity, params.cubic_capacity)
                        set(it.seating_capacity, params.seating_capacity)
                        set(it.purchase_date, params.purchase_date)
                        set(it.fuel, params.fuel)
                        set(it.body_type, params.body_type)
                        set(it.rto,params.rto)

                    }
                        transaction.commit()
                    }
            else {
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

    fun shouldRollback(params: Vehicle_DerivedDTO): Boolean {
        if (params.cust_id == params.customer.id)
            return true
        else
            return false
    }




    suspend fun getVehicle_Derived(): List<Vehicle_Derived> {
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(Vehicles_Derived).select()
                .map { row -> Vehicles_Derived.createEntity(row) }
        }
    }




    suspend fun getVeicle_DerivedWithCustomers(): List<Vehicle_Derived> {
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(Vehicles_Derived).joinReferencesAndSelect()
                .map { row -> Vehicles_Derived.createEntity(row, withReferences = true) }
        }
    }




    suspend fun UpdatedVehicle_Derived(params: Vehicle_DerivedDTO): Int {
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
                noOfRecordsAffected = dbConnection.update(Vehicles_Derived) {
                    set(it.id, params.id)
                    set(it.reg_number, params.reg_number)
                    set(it.cust_id, params.cust_id)
                    set(it.segment, params.segment)
                    set(it.cubic_capacity, params.cubic_capacity)
                    set(it.seating_capacity, params.seating_capacity)
                    set(it.purchase_date, params.purchase_date)
                    set(it.fuel, params.fuel)
                    set(it.body_type, params.body_type)
                    set(it.rto,params.rto)
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

    fun shouldrollback(params: Vehicle_DerivedDTO): Boolean {
        if ( params.id == params.id )
            return true
        else
            return false
    }






    fun updateVehicle_derivedId(params: Vehicle_DerivedDTO): Int {
        var data:Int=0
        val dbConnection = DatabaseFactory.getConnection()
        val transaction =
            dbConnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            val gettingdata=dbConnection.from(Vehicles_Derived).select(Vehicles_Derived.id).
            map { row -> Vehicles_Derived.createEntity(row) }
            data = dbConnection.update(Vehicles_Derived) {
                set(it.id, params.id)
                set(it.reg_number, params.reg_number)
                set(it.cust_id, params.cust_id)
                set(it.segment, params.segment)
                set(it.cubic_capacity, params.cubic_capacity)
                set(it.seating_capacity, params.seating_capacity)
                set(it.purchase_date, params.purchase_date)
                set(it.fuel, params.fuel)
                set(it.body_type, params.body_type)
                set(it.rto,params.rto)
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






    fun deleteBYid(params: Vehicle_DerivedDTO):Int{
        var data:Int=0
        val dbConnection = DatabaseFactory.getConnection()
        val transaction =
            dbConnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            data = dbConnection.delete(Vehicles_Derived){
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


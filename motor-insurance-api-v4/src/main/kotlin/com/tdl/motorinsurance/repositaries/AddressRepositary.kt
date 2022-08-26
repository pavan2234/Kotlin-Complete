package com.tdl.motorinsurance.repositaries

import com.tdl.motorinsurance.dbconfig.DatabaseFactory
import com.tdl.motorinsurance.entities.*
import com.tdl.motorinsurance.model.AddressDTO
import com.tdl.motorinsurance.model.CustomerDTO
import com.tdl.motorinsurance.model.VehicleDTO
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.*

class AddressRepositary {

    suspend fun saveAddressWithCustomerandVehicle(params: AddressDTO): Int {
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
                dbConnection.insert(Vehicles){
                    set(it.id,params.vehicle.id)
                    set(it.cust_id, params.vehicle.cust_id)
                    set(it.reg_number, params.vehicle.reg_number)
                    set(it.type, params.vehicle.type)
                    set(it.make, params.vehicle.make)
                    set(it.model, params.vehicle.model)
                    set(it.variant,params.vehicle.variant)
                    set(it.reg_date,params.vehicle.reg_date)
                    set(it.engine_number,params.vehicle.engine_number)
                    set(it.chassis_number,params.vehicle.chassis_number)
                    set(it.created_at, params.vehicle.created_at)
                    set(it.updated_at, params.vehicle.updated_at)
                }
                noOfRecordsAffected = dbConnection.insert(Addresses) {
                    set(it.id, params.id)
                    set(it.cust_id, params.cust_id)
                    set(it.veh_id, params.veh_id)
                    set(it.addr_line1, params.addr_line1)
                    set(it.addr_line2, params.addr_line2)
                    set(it.pincode, params.pincode)
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

    fun shouldRollback(params: AddressDTO): Boolean {
        if (params.cust_id == params.customer.id && params.veh_id == params.vehicle.id)
            return true
        else
            return false
    }

    suspend fun getAddress(): List<Address> {
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(Addresses).select()
                .map { row -> Addresses.createEntity(row)}

        }
    }


    /*-------------------------------------------------------*/


    suspend fun getAddressWithCustomersandVehicle(): List<AddressDTO> {
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(Addresses).joinReferencesAndSelect()
                .map { row -> Addresses.createEntity(row, withReferences = true) }.map {
                    AddressDTO(
                        it.id,
                        it.customer.id,
                        it.vehicle.id,
                        it.addr_line1,
                        it.addr_line2,
                        it.pincode,
                        it.created_at,
                        it.updated_at,
                        CustomerDTO(
                            it.customer.id,
                            it.customer.cust_hash,
                            it.customer.name,
                            it.customer.phone_number,
                            it.customer.email,
                            it.customer.created_at,
                            it.customer.updated_at
                        ),
                        VehicleDTO(
                            it.vehicle.id,
                            it.vehicle.cust_id,
                            it.vehicle.reg_number,
                            it.vehicle.type,
                            it.vehicle.make,
                            it.vehicle.model,
                            it.vehicle.variant,
                            it.vehicle.reg_date,
                            it.vehicle.engine_number,
                            it.vehicle.chassis_number,
                            it.vehicle.created_at,
                            it.vehicle.updated_at,
                            CustomerDTO(
                                it.customer.id,
                                it.customer.cust_hash,
                                it.customer.name,
                                it.customer.phone_number,
                                it.customer.email,
                                it.customer.created_at,
                                it.customer.updated_at
                            )
                        )
                    )
                }
        }
    }

    /*-------------------------------------------------------*/

    suspend fun UpdatedAddress(params: AddressDTO): Int {
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
                dbConnection.update(Vehicles){
                    set(it.id,params.vehicle.id)
                    set(it.cust_id, params.vehicle.cust_id)
                    set(it.reg_number, params.vehicle.reg_number)
                    set(it.type, params.vehicle.type)
                    set(it.make, params.vehicle.make)
                    set(it.model, params.vehicle.model)
                    set(it.variant,params.vehicle.variant)
                    set(it.reg_date,params.vehicle.reg_date)
                    set(it.engine_number,params.vehicle.engine_number)
                    set(it.chassis_number,params.vehicle.chassis_number)
                    set(it.created_at, params.vehicle.created_at)
                    set(it.updated_at, params.vehicle.updated_at)
                }
                noOfRecordsAffected = dbConnection.update(Addresses) {
                    set(it.id, params.id)
                    set(it.cust_id, params.cust_id)
                    set(it.veh_id, params.veh_id)
                    set(it.addr_line1, params.addr_line1)
                    set(it.addr_line2, params.addr_line2)
                    set(it.pincode, params.pincode)
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

    fun shouldrollback(params: AddressDTO): Boolean {
        if ( params.id == params.id )
            return true
        else
            return false
    }


    /*-------------------------------------------------------*/

    fun updateAddressById(params: AddressDTO): Int {
        var data:Int=0
        val dbConnection = DatabaseFactory.getConnection()
        val transaction =
            dbConnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            val gettingdata=dbConnection.from(Nominees).select(Nominees.id).
            map { row -> Nominees.createEntity(row) }
            data = dbConnection.update(Addresses) {
                set(it.id, params.id)
                set(it.cust_id, params.cust_id)
                set(it.veh_id, params.veh_id)
                set(it.addr_line1, params.addr_line1)
                set(it.addr_line2, params.addr_line2)
                set(it.pincode, params.pincode)
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


    fun deleteBYid(params: AddressDTO):Int{
        var data:Int=0
        val dbConnection = DatabaseFactory.getConnection()
        val transaction =
            dbConnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            data = dbConnection.delete(Addresses){
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
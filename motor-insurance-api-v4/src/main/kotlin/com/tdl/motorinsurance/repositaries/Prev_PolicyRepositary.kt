package com.tdl.motorinsurance.repositaries

import com.tdl.motorinsurance.dbconfig.DatabaseFactory
import com.tdl.motorinsurance.entities.*
import com.tdl.motorinsurance.model.*
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.*

class Prev_PolicyRepositary {

    suspend fun savePrev_PolicyWithVehicle(params: Prev_PolicyDTO): Int {
        var noOfRecordsAffected: Int
        val dbConnection = DatabaseFactory.getConnection()
        val transaction =
            dbConnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            if (shouldRollback(params)){
                dbConnection.insert(Vehicles) {
                    set(it.id, params.vehicle.id)
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

                noOfRecordsAffected = dbConnection.insert(Prev_Policies) {
                    set(it.id, params.id)
                    set(it.veh_id, params.veh_id)
                    set(it.insurer_name, params.insurer_name)
                    set(it.policy_number, params.policy_number)
                    set(it.is_expired, params.is_expired)
                    set(it.ncb_benifit,params.ncb_benfit)
                    set(it.created_at,params.created_at)
                    set(it.updated_at,params.updated_at)
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

    fun shouldRollback(params: Prev_PolicyDTO): Boolean {
        if (params.id == params.vehicle.id)
            return true
        else
            return false
    }




    suspend fun getPrev_Policy(): List<Prev_Policy> {
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(Prev_Policies).select()
                .map { row -> Prev_Policies.createEntity(row) }
        }
    }




    suspend fun getPrev_PolicyWithVehicle(): List<Prev_PolicyDTO> {
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(Prev_Policies).joinReferencesAndSelect()
                .map { row -> Prev_Policies.createEntity(row, withReferences = true) }.map {
                        Prev_PolicyDTO(
                            it.id,
                            it.vehicle.id,
                            it.insurer_name,
                            it.policy_number,
                            it.is_expired,
                            it.ncb_benifit,
                            it.created_at,
                            it.updated_at,
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
                                    it.vehicle.customer.id,
                                    it.vehicle.customer.cust_hash,
                                    it.vehicle.customer.name,
                                    it.vehicle.customer.phone_number,
                                    it.vehicle.customer.email,
                                    it.vehicle.customer.created_at,
                                    it.vehicle.customer.updated_at
                                )

                            )
                            )
                    }

        }
    }




    suspend fun UpdatedPrev_Policy(params: Prev_PolicyDTO): Int {
        var noOfRecordsAffected: Int
        val dbConnection = DatabaseFactory.getConnection()
        val transaction =
            dbConnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            if (shouldrollback(params)) {
                dbConnection.update(Vehicles) {
                    set(it.id, params.vehicle.id)
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
                noOfRecordsAffected = dbConnection.update(Prev_Policies) {
                    set(it.id, params.id)
                    set(it.veh_id, params.veh_id)
                    set(it.insurer_name, params.insurer_name)
                    set(it.policy_number, params.policy_number)
                    set(it.is_expired, params.is_expired)
                    set(it.ncb_benifit,params.ncb_benfit)
                    set(it.created_at,params.created_at)
                    set(it.updated_at,params.updated_at)
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

    fun shouldrollback(params: Prev_PolicyDTO): Boolean {
        if ( params.id == params.id )
            return true
        else
            return false
    }






    fun updatePrev_policyId(params: Prev_PolicyDTO): Int {
        var data:Int=0
        val dbConnection = DatabaseFactory.getConnection()
        val transaction =
            dbConnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            val gettingdata=dbConnection.from(Vehicles_Derived).select(Vehicles_Derived.id).
            map { row -> Vehicles_Derived.createEntity(row) }
            data = dbConnection.update(Prev_Policies) {
                set(it.id, params.id)
                set(it.veh_id, params.veh_id)
                set(it.insurer_name, params.insurer_name)
                set(it.policy_number, params.policy_number)
                set(it.is_expired, params.is_expired)
                set(it.ncb_benifit,params.ncb_benfit)
                set(it.created_at,params.created_at)
                set(it.updated_at,params.updated_at)
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






    fun deleteBYid(params: Prev_PolicyDTO):Int{
        var data:Int=0
        val dbConnection = DatabaseFactory.getConnection()
        val transaction =
            dbConnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        try {
            data = dbConnection.delete(Prev_Policies){
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


    fun getOnboarding(params: Prev_PolicyDTO){
        val dbConnection = DatabaseFactory.getConnection()
        val transaction =
            dbConnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        if ((Prev_Policies.veh_id).equals(params.veh_id)){
            var noOfeffected:Int
            var d = dbConnection.from(Prev_Policies).joinReferencesAndSelect().
                    map { row -> Prev_Policies.createEntity(row) }
            transaction.commit()
            println(d)
        }else{
            println("Failed")
        }
        transaction.close()

    }

}
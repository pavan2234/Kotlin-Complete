package com.tdl.motorinsurance.repositaries

import com.tdl.motorinsurance.dbconfig.DatabaseFactory
import com.tdl.motorinsurance.entities.*
import com.tdl.motorinsurance.model.*
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.*

class QuoteRepositary {
    suspend fun saveQuote(params: QuoteDTO): Int {
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
                dbConnection.insert(Prev_Policies) {
                    set(it.id, params.prev_policy.id)
                    set(it.veh_id, params.prev_policy.veh_id)
                    set(it.insurer_name, params.prev_policy.insurer_name)
                    set(it.policy_number, params.prev_policy.policy_number)
                    set(it.is_expired, params.prev_policy.is_expired)
                    set(it.ncb_benifit, params.prev_policy.ncb_benfit)
                    set(it.created_at, params.prev_policy.created_at)
                    set(it.updated_at, params.prev_policy.updated_at)
                }
                dbConnection.insert(Addresses){
                    set(it.id, params.address.id)
                    set(it.cust_id, params.address.cust_id)
                    set(it.veh_id, params.address.veh_id)
                    set(it.addr_line1, params.address.addr_line1)
                    set(it.addr_line2, params.address.addr_line2)
                    set(it.pincode, params.address.pincode)
                    set(it.created_at, params.address.created_at)
                    set(it.updated_at, params.address.updated_at)
                }
                noOfRecordsAffected = dbConnection.insert(Quotes) {
                    set(it.id, params.id)
                    set(it.veh_id,params.veh_id)
                    set(it.cust_id, params.cust_id)
                    set(it.prev_policy_id, params.prev_policy_id)
                    set(it.nominees, params.nominees)
                    set(it.addr_id, params.addr_id)
                    set(it.type, params.type)
                    set(it.insurer, params.insurer)
                    set(it.insurerr,params.insurerr)
                    set(it.idv_details,params.idv_details)
                    set(it.add_ons, params.add_ons)
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

    fun shouldRollback(params: QuoteDTO): Boolean {
        if (params.cust_id == params.customer.id && params.veh_id == params.vehicle.id
            && params.prev_policy_id == params.prev_policy.id  && params.addr_id == params.address.id)
            return true
        else
            return false
    }

    suspend fun getQuotes(): List<Quote> {
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(Quotes).joinReferencesAndSelect()
                .map { row -> Quotes.createEntity(row, withReferences = true) }
        }
    }

    suspend fun getNomineesWithCustomers(): List<QuoteDTO> {
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(Quotes).joinReferencesAndSelect()
                .map { row -> Quotes.createEntity(row, withReferences = true) }.map {
                    QuoteDTO(
                        it.id,
                        it.vehicle.id,
                        it.customer.id,
                        it.prev_policy.id,
                        it.nominees,
                        it.addr_id,
                        it.type,
                        it.insurer,
                        it.insurerr,
                        it.idv_details,
                        it.add_ons,
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
                        ),
                        Prev_PolicyDTO(
                            it.prev_policy.id,
                            it.prev_policy.vehicle.id,
                            it.prev_policy.insurer_name,
                            it.prev_policy.policy_number,
                            it.prev_policy.is_expired,
                            it.prev_policy.ncb_benifit,
                            it.prev_policy.created_at,
                            it.prev_policy.updated_at,
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
                        ),
                        AddressDTO(
                            it.address.id,
                            it.address.customer.id,
                            it.address.vehicle.id,
                            it.address.addr_line1,
                            it.address.addr_line2,
                            it.address.pincode,
                            it.address.created_at,
                            it.address.updated_at,
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


                    )
                }
        }
    }

}
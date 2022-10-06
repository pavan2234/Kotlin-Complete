package com.example.repository

import com.example.databaseconfig.DatabaseFactory
import com.example.entity.*
import com.example.model.*
import com.example.model_joins.collegedetailDTO
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.*

class CollegeRepositorywithrefernces {
    fun saveCollegeDetails(params: collegedetailDTO):Int{
        val db = DatabaseFactory.getConnection()
        val transaction = db.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        var effectedlines:Int
        try {
            if (shouldrollback(params)) {
                db.insert(locations) {
                    set(it.id, params.locationDTO.id)
                    set(it.area, params.locationDTO.area)
                    set(it.colony, params.locationDTO.colony)
                    set(it.pincode, params.locationDTO.pincode)
                    set(it.mobilenumber, params.locationDTO.mobilenumber)
                    set(it.road_no, params.locationDTO.road_no)
                }
                db.insert(companies) {
                    set(it.id, params.companyDTO.id)
                    set(it.name, params.companyDTO.name)
                    set(it.bond, params.companyDTO.bond)
                    set(it.location, params.companyDTO.location)
                    set(it.mnc_or_startup, params.companyDTO.mnc_or_startup)
                    set(it.package_offered, params.companyDTO.package_offered)
                }
                db.insert(busdetails) {
                    set(it.id, params.busdetailDTO.id)
                    set(it.route, params.busdetailDTO.route)
                    set(it.capacity, params.busdetailDTO.capacity)
                    set(it.fee, params.busdetailDTO.fee)
                    set(it.time, params.busdetailDTO.time)
                }
                effectedlines = db.insert(collegedetails) {
                    set(it.id, params.id)
                    set(it.name, params.name)
                    set(it.affliated, params.affliated)
                    set(it.location_id, params.location_id)
                    set(it.company_id, params.company_id)
                    set(it.bus_id, params.bus_id)
                }
                transaction.commit()
            }else{
                    transaction.rollback()
                effectedlines = 0
            }
        }catch (e:Exception){
            transaction.rollback()
            e.printStackTrace()
            effectedlines = 0
        }finally {
            transaction.close()
        }
        return effectedlines
    }
    fun shouldrollback(params: collegedetailDTO):Boolean{
        if (params.location_id == params.locationDTO.id && params.company_id == params.companyDTO.id && params.bus_id == params.busdetailDTO.id)
            return true
        else return false
    }

    suspend fun getCollegeDetails():List<collegedetailDTO>{
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(collegedetails).joinReferencesAndSelect().map { row -> collegedetails.createEntity(row)  }.map {
                collegedetailDTO(
                    it.id,
                    it.name,
                    it.affliated,
                    it.location.id,
                    it.bus.id,
                    it.company.id,
                    locationDTO(
                        it.location.id,
                        it.location.road_no,
                        it.location.colony,
                        it.location.area,
                        it.location.pincode,
                        it.location.mobilenumber
                    ),busdetailDTO(
                        it.bus.id,
                        it.bus.route,
                        it.bus.fee,
                        it.bus.capacity,
                        it.bus.time
                    ),
                    companyDTO(
                        it.company.id,
                        it.company.name,
                        it.company.package_offered,
                        it.company.location,
                        it.company.bond,
                        it.company.mnc_or_startup,
                    )
                )
            }
        }
    }

}
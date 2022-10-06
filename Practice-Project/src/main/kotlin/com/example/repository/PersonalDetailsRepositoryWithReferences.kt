package com.example.repository
import com.example.databaseconfig.DatabaseFactory
import com.example.entity.*
import com.example.model.*
import com.example.model_joins.collegedetailDTO
import com.example.model_joins.personaldetailDTO
import com.example.model_joins.placementDTO
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.*

class PersonalDetailsRepositoryWithReferences {

    fun savePersonalDetails(params: personaldetailDTO):Int {
        val databaseconnection = DatabaseFactory.getConnection()
        val transaction =
            databaseconnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        var noofevents:Int
        try {
            if (shouldrollback(params)) {
                databaseconnection.insert(collegedetails) {
                    set(it.id, params.collegedetailDTO.id)
                    set(it.name, params.collegedetailDTO.name)
                    set(it.affliated, params.collegedetailDTO.affliated)
                    set(it.location_id, params.collegedetailDTO.location_id)
                    set(it.company_id, params.collegedetailDTO.company_id)
                    set(it.bus_id, params.collegedetailDTO.bus_id)
                }
                databaseconnection.insert(busdetails) {
                    set(it.id, params.busdetailDTO.id)
                    set(it.route, params.busdetailDTO.route)
                    set(it.capacity, params.busdetailDTO.capacity)
                    set(it.fee, params.busdetailDTO.fee)
                    set(it.time, params.busdetailDTO.time)
                }
                databaseconnection.insert(placements) {
                    set(it.id, params.placementDTO.id)
                    set(it.company_id, params.placementDTO.company_id)
                    set(it.noofstudents, params.placementDTO.noofstudents)
                    set(it.passing_year, params.placementDTO.passing_year)
                    set(it.pack_age, params.placementDTO.pack_age)
                    set(it.location, params.placementDTO.location)
                    set(it.wfh, params.placementDTO.wfh)
                }
                databaseconnection.insert(companies) {
                    set(it.id, params.companyDTO.id)
                    set(it.name, params.companyDTO.name)
                    set(it.location, params.companyDTO.location)
                    set(it.package_offered, params.companyDTO.package_offered)
                    set(it.mnc_or_startup, params.companyDTO.mnc_or_startup)
                    set(it.bond, params.companyDTO.bond)
                }
                noofevents = databaseconnection.insert(persons) {
                    set(it.id, params.id)
                    set(it.name, params.name)
                    set(it.dob, params.dob)
                    set(it.father, params.father)
                    set(it.placement_id, params.placement_id)
                    set(it.bus_id, params.bus_id)
                    set(it.college_id, params.college_id)
                    set(it.company_id, params.company_id)
                }
                transaction.commit()
            }else{
                transaction.rollback()
                noofevents = 0
            }
        }catch (e:Exception){
            transaction.rollback()
            e.printStackTrace()
            noofevents = 0
        }finally {
            transaction.close()
        }
        return noofevents
    }

    private fun shouldrollback(params: personaldetailDTO):Boolean{
        return params.placement_id == params.placementDTO.id &&
                params.bus_id == params.busdetailDTO.id &&
                params.college_id == params.collegedetailDTO.id &&
                params.company_id == params.companyDTO.id
    }

    suspend fun getpersonalDetails():List<personaldetailDTO>{
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(persons).joinReferencesAndSelect().map {
                    row -> persons.createEntity(row) }.map {
                        personaldetailDTO(
                            it.id,
                            it.name,
                            it.dob,
                            it.father,
                            it.placement.id,
                            it.bus.id,
                            it.college.id,
                            it.company.id,
                            placementDTO(it.placement.id,
                                it.placement.company.id,
                                it.placement.noofstudents,
                                it.placement.passing_year,
                                it.placement.pack_age,
                                it.placement.location,
                                it.placement.wfh,
                                companyDTO(
                                    it.placement.company.id,
                                    it.placement.company.name,
                                    it.placement.company.package_offered,
                                    it.placement.company.location,
                                    it.placement.company.bond,
                                    it.placement.company.mnc_or_startup,
                                )),
                            busdetailDTO(it.bus.id,
                                it.bus.route,
                                it.bus.fee,
                                it.bus.capacity,
                                it.bus.time),
                            collegedetailDTO(
                                it.college.id,
                                it.college.name,
                                it.college.affliated,
                                it.college.location.id,
                                it.college.bus.id,
                                it.college.company.id,
                                locationDTO(
                                    it.college.location.id,
                                    it.college.location.road_no,
                                    it.college.location.colony,
                                    it.college.location.area,
                                    it.college.location.pincode,
                                    it.college.location.mobilenumber
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
                                )),
                            companyDTO(
                                it.company.id,
                                it.company.name,
                                it.company.location,
                                it.company.package_offered,
                                it.company.mnc_or_startup,
                                it.company.bond)
                        )
                 }
        }
    }
}
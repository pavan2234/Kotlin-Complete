package com.example.repository
import com.example.databaseconfig.DatabaseFactory
import com.example.entity.*
import com.example.model.*
import com.example.model_joins.collegedetailDTO
import com.example.model_joins.personaldetailDTO
import com.example.model_joins.placementDTO
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.*

class PersonalDetailsRepositoryINDV {

    fun saveINDVPersonalDetails(params: PersonINDVDTO):Int {
        val databaseconnection = DatabaseFactory.getConnection()
        val transaction =
            databaseconnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        var noofevents:Int
        try {

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
        }catch (e:Exception){
            transaction.rollback()
            e.printStackTrace()
            noofevents = 0
        }finally {
            transaction.close()
        }
        return noofevents
    }

    suspend fun getINDVpersonalDetails():List<PersonINDVDTO>{
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(persons).joinReferencesAndSelect().map {
                    row -> persons.createEntity(row) }.map {
                        PersonINDVDTO(
                            it.id,
                            it.name,
                            it.dob,
                            it.father,
                            it.placement.id,
                            it.bus.id,
                            it.college.id,
                            it.company.id)
                 }
        }
    }
}
package com.example.repository
import com.example.databaseconfig.DatabaseFactory
import com.example.entity.companies
import com.example.entity.placements
import com.example.model.companyDTO
import com.example.model_joins.placementDTO
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.*

class PlacementRepositoryWithRefernces {
    fun savePlacementDetails(params: placementDTO):Int {
        val databaseconnection = DatabaseFactory.getConnection()
        val transaction =
            databaseconnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        var noofevents:Int
        try {
            if (shouldrollback(params)){
            noofevents=  databaseconnection.insert(placements) {
                set(it.id, params.id)
                set(it.company_id, params.companyDTO.id)
                set(it.noofstudents, params.noofstudents)
                set(it.passing_year, params.passing_year)
                set(it.pack_age, params.pack_age)
                set(it.location,params.location)
                set(it.wfh,params.wfh)
            }
            databaseconnection.insert(companies) {
                set(it.id, params.companyDTO.id)
                set(it.name, params.companyDTO.name)
                set(it.location, params.companyDTO.location)
                set(it.package_offered, params.companyDTO.package_offered)
                set(it.mnc_or_startup, params.companyDTO.mnc_or_startup)
                set(it.bond,params.companyDTO.bond)
            }
            transaction.commit()
            }else{
                transaction.rollback()
                noofevents = 0
            }
        }catch (e:Exception){
            e.printStackTrace()
            noofevents = 0
        }finally {
            transaction.close()
        }
        return noofevents
    }
   private fun shouldrollback(params: placementDTO):Boolean{
        return params.company_id == params.companyDTO.id
    }

    suspend fun getPlacementDetails():List<placementDTO>{
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(placements).joinReferencesAndSelect().map {
                    row -> placements.createEntity(row) }.map {
                placementDTO(
                    it.id,
                    it.company.id,
                    it.noofstudents,
                    it.passing_year,
                    it.pack_age,
                    it.location,
                    it.wfh,
                    companyDTO(
                        it.company.id,
                        it.company.name,
                        it.company.location,
                        it.company.package_offered,
                        it.company.bond,
                        it.company.mnc_or_startup,
                    )
                )
                 }
        }
    }

}
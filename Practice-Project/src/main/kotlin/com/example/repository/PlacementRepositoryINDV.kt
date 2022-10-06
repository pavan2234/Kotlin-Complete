package com.example.repository
import com.example.databaseconfig.DatabaseFactory
import com.example.entity.companies
import com.example.entity.placements
import com.example.model.PlacementINDVDTO
import com.example.model.companyDTO
import com.example.model_joins.placementDTO
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.*

class PlacementRepositoryINDV {
    fun saveINDVPlacementDetails(params: PlacementINDVDTO):Int {
        val databaseconnection = DatabaseFactory.getConnection()
        val transaction =
            databaseconnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        var noofevents:Int
        try {
            noofevents=  databaseconnection.insert(placements) {
                set(it.id, params.id)
                set(it.company_id, params.company_id)
                set(it.noofstudents, params.noofstudents)
                set(it.passing_year, params.passing_year)
                set(it.pack_age, params.pack_age)
                set(it.location,params.location)
                set(it.wfh,params.wfh)
            }
            transaction.commit()
        }catch (e:Exception){
            e.printStackTrace()
            noofevents = 0
        }finally {
            transaction.close()
        }
        return noofevents
    }

    suspend fun getINDVPlacementDetails():List<PlacementINDVDTO>{
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(placements).select().map {
                    row -> placements.createEntity(row) }.map {
                PlacementINDVDTO(
                    it.id,
                    it.company.id,
                    it.noofstudents,
                    it.passing_year,
                    it.pack_age,
                    it.location,
                    it.wfh
                )
                 }
        }
    }

}
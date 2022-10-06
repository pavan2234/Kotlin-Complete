package com.example.repository
import com.example.databaseconfig.DatabaseFactory
import com.example.entity.locations
import com.example.model.locationDTO
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.*

class LocationRepository {
    fun savelocationdetails(params: locationDTO):Int {
        val databaseconnection = DatabaseFactory.getConnection()
        val transaction =
            databaseconnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        var noofevents:Int
        try {
            noofevents=  databaseconnection.insert(locations) {
                set(it.id, params.id)
                set(it.road_no, params.road_no)
                set(it.colony, params.colony)
                set(it.area, params.area)
                set(it.pincode, params.pincode)
                set(it.mobilenumber,params.mobilenumber)
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

    suspend fun getlocationdetails():List<locationDTO>{
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(locations).select().map {
                    row -> locations.createEntity(row) }.map {
                locationDTO(
                    it.id,
                    it.road_no,
                    it.colony,
                    it.area,
                    it.pincode,
                    it.mobilenumber
                )
                }
        }
    }
}
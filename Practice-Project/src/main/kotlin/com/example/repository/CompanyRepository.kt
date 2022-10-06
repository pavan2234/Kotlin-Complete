package com.example.repository
import com.example.databaseconfig.DatabaseFactory
import com.example.entity.companies
import com.example.model.companyDTO
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.*
class CompanyRepository {

    fun saveCompanyDetails(params: companyDTO):Int {
        val databaseconnection = DatabaseFactory.getConnection()
        val transaction =
            databaseconnection.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        var noofevents:Int
        try {
            noofevents=  databaseconnection.insert(companies) {
                set(it.id, params.id)
                set(it.name, params.name)
                set(it.location, params.location)
                set(it.package_offered, params.package_offered)
                set(it.mnc_or_startup, params.mnc_or_startup)
                set(it.bond,params.bond)
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

    suspend fun getcompanydetails():List<companyDTO>{
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(companies).select().map {
                    row -> companies.createEntity(row) }.map {
                companyDTO(
                    it.id,
                    it.name,it.location,it.package_offered,it.mnc_or_startup,it.bond
                )

            }
        }
    }
}
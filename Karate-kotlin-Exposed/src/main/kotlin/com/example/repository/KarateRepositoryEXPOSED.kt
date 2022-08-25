package com.example.repository

import KaratesE
import com.example.DatabaseConfiguration.DatabaseConnection
import com.example.entities.Kungfu
import com.example.model.KungfuDTO
import com.example.model.karateDTO
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.statements.InsertStatement

class KarateRepositoryEXPOSED {

    /*Creating Customers...*/

    suspend fun createDetails(params: karateDTO): karateDTO? {
        var statement: InsertStatement<Number>? = null
        DatabaseConnection.dbQuery {
            statement = KaratesE.insert {
                it[id] = params.id
                it[name] = params.name
                it[age] = params.age
                it[area] = params.area
                it[kungfu_id] = params.kungfu_id
                Kungfu.insert {it->
                    it[kungfu_id] = params.kungfu_id
                    it[name] = params.name
                    it[age] = params.age
                    it[area] = params.area

                }

                }

            }
        return convertToKarate(statement?.resultedValues?.get(0))
    }


    fun convertToKarate(row: ResultRow?): karateDTO? {
        return if (row == null) {
            null
        } else {
            karateDTO(
                id = row[KaratesE.id],
                name = row[KaratesE.name],
                age = row[KaratesE.age],
                area = row[KaratesE.area],
                kungfu_id = row[KaratesE.kungfu_id],
                kungfu = KungfuDTO(
                    kungfu_id = row[Kungfu.kungfu_id],
                    name = row[Kungfu.name],
                    age = row[Kungfu.age],
                    area = row[Kungfu.area]

                )

            )
        }
    }

    /* Getting  total customers.....*/

    suspend fun getDetails(): List<karateDTO?> {
        var getCustomers = DatabaseConnection.dbQuery {
            KaratesE.innerJoin(Kungfu).selectAll().map { convertToKarate(it) }
        }
        return getCustomers
    }

    /*Getting customrs by their ID...*/


//    suspend fun getCustomerById1(id: Column<Int>): List<karateDTO?> {
//        var  getCustomerByid1 = DatabaseConnection.dbQuery {
//            KaratesE.select { KaratesE.id eq id }.
//            map { convertToKarate(it) }.singleOrNull()
//
//        }
//        return  getCustomerByid1(id)
//    }

    suspend fun getCustomerById(id: Column<Int>): List<karateDTO?> {
        return listOf(DatabaseConnection.dbQuery {
            KaratesE.select { KaratesE.id eq id }.map { convertToKarate(it) }.singleOrNull()
        })

    }
    
}



package com.example.services

import com.example.dbconfig.DatabaseConnection
import com.example.entitybinding.Order
import com.example.entitybinding.Orders
import com.example.entitybinding.Prev_policies
import com.example.entitybinding.Prev_policy
import org.ktorm.dsl.from
import org.ktorm.dsl.joinReferencesAndSelect
import org.ktorm.dsl.map
import org.ktorm.dsl.select


interface Prev_PolicyService {
    fun Prev_Policies():List<Prev_policy>
    fun Perv_PolicyWithVehicle():List<Prev_policy>
}
class subPrev_PolicyService :Prev_PolicyService{

    val db= DatabaseConnection.database

    override fun Prev_Policies(): List<Prev_policy> {
        val totalPrev_Policies=db.from(Prev_policies).select()
            .map { row -> Prev_policies.createEntity(row) }
        return totalPrev_Policies
    }

    override fun Perv_PolicyWithVehicle(): List<Prev_policy> {
        val totalPrev_PolicyWithVehicle=db.from(Prev_policies).joinReferencesAndSelect()
            .map { row -> Prev_policies.createEntity(row) }
        return totalPrev_PolicyWithVehicle

    }

}
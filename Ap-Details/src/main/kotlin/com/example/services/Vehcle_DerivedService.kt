package com.example.services

import com.example.dbconfig.DatabaseConnection
import com.example.entitybinding.Vehicle_Derived
import com.example.entitybinding.Vehicle_Derives
import org.ktorm.dsl.from
import org.ktorm.dsl.joinReferencesAndSelect
import org.ktorm.dsl.map
import org.ktorm.dsl.select


interface Vehicle_DerivedService {
    fun TotalVehicle_Derives():List<Vehicle_Derived>
    fun Vehicle_DerivedWithCustomer():List<Vehicle_Derived>
}
class subVehicle_DerivesService :Vehicle_DerivedService{

    val db= DatabaseConnection.database

    override fun TotalVehicle_Derives(): List<Vehicle_Derived> {
        val TotalVehicle_Derives=db.from(Vehicle_Derives).select()
            .map { row -> Vehicle_Derives.createEntity(row) }
        return TotalVehicle_Derives
    }

    override fun Vehicle_DerivedWithCustomer(): List<Vehicle_Derived> {
        val Vehicle_DerivedWithCustomer=db.from(Vehicle_Derives).joinReferencesAndSelect()
            .map { row -> Vehicle_Derives.createEntity(row) }
        return Vehicle_DerivedWithCustomer

    }

}
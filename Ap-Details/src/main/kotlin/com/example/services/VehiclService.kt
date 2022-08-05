package com.example.services

import com.example.EntityBindings.Vehicle
import com.example.EntityBindings.Vehicles
import com.example.dbconfig.DatabaseConnection
import org.ktorm.dsl.*
import org.ktorm.schema.Column

interface VehiclService{
    fun Vehicle() :List<Vehicle>
    fun VehicleByregNo(reg_number: Column<Int>):List<Vehicle>
    fun VehicleWithCustomer():List<Vehicle>


}
class SubvehicleService: VehiclService{
    val db=DatabaseConnection.database

    override fun Vehicle(): List<Vehicle> {
        val TotalVehicles=db.from(Vehicles).select().
        map {row -> Vehicles.createEntity(row)  }
        return TotalVehicles
    }

    override fun VehicleByregNo(reg_number: Column<Int>): List<Vehicle> {
        val vehiclebyregNo=db.from(Vehicles).select().
        where { Vehicles.reg_number eq reg_number }.
        map { row -> Vehicles.createEntity(row) }
        return  vehiclebyregNo
    }

    override fun VehicleWithCustomer(): List<Vehicle> {
        val vehiclewithcustomer=db.from(Vehicles).joinReferencesAndSelect()
            .map { row -> Vehicles.createEntity(row) }
        return  vehiclewithcustomer
    }

}
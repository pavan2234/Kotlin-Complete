package com.example.repository

import com.example.EntityBinding.customers
import com.example.EntityBinding.vehicles
import com.example.Interface.customer
import com.example.Interface.vehicle
import com.example.database.DatabaseConnection
import me.liuwj.ktorm.dsl.*
import me.liuwj.ktorm.schema.Column
import org.ktorm.dsl.joinReferencesAndSelect

interface repository {
    fun getCustomers():List<customer>
    fun getCustomerBYId(customerid: Column<Int>):List<customer>
    fun getVehicle():List<vehicle>
    fun getVehicleById(vehicleid:Column<Int>):List<vehicle>
}
class subrepository:repository{
    val db = DatabaseConnection.database
    override fun getCustomers(): List<customer> {
        val getcustomers = db.from(customers).select().
                map { row -> customers.createEntity(row)}
        return getcustomers
    }

    override fun getCustomerBYId(customerid: Column<Int>): List<customer> {
        val getcustomerbyid = db.from(customers).joinReferencesAndSelect().
        map { row -> customers.createEntity(row)}
        return getcustomerbyid
    }

    override fun getVehicle(): List<vehicle> {
        val getvehicle = db.from(vehicles).joinReferencesAndSelect().
        map { row -> vehicles.createEntity(row)}
        return getvehicle
    }

    override fun getVehicleById( vehicleid: Column<Int>): List<vehicle> {
        val getvehiclebyid = db.from(vehicles).joinReferencesAndSelect().
        map { row -> vehicles.createEntity(row)}
        return getvehiclebyid
    }

}
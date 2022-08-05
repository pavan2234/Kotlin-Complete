package com.example.repositaries

import com.example.dbconfig.DatabaseConnection
import com.example.entities.Vehicle
import com.example.model.Vehicles
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.insert
import org.ktorm.schema.int
import org.ktorm.schema.varchar

fun Application.VehicleConfigureRepo(){
    val db= DatabaseConnection.database
    routing {
        route("/api/v1/fs/mi") {
            get("/VehicleInserting") {
                val vehicleCredentials = call.receive<Vehicles>()
                val veh_id = vehicleCredentials.veh_id
                val cust_id = vehicleCredentials.cust_id
                val reg_number = vehicleCredentials.reg_number
                val type = vehicleCredentials.type
                val make = vehicleCredentials.make
                val model = vehicleCredentials.model
                val variant = vehicleCredentials.variant
                val reg_date = vehicleCredentials.reg_date
                val engine_number = vehicleCredentials.engine_number
                val chassis_number = vehicleCredentials.chassis_number
                val created_at = vehicleCredentials.created_at
                val updated_at = vehicleCredentials.updated_at
                db.insert(Vehicle) {
                    set(it.veh_id, veh_id)
                    set(it.cust_id, cust_id)
                    set(it.reg_number, reg_number)
                    set(it.type, type)
                    set(it.model, model)
                    set(it.variant, variant)
                    set(it.reg_date, reg_date)
                    set(it.engine_number, engine_number)
                    set(it.chassis_number, chassis_number)
                    set(it.created_at, created_at)
                    set(it.updated_at, updated_at)
                    set(it.make, make)

                }
                call.respondText("Succesfully Inserted")
            }
        }

    }
}
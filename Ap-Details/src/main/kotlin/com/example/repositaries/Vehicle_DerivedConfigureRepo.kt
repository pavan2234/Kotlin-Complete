package com.example.repositaries

import com.example.dbconfig.DatabaseConnection
import com.example.entitybinding.Vehicle_Derives
import com.example.model.Vehicle_Derived
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.insert

fun Application.Vehicle_DerivedConfigureRepo() {
    val db = DatabaseConnection.database
    routing {
        route("/api/v1/fs/mi") {
            get("/Vehicle_DeriveddetailsInserting") {
                val vehicle_derivedDetails=call.receive<Vehicle_Derived>()
                val id=vehicle_derivedDetails.id
                val reg_number=vehicle_derivedDetails.reg_number
                val cust_id=vehicle_derivedDetails.cust_id
                val segment=vehicle_derivedDetails.segment
                val cubic_capacity=vehicle_derivedDetails.cubic_capacity
                val seating_capacity=vehicle_derivedDetails.seating_capacity
                val purchase_date=vehicle_derivedDetails.purchase_date
                val fuel=vehicle_derivedDetails.fuel
                val body_type=vehicle_derivedDetails.body_type
                val rto_name=vehicle_derivedDetails.rto_name
                val rto_group_code=vehicle_derivedDetails.rto_group_code
                val rto_zone=vehicle_derivedDetails.rto_zone

                db.insert(Vehicle_Derives){
                    set(it.id,id)
                    set(it.reg_number,reg_number)
                    set(it.cust_id,cust_id)
                    set(it.segment,segment)
                    set(it.cubic_capacity,cubic_capacity)
                    set(it.seating_capacity,seating_capacity)
                    set(it.purchase_date,purchase_date)
                    set(it.fuel,fuel)
                    set(it.body_type,body_type)
                    set(it.rto_name,rto_name)
                    set(it.rto_group_code,rto_group_code)
                    set(it.rto_zone,rto_zone)
                }
                call.respondText("Succesfully inserted...")
            }
        }
    }
}

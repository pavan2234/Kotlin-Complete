package com.example.repositaries

import com.example.dbconfig.DatabaseConnection
import com.example.entities.Addres
import com.example.model.Address
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.*

fun Application.AddressConfigureRepo(){
    val db= DatabaseConnection.database
    routing {
        route("/api/v1/fs/mi") {
            get("/addressInserting") {
                val AddressCredentials = call.receive<Address>()
                val id = AddressCredentials.id
                val cust_id = AddressCredentials.cust_id
                val veh_id = AddressCredentials.veh_id
                val addr_line1 = AddressCredentials.addr_line1
                val addr_line2 = AddressCredentials.addr_line2
                val pincode = AddressCredentials.pincode
                val created_at = AddressCredentials.created_at
                val updated_at = AddressCredentials.updated_at

                db.insert(Addres) {
                    set(it.id, id)
                    set(it.cust_id, cust_id)
                    set(it.veh_id, veh_id)
                    set(it.addr_line1, addr_line1)
                    set(it.addr_line2, addr_line2)
                    set(it.pincode, pincode)
                    set(it.created_at, created_at)
                    set(it.updated_at, updated_at)
                }
                call.respondText("Succesfully Inserted")
            }
        }
    }
}
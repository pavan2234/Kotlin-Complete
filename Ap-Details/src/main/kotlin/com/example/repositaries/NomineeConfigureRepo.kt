package com.example.repositaries

import com.example.dbconfig.DatabaseConnection
import com.example.entities.Nomine
import com.example.model.Nominee
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.insert

fun Application.NomineeConfigureRepo(){
    val db= DatabaseConnection.database
    routing {
        route("/api/v1/fs/mi") {
            get("/NomineedetailsInserting") {
                val nomineeCredentials = call.receive<Nominee>()
                val id = nomineeCredentials.id
                val cust_id = nomineeCredentials.cust_id
                val name = nomineeCredentials.name
                val relationship = nomineeCredentials.relationship
                val age = nomineeCredentials.age
                val guardian_name = nomineeCredentials.guardian_name
                val guardian_relationShip = nomineeCredentials.guardian_relationShip
                val created_at = nomineeCredentials.created_at
                val updated_at = nomineeCredentials.updated_at

                db.insert(Nomine) {
                    set(it.id, id)
                    set(it.cust_id, cust_id)
                    set(it.name, name)
                    set(it.relationship, relationship)
                    set(it.age, age)
                    set(it.guardian_name, guardian_name)
                    set(it.guardian_relationShip, guardian_relationShip)
                    set(it.created_at, created_at)
                    set(it.updated_at, updated_at)
                }
                call.respondText("Succesfully Inserted...")
            }
        }
    }
}
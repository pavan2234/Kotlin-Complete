package com.example.repositaries

import com.example.dbconfig.DatabaseConnection
import com.example.entities.Customer
import com.example.model.Customers
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.insert

//

fun Application.customerConfigure(){
    val db= DatabaseConnection.database
    routing {
        route("/api/v1/fs/mi"){
            get ("/CustomerInserting"){
                val customercredentials=call.receive<Customers>()
                val cust_id=customercredentials.cust_id
                val cust_hash= customercredentials.cust_hash
                val  name=customercredentials.name
                val phone_number= customercredentials.phone_number
                val email=customercredentials.email
                val created_at=customercredentials.created_at
                val updated_at=customercredentials.updated_at

                db.insert(Customer){
                    set(it.cust_id,cust_id)
                    set(it.cust_hash,cust_hash)
                    set(it.name,name)
                    set(it.phone_number,phone_number)
                    set(it.email,email)
                    set(it.created_at,created_at)
                    set(it.updated_at,updated_at)
                }
                call.respondText("Succesfully inserted...")
            }
        }
    }
}
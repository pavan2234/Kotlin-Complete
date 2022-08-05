package com.example.repositaries

import com.example.dbconfig.DatabaseConnection
import com.example.entities.Prev_Policie
import com.example.model.Prev_Policy
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.insert

fun Application.Prev_PolicieConfigureRepo() {
    val db = DatabaseConnection.database
    routing {
        route("/api/v1/fs/mi") {
            get("/Prev_PolicydetailsInserting") {
                val prev_PolicyDetails=call.receive<Prev_Policy>()
                val id=prev_PolicyDetails.id
                val veh_id=prev_PolicyDetails.veh_id
                val insurer_name=prev_PolicyDetails.insurer_name
                val policy_number=prev_PolicyDetails.policy_number
                val is_expired=prev_PolicyDetails.is_expired
                val ncb_benefitClaimed_prev_year=prev_PolicyDetails.ncb_benefitClaimed_prev_year
                val ncb_benefitPrev_ncb=prev_PolicyDetails.ncb_benefitPrev_ncb
                val ncb_benefitCurr_ncb=prev_PolicyDetails.ncb_benefitCurr_ncb
                val created_at=prev_PolicyDetails.created_at
                val updated_at=prev_PolicyDetails.updated_at

                db.insert(Prev_Policie){
                    set(it.id,id)
                    set(it.veh_id,veh_id)
                    set(it.insurer_name,insurer_name)
                    set(it.policy_number,policy_number)
                    set(it.is_expired,is_expired)
                    set(it.ncb_benefitClaimed_prev_year,ncb_benefitClaimed_prev_year)
                    set(it.ncb_benefitPrev_ncb,ncb_benefitPrev_ncb)
                    set(it.ncb_benefitCurr_ncb,ncb_benefitCurr_ncb)
                    set(it.created_at,created_at)
                    set(it.updated_at,updated_at)
                }
                call.respondText("Succesfully inserted....")
            }
        }
    }
}
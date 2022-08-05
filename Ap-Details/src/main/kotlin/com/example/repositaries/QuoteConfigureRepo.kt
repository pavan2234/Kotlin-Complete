package com.example.repositaries

import com.example.dbconfig.DatabaseConnection
import com.example.entities.Quotes
import com.example.model.Quote
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.insert

fun Application.QuoteConfigureRepo() {
    val db = DatabaseConnection.database
    routing {
        route("/api/v1/fs/mi") {
            get("/QuotedetailsInserting") {
                val quotedetails=call.receive<Quote>()
                val id=quotedetails.id
                val veh_id=quotedetails.veh_id
                val cust_id=quotedetails.cust_id
                val prev_policy_id=quotedetails.prev_policy_id
                val nominees_id=quotedetails.nominees_id
                val nominees_percentage=quotedetails.nominees_percentage
                val addr_id=quotedetails.addr_id
                val type=quotedetails.type
                val insurer=quotedetails.insurer
                val insurer_quote_identifier_quoteNumber=quotedetails.insurer_quote_identifier_quoteNumber
                val insurer_quote_identifier_ref_Number=quotedetails.insurer_quote_identifier_ref_Number
                val insurer_quote_identifier_proposal_Number=quotedetails.insurer_quote_identifier_proposal_Number
                val idv_detailbase_quote=quotedetails.idv_detailbase_quote
                val idv_detailbase_idv=quotedetails.idv_detailbase_idv
                val idv_detail_median_quote=quotedetails.idv_detail_median_quote
                val idv_detail_median_idv=quotedetails.idv_detail_median_idv
                val idv_detail_max_quote=quotedetails.idv_detail_max_quote
                val idv_detail_max_idv=quotedetails.idv_detail_max_idv
                val add_ons_type=quotedetails.add_ons_type
                val add_ons_price=quotedetails.add_ons_price
                val policy_tenure=quotedetails.policy_tenure
                val policy_type=quotedetails.policy_type
                val created_at=quotedetails.created_at
                val updated_at=quotedetails.updated_at

                db.insert(Quotes){
                    set(it.id,id)
                    set(it.veh_id,veh_id)
                    set(it.cust_id,cust_id)
                    set(it.prev_policy_id,prev_policy_id)
                    set(it.nominees_id,nominees_id)
                    set(it.nominees_percentage,nominees_percentage)
                    set(it.addr_id,addr_id)
                    set(it.type,type)
                    set(it.insurer,insurer)
                    set(it.insurer_quote_identifier_quoteNumber,insurer_quote_identifier_quoteNumber)
                    set(it.insurer_quote_identifier_ref_Number,insurer_quote_identifier_ref_Number)
                    set(it.insurer_quote_identifier_proposal_Number,insurer_quote_identifier_proposal_Number)
                    set(it.idv_detailbase_quote,idv_detailbase_quote)
                    set(it.idv_detailbase_idv,idv_detailbase_idv)
                    set(it.idv_detail_median_quote,idv_detail_median_quote)
                    set(it.idv_detail_median_idv,idv_detail_median_idv)
                    set(it.idv_detail_max_quote,idv_detail_max_quote)
                    set(it.idv_detail_max_idv,idv_detail_max_idv)
                    set(it.add_ons_type,add_ons_type)
                    set(it.add_ons_price,add_ons_price)
                    set(it.policy_tenure,policy_tenure)
                    set(it.policy_type,policy_type)
                    set(it.created_at,created_at)
                    set(it.updated_at,updated_at)
                }
                call.respondText("Succesfully inserted....")
            }
        }
    }
}

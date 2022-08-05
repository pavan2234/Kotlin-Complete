package com.example.entities

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Quotes :Table<Nothing>("quote"){
    val id=int("id").primaryKey()
    val veh_id=int("veh_id")
    val cust_id=int("cust_id")
    val prev_policy_id= int("prev_policy_id")
    val nominees_id=int("nominees_id")
    val nominees_percentage=int("nominees_percentage")
    val addr_id=int("addr_id")
    val type=varchar("type")
    val insurer=varchar("insurer")
    val insurer_quote_identifier_quoteNumber=varchar("insurer_quote_identifier_quoteNumber")
    val insurer_quote_identifier_ref_Number=varchar("insurer_quote_identifier_ref_Number")
    val insurer_quote_identifier_proposal_Number=varchar("insurer_quote_identifier_proposal_Number")
    val idv_detailbase_quote=int("idv_detailbase_quote")
    val idv_detailbase_idv=int("idv_detailbase_idv")
    val idv_detail_median_quote=int("idv_detail_median_quote")
    val idv_detail_median_idv=int("idv_detail_median_idv")
    val idv_detail_max_quote=int("idv_detail_max_quote")
    val idv_detail_max_idv=int("idv_detail_max_idv")
    val add_ons_type=varchar("add_ons_type")
    val add_ons_price=varchar("add_ons_price")
    val policy_tenure=int("policy_tenure")
    val policy_type=varchar("policy_type")
    val created_at=varchar("created_at")
    val updated_at=varchar("updated_at")
}
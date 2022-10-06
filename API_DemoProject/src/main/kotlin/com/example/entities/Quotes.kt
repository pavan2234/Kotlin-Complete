package com.example.entities

import org.jetbrains.exposed.sql.Table


object Quotes :Table("quote"){
    val id=integer("id")
    val veh_id=integer("veh_id")
    val cust_id=integer("cust_id")
    val prev_policy_id= integer("prev_policy_id")
    val nominees_id=integer("nominees_id")
    val nominees_percentage=integer("nominees_percentage")
    val addr_id=integer("addr_id")
    val type=varchar("type",50)
    val insurer=varchar("insurer",50)
    val insurer_quote_identifier_quoteNumber=varchar("insurer_quote_identifier_quoteNumber",50)
    val insurer_quote_identifier_ref_Number=varchar("insurer_quote_identifier_ref_Number",50)
    val insurer_quote_identifier_proposal_Number=varchar("insurer_quote_identifier_proposal_Number",50)
    val idv_detailbase_quote=integer("idv_detailbase_quote")
    val idv_detailbase_idv=integer("idv_detailbase_idv")
    val idv_detail_median_quote=integer("idv_detail_median_quote")
    val idv_detail_median_idv=integer("idv_detail_median_idv")
    val idv_detail_max_quote=integer("idv_detail_max_quote")
    val idv_detail_max_idv=integer("idv_detail_max_idv")
    val add_ons_type=varchar("add_ons_type",50)
    val add_ons_price=varchar("add_ons_price",50)
    val policy_tenure=integer("policy_tenure")
    val policy_type=varchar("policy_type",50)
    val created_at=varchar("created_at",50)
    val updated_at=varchar("updated_at",50)

    override val primaryKey=PrimaryKey(id)
}
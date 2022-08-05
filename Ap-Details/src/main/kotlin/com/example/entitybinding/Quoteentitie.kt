package com.example.entitybinding

import com.example.EntityBindings.Customer
import com.example.EntityBindings.Customers
import com.example.EntityBindings.Vehicles
import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Quote:Entity<Quote>{
    val id:Int
    val veh_id:Int
    val cust_id:Int
    val prev_policy_id:Int
    val nominees_id:Int
    val nominees_percentage:Int
    val addr_id:Int
    val type:String
    val insurer:String
    val insurer_quote_identifier_quoteNumber:String
    val insurer_quote_identifier_ref_Number:String
    val insurer_quote_identifier_proposal_Number:String
    val idv_detailbase_quote:Int
    val idv_detailbase_idv:Int
    val idv_detail_median_quote:Int
    val idv_detail_median_idv:Int
    val idv_detail_max_quote:Int
    val idv_detail_max_idv:Int
    val add_ons_type:String
    val add_ons_price:String
    val policy_tenure:Int
    val policy_type:String
    val created_at:String
    val updated_at:String
    val vehicle: com.example.EntityBindings.Vehicle
    val customer: Customer
    val perv_policy:Prev_policy

}
object Quotes:Table<Quote>("quote"){
    val id=int("id").primaryKey().bindTo { it.id }
    val veh_id=int("veh_id").references(Vehicles){it.vehicle}
    val cust_id=int("cust_id").references(Customers){it.customer}
    val prev_policy_id= int("prev_policy_id").references(Prev_policies){it.perv_policy}
    val nominees_id=int("nominees_id").bindTo { it.nominees_id }
    val nominees_percentage=int("nominees_percentage").bindTo { it.nominees_percentage }
    val addr_id=int("addr_id").bindTo { it.addr_id }
    val type=varchar("type").bindTo { it.type }
    val insurer=varchar("insurer").bindTo { it.insurer }
    val insurer_quote_identifier_quoteNumber=varchar("insurer_quote_identifier_quoteNumber").bindTo { it.insurer_quote_identifier_quoteNumber}
    val insurer_quote_identifier_ref_Number=varchar("insurer_quote_identifier_ref_Number").bindTo { it.insurer_quote_identifier_ref_Number }
    val insurer_quote_identifier_proposal_Number=varchar("insurer_quote_identifier_proposal_Number").bindTo { it.insurer_quote_identifier_proposal_Number }
    val idv_detailbase_quote=int("idv_detailbase_quote").bindTo { it.idv_detailbase_quote }
    val idv_detailbase_idv=int("idv_detailbase_idv").bindTo { it.idv_detailbase_idv }
    val idv_detail_median_quote=int("idv_detail_median_quote").bindTo { it.idv_detail_median_quote }
    val idv_detail_median_idv=int("idv_detail_median_idv").bindTo { it.idv_detail_median_idv }
    val idv_detail_max_quote=int("idv_detail_max_quote").bindTo { it.idv_detail_max_quote }
    val idv_detail_max_idv=int("idv_detail_max_idv").bindTo { it.idv_detail_max_idv }
    val add_ons_type=varchar("add_ons_type").bindTo { it.add_ons_type }
    val add_ons_price=varchar("add_ons_price").bindTo { it.add_ons_price }
    val policy_tenure=int("policy_tenure").bindTo { it.policy_tenure }
    val policy_type=varchar("policy_type").bindTo { it.policy_type }
    val created_at=varchar("created_at").bindTo { it.created_at }
    val updated_at=varchar("updated_at").bindTo { it.updated_at }
}
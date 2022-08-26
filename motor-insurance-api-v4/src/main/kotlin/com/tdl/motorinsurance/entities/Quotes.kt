package com.tdl.motorinsurance.entities

import com.tdl.motorinsurance.model.*
import com.tdl.motorinsurance.model.Nominees
import org.ktorm.entity.Entity
import org.ktorm.jackson.json
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Quote : Entity<Quote> {
    val id:String
    val veh_id:String
    val cust_id:String
    val prev_policy_id:String
    val nominees:Nominees
    val addr_id:String
    val type:String
    val insurer:String
    val insurerr:InsurerQuoteIdentifier?
    val idv_details:IDVDetails?
    val add_ons:AddOns?
    val created_at:String
    val updated_at:String
    val vehicle:Vehicle
    val customer:Customer
    val prev_policy:Prev_Policy
    val address:Address
}

object Quotes : Table<Quote>("Quote") {
    val id = varchar("id").bindTo { it.id }
    val veh_id = varchar("veh_id").references(Vehicles){it.vehicle}
    val cust_id = varchar("cust_id").references(Customers) {it.customer}
    val prev_policy_id = varchar("prev_policy_id").references(Prev_Policies) {it.prev_policy}
    val nominees = json<Nominees>("nominees").bindTo { it.nominees }
    val addr_id = varchar("addr_id").references(Addresses) {it.address}
    val type = varchar("type").bindTo { it.type }
    val insurer = varchar("insurer").bindTo { it.insurer }
    val insurerr = json<InsurerQuoteIdentifier>("insurerr").bindTo { it.insurerr }
    val idv_details = json<IDVDetails>("idv_details").bindTo { it.idv_details }
    val add_ons = json<AddOns>("add_ons").bindTo { it.add_ons }
    val created_at = varchar("created_at").bindTo { it.created_at }
    val updated_at = varchar("updated_at").bindTo { it.updated_at }
}
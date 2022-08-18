package com.tdl.motorinsurance.entities

import com.tdl.motorinsurance.model.Ncb_Benifit
import org.ktorm.entity.Entity
import org.ktorm.jackson.json
import org.ktorm.schema.Table
import org.ktorm.schema.boolean
import org.ktorm.schema.varchar

interface Prev_Policy : Entity<Prev_Policy> {
    val id: String?
    val veh_id: String?
    val insurer_name: String?
    val policy_number: String
    val is_expired:Boolean?
    val ncb_benifit: Ncb_Benifit?
    val created_at: String?
    val updated_at: String?
    val vehicle:Vehicle
}

object Prev_Policies : Table<Prev_Policy>("prev_policy") {
    val id = varchar("id").primaryKey().bindTo { it.id }
    val insurer_name = varchar("insurer_name").bindTo { it.insurer_name }
    val policy_number = varchar("policy_number").bindTo { it.policy_number }
    val is_expired = boolean("is_expired").bindTo { it.is_expired }
    val ncb_benifit = json<Ncb_Benifit>("ncb_benifit").bindTo { it.ncb_benifit }
    val created_at = varchar("created_at").bindTo { it.created_at }
    val updated_at = varchar("updated_at").bindTo { it.updated_at}
    val veh_id = varchar("veh_id").references(Vehicles){ it.vehicle}

}
package com.example.entitybinding

import com.example.EntityBindings.Addres.references
import com.example.EntityBindings.Customer
import com.example.EntityBindings.Vehicles
import com.example.entities.Prev_Policie.primaryKey
import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.boolean
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Prev_policy :Entity<Prev_policy>{
    val id:Int
    val veh_id:Int
    val insurer_name:String
    val policy_number:Int
    val is_expired:Boolean
    val ncb_benefitClaimed_prev_year:Boolean
    val ncb_benefitPrev_ncb:Int
    val ncb_benefitCurr_ncb:Int
    val created_at:String
    val updated_at:String
    val vehicle: com.example.EntityBindings.Vehicle

}
object Prev_policies :Table<Prev_policy>("prev_policy"){
    val id=int("id").primaryKey() .bindTo { it.id }
    val veh_id=int("veh_id").references(Vehicles){it.vehicle}
    val insurer_name=varchar("insurer_name").bindTo { it.insurer_name }
    val policy_number= int("policy_number").bindTo { it.policy_number }
    val is_expired=boolean("is_expired").bindTo { it.is_expired }
    val ncb_benefitClaimed_prev_year=boolean("ncb_benefitClaimed_prev_year").bindTo { it.ncb_benefitClaimed_prev_year }
    val ncb_benefitPrev_ncb=int("ncb_benefitPrev_ncb").bindTo { it.ncb_benefitPrev_ncb }
    val ncb_benefitCurr_ncb=int("ncb_benefitCurr_ncb").bindTo { it.ncb_benefitCurr_ncb }
    val created_at=varchar("created_at")
    val updated_at=varchar("updated_at")
}
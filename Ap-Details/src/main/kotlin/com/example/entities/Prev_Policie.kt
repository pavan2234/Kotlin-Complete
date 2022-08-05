package com.example.entities

import org.ktorm.schema.Table
import org.ktorm.schema.boolean
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Prev_Policie :Table<Nothing>("prev_policy"){
    val id=int("id").primaryKey()
    val veh_id=int("veh_id")
    val insurer_name=varchar("insurer_name")
    val policy_number= int("policy_number")
    val is_expired=boolean("is_expired")
    val ncb_benefitClaimed_prev_year=boolean("ncb_benefitClaimed_prev_year")
    val ncb_benefitPrev_ncb=int("ncb_benefitPrev_ncb")
    val ncb_benefitCurr_ncb=int("ncb_benefitCurr_ncb")
    val created_at=varchar("created_at")
    val updated_at=varchar("updated_at")
}
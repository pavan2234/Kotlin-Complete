package com.example.entities

import org.jetbrains.exposed.sql.Table

object Prev_Policie :Table("prev_policy"){
    val id=integer("id")
    val veh_id=integer("veh_id")
    val insurer_name=varchar("insurer_name",50)
    val policy_number= integer("policy_number")
    val is_expired=varchar("is_expired",50)
    val ncb_benefitClaimed_prev_year=varchar("ncb_benefitClaimed_prev_year",50)
    val ncb_benefitPrev_ncb=integer("ncb_benefitPrev_ncb")
    val ncb_benefitCurr_ncb=integer("ncb_benefitCurr_ncb")
    val created_at=varchar("created_at",50)
    val updated_at=varchar("updated_at",50)

    override val primaryKey=PrimaryKey(id)
}
package com.tdl.motorinsurance.entities

import com.tdl.motorinsurance.model.NomineeDTO
import org.ktorm.entity.Entity
import org.ktorm.jackson.json
import org.ktorm.schema.Table
import org.ktorm.schema.varchar

interface InsuredDet :Entity<InsuredDet>{
    val nomineeId:String
    val name:String
    val email:String
    val phone_Number:String
    val nominees:Nominee
}

object InsuredDetails :Table<InsuredDet>("insureddetails"){
    val name=varchar("name").primaryKey().bindTo { it.name }
    val email=varchar("email").bindTo { it.email }
    val phone_Number=varchar("phone_number").bindTo { it.phone_Number }
    val nomineeId=varchar("nomineeid").references(Nominees){it.nominees}
}
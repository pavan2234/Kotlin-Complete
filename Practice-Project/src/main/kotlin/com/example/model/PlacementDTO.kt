package com.example.model_joins

import com.example.model.companyDTO

data class placementDTO(
    val id :Int,
    val company_id:Int,
    val noofstudents:String,
    val passing_year:String,
    val pack_age : String,
    val location : String,
    val wfh : String,
    val companyDTO: companyDTO
)

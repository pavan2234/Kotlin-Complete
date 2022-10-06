package com.example.model_joins

import com.example.model.busdetailDTO
import com.example.model.companyDTO

data class personaldetailDTO(
    val id: Int,
    val name: String,
    val dob: String,
    val father: String,
    val placement_id: Int,
    val bus_id: Int,
    val college_id :Int,
    val company_id:Int,
    val placementDTO: placementDTO,
    val busdetailDTO: busdetailDTO,
    val collegedetailDTO: collegedetailDTO,
    val companyDTO: companyDTO
)

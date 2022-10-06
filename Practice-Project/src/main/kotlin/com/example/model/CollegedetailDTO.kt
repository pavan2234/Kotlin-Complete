package com.example.model_joins

import com.example.model.busdetailDTO
import com.example.model.companyDTO
import com.example.model.locationDTO

data class collegedetailDTO(
    val id:Int,
    val name: String,
    val affliated: String,
    val location_id: Int,
    val bus_id: Int,
    val company_id:Int,
    val locationDTO: locationDTO,
    val busdetailDTO: busdetailDTO,
    val companyDTO: companyDTO

)

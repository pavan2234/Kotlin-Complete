package com.example.service

import com.example.model.karateDTO
import com.example.repository.KarateRepositoryEXPOSED
import org.jetbrains.exposed.sql.Column

class KarateService {
    val karaterepo2 = KarateRepositoryEXPOSED()

    suspend fun createDetails(params: karateDTO):karateDTO?{
        return karaterepo2.createDetails(params)
    }
    suspend fun getDetails():List<karateDTO?>{
        return karaterepo2.getDetails()
    }
    suspend fun getDetailsById(id: Column<Int>):List<karateDTO?>{
        return karaterepo2.getCustomerById(id)
    }


}
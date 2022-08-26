package com.example.service

import com.example.entities.karate
import com.example.model.karateDTO
import com.example.repository.KarateRepository

class KarateService {
    val karaterepo = KarateRepository()
    suspend fun CustomerEntry(params:karateDTO):Int{
    return karaterepo.CustomerEntry(params)
    }
//    suspend fun TraineeDetails():List<karate>{
//        return karaterepo.TraineeDetails()
//    }
    suspend fun TraineeDetails():List<karateDTO>{
        return karaterepo.TraineeDetails()
    }
    suspend fun UpdateDetails(params:karateDTO):Int{
        return karaterepo.UpdateDetails(params)
    }
}
package com.example.service

import com.example.model.PlacementINDVDTO
import com.example.model_joins.placementDTO
import com.example.repository.PlacementRepositoryINDV
import com.example.repository.PlacementRepositoryWithRefernces

class placementservice {
    private val placementrepo = PlacementRepositoryWithRefernces()

    fun savePlacementDetails(params: placementDTO):Int{
        return placementrepo.savePlacementDetails(params)
    }
    suspend fun getPlacementDetails():List<placementDTO>{
        return placementrepo.getPlacementDetails()
    }

    private val placementINDVrepo = PlacementRepositoryINDV()

    fun saveINDVPlacementDetails(params: PlacementINDVDTO): Int {
        return placementINDVrepo.saveINDVPlacementDetails(params)
    }
    suspend fun getINDVPlacementDetails():List<PlacementINDVDTO>{
        return placementINDVrepo.getINDVPlacementDetails()
    }
}
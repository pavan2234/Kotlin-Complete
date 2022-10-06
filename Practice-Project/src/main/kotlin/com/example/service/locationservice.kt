package com.example.service

import com.example.model.locationDTO
import com.example.repository.LocationRepository

class locationservice {
    private val locationrepo = LocationRepository()
     fun saveLocatioDetails(params: locationDTO):Int{
         return locationrepo.savelocationdetails(params)
     }
    suspend fun getLocationDetails():List<locationDTO>{
        return locationrepo.getlocationdetails()
    }
}
package com.example.service

import com.example.model.PersonINDVDTO
import com.example.model_joins.personaldetailDTO
import com.example.repository.PersonalDetailsRepositoryINDV
import com.example.repository.PersonalDetailsRepositoryWithReferences

class personaldetailservice {
    private val personalrepo = PersonalDetailsRepositoryWithReferences()
    fun savePersonalDetails(params: personaldetailDTO):Int{
        return personalrepo.savePersonalDetails(params)
    }
    suspend fun getPersonalDetails():List<personaldetailDTO>{
        return personalrepo.getpersonalDetails()
    }

    private val personalINDVrepo = PersonalDetailsRepositoryINDV()

    fun saveINDVPersonalDetails(params: PersonINDVDTO): Int {
        return personalINDVrepo.saveINDVPersonalDetails(params)
    }
    suspend fun getINDVPersonalDetails():List<PersonINDVDTO>{
        return personalINDVrepo.getINDVpersonalDetails()
    }
}
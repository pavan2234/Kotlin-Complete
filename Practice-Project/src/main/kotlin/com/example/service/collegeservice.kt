package com.example.service

import com.example.model.CollegeINDVDTO
import com.example.model_joins.collegedetailDTO
import com.example.repository.CollegeRepositoryINDV
import com.example.repository.CollegeRepositorywithrefernces

class collegeservice {
    private val collegerepo = CollegeRepositorywithrefernces()
    fun saveCollegeDetails(params: collegedetailDTO):Int{
        return collegerepo.saveCollegeDetails(params)
    }
    suspend fun getCollegeDetails():List<collegedetailDTO>{
        return collegerepo.getCollegeDetails()
    }

    private val collegeINDVrepo = CollegeRepositoryINDV()
    fun saveINDVCollegeDetails(params: CollegeINDVDTO):Int{
        return collegeINDVrepo.saveINDVCollegeDetails(params)
    }
    suspend fun getINDVCollegeDetails():List<CollegeINDVDTO>{
        return collegeINDVrepo.getINDVCollegeDetails()
    }
}
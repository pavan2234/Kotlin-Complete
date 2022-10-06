package com.example.service

import com.example.model.companyDTO
import com.example.repository.CompanyRepository

class companyservice {
    private val companyrepo = CompanyRepository()
    fun saveCompanyDetails(params: companyDTO):Int{
        return companyrepo.saveCompanyDetails(params)
    }
    suspend fun getCompanyDetails():List<companyDTO>{
        return companyrepo.getcompanydetails()
    }
}
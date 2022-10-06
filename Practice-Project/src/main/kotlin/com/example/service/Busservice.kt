package com.example.service

import com.example.model.busdetailDTO
import com.example.repository.Busrepository

class Busservice{
    private val busrepo = Busrepository()
    fun saveBusDetails(params:busdetailDTO):Int{
        return busrepo.savebusdetails(params)
    }
    suspend fun getBusDetails():List<busdetailDTO>{
        return busrepo.getbusdetails()
    }
}
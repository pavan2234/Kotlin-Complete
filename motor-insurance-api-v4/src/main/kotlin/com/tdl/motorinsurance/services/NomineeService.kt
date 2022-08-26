package com.tdl.motorinsurance.services

import com.tdl.motorinsurance.entities.Nominee
import com.tdl.motorinsurance.model.NomineeDTO
import com.tdl.motorinsurance.repositaries.NomineeRepository

class NomineeService {

    private val nomineeRepository = NomineeRepository()

    suspend fun saveNomineeWithCustomer(params: NomineeDTO): Int {
        return nomineeRepository.saveNomineeWithCustomer(params)
    }

    suspend fun getNominees(): List<Nominee> {
        return nomineeRepository.getNominees()
    }

    suspend fun getNomineesWithCustomers(): List<NomineeDTO> {
        return nomineeRepository.getNomineesWithCustomers()
    }

    suspend fun updateNomineeWithCustomers(params: NomineeDTO): Int {
        return nomineeRepository.UpdatedNominee(params)
    }

    suspend fun UpdateNomineeById(params: NomineeDTO): Int {
        return nomineeRepository.updatenomineById(params)
    }

    suspend fun deleteById(params: NomineeDTO):Int{
        return nomineeRepository.deleteBYid(params)
    }
}

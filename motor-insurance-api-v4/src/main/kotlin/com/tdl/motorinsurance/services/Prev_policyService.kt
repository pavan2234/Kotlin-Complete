package com.tdl.motorinsurance.services

import com.tdl.motorinsurance.entities.Nominee
import com.tdl.motorinsurance.entities.Prev_Policy
import com.tdl.motorinsurance.model.NomineeDTO
import com.tdl.motorinsurance.model.Prev_PolicyDTO
import com.tdl.motorinsurance.repositaries.NomineeRepository
import com.tdl.motorinsurance.repositaries.Prev_PolicyRepositary

class Prev_policyService {

    private val prev_policyRepository = Prev_PolicyRepositary()

    suspend fun savePrev_PolicyWithVehicle(params: Prev_PolicyDTO): Int {
        return prev_policyRepository.savePrev_PolicyWithVehicle(params)
    }

    suspend fun getPrev_Policy(): List<Prev_Policy> {
        return prev_policyRepository.getPrev_Policy()
    }

    suspend fun getPrev_policyWithVehicle(): List<Prev_PolicyDTO> {
        return prev_policyRepository.getPrev_PolicyWithVehicle()
    }

    suspend fun updatePrev_PolicyWithVehicle(params: Prev_PolicyDTO): Int {
        return prev_policyRepository.UpdatedPrev_Policy(params)
    }

    suspend fun UpdatePrev_PolicyById(params: Prev_PolicyDTO): Int {
        return prev_policyRepository.updatePrev_policyId(params)
    }

    suspend fun deleteById(params: Prev_PolicyDTO):Int{
        return prev_policyRepository.deleteBYid(params)
    }
    suspend fun getOnboarding(params: Prev_PolicyDTO){
        return prev_policyRepository.getOnboarding(params)
    }
}
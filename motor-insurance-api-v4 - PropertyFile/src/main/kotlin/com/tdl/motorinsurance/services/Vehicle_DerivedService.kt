package com.tdl.motorinsurance.services

import com.tdl.motorinsurance.entities.Nominee
import com.tdl.motorinsurance.entities.Vehicle
import com.tdl.motorinsurance.entities.Vehicle_Derived
import com.tdl.motorinsurance.model.NomineeDTO
import com.tdl.motorinsurance.model.Vehicle_DerivedDTO
import com.tdl.motorinsurance.repositaries.NomineeRepository
import com.tdl.motorinsurance.repositaries.Veicle_DerivedRepositary


class Vehicle_DerivedService {
    private val vehicle_derivedRepository = Veicle_DerivedRepositary()

    suspend fun saveVehicle_deivedWithCustomer(params: Vehicle_DerivedDTO): Int {
        return vehicle_derivedRepository.saveVehicle_derivedWithCustomer(params)
    }

    suspend fun getVehile_Derived(): List<Vehicle_Derived> {
        return vehicle_derivedRepository.getVehicle_Derived()
    }

    suspend fun getVehicle_derivedWithCustomers(): List<Vehicle_DerivedDTO> {
        return vehicle_derivedRepository.getVeicle_DerivedWithCustomers()
    }

    suspend fun updateVehicle_derivedWithCustomers(params: Vehicle_DerivedDTO): Int {
        return vehicle_derivedRepository.UpdatedVehicle_Derived(params)
    }

    suspend fun UpdateVehicle_derivedById(params: Vehicle_DerivedDTO): Int {
        return vehicle_derivedRepository.updateVehicle_derivedId(params)
    }

    suspend fun deleteById(params: Vehicle_DerivedDTO):Int{
        return vehicle_derivedRepository.deleteBYid(params)
    }
}
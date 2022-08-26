package com.tdl.motorinsurance.services

import com.tdl.motorinsurance.entities.Vehicle
import com.tdl.motorinsurance.entities.Vehicle_Derived
import com.tdl.motorinsurance.model.VehicleDTO
import com.tdl.motorinsurance.model.Vehicle_DerivedDTO
import com.tdl.motorinsurance.repositaries.VehicleRepositary
import com.tdl.motorinsurance.repositaries.Veicle_DerivedRepositary

class VehicleService {
    private val vehicleRepository = VehicleRepositary()

    suspend fun saveVehicleWithCustomer(params: VehicleDTO): Int {
        return vehicleRepository.saveVehicleWithCustomer(params)
    }

    suspend fun getVehile(): List<Vehicle> {
        return vehicleRepository.getVehicles()
    }

    suspend fun getVehicleWithCustomers(): List<VehicleDTO> {
        return vehicleRepository.getVehicleWithCustomers()
    }

    suspend fun updateVehicleWithCustomers(params: VehicleDTO): Int {
        return vehicleRepository.UpdatedVehicle(params)
    }

    suspend fun UpdateVehicleById(params: VehicleDTO): Int {
        return vehicleRepository.updateVehicleById(params)
    }

    suspend fun deleteById(params: VehicleDTO):Int{
        return vehicleRepository.deleteBYid(params)
    }
}
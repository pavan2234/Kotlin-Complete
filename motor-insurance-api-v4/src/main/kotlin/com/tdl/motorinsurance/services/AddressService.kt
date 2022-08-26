package com.tdl.motorinsurance.services

import com.tdl.motorinsurance.entities.Address
import com.tdl.motorinsurance.entities.Nominee
import com.tdl.motorinsurance.model.AddressDTO
import com.tdl.motorinsurance.model.NomineeDTO
import com.tdl.motorinsurance.repositaries.AddressRepositary
import com.tdl.motorinsurance.repositaries.NomineeRepository

class AddressService {

    private val addressRepository = AddressRepositary()

    suspend fun saveAddressWithCustomerandVehicle(params: AddressDTO): Int {
        return addressRepository.saveAddressWithCustomerandVehicle(params)
    }

    suspend fun getAddress(): List<Address> {
        return addressRepository.getAddress()
    }

    suspend fun getAddressWithCustomersandVehicle(): List<AddressDTO> {
        return addressRepository.getAddressWithCustomersandVehicle()
    }

    suspend fun updateAddressWithCustomersandVehicle(params: AddressDTO): Int {
        return addressRepository.UpdatedAddress(params)
    }

    suspend fun UpdateAddressById(params: AddressDTO): Int {
        return addressRepository.updateAddressById(params)
    }

    suspend fun deleteById(params: AddressDTO):Int{
        return addressRepository.deleteBYid(params)
    }
}
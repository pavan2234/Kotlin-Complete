package com.example.services

import com.example.EntityBindings.Addres
import com.example.EntityBindings.Address
import com.example.dbconfig.DatabaseConnection
import org.ktorm.dsl.from
import org.ktorm.dsl.joinReferencesAndSelect
import org.ktorm.dsl.map
import org.ktorm.dsl.select

interface AddressService {
    fun TotalAddress():List<Address>
    fun Addresswithcustomer():List<Address>
}
class subAddressSrvice:AddressService{
    val db=DatabaseConnection.database
    override fun TotalAddress(): List<Address> {
        val OnlyAddress=db.from(Addres).select().map { row -> Addres.createEntity(row) }
        return OnlyAddress
    }

    override fun Addresswithcustomer(): List<Address> {
        val AddressWithCustomer=db.from(Addres).joinReferencesAndSelect()
            .map {  row -> Addres.createEntity(row) }
        return AddressWithCustomer
    }

}
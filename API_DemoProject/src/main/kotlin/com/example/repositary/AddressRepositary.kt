package com.example.repositary

import com.example.entities.Addres
import com.example.entities.Customer
import com.example.model.Address
import com.example.model.Customers
import com.org.db.DatabaseFactory
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.statements.InsertStatement
/*
class AddressRepositary {*/

/*
    suspend fun createAddress(params: Address): Address?{
        var statement: InsertStatement<Number>?=null
        DatabaseFactory.dbQuery {
            statement= Addres.insert {
                it[id]=params.id
                it[cust_id]= params.cust_id
                it[veh_id]=params.veh_id
                it[created_at]=params.created_at
                it[updated_at]=params.updated_at
            }
        }
        return convertToCustomers(statement?.resultedValues?.get(0))
    }

}*/

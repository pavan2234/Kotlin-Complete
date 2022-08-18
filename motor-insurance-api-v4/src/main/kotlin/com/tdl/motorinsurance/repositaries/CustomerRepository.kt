package com.tdl.motorinsurance.repositaries

import com.tdl.motorinsurance.dbconfig.DatabaseFactory
import com.tdl.motorinsurance.entities.Customer
import com.tdl.motorinsurance.entities.Customers
import com.tdl.motorinsurance.model.CustomerDTO
import org.ktorm.dsl.from
import org.ktorm.dsl.insert
import org.ktorm.dsl.map
import org.ktorm.dsl.select

class CustomerRepository {

    suspend fun saveCustomer(params: CustomerDTO): Int {
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().insert(Customers) {
                set(it.id, params.id)
                set(it.cust_hash, params.cust_hash)
                set(it.name, params.name)
                set(it.phone_number, params.phone_number)
                set(it.email, params.email)
                set(it.created_at, params.created_at)
                set(it.updated_at, params.updated_at)

            }
        }
    }

    suspend fun getCustomers(): List<Customer> {
        return DatabaseFactory.dbQuery {
            DatabaseFactory.getConnection().from(Customers).select()
                .map { row -> Customers.createEntity(row) }
        }
    }
}

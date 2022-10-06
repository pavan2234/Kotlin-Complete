package com.example.repositary

import com.example.entities.Customer
import com.example.model.Customers
import com.org.db.DatabaseFactory
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.statements.InsertStatement

class CustomerRepositary {

    /*Creating Customers...*/

    suspend fun createCustomer(params: Customers):Customers?{
        var statement:InsertStatement<Number>?=null
        DatabaseFactory.dbQuery {
            statement= Customer.insert {
                it[cust_id]= params.cust_id
                it[cust_hash]=params.cust_hash
                it[name]=params.name
                it[phone_number]=params.phone_number
                it[email]=params.email
                it[created_at]=params.created_at
                it[updated_at]=params.updated_at
            }
        }
        return convertToCustomers(statement?.resultedValues?.get(0))
    }


    fun convertToCustomers(row: ResultRow?):Customers? {
        return if (row == null) {
            null
        } else {
            Customers(
                cust_id = row[Customer.cust_id],
                cust_hash = row[Customer.cust_hash],
                name = row[Customer.name],
                phone_number = row[Customer.phone_number],
                email = row[Customer.email],
                created_at = row[Customer.created_at],
                updated_at = row[Customer.updated_at]
            )
        }
    }

         /* Getting  total customers.....*/

        suspend fun getCustomers() :List<Customers?>{
            var getCustomers=DatabaseFactory.dbQuery {
                Customer.selectAll().map { convertToCustomers(it) }
            }
            return getCustomers
        }

        /*Getting customrs by their ID...*/


        suspend fun getCustomerById(cust_id:Int):List<Customers?>{
            var getCustomerById=DatabaseFactory.dbQuery {
                Customer.select { Customer.cust_id eq cust_id }.
                map { convertToCustomers(it) }.singleOrNull()
            }
            return getCustomerById(cust_id)
        }
    }


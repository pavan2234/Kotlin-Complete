package com.example.services

import com.example.EntityBindings.Nominee
import com.example.EntityBindings.Nominees
import com.example.dbconfig.DatabaseConnection
import com.example.entitybinding.Order
import com.example.entitybinding.Orders
import org.ktorm.dsl.from
import org.ktorm.dsl.joinReferencesAndSelect
import org.ktorm.dsl.map
import org.ktorm.dsl.select

interface OrderService {
    fun Order():List<Order>
    fun OrderWithQuoteandCustomer():List<Order>
}
class subOrderService :OrderService{

    val db= DatabaseConnection.database

    override fun Order(): List<Order> {
        val totalOrders=db.from(Orders).select()
            .map { row -> Orders.createEntity(row) }
        return totalOrders
    }

    override fun OrderWithQuoteandCustomer(): List<Order> {
        val totalOrdersWithCustomerandQuote=db.from(Orders).joinReferencesAndSelect()
            .map { row -> Orders.createEntity(row) }
        return totalOrdersWithCustomerandQuote

    }

}
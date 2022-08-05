package com.example.services

import com.example.dbconfig.DatabaseConnection
import com.example.entitybinding.Prev_policies
import com.example.entitybinding.Prev_policy
import com.example.entitybinding.Quote
import com.example.entitybinding.Quotes
import org.ktorm.dsl.from
import org.ktorm.dsl.joinReferencesAndSelect
import org.ktorm.dsl.map
import org.ktorm.dsl.select


interface QuoteService {
    fun TotalQuotes():List<Quote>
    fun QuotesWithVehicleCustomerPre_Policy():List<Quote>
}
class subQuoteService :QuoteService{

    val db= DatabaseConnection.database

    override fun TotalQuotes(): List<Quote> {
        val totalQuotes=db.from(Quotes).select()
            .map { row -> Quotes.createEntity(row) }
        return totalQuotes
    }

    override fun QuotesWithVehicleCustomerPre_Policy(): List<Quote> {
        val totalQuotesWithVehicleCustomerPrev_Policy=db.from(Quotes).joinReferencesAndSelect()
            .map { row -> Quotes.createEntity(row) }
        return totalQuotesWithVehicleCustomerPrev_Policy

    }

}
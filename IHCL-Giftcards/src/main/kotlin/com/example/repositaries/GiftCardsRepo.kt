package com.example.repositaries

import com.example.DataBaseConfiguration.DataBaseConnection
import com.example.Entities.GiftCardds
import com.example.Entities.GiftCards
import com.example.Models.GiftCard
import com.example.Models.GiftCardd
import org.ktorm.dsl.*
import org.ktorm.schema.Column


interface GiftCardsRepo {
    fun gettingGifiCards():List<GiftCardd>
    fun getGiftCardsById(TransactionId: Column<Int>):List<GiftCardd>
   // fun NewGiftCardInput():List<GiftCardd>
}
class SubGiftcardsRepo:GiftCardsRepo{
        val db = DataBaseConnection.database
        override fun gettingGifiCards(): List<GiftCardd> {
            val TotalGiftCards=db.from(GiftCardds).select().
                    map { row -> GiftCardds.createEntity(row) }
            return TotalGiftCards
        }
        override fun getGiftCardsById(TransactionId: Column<Int>): List<GiftCardd> {
            val getGiftCard=db.from(GiftCardds).select().
                    where { GiftCardds.TransactionId eq TransactionId }.
                    map { row -> GiftCardds.createEntity(row) }
            return getGiftCard
    }

   /* override fun NewGiftCardInput(): List<GiftCardd> {
        val newGiftCard=db.insert(GiftCardds){
            set(it.TransactionId,TransactionId)
        }
    }*/
}
package com.example.com.eample.repositary

import com.example.com.eample.DataBase.DataBaseConnection
import com.example.com.eample.models.GiftCardd
import com.example.com.eample.models.GiftCardds
import com.example.com.eample.models.h
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.channels.broadcast
import org.ktorm.dsl.*

interface GiftcardConfigure {
    fun gettingGifiCards():List<GiftCardd>
    fun getGiftCardsById(TransactionId: Int):List<GiftCardd>
    fun getGiftCardByMerchantName(MerchantName :String):List<GiftCardd>
    fun getGiftCardBtYCardType(CardType:String):List<GiftCardd>
    suspend fun gift()
}
class SubGiftRepo : GiftcardConfigure{
    val db = DataBaseConnection.database
    val obj= h()
    override fun gettingGifiCards(): List<GiftCardd> {
        val TotalGiftCards=db.from(GiftCardds).select().
        map { row -> GiftCardds.createEntity(row) }
        return TotalGiftCards
    }
    override fun getGiftCardsById(TransactionId: Int): List<GiftCardd> {
        val getGiftCard=db.from(GiftCardds).select().
        where { GiftCardds.TransactionId eq(TransactionId)}.
        map { row -> GiftCardds.createEntity(row) }
        return getGiftCard
    }
    override fun getGiftCardByMerchantName(MerchantName: String): List<GiftCardd> {
        val getGiftMerchantName=db.from(GiftCardds).select().
        where { GiftCardds.MerchantName eq(MerchantName)}.
        map { row -> GiftCardds.createEntity(row) }
        return getGiftMerchantName
    }

    override fun getGiftCardBtYCardType(CardType: String): List<GiftCardd> {
        val getGiftCardType=db.from(GiftCardds).select().
        where { GiftCardds.CardType eq(CardType)}.
        map { row -> GiftCardds.createEntity(row) }
        return getGiftCardType
    }

    override suspend fun gift(){
       val responce=obj.myMethod()
    }
}
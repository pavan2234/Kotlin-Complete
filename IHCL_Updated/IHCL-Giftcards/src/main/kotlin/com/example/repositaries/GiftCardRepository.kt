package com.example.repositaries

import com.example.DataBaseConfiguration.DataBaseConnection
import com.example.Entities.GiftCard
import com.example.Entities.GiftCards
import com.example.Models.GiftCardDTO
import org.ktorm.database.TransactionIsolation
import org.ktorm.dsl.from
import org.ktorm.dsl.insert
import org.ktorm.dsl.map
import org.ktorm.dsl.select

class GiftCardRepository {

    fun SaveGiftCard(params:GiftCardDTO):Int {
        val db = DataBaseConnection.getConnection()
        val transaction = db.transactionManager.newTransaction(isolation = TransactionIsolation.READ_COMMITTED)
        var noOfOperation:Int
        try{
            noOfOperation=db.insert(GiftCards) {
            set(it.TransactionId, params.TransactionId)
            set(it.CardNumber, params.CardNumber)
            set(it.CardPIN, params.CardPIN)
            set(it.Amount, params.Amount)
            set(it.ApprovalCode, params.ApprovalCode)
            set(it.AddonCardNumber, params.AddonCardNumber)
            set(it.MerchantName, params.MerchantName)
            set(it.DiscountAmount, params.DiscountAmount)
            set(it.PaymentType, params.PaymentType)
            set(it.ResponseMessage, params.ResponseMessage)
            set(it.MerchantOutletAddress1, params.MerchantOutletAddress1)
            set(it.MerchantOutletAddress2, params.MerchantOutletAddress2)
            set(it.MerchantOutletCity, params.MerchantOutletCity)
            set(it.MerchantOutletState, params.MerchantOutletState)
            set(it.MerchantOutletCountry, params.MerchantOutletCountry)
            set(it.MerchantOutletPinCode, params.MerchantOutletPinCode)
            set(it.ReceiptFooterLine1, params.ReceiptFooterLine1)
            set(it.ReceiptFooterLine2, params.ReceiptFooterLine2)
            set(it.ReceiptFooterLine3, params.ReceiptFooterLine3)
            set(it.ReceiptFooterLine4, params.ReceiptFooterLine4)
            set(it.CardType, params.CardType)
            set(it.TransactionResult, params.TransactionResult)
        }
            transaction.commit()
        }catch (e:Exception){
            e.printStackTrace()
            noOfOperation=0
        }finally {
            transaction.close()
        }
        return noOfOperation
    }
    suspend fun getGiftcard():List<GiftCard> {
        return DataBaseConnection.dbQuery {
            DataBaseConnection.getConnection().from(GiftCards).select()
                .map { row -> GiftCards.createEntity(row) }
        }
    }

}

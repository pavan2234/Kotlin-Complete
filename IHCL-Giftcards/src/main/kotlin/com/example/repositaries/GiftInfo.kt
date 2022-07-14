package com.example.repositaries

import com.example.DataBaseConfiguration.DataBaseConnection
import com.example.Entities.GiftCards
import com.example.Models.GiftCard
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.insert

fun Application.GiftInfo(){
    val db=DataBaseConnection.database
    routing {
        post("/GiftCardInserting"){
            val giftcarddetails=call.receive<GiftCard>()
            val TransactionId=giftcarddetails.TransactionId
            val CardNumber=giftcarddetails.CardNumber
            val CardPIN =giftcarddetails.CardPIN
            val Amount =giftcarddetails.Amount
            val ApprovalCode=giftcarddetails.ApprovalCode
            val AddonCardNumber=giftcarddetails.AddonCardNumber
            val MerchantName =giftcarddetails.MerchantName
            val DiscountAmount =giftcarddetails.DiscountAmount
            val PaymentType=giftcarddetails.PaymentType
            val ResponseMessage=giftcarddetails.ResponseMessage
            val MerchantOutletAddress1 =giftcarddetails.MerchantOutletAddress1
            val MerchantOutletAddress2=giftcarddetails.MerchantOutletAddress2
            val MerchantOutletCity=giftcarddetails.MerchantOutletCity
            val MerchantOutletState=giftcarddetails.MerchantOutletState
            val MerchantOutletCountry=giftcarddetails.MerchantOutletCountry
            val MerchantOutletPinCode =giftcarddetails.MerchantOutletPinCode
            val ReceiptFooterLine1 =giftcarddetails.ReceiptFooterLine1
            val ReceiptFooterLine2 =giftcarddetails.ReceiptFooterLine2
            val ReceiptFooterLine3 =giftcarddetails.ReceiptFooterLine3
            val ReceiptFooterLine4 =giftcarddetails.ReceiptFooterLine4
            val CardType =giftcarddetails.CardType
            val TransactionResult=giftcarddetails.TransactionResult

            db.insert(GiftCards){
                set(it.TransactionId,TransactionId)
                set(it.CardNumber,CardNumber)
                set(it.CardPIN,CardPIN)
                set(it.Amount,Amount)
                set(it.ApprovalCode,ApprovalCode)
                set(it.AddonCardNumber,AddonCardNumber)
                set(it.MerchantName,MerchantName)
                set(it.DiscountAmount,DiscountAmount)
                set(it.PaymentType,PaymentType)
                set(it.ResponseMessage,ResponseMessage)
                set(it.MerchantOutletAddress1,MerchantOutletAddress1)
                set(it.MerchantOutletAddress2,MerchantOutletAddress2)
                set(it.MerchantOutletCity,MerchantOutletCity)
                set(it.MerchantOutletState,MerchantOutletState)
                set(it.MerchantOutletCountry,MerchantOutletCountry)
                set(it.MerchantOutletPinCode,MerchantOutletPinCode)
                set(it.ReceiptFooterLine1,ReceiptFooterLine1)
                set(it.ReceiptFooterLine2,ReceiptFooterLine2)
                set(it.ReceiptFooterLine3,ReceiptFooterLine3)
                set(it.ReceiptFooterLine4,ReceiptFooterLine4)
                set(it.CardType,CardType)
                set(it.TransactionResult,TransactionResult)
            }

            call.respondText("Succesfully inserted..")
        }
    }
}
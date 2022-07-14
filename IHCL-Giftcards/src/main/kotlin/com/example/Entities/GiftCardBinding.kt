package com.example.Entities

import com.example.Entities.GiftCards.primaryKey
import com.example.Models.GiftCardd
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object GiftCardds : Table<GiftCardd>("giftcards"){
    val TransactionId=int("TransactionId").primaryKey().bindTo { it.TransactionId }
    val CardNumber=varchar("CardNumber").bindTo { it.CardNumber }
    val CardPIN =varchar("CardPIN").bindTo { it.CardPIN }
    val Amount =int("Amount").bindTo { it.Amount }
    val ApprovalCode=varchar("ApprovalCode").bindTo { it.ApprovalCode }
    val AddonCardNumber=varchar("AddonCardNumber").bindTo { it.AddonCardNumber }
    val MerchantName =varchar("MerchantName").bindTo { it.MerchantName }
    val DiscountAmount =int("DiscountAmount").bindTo { it.DiscountAmount }
    val PaymentType=varchar("PaymentType").bindTo { it.PaymentType }
    val ResponseMessage=varchar("ResponseMessage").bindTo { it.ResponseMessage }
    val MerchantOutletAddress1 =varchar("MerchantOutletAddress1").bindTo { it.MerchantOutletAddress1 }
    val MerchantOutletAddress2=varchar("MerchantOutletAddress2").bindTo { it.MerchantOutletAddress2 }
    val MerchantOutletCity=varchar("MerchantOutletCity").bindTo { it.MerchantOutletCity }
    val MerchantOutletState=varchar("MerchantOutletState").bindTo { it.MerchantOutletState }
    val MerchantOutletCountry=varchar("MerchantOutletCountry").bindTo { it.MerchantOutletCountry }
    val MerchantOutletPinCode =varchar("MerchantOutletPinCode").bindTo { it.MerchantOutletPinCode }
    val ReceiptFooterLine1 =varchar("ReceiptFooterLine1").bindTo { it.ReceiptFooterLine1 }
    val ReceiptFooterLine2 =varchar("ReceiptFooterLine2").bindTo { it.ReceiptFooterLine2 }
    val ReceiptFooterLine3=varchar("ReceiptFooterLine3").bindTo { it.ReceiptFooterLine3 }
    val ReceiptFooterLine4 =varchar("ReceiptFooterLine4").bindTo { it.ReceiptFooterLine4 }
    val CardType =varchar("CardType").bindTo { it.CardType }
    val TransactionResult=varchar("TransactionResult").bindTo { it.TransactionResult }
}
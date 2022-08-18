package com.example.Entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface GiftCard  : Entity<GiftCard> {
    val TransactionId:Int
    val CardNumber:String
    val CardPIN :String
    val Amount :Int
    val ApprovalCode:String
    val AddonCardNumber:String
    val MerchantName :String
    val DiscountAmount : Int
    val PaymentType: String
    val ResponseMessage:String
    val MerchantOutletAddress1 :String
    val MerchantOutletAddress2:String
    val MerchantOutletCity:String
    val MerchantOutletState: String
    val MerchantOutletCountry:String
    val MerchantOutletPinCode :String
    val ReceiptFooterLine1 :String
    val ReceiptFooterLine2 :String
    val ReceiptFooterLine3 :String
    val ReceiptFooterLine4 :String
    val CardType :String
    val TransactionResult:String
}

object GiftCards : Table<GiftCard>("giftcards"){
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
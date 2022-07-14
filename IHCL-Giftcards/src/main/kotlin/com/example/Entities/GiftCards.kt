package com.example.Entities

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object GiftCards  : Table<Nothing>("giftcards"){
    val TransactionId=int("TransactionId").primaryKey()
    val CardNumber=varchar("CardNumber")
    val CardPIN =varchar("CardPIN")
    val Amount =int("Amount")
    val ApprovalCode=varchar("ApprovalCode")
    val AddonCardNumber=varchar("AddonCardNumber")
    val MerchantName =varchar("MerchantName")
    val DiscountAmount =int("DiscountAmount")
    val PaymentType=varchar("PaymentType")
    val ResponseMessage=varchar("ResponseMessage")
    val MerchantOutletAddress1 =varchar("MerchantOutletAddress1")
    val MerchantOutletAddress2=varchar("MerchantOutletAddress2")
    val MerchantOutletCity=varchar("MerchantOutletCity")
    val MerchantOutletState=varchar("MerchantOutletState")
    val MerchantOutletCountry=varchar("MerchantOutletCountry")
    val MerchantOutletPinCode =varchar("MerchantOutletPinCode")
    val ReceiptFooterLine1 =varchar("ReceiptFooterLine1")
    val ReceiptFooterLine2 =varchar("ReceiptFooterLine2")
    val ReceiptFooterLine3=varchar("ReceiptFooterLine3")
    val ReceiptFooterLine4 =varchar("ReceiptFooterLine4")
    val CardType =varchar("CardType")
    val TransactionResult=varchar("TransactionResult")
}
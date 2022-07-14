package com.example.com.eample.models

import org.ktorm.dsl.QueryRowSet
import org.ktorm.schema.BaseTable
import org.ktorm.schema.int
import org.ktorm.schema.varchar

//GiftCard Entities..

object GiftCardds : BaseTable<GiftCardd>("giftcards"){
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
    override fun doCreateEntity(row: QueryRowSet, withReferences: Boolean)= GiftCardd (
        TransactionId=row[TransactionId] ?:0,
        CardNumber=row[CardNumber].toString(),
        CardPIN = row[CardPIN].toString(),
        Amount = row[Amount]?:0,
        ApprovalCode = row[ApprovalCode].toString(),
        AddonCardNumber = row[AddonCardNumber].toString(),
        MerchantName = row[MerchantName].toString(),
        DiscountAmount = row[DiscountAmount]?:0,
        PaymentType = row[PaymentType].toString(),
        ResponseMessage = row[ResponseMessage].toString(),
        MerchantOutletAddress1 = row[MerchantOutletAddress1].toString(),
        MerchantOutletAddress2 = row[MerchantOutletAddress2].toString(),
        MerchantOutletCity = row[MerchantOutletCity].toString(),
        MerchantOutletState = row[MerchantOutletState].toString(),
        MerchantOutletCountry = row[MerchantOutletCountry].toString(),
        MerchantOutletPinCode = row[MerchantOutletPinCode].toString(),
        ReceiptFooterLine1 = row[ReceiptFooterLine1].toString(),
        ReceiptFooterLine2 = row[ReceiptFooterLine2].toString(),
        ReceiptFooterLine3 = row[ReceiptFooterLine3].toString(),
        ReceiptFooterLine4 = row[ReceiptFooterLine4].toString(),
        CardType = row[CardType].toString(),
        TransactionResult = row[TransactionResult].toString(),
    )
}
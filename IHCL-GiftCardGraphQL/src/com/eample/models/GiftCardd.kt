package com.example.com.eample.models

//Pojo class Giftcard

data class GiftCardd(
    val TransactionId:Int,
    val CardNumber:String,
    val CardPIN:String,
    val Amount:Int,
    val ApprovalCode:String,
    val AddonCardNumber:String,
    val MerchantName:String,
    val DiscountAmount: Int,
    val PaymentType: String,
    val ResponseMessage:String,
    val MerchantOutletAddress1:String,
    val MerchantOutletAddress2:String,
    val MerchantOutletCity:String,
    val MerchantOutletState: String,
    val MerchantOutletCountry:String,
    val MerchantOutletPinCode:String,
    val ReceiptFooterLine1:String,
    val ReceiptFooterLine2:String,
    val ReceiptFooterLine3:String,
    val ReceiptFooterLine4:String,
    val CardType:String,
    val TransactionResult:String
)
//}
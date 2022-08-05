package com.example.com.eample.graphQL

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.example.com.eample.models.h
import com.example.com.eample.repositary.GiftcardConfigure
import com.example.com.eample.repositary.SubGiftRepo
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

fun SchemaBuilder.schemas() {
    val giftCardObj: GiftcardConfigure = SubGiftRepo()
    // val classobj= h()
    query("GettingGiftCards") {
        description = "All Gift card Details.."
        resolver {
            ->
            giftCardObj.gettingGifiCards()
        }
    }
    query("GettingGiftCardById") {
        description = "GiftCard by id.."
        resolver { TransactionId: Int ->
            giftCardObj.getGiftCardsById(TransactionId)
        }

    }
    query("GiftCardByMerchantName") {
        description = "GiftCard By MerchantName.."
        resolver { MerchantName: String ->
            giftCardObj.getGiftCardByMerchantName(MerchantName)
        }
    }
    query("GiftCardByCardType") {
        description = "GiftCards By Card Type.."
        resolver { CardType: String ->
            giftCardObj.getGiftCardBtYCardType(CardType)
        }
    }
    query("Get") {
        resolver { ->
            getData()
        }
    }
//    mutation("InsertData"){
//        resolver {
//            ->
//        }
//    }
}

suspend fun getData(): String {
    val client = HttpClient(CIO)
    val response: HttpResponse = client.get("http://0.0.0.0:8080/Giftcards")
    println(response.readText())
    return response.readText()
}
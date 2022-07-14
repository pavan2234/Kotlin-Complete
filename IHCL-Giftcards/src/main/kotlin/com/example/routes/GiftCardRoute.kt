package com.example.routes

import com.example.Entities.GiftCards.TransactionId
import com.example.repositaries.SubGiftcardsRepo
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.schema.Column

fun Application.GiftCardConfigureRoute(){
    routing {
        val subcardGiftRepo=SubGiftcardsRepo()
        get ("/GiftCards"){
            call.respondText(subcardGiftRepo.gettingGifiCards().toString())
        }
        get ("/GiftCardsById"){
            call.respondText(subcardGiftRepo.getGiftCardsById(TransactionId = TransactionId).toString())
        }
    }
}
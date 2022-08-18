package com.example.routes

import com.example.Models.GiftCardDTO
import com.example.repositaries.GiftCardsService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.GiftCardConfigureRoute(){
    val Giftcardser = GiftCardsService()
    routing {
        route("giftcard/table"){
            post ("/SaveGiftcards"){
                val params = call.receive<GiftCardDTO>()
                val count = Giftcardser.SaveGiftCards(params)
                if (count ==0)
                    call.respond("No rows affected")
                else
                call.respond(params)
            }
            get("GetGiftCard"){
                call.respond(Giftcardser.getGiftcard())
            }

        }
    }
}
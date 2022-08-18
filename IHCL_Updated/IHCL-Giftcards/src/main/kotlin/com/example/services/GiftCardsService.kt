package com.example.repositaries

import com.example.Entities.GiftCard
import com.example.Models.GiftCardDTO

class GiftCardsService {
        private val GiftCardRepo = GiftCardRepository()

       suspend fun SaveGiftCards(params:GiftCardDTO):Int {
           return GiftCardRepo.SaveGiftCard(params)
       }
       suspend fun getGiftcard(): List<GiftCard> {
           return GiftCardRepo.getGiftcard()
       }
}
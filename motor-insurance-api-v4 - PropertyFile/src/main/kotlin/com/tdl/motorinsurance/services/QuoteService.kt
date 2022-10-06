package com.tdl.motorinsurance.services

import com.tdl.motorinsurance.entities.Nominee
import com.tdl.motorinsurance.entities.Quote
import com.tdl.motorinsurance.model.NomineeDTO
import com.tdl.motorinsurance.model.QuoteDTO
import com.tdl.motorinsurance.repositaries.NomineeRepository
import com.tdl.motorinsurance.repositaries.QuoteRepositary

class QuoteService {
    private val quoteRepository = QuoteRepositary()


    suspend fun saveQuote(params: QuoteDTO): Int {
        return quoteRepository.saveQuote(params)
    }

    suspend fun getQuotes(): List<Quote> {
        return quoteRepository.getQuotes()
    }

    suspend fun getQuotess(): List<QuoteDTO> {
        return quoteRepository.getNomineesWithCustomers()
    }
}
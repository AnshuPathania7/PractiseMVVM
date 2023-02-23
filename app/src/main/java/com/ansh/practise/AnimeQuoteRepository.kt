package com.ansh.practise

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse

class AnimeQuoteRepository {
    suspend  fun getAnimeQuote() :  AnimeQuoteModel? {
        val apiInterface = ApiInterface.create()
        val animeQuoteResponse = apiInterface.getAnimeQuotes()
        val animeQuoteData = animeQuoteResponse.body()

        return animeQuoteData
    }
}
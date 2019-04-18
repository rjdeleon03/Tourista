package com.pabsdl.tourista.network

import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface CurrencyRetrofitService {

    @Headers(
        "X-RapidAPI-Host: currency-exchange.p.rapidapi.com",
        "X-RapidAPI-Key: f9201c7440mshd36779863b8e0cfp1ef779jsn6f0177e8571b"
    )
    @GET("exchange?q=1.0&from=USD&to=PHP")
    fun getConversionRate() : Deferred<Response<JsonPrimitive>>
}
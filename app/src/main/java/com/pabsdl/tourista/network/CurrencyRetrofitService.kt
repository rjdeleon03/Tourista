package com.pabsdl.tourista.network

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface CurrencyRetrofitService {

    @GET("/api/live?pairs=USDPHP")
    fun getConversionRate() : Deferred<Response<JsonObject>>
}
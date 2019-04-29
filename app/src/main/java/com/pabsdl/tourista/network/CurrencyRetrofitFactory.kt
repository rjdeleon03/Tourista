package com.pabsdl.tourista.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CurrencyRetrofitFactory {

    const val BASE_URL = "https://currency-exchange.p.rapidapi.com/"
    private var INSTANCE: CurrencyRetrofitService? = null

    @JvmStatic
    @Synchronized
    fun getService(): CurrencyRetrofitService {
        if (INSTANCE == null) {
            INSTANCE = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(CurrencyRetrofitService::class.java)
        }
        return INSTANCE!!
    }

}
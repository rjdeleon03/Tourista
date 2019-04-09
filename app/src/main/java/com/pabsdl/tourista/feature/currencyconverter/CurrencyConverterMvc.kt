package com.pabsdl.tourista.feature.currencyconverter

import android.view.View

interface CurrencyConverterMvc {
    val rootView: View

    interface Listener {
        fun onConvertClicked()
        fun onSwapCurrencyClicked()
    }

    fun <T : View?> findViewById(id: Int): T
    fun registerListener(listener: Listener)
    fun unregisterListener(listener: Listener)
}
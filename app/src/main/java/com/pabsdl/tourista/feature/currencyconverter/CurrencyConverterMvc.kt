package com.pabsdl.tourista.feature.currencyconverter

import com.pabsdl.tourista.common.base.BaseListener

interface CurrencyConverterMvc {

    interface Listener: BaseListener {
        fun onConvertClicked()
        fun onSwapCurrencyClicked()
    }
}
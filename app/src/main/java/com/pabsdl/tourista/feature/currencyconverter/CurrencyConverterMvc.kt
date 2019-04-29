package com.pabsdl.tourista.feature.currencyconverter

import com.pabsdl.tourista.common.base.BaseListener
import com.pabsdl.tourista.common.base.ObservableViewMvc

interface CurrencyConverterMvc : ObservableViewMvc<CurrencyConverterMvc.Listener> {

    interface Listener: BaseListener {
        fun onConvertClicked()
        fun onSwapCurrencyClicked()
    }
}
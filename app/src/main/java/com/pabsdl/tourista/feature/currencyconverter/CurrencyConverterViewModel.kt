package com.pabsdl.tourista.feature.currencyconverter

import androidx.lifecycle.MutableLiveData
import com.pabsdl.tourista.model.CurrencyConversionData

interface CurrencyConverterViewModel {
    fun getConversionData(): MutableLiveData<CurrencyConversionData>

    fun getConversionRate()
}
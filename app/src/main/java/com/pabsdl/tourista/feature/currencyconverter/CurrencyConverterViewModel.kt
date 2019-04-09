package com.pabsdl.tourista.feature.currencyconverter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface CurrencyConverterViewModel {
    fun getBaseAmount(): MutableLiveData<Float>
}
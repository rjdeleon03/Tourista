package com.pabsdl.tourista.feature.currencyconverter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CurrencyConverterViewModelImpl(application: Application):
    AndroidViewModel(application), CurrencyConverterViewModel {

    private val mBaseAmount: MutableLiveData<Float> = MutableLiveData()

    override fun getBaseAmount() : MutableLiveData<Float> = mBaseAmount
}
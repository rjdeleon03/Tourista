package com.pabsdl.tourista.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.pabsdl.tourista.BR

class CurrencyConversionData: BaseObservable() {

    private var _baseCurrency: String = ""
    private var _baseAmount: Float = 0f
    private var _targetCurrency: String = ""
    private var _targetAmount: Float = 0f
    private var _rate: Float = 0f

    var baseCurrency: String
        @Bindable get() = _baseCurrency
        set(value) {
            notifyPropertyChanged(BR.baseCurrency)
            _baseCurrency = value
        }

    var baseAmount: Float
        @Bindable get() = _baseAmount
        set(value) {
            if (_baseAmount != value) {
                notifyPropertyChanged(BR.baseAmount)
                _baseAmount = value
            }
        }

    var targetCurrency: String
        @Bindable get() = _targetCurrency
        set(value) {
            notifyPropertyChanged(BR.targetCurrency)
            _targetCurrency = value
        }

    var targetAmount: Float
        @Bindable get() = _targetAmount
        set(value) {
            notifyPropertyChanged(BR.targetAmount)
            _targetAmount = value
        }

    var rate: Float
        @Bindable get() = _rate
        set(value) {
            notifyPropertyChanged(BR.rate)
            _rate = value
        }

    fun setRateAndUpdateTargetAmount(convRate: Float) {
        rate = convRate
        targetAmount = baseAmount * convRate
    }
}
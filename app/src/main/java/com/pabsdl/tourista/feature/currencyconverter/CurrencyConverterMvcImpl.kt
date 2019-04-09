package com.pabsdl.tourista.feature.currencyconverter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.pabsdl.tourista.R
import com.pabsdl.tourista.common.base.BaseObservableViewMvc

class CurrencyConverterMvcImpl(inflater: LayoutInflater, parent: ViewGroup?) :
    BaseObservableViewMvc<CurrencyConverterMvc.Listener>(), CurrencyConverterMvc {

    override val mRootView: View = inflater.inflate(R.layout.fragment_currency_converter, parent, false)

    init {
        val convertButton = findViewById<Button>(R.id.currencyConvertButton)
        convertButton.setOnClickListener {
            for(listener in mListeners) {
                listener.onConvertClicked()
            }
        }

        val swapButton = findViewById<ImageButton>(R.id.currencySwapButton)
        swapButton.setOnClickListener {
            for(listener in mListeners) {
                listener.onSwapCurrencyClicked()
            }
        }
    }

    override val rootView: View
        get() { return mRootView }

}
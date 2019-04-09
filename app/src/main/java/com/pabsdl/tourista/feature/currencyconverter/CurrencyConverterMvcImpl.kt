package com.pabsdl.tourista.feature.currencyconverter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.pabsdl.tourista.R

class CurrencyConverterMvcImpl(inflater: LayoutInflater,
                               parent: ViewGroup?) : CurrencyConverterMvc {

    private val mListeners = ArrayList<CurrencyConverterMvc.Listener>()

    private val mRootView: View = inflater.inflate(R.layout.fragment_currency_converter, parent, false)

    override fun <T : View?> findViewById(id: Int) = rootView.findViewById<T>(id)

    init {
        val convertButton = findViewById<Button>(R.id.currencyConvertButton)
        convertButton?.setOnClickListener {
            for(listener in mListeners) {
                listener.onConvertClicked()
            }
        }

        val swapButton = findViewById<ImageButton>(R.id.currencySwapButton)
        swapButton?.setOnClickListener {
            for(listener in mListeners) {
                listener.onSwapCurrencyClicked()
            }
        }
    }

    override val rootView: View
        get() { return mRootView }

    override fun registerListener(listener: CurrencyConverterMvc.Listener) {
        mListeners.add(listener)
    }

    override fun unregisterListener(listener: CurrencyConverterMvc.Listener) {
        mListeners.remove(listener)
    }

}
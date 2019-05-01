package com.pabsdl.tourista.feature.currencyconverter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import com.pabsdl.tourista.common.base.BaseListener
import com.pabsdl.tourista.common.base.BaseObservableViewMvc
import com.pabsdl.tourista.common.base.ObservableDataBindingViewMvc
import com.pabsdl.tourista.databinding.FragmentCurrencyConverterBinding

interface CurrencyConverterMvc :
    ObservableDataBindingViewMvc<CurrencyConverterMvc.Listener, CurrencyConverterViewModel> {

    interface Listener: BaseListener {
        fun onConvertClicked()
        fun onSwapCurrencyClicked()
    }
}

class CurrencyConverterMvcImpl(inflater: LayoutInflater, parent: ViewGroup?) :
    BaseObservableViewMvc<CurrencyConverterMvc.Listener>(), CurrencyConverterMvc {

    private val mDataBinding = FragmentCurrencyConverterBinding.inflate(inflater, parent, false)
    override val mRootView = mDataBinding.root

    override val rootView: View
        get() { return mRootView }

    init {
        mDataBinding.currencyConvertButton.setOnClickListener {
            for(listener in mListeners) {
                listener.onConvertClicked()
            }
        }
        mDataBinding.currencySwapButton.setOnClickListener {
            for(listener in mListeners) {
                listener.onSwapCurrencyClicked()
            }
        }
    }

    override fun setupViewModel(viewModel: CurrencyConverterViewModel, lifecycleOwner: LifecycleOwner) {
        mDataBinding.viewModel = viewModel
        mDataBinding.lifecycleOwner = lifecycleOwner
    }
}
package com.pabsdl.tourista.feature.currencyconverter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import com.pabsdl.tourista.common.base.BaseListener
import com.pabsdl.tourista.common.base.BaseObservableViewMvc
import com.pabsdl.tourista.common.base.ObservableViewMvc
import com.pabsdl.tourista.databinding.FragmentCurrencyConverterBinding
import java.lang.ref.WeakReference

interface CurrencyConverterMvc : ObservableViewMvc<CurrencyConverterMvc.Listener> {

    interface Listener: BaseListener {
        fun onConvertClicked()
        fun onSwapCurrencyClicked()
    }
}

class CurrencyConverterMvcImpl(inflater: LayoutInflater, parent: ViewGroup?,
                               viewModel: CurrencyConverterViewModel, lifecycleOwner: LifecycleOwner) :
    BaseObservableViewMvc<CurrencyConverterMvc.Listener>(), CurrencyConverterMvc {

    private val mLifecycleOwner = WeakReference<LifecycleOwner>(lifecycleOwner)
    private val mViewModel = viewModel
    private val mDataBinding = FragmentCurrencyConverterBinding.inflate(inflater, parent, false)
    override val mRootView = mDataBinding.root

    override val rootView: View
        get() { return mRootView }

    init {
        mDataBinding.viewModel = mViewModel
        mDataBinding.lifecycleOwner = mLifecycleOwner.get()
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
}
package com.pabsdl.tourista.feature.currencyconverter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import com.pabsdl.tourista.common.base.BaseObservableViewMvc
import com.pabsdl.tourista.databinding.FragmentCurrencyConverterBinding
import java.lang.ref.WeakReference

class CurrencyConverterMvcImpl(inflater: LayoutInflater, parent: ViewGroup?,
                               viewModel: CurrencyConverterViewModel, lifecycleOwner: LifecycleOwner) :
    BaseObservableViewMvc<CurrencyConverterMvc.Listener>(), CurrencyConverterMvc {

    private val mLifecycleOwner = WeakReference<LifecycleOwner>(lifecycleOwner)
    private val mViewModel = viewModel
    private val mDataBinding = FragmentCurrencyConverterBinding.inflate(inflater, parent, false)
    override val mRootView: View = mDataBinding.root

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

    override val rootView: View
        get() { return mRootView }

}
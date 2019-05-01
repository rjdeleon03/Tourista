package com.pabsdl.tourista.feature.tools

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pabsdl.tourista.R
import com.pabsdl.tourista.common.base.BaseListener
import com.pabsdl.tourista.common.base.BaseObservableViewMvc
import com.pabsdl.tourista.common.base.ObservableViewMvc
import kotlinx.android.synthetic.main.fragment_tools.view.*

interface ToolsMvc : ObservableViewMvc<ToolsMvc.Listener> {

    interface Listener : BaseListener {

        fun onCurrencyConversionButtonClicked()

        fun onVisaInformationButtonClicked()

    }
}

class ToolsMvcImpl(inflater: LayoutInflater, parent: ViewGroup?) :
    BaseObservableViewMvc<ToolsMvc.Listener>(), ToolsMvc {

    override val mRootView = inflater.inflate(R.layout.fragment_tools, parent, false)!!

    override val rootView: View
        get() = mRootView

    init {
        mRootView.toolsCurrencyConversionButton.setClickAction {
            for (listener in mListeners) {
                listener.onCurrencyConversionButtonClicked()
            }
        }
        mRootView.toolsVisaInformationButton.setClickAction {
            for (listener in mListeners) {
                listener.onVisaInformationButtonClicked()
            }
        }
    }
}
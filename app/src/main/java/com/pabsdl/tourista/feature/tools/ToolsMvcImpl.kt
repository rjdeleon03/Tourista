package com.pabsdl.tourista.feature.tools

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pabsdl.tourista.R
import com.pabsdl.tourista.common.base.BaseObservableViewMvc
import kotlinx.android.synthetic.main.fragment_tools.view.*

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
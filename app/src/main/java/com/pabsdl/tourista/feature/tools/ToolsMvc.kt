package com.pabsdl.tourista.feature.tools

import com.pabsdl.tourista.common.base.BaseListener
import com.pabsdl.tourista.common.base.ObservableViewMvc

interface ToolsMvc : ObservableViewMvc<ToolsMvc.Listener> {

    interface Listener : BaseListener {

        fun onCurrencyConversionButtonClicked()

        fun onVisaInformationButtonClicked()

    }
}
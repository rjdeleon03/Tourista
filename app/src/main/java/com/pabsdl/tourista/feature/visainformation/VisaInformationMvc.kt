package com.pabsdl.tourista.feature.visainformation

import com.pabsdl.tourista.common.base.BaseListener
import com.pabsdl.tourista.common.base.ObservableViewMvc

interface VisaInformationMvc : ObservableViewMvc<VisaInformationMvc.Listener>{

    interface Listener: BaseListener {

        fun onCountryFieldClicked(text: String, reqCode: Int)

        fun onSearchDetailsClicked()
    }
}
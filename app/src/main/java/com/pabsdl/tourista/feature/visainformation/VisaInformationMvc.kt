package com.pabsdl.tourista.feature.visainformation

import com.pabsdl.tourista.common.base.BaseListener

interface VisaInformationMvc {

    interface Listener: BaseListener {

        fun onCountryFieldClicked(text: String, reqCode: Int)

        fun onGetVisaInfoClicked()

        fun onSearchDetailsClicked()
    }
}
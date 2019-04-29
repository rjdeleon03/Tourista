package com.pabsdl.tourista.feature.visacountriesdialog

import com.pabsdl.tourista.common.base.BaseListener
import com.pabsdl.tourista.common.base.ObservableViewMvc

interface VisaCountriesMvc : ObservableViewMvc<VisaCountriesMvc.Listener> {

    interface Listener: BaseListener {

        fun onItemClicked(country: String)

        fun onSearchInputChanged(input: String)

    }

    fun setCountryInput(country: String?)

    fun setCountries(countries: List<String>)

}
package com.pabsdl.tourista.feature.visacountriesdialog

import com.pabsdl.tourista.common.base.BaseListener

interface VisaCountriesMvc {

    interface Listener: BaseListener {

        fun onItemClicked(country: String)

        fun onSearchInputChanged(input: String)

    }

    fun setCountries(countries: List<String>)

}
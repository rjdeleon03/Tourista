package com.pabsdl.tourista.feature.visacountriesdialog

import androidx.lifecycle.LiveData

interface VisaCountriesViewModel {

    fun getCountries(): LiveData<List<String>>

    fun searchCountries(country: String)

}
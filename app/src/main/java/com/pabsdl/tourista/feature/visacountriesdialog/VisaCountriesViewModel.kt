package com.pabsdl.tourista.feature.visacountriesdialog

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class VisaCountriesViewModel(application: Application) :
    AndroidViewModel(application) {

    private val mRepository = VisaCountriesRepository(application)

    fun getCountries() = mRepository.getCountries()

    fun searchCountries(country: String) = mRepository.searchCountries(country)
}
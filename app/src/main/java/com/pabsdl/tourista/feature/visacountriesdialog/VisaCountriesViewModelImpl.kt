package com.pabsdl.tourista.feature.visacountriesdialog

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class VisaCountriesViewModelImpl(application: Application) :
    AndroidViewModel(application), VisaCountriesViewModel {

    private val mRepository = VisaCountriesRepository(application)

    override fun getCountries() = mRepository.getCountries()

    override fun searchCountries(country: String) = mRepository.searchCountries(country)
}
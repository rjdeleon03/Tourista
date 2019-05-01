package com.pabsdl.tourista.feature.dialogs.visacountries

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

interface VisaCountriesViewModel {

    fun getCountries(): LiveData<List<String>>

    fun searchCountries(country: String)

}

class VisaCountriesViewModelImpl(application: Application) :
    AndroidViewModel(application), VisaCountriesViewModel {

    private val mRepository = VisaCountriesRepository(application)

    override fun getCountries() = mRepository.getCountries()

    override fun searchCountries(country: String) = mRepository.searchCountries(country)
}
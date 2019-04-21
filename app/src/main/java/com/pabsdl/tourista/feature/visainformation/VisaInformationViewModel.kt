package com.pabsdl.tourista.feature.visainformation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class VisaInformationViewModel(application: Application) :
    AndroidViewModel(application) {

    private val mRepository = VisaInformationRepository(application)
    private val mPassportCountry: MutableLiveData<String> = MutableLiveData()
    private val mDestinationCountry: MutableLiveData<String> = MutableLiveData()

    // region Text live data

    fun getPassportCountry(): LiveData<String> = mPassportCountry

    fun getDestinationCountry(): LiveData<String> = mDestinationCountry

    fun setPassportCountry(country: String) {
        mPassportCountry.value = country
    }

    fun setDestinationCountry(country: String) {
        mDestinationCountry.value = country
    }

    // endregion

    // region Repository methods

    fun getVisaInfo() = mRepository.getVisaInfo()

    fun searchVisaInfo() = mRepository.searchVisaInfo(
        mPassportCountry.value!!, mDestinationCountry.value!!)

    // endregion
}
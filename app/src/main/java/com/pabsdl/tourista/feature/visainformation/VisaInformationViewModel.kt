package com.pabsdl.tourista.feature.visainformation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class VisaInformationViewModel(application: Application) :
    AndroidViewModel(application) {

    private val mPassportCountry: MutableLiveData<String> = MutableLiveData()
    private val mDestinationCountry: MutableLiveData<String> = MutableLiveData()

    fun getPassportCountry(): LiveData<String> = mPassportCountry

    fun getDestinationCountry(): LiveData<String> = mDestinationCountry

    fun setPassportCountry(country: String) {
        mPassportCountry.value = country
    }

    fun setDestinationCountry(country: String) {
        mDestinationCountry.value = country
    }
}
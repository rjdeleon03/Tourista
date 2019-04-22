package com.pabsdl.tourista.feature.visainformation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pabsdl.tourista.model.VisaInfoData

class VisaInformationViewModelImpl(application: Application) :
    AndroidViewModel(application), VisaInformationViewModel {

    private val mRepository = VisaInformationRepository(application)
    private val mPassportCountry: MutableLiveData<String> = MutableLiveData()
    private val mDestinationCountry: MutableLiveData<String> = MutableLiveData()

    // region Text live data

    override fun getPassportCountry(): LiveData<String> = mPassportCountry

    override fun getDestinationCountry(): LiveData<String> = mDestinationCountry

    override fun setPassportCountry(country: String) {
        mPassportCountry.value = country
    }

    override fun setDestinationCountry(country: String) {
        mDestinationCountry.value = country
    }

    // endregion

    // region Repository methods

    override fun getVisaInfo() = mRepository.getVisaInfo()

    override fun getBookmarks() = mRepository.getBookmarks()

    override fun searchVisaInfo() {
        val passportCountry = mPassportCountry.value
        val destinationCountry = mDestinationCountry.value
        if (!passportCountry.isNullOrEmpty() && !destinationCountry.isNullOrEmpty())
            mRepository.searchVisaInfo(passportCountry, destinationCountry)
    }

    // endregion
}
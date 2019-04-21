package com.pabsdl.tourista.feature.visainformation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.pabsdl.tourista.data.AppDatabase

class VisaInformationRepository(application: Application) {

    private val mDatabase = AppDatabase.getDatabase(application.applicationContext)
    private val mCountries: MediatorLiveData<List<String>> = MediatorLiveData()

    fun getCountries(): LiveData<List<String>> = mCountries

    fun searchCountries(country: String) {
        mCountries.addSource(
            mDatabase.visaInformationDao().getCountries("%$country%")) {
            mCountries.value = it
        }
    }

}
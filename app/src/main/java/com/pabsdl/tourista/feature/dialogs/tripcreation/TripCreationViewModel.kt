package com.pabsdl.tourista.feature.dialogs.tripcreation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class TripCreationViewModel(application: Application) :
    AndroidViewModel(application) {

    private val mRepository = TripCreationRepository(application)

    fun getTrip() = mRepository.getTrip()

    fun saveTrip() = mRepository.saveTrip()

    fun setStartDate(year: Int, month: Int, day: Int) =
        mRepository.setStartDate(year, month, day)

    fun setEndDate(year: Int, month: Int, day: Int) =
        mRepository.setEndDate(year, month, day)
}

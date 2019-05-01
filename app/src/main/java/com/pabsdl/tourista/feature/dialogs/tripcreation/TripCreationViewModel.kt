package com.pabsdl.tourista.feature.dialogs.tripcreation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.pabsdl.tourista.common.CustomMutableLiveData
import com.pabsdl.tourista.data.entities.Trip

interface TripCreationViewModel {
    fun getTrip(): CustomMutableLiveData<Trip>
    fun saveTrip()
    fun setStartDate(year: Int, month: Int, day: Int)
    fun setEndDate(year: Int, month: Int, day: Int)
}

class TripCreationViewModelImpl(application: Application) :
    AndroidViewModel(application), TripCreationViewModel {

    private val mRepository = TripCreationRepository(application)

    override fun getTrip() = mRepository.getTrip()

    override fun saveTrip() = mRepository.saveTrip()

    override fun setStartDate(year: Int, month: Int, day: Int) =
        mRepository.setStartDate(year, month, day)

    override fun setEndDate(year: Int, month: Int, day: Int) =
        mRepository.setEndDate(year, month, day)
}

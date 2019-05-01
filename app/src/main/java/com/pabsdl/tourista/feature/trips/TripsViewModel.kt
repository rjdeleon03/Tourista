package com.pabsdl.tourista.feature.trips

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.pabsdl.tourista.data.entities.Trip

interface TripsViewModel {

    fun getTrips(): LiveData<List<Trip>>

    fun deleteTrip(trip: Trip)
}

class TripsViewModelImpl(application: Application) :
    AndroidViewModel(application), TripsViewModel {

    private val mRepository = TripsRepository(application)

    override fun getTrips() = mRepository.getTrips()

    override fun deleteTrip(trip: Trip) = mRepository.deleteTrip(trip)
}

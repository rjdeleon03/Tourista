package com.pabsdl.tourista.feature.dialogs.tripcreation

import android.app.Application
import com.pabsdl.tourista.common.CustomMutableLiveData
import com.pabsdl.tourista.data.AppDatabase
import com.pabsdl.tourista.data.entities.Trip
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.joda.time.LocalDate

class TripCreationRepository(application: Application) {

    private val mDatabase = AppDatabase.getDatabase(application)
    private val mTrip: CustomMutableLiveData<Trip> = CustomMutableLiveData()

    init {
        val currentDate = LocalDate()
        mTrip.setValue(Trip(name = "",
            startDate = currentDate.toDate().time,
            endDate = currentDate.plusDays(1).toDate().time))
    }

    fun getTrip() = mTrip

    fun saveTrip() {
        CoroutineScope(Job() + Dispatchers.Main).launch(Dispatchers.IO) {
            mDatabase.tripDao().insert(mTrip.value!!)
        }
    }

    fun setStartDate(year: Int, month: Int, day: Int) {
        val trip = mTrip.value!!
        trip.bindableStartDate = LocalDate(year, month, day).toDate().time
    }

    fun setEndDate(year: Int, month: Int, day: Int) {
        val trip = mTrip.value!!
        trip.bindableEndDate = LocalDate(year, month, day).toDate().time
    }
}
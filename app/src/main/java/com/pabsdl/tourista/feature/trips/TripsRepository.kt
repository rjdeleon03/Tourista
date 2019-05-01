package com.pabsdl.tourista.feature.trips

import android.app.Application
import com.pabsdl.tourista.data.AppDatabase
import com.pabsdl.tourista.data.entities.Trip
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TripsRepository(application: Application) {

    private val mDatabase = AppDatabase.getDatabase(application)
    private val mTrips = mDatabase.tripDao().getAll()

    fun getTrips() = mTrips

    fun deleteTrip(trip: Trip) {
        CoroutineScope(Job() + Dispatchers.Main).launch(Dispatchers.IO) {
            mDatabase.tripDao().delete(trip)
        }
    }
}
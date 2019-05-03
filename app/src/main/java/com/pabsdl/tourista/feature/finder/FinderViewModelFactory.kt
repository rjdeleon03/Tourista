package com.pabsdl.tourista.feature.finder

import android.app.Application
import android.location.LocationManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FinderViewModelFactory(application: Application, locationManager: LocationManager) :
    ViewModelProvider.Factory {

    private val mApplication = application
    private val mLocationManager = locationManager

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return (FinderViewModel(mApplication, mLocationManager) as T)
    }
}
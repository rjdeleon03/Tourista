package com.pabsdl.tourista.feature.finder

import android.annotation.SuppressLint
import android.app.Application
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.here.android.mpa.common.GeoCoordinate
import com.here.android.mpa.search.ErrorCode
import com.here.android.mpa.search.SearchRequest

class FinderViewModel(application: Application, locationManager: LocationManager) :
    AndroidViewModel(application) {

    private val mLocationManager = locationManager
    private val mCurrentLocation: MutableLiveData<GeoCoordinate> = MutableLiveData()

    val currentLocation: LiveData<GeoCoordinate>
        get() = mCurrentLocation

    @SuppressLint("MissingPermission")
    fun requestLocation() {
        mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0f, createLocationListener())
    }

    // TODO: Temporary test method
    fun getRestaurants(center: GeoCoordinate) {
        try {

            val request = SearchRequest("restaurant").setSearchCenter(center)
            request.collectionSize = 10

            val error = request.execute { data, err ->
                if (err != ErrorCode.NONE) {
                    // Error
                    return@execute
                }
                val x = data
            }
            if (error  != ErrorCode.NONE) {
                // Error
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    private fun createLocationListener(): LocationListener = object: LocationListener {
        override fun onLocationChanged(location: Location?) {
            if (location != null)
                mCurrentLocation.value = GeoCoordinate(location.latitude, location.longitude)
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        }

        override fun onProviderEnabled(provider: String?) {
        }

        override fun onProviderDisabled(provider: String?) {
        }
    }
}

package com.pabsdl.tourista.feature.finder

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.here.android.mpa.common.GeoCoordinate
import com.here.android.mpa.search.ErrorCode
import com.here.android.mpa.search.SearchRequest

class FinderViewModel(application: Application) :
    AndroidViewModel(application) {

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
}

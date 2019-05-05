package com.pabsdl.tourista.feature.finder

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.here.android.mpa.common.GeoCoordinate
import com.here.android.mpa.search.*

class FinderViewModel(application: Application) :
    AndroidViewModel(application) {

    // TODO: Temporary test method
    fun getRestaurants(center: GeoCoordinate) {
        try {

            val request = AroundRequest()
            request.setSearchCenter(center)

            val filter = CategoryFilter()
            filter.add(Category.Global.EAT_DRINK)
            request.setCategoryFilter(filter)
//            request.setSearchArea(GeoBoundingBox(center, 100f, 100f))

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

package com.pabsdl.tourista.feature.trips

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pabsdl.tourista.R
import com.pabsdl.tourista.common.base.BaseListener
import com.pabsdl.tourista.common.base.BaseObservableViewMvc
import com.pabsdl.tourista.common.base.ObservableViewMvc
import com.pabsdl.tourista.data.entities.Trip
import com.pabsdl.tourista.utils.clickWithGuard
import kotlinx.android.synthetic.main.item_trip.view.*

interface TripsItemMvc: ObservableViewMvc<TripsItemMvc.Listener> {

    interface Listener : BaseListener {

        fun onItemClicked(trip: Trip)
    }

    fun bindTrip(trip: Trip)
}

class TripsItemMvcImpl(inflater: LayoutInflater, parent: ViewGroup?) :
    BaseObservableViewMvc<TripsItemMvc.Listener>(), TripsItemMvc {

    override val mRootView = inflater.inflate(R.layout.item_trip, parent, false)

    override val rootView: View
        get() = mRootView

    override fun bindTrip(trip: Trip) {
        mRootView.tripNameText.text = trip.name
        mRootView.clickWithGuard {
            for(listener in mListeners)
                listener.onItemClicked(trip)
        }
    }
}
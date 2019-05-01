package com.pabsdl.tourista.feature.trips

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pabsdl.tourista.R
import com.pabsdl.tourista.common.base.BaseListener
import com.pabsdl.tourista.common.base.BaseObservableViewMvc
import com.pabsdl.tourista.common.base.ObservableViewMvc
import com.pabsdl.tourista.utils.clickWithGuard
import kotlinx.android.synthetic.main.fragment_trips.view.*

interface TripsMvc : ObservableViewMvc<TripsMvc.Listener> {

    interface Listener: BaseListener {
        fun onAddButtonClicked()
    }
}

class TripsMvcImpl(inflater: LayoutInflater, parent: ViewGroup?) :
    BaseObservableViewMvc<TripsMvc.Listener>(), TripsMvc {

    override val mRootView = inflater.inflate(R.layout.fragment_trips, parent, false)!!
    override val rootView: View
        get() = mRootView

    init {
        mRootView.tripsAddButton.clickWithGuard {
            for (listener in mListeners) {
                listener.onAddButtonClicked()
            }
        }
    }

}
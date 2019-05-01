package com.pabsdl.tourista.feature.trips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.pabsdl.tourista.common.base.BaseMvcFragment
import com.pabsdl.tourista.feature.dialogs.tripcreation.TripCreationFragment

class TripsFragment :
    BaseMvcFragment<TripsMvc, TripsMvc.Listener>(), TripsMvc.Listener {

    companion object {
        private const val TRIP_CREATION_FRAGMENT_KEY = "TRIP_CREATION_FRAGMENT_KEY"
    }

    private lateinit var mViewModel: TripsViewModel

    override fun initializeMvc(inflater: LayoutInflater, container: ViewGroup?) {
        mViewMvc = TripsMvcImpl(inflater, container)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = ViewModelProviders.of(this).get(TripsViewModelImpl::class.java)
    }

    // region TripsMvc.Listener

    override fun onAddButtonClicked() {
        val dialog = TripCreationFragment.newInstance()
        dialog.show(fragmentManager!!, TRIP_CREATION_FRAGMENT_KEY)
    }

    // endregion
}

package com.pabsdl.tourista.feature.trips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.pabsdl.tourista.R
import com.pabsdl.tourista.common.base.BaseMvcFragment
import com.pabsdl.tourista.data.entities.Trip
import com.pabsdl.tourista.feature.dialogs.tripcreation.TripCreationFragment

class TripsFragment :
    BaseMvcFragment<TripsMvc, TripsMvc.Listener>(), TripsMvc.Listener {

    companion object {
        private const val TRIP_CREATION_FRAGMENT_KEY = "TRIP_CREATION_FRAGMENT_KEY"
    }

    private lateinit var mViewModel: TripsViewModel
    private lateinit var mNavController: NavController

    override fun initializeMvc(inflater: LayoutInflater, container: ViewGroup?) {
        mViewMvc = TripsMvcImpl(inflater, container)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mNavController = findNavController()
        mViewModel = ViewModelProviders.of(this).get(TripsViewModelImpl::class.java)
        mViewModel.getTrips().observe(this, Observer {
            mViewMvc.setTrips(it)
        })
    }

    // region TripsMvc.Listener

    override fun onAddButtonClicked() {
        val dialog = TripCreationFragment.newInstance()
        dialog.show(fragmentManager!!, TRIP_CREATION_FRAGMENT_KEY)
    }

    override fun onItemClicked(trip: Trip) {
        mNavController.navigate(R.id.action_tripsFragment_to_tripInfoFragment)
    }

    // endregion
}

package com.pabsdl.tourista.feature.trips

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.here.android.mpa.common.MapSettings
import com.here.android.mpa.common.OnEngineInitListener
import com.here.android.mpa.mapping.SupportMapFragment

import com.pabsdl.tourista.R
import java.io.File

class TripsFragment : Fragment() {

    companion object {
        fun newInstance() = TripsFragment()
    }

    private lateinit var viewModel: TripsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trips, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TripsViewModel::class.java)
        // TODO: Use the ViewModel

        val externalFilesDir = context!!.applicationContext.getExternalFilesDir(null)
        val success = MapSettings.setIsolatedDiskCacheRootPath("$externalFilesDir${File.separator}.here-maps", resources.getString(R.string.app_map_intent))

        val mapFragment = (childFragmentManager.findFragmentById(R.id.tripsMapFragment) as SupportMapFragment)
        mapFragment.init { error ->
            if (error == OnEngineInitListener.Error.NONE) {
                val map = mapFragment.map
                val x = 5
            }
        }
    }

}

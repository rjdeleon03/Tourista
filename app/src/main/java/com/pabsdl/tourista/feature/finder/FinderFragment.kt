package com.pabsdl.tourista.feature.finder

import android.content.Context
import android.location.Location
import android.location.LocationManager
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.IBinder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.here.android.mpa.common.GeoPosition
import com.here.android.mpa.common.MapSettings
import com.here.android.mpa.common.OnEngineInitListener
import com.here.android.mpa.common.PositioningManager
import com.here.android.mpa.mapping.Map
import com.here.android.mpa.mapping.SupportMapFragment
import com.here.posclient.UpdateOptions
import com.here.services.common.PositioningError
import com.here.services.location.internal.PositionListener

import com.pabsdl.tourista.R
import com.pabsdl.tourista.common.base.BaseMvcFragment
import com.pabsdl.tourista.utils.UIUtils
import kotlinx.android.synthetic.main.fragment_finder.*
import java.io.File
import java.lang.ref.WeakReference

class FinderFragment :
    BaseMvcFragment<FinderViewMvc, FinderViewMvc.Listener>(), FinderViewMvc.Listener {

    companion object {
        fun newInstance() = FinderFragment()
    }

    private lateinit var mViewModel: FinderViewModel
    private var mPosManager: PositioningManager? = null
    private var mPosListener: PositioningManager.OnPositionChangedListener? = null
    private var mMap: Map? = null

    init {
        mPosListener = object: PositioningManager.OnPositionChangedListener {

            override fun onPositionFixChanged(
                p0: PositioningManager.LocationMethod?,
                p1: PositioningManager.LocationStatus?
            ) {}

            override fun onPositionUpdated(p0: PositioningManager.LocationMethod?,
                                           p1: GeoPosition?, p2: Boolean) {
                mMap?.setCenter(p1!!.coordinate, Map.Animation.LINEAR)
                mPosManager?.removeListener(mPosListener)
            }
        }
    }

    override fun initializeMvc(inflater: LayoutInflater, container: ViewGroup?) {
        mViewMvc = FinderViewMvcImpl(inflater, container)
    }

    override fun onResume() {
        super.onResume()
        mPosManager?.start(PositioningManager.LocationMethod.GPS_NETWORK)
    }

    override fun onPause() {
        mPosManager?.stop()
        super.onPause()
    }

    override fun onDestroy() {
        mPosManager?.removeListener(mPosListener)
        super.onDestroy()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val application = activity!!.application
        val locationManager = activity!!.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val factory = FinderViewModelFactory(application, locationManager)
        mViewModel = ViewModelProviders.of(this, factory).get(FinderViewModel::class.java)
        setupMap()
    }

    private fun setupLocationRetriever() {
        mViewModel.currentLocation.observe(viewLifecycleOwner, Observer {
            // TODO: Mark location on map
            val loc = it
        })
        mViewModel.requestLocation()
    }

    private fun setupMap() {

        val externalFilesDir = context!!.applicationContext.getExternalFilesDir(null)
        val success = MapSettings.setIsolatedDiskCacheRootPath(
            "$externalFilesDir${File.separator}.here-maps",
            resources.getString(R.string.app_map_intent))
        if (!success) return

        val mapFragment = (childFragmentManager.findFragmentById(R.id.finderMapFragment) as SupportMapFragment)
        mapFragment.init { error ->

            // TODO: Handle error accordingly
            if (error != OnEngineInitListener.Error.NONE) {
                UIUtils.createAndShowSnackbar(finderRootLayout, R.string.finder_map_error)
                return@init
            }
            mMap = mapFragment.map
            mPosManager = PositioningManager.getInstance()
            mPosManager?.addListener(WeakReference<PositioningManager.OnPositionChangedListener>(mPosListener))
            mPosManager?.start(PositioningManager.LocationMethod.GPS_NETWORK)
            mMap?.positionIndicator?.isVisible = true
        }
    }

}

package com.pabsdl.tourista.feature.finder

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.here.android.mpa.common.MapSettings
import com.here.android.mpa.common.OnEngineInitListener
import com.here.android.mpa.mapping.SupportMapFragment

import com.pabsdl.tourista.R
import com.pabsdl.tourista.common.base.BaseMvcFragment
import kotlinx.android.synthetic.main.fragment_finder.*
import java.io.File

class FinderFragment :
    BaseMvcFragment<FinderViewMvc, FinderViewMvc.Listener>(), FinderViewMvc.Listener {

    companion object {
        fun newInstance() = FinderFragment()
    }

    private lateinit var mViewModel: FinderViewModel

    override fun initializeMvc(inflater: LayoutInflater, container: ViewGroup?) {
        mViewMvc = FinderViewMvcImpl(inflater, container)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(FinderViewModel::class.java)

        val externalFilesDir = context!!.applicationContext.getExternalFilesDir(null)
        val success = MapSettings.setIsolatedDiskCacheRootPath(
            "$externalFilesDir${File.separator}.here-maps",
            resources.getString(R.string.app_map_intent))
        if (!success) return

        val mapFragment = (childFragmentManager.findFragmentById(R.id.finderMapFragment) as SupportMapFragment)
        mapFragment.init { error ->
            
            // TODO: Handle error accordingly
            if (error != OnEngineInitListener.Error.NONE)
                Snackbar.make(finderRootLayout, R.string.finder_map_error, Snackbar.LENGTH_LONG).show()
        }
    }

}

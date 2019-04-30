package com.pabsdl.tourista.feature.trips

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pabsdl.tourista.R

class TripsFragment : Fragment() {

    companion object {
        fun newInstance() = TripsFragment()
    }

    private lateinit var mViewModel: TripsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trips, container, false)
    }

}

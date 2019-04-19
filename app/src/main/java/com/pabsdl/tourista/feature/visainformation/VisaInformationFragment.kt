package com.pabsdl.tourista.feature.visainformation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pabsdl.tourista.R

/**
 * A simple [Fragment] subclass.
 * Use the [VisaInformationFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class VisaInformationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_visa_information, container, false)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment VisaInformationFragment.
         */
        @JvmStatic
        fun newInstance() =
            VisaInformationFragment()
    }
}

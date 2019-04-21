package com.pabsdl.tourista.feature.visacountriesfragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

import com.pabsdl.tourista.R

/**
 * A simple [Fragment] subclass.
 * Use the [VisaCountriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class VisaCountriesFragment : DialogFragment() {
    private var country: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            country = it.getString(COUNTRY_KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_visa_countries, container, false)
    }


    companion object {

        private const val COUNTRY_KEY = "COUNTRY_KEY"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param country Country search term.
         * @return A new instance of fragment VisaCountriesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(country: String) =
            VisaCountriesFragment().apply {
                arguments = Bundle().apply {
                    putString(COUNTRY_KEY, country)
                }
            }
    }
}

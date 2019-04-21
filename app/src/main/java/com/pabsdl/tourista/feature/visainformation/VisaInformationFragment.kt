package com.pabsdl.tourista.feature.visainformation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import com.pabsdl.tourista.R
import com.pabsdl.tourista.feature.visacountriesdialog.VisaCountriesFragment
import kotlinx.android.synthetic.main.fragment_visa_information.*
import kotlinx.android.synthetic.main.fragment_visa_information.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [VisaInformationFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class VisaInformationFragment : Fragment() {

    private lateinit var mViewModel: VisaInformationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(VisaInformationViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_visa_information, container, false)
        view.visaPassportText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) displayVisaCountriesFragment(view.visaPassportText.text.toString())
        }
        view.visaDestinationText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) displayVisaCountriesFragment(view.visaDestinationText.text.toString())
        }

        return view
    }

    private fun displayVisaCountriesFragment(country: String) {
        val dialog = VisaCountriesFragment.newInstance(country)
        dialog.show(childFragmentManager, VISA_COUNTRIES_FRAGMENT_KEY)
    }

    companion object {

        private const val VISA_COUNTRIES_FRAGMENT_KEY = "VISA_COUNTRIES_FRAGMENT_KEY"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment VisaInformationFragment.
         */
        @JvmStatic
        fun newInstance() = VisaInformationFragment()
    }
}

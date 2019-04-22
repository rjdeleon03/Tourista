package com.pabsdl.tourista.feature.visainformation


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pabsdl.tourista.Constants

import com.pabsdl.tourista.R
import com.pabsdl.tourista.databinding.FragmentVisaInformationBinding
import com.pabsdl.tourista.feature.visacountriesdialog.VisaCountriesFragment
import com.pabsdl.tourista.feature.webview.WebViewActivity
import com.pabsdl.tourista.utils.clickWithGuard
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
        val binding = FragmentVisaInformationBinding.inflate(inflater, container, false)
        binding.viewModel = mViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        visaPassportText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) displayVisaCountriesFragment(view.visaPassportText.text.toString(),
                Constants.VISA_COUNTRY_REQ_PASSPORT_CODE)
        }
        visaDestinationText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) displayVisaCountriesFragment(view.visaDestinationText.text.toString(),
                Constants.VISA_COUNTRY_REQ_DESTINATION_CODE)
        }
        visaSearchButton.clickWithGuard { mViewModel.searchVisaInfo() }
        visaReqsSearchButton.clickWithGuard {
            WebViewActivity.newInstance(activity!!, createSearchUrl())
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Constants.VISA_COUNTRY_RES_CODE) {
            val country = data?.getStringExtra(Constants.VISA_COUNTRY_RESULT_KEY)
            when (requestCode) {
                Constants.VISA_COUNTRY_REQ_PASSPORT_CODE -> {
                    mViewModel.setPassportCountry(country!!)
                }
                Constants.VISA_COUNTRY_REQ_DESTINATION_CODE -> {
                    mViewModel.setDestinationCountry(country!!)
                }
            }
        }
    }

    private fun displayVisaCountriesFragment(country: String, requestCode: Int) {
        val dialog = VisaCountriesFragment.newInstance(country)
        dialog.setTargetFragment(this, requestCode)
        dialog.show(fragmentManager!!, VISA_COUNTRIES_FRAGMENT_KEY)
    }

    private fun createSearchUrl(): String {
        val passportCountry = visaPassportText.text.toString()
        val destinationCountry = visaDestinationText.text.toString()
        val query = "$destinationCountry visa requirements for \"$passportCountry passport \""
            .replace(' ', '+')
        return "https://www.google.com/search?q=$query"
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

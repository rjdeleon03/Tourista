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
class VisaInformationFragment : Fragment(), VisaInformationMvc.Listener {

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

    private lateinit var mViewMvc: VisaInformationMvcImpl
    private lateinit var mViewModel: VisaInformationViewModelImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(VisaInformationViewModelImpl::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mViewMvc = VisaInformationMvcImpl(inflater, container, mViewModel, viewLifecycleOwner)
        mViewMvc.registerListener(this)
        return mViewMvc.rootView
    }

    override fun onDestroyView() {
        mViewMvc.unregisterListener(this)
        super.onDestroyView()
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
            mViewModel.searchVisaInfo()
        }
    }

    // region VisaInformationMvc.Listener

    override fun onSearchDetailsClicked() {
        WebViewActivity.newInstance(activity!!, createSearchUrl())
    }

    override fun onCountryFieldClicked(text: String, reqCode: Int) {
        val dialog = VisaCountriesFragment.newInstance(text)
        dialog.setTargetFragment(this, reqCode)
        dialog.show(fragmentManager!!, VISA_COUNTRIES_FRAGMENT_KEY)
    }

    private fun createSearchUrl(): String {
        val passportCountry = visaPassportText.text.toString()
        val destinationCountry = visaDestinationText.text.toString()
        val query = "$destinationCountry visa requirements for \"$passportCountry passport \""
            .replace(' ', '+')
        return "https://www.google.com/search?q=$query"
    }

    // endregion
}

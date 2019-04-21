package com.pabsdl.tourista.feature.visainformation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.pabsdl.tourista.R
import kotlinx.android.synthetic.main.fragment_visa_information.*

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
        return inflater.inflate(R.layout.fragment_visa_information, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel.getCountries().observe(this, Observer {
        })

        visaSearchButton.setOnClickListener {
            mViewModel.searchCountries(visaPassportText.text.toString())
        }
    }

    companion object {
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

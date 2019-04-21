package com.pabsdl.tourista.feature.visacountriesdialog


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.pabsdl.tourista.R
import kotlinx.android.synthetic.main.fragment_visa_countries.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [VisaCountriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class VisaCountriesFragment : DialogFragment() {
    private var country: String? = null
    private lateinit var mViewModel: VisaCountriesViewModel
    private lateinit var mAdapter: VisaCountriesAdapter

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            country = it.getString(COUNTRY_KEY)
        }

        mViewModel = ViewModelProviders.of(this).get(VisaCountriesViewModel::class.java)
        mAdapter = VisaCountriesAdapter(context!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_visa_countries, container, false)
        view.visaCountriesRecyclerView.adapter = mAdapter
        view.visaCountriesSearchText.doOnTextChanged { text, start, count, after ->
            mViewModel.searchCountries(text.toString())
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.getCountries().observe(viewLifecycleOwner, Observer {
            mAdapter.setCountries(it)
        })
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}

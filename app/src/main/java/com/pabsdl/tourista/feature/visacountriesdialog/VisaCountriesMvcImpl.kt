package com.pabsdl.tourista.feature.visacountriesdialog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import com.pabsdl.tourista.R
import com.pabsdl.tourista.common.base.BaseObservableViewMvc
import kotlinx.android.synthetic.main.fragment_visa_countries.view.*

class VisaCountriesMvcImpl(inflater: LayoutInflater, parent: ViewGroup?) :
    BaseObservableViewMvc<VisaCountriesMvc.Listener>(), VisaCountriesMvc {

    private val mInflater = inflater
    private val mAdapter = VisaCountriesAdapter(mInflater)
    override val mRootView = inflater.inflate(R.layout.fragment_visa_countries, parent, false)!!

    override val rootView: View
        get() { return mRootView }

    init {
        mAdapter.setClickHandler {
            for (listener in mListeners) {
                listener.onItemClicked(it)
            }
        }
        mRootView.visaCountriesRecyclerView.adapter = mAdapter
        mRootView.visaCountriesSearchText.doAfterTextChanged {
            for (listener in mListeners) {
                listener.onSearchInputChanged(it.toString())
            }
        }
        mRootView.visaCountriesSearchText.requestFocus()
    }

    override fun setCountries(countries: List<String>) = mAdapter.setCountries(countries)
}
package com.pabsdl.tourista.feature.dialogs.visacountries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pabsdl.tourista.R
import com.pabsdl.tourista.common.base.BaseListener
import com.pabsdl.tourista.common.base.BaseObservableViewMvc
import com.pabsdl.tourista.common.base.ObservableViewMvc
import com.pabsdl.tourista.utils.clickWithGuard
import kotlinx.android.synthetic.main.item_visa_country_result.view.*

interface VisaCountriesItemMvc : ObservableViewMvc<VisaCountriesItemMvc.Listener> {

    interface Listener : BaseListener {

        fun onItemClicked(country: String)
    }

    fun bindCountry(country: String)
}

class VisaCountriesItemMvcImpl(inflater: LayoutInflater, parent: ViewGroup?) :
    BaseObservableViewMvc<VisaCountriesItemMvc.Listener>(),
    VisaCountriesItemMvc {

    override val mRootView = inflater.inflate(R.layout.item_visa_country_result, parent, false)!!

    override val rootView: View
        get() = mRootView

    init {
        mRootView.clickWithGuard {
            for (listener in mListeners)
                listener.onItemClicked(mRootView.visaCountryResultText.text.toString())
        }
    }

    override fun bindCountry(country: String) {
        mRootView.visaCountryResultText.text = country
    }
}
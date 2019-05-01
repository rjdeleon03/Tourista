package com.pabsdl.tourista.feature.dialogs.visacountries

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import com.pabsdl.tourista.R
import com.pabsdl.tourista.common.base.BaseListener
import com.pabsdl.tourista.common.base.BaseObservableViewMvc
import com.pabsdl.tourista.common.base.ObservableViewMvcDialog
import com.pabsdl.tourista.utils.UIUtils
import kotlinx.android.synthetic.main.fragment_visa_countries.view.*

interface VisaCountriesMvc : ObservableViewMvcDialog<VisaCountriesMvc.Listener> {

    interface Listener: BaseListener {

        fun onItemClicked(country: String)

        fun onSearchInputChanged(input: String)

    }

    fun setCountryInput(country: String?)

    fun setCountries(countries: List<String>)

}

class VisaCountriesMvcImpl(inflater: LayoutInflater, parent: ViewGroup?) :
    BaseObservableViewMvc<VisaCountriesMvc.Listener>(),
    VisaCountriesMvc {

    private val mInflater = inflater
    private val mAdapter = VisaCountriesAdapter(mInflater) {
        for (listener in mListeners)
            listener.onItemClicked(it)
    }
    override val mRootView = inflater.inflate(R.layout.fragment_visa_countries, parent, false)!!

    override val rootView: View
        get() { return mRootView }

    init {
        mRootView.visaCountriesRecyclerView.adapter = mAdapter
        mRootView.visaCountriesSearchText.doAfterTextChanged {
            for (listener in mListeners) {
                listener.onSearchInputChanged(it.toString())
            }
        }
        mRootView.visaCountriesSearchText.requestFocus()
    }

    override fun createDialog(context: Context): Dialog {
        return UIUtils.createPlainDialog(context, rootView)
    }

    override fun setCountryInput(country: String?) {
        mRootView.visaCountriesSearchText.setText(country)
    }

    override fun setCountries(countries: List<String>) = mAdapter.setCountries(countries)
}
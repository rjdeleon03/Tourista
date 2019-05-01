package com.pabsdl.tourista.feature.dialogs.visacountries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class VisaCountriesAdapter(inflater: LayoutInflater,
                           clickHandler: ((String) -> Unit)? = null) :
    RecyclerView.Adapter<VisaCountriesAdapter.ViewHolder>(), VisaCountriesItemMvc.Listener {

    private val mInflater = inflater
    private val mClickHandler: ((String) -> Unit)? = clickHandler
    private var mCountries: List<String>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewMvc = VisaCountriesItemMvcImpl(mInflater, parent)
        viewMvc.registerListener(this)
        return ViewHolder(viewMvc)
    }

    override fun getItemCount( ): Int {
        if (mCountries == null) return 0
        return mCountries!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewMvc.bindCountry(mCountries!![position])
    }

    override fun onItemClicked(country: String) {
        mClickHandler?.invoke(country)
    }

    fun setCountries(countries: List<String>) {
        mCountries = countries
        notifyDataSetChanged()
    }

    class ViewHolder(viewMvc: VisaCountriesItemMvc) :
        RecyclerView.ViewHolder(viewMvc.rootView) {

        private val mViewMvc = viewMvc

        val viewMvc: VisaCountriesItemMvc
            get() = mViewMvc
    }
}
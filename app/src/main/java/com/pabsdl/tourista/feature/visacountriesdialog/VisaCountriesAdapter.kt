package com.pabsdl.tourista.feature.visacountriesdialog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pabsdl.tourista.R
import kotlinx.android.synthetic.main.item_visa_country_result.view.*

class VisaCountriesAdapter(inflater: LayoutInflater) :
    RecyclerView.Adapter<VisaCountriesAdapter.ViewHolder>() {

    private val mInflater = inflater
    private var mCountries: List<String>? = null
    private var mClickHandler: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.item_visa_country_result, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (mCountries == null) return 0
        return mCountries!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.getTextView().text = mCountries?.get(position)
        holder.setOnClickListener(View.OnClickListener {
            mClickHandler?.invoke(holder.getTextView().text.toString())
        })
    }

    fun setCountries(countries: List<String>) {
        mCountries = countries
        notifyDataSetChanged()
    }

    fun setClickHandler(handler: (String) -> Unit) {
        mClickHandler = handler
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val mView = view

        fun getTextView() = mView.visaCountryResultText!!

        fun setOnClickListener(listener: View.OnClickListener) {
            mView.setOnClickListener(listener)
        }
    }
}
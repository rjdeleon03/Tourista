package com.pabsdl.tourista.feature.trips

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pabsdl.tourista.data.entities.Trip

class TripsAdapter(inflater: LayoutInflater,
                   clickHandler: ((Trip) -> Unit)? = null) :
    RecyclerView.Adapter<TripsAdapter.ViewHolder>(), TripsItemMvc.Listener {

    private val mInflater = inflater
    private val mClickHandler = clickHandler
    private var mTrips: List<Trip>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewMvc = TripsItemMvcImpl(mInflater, parent)
        viewMvc.registerListener(this)
        return ViewHolder(viewMvc)
    }

    override fun getItemCount(): Int {
        if (mTrips == null) return 0
        return mTrips!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewMvc.bindTrip(mTrips!![position])
    }

    fun setTrips(trips: List<Trip>) {
        mTrips = trips
        notifyDataSetChanged()
    }

    override fun onItemClicked(trip: Trip) {
        mClickHandler?.invoke(trip)
    }

    class ViewHolder(viewMvc: TripsItemMvc) :
        RecyclerView.ViewHolder(viewMvc.rootView) {

        private val mViewMvc = viewMvc

        val viewMvc: TripsItemMvc
            get() = mViewMvc
    }
}
package com.pabsdl.tourista.feature.dialogs.tripcreation

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.pabsdl.tourista.R
import com.pabsdl.tourista.common.base.BaseListener
import com.pabsdl.tourista.common.base.BaseObservableViewMvc
import com.pabsdl.tourista.common.base.ObservableViewMvcDialog

interface TripCreationMvc : ObservableViewMvcDialog<TripCreationMvc.Listener> {

    interface Listener: BaseListener {

        fun onAddButtonClicked()
    }
}

class TripCreationMvcImpl(inflater: LayoutInflater, parent: ViewGroup?) :
    BaseObservableViewMvc<TripCreationMvc.Listener>(), TripCreationMvc {

    override val mRootView = inflater.inflate(R.layout.fragment_trip_creation, parent, false)!!

    override val rootView: View
        get() = mRootView

    override fun createDialog(context: Context, dismissAction: () -> Unit): Dialog {
        return AlertDialog.Builder(context)
            .setView(rootView)
            .setPositiveButton(R.string.text_ok) { _, _ ->
                Toast.makeText(context, "OK Clicked", Toast.LENGTH_SHORT).show()
                dismissAction()
            }
            .setNegativeButton(R.string.text_cancel) { _, _ ->
                dismissAction()
            }
            .create()
    }

}
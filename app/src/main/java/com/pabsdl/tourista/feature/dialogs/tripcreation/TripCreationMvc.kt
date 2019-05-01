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
import com.pabsdl.tourista.utils.clickWithGuard
import kotlinx.android.synthetic.main.fragment_trip_creation.view.*

interface TripCreationMvc : ObservableViewMvcDialog<TripCreationMvc.Listener> {

    interface Listener: BaseListener {

        fun onOkButtonClicked()
        fun onCancelButtonClicked()
        fun onStartDateClicked()
        fun onEndDateClicked()
    }
}

class TripCreationMvcImpl(inflater: LayoutInflater, parent: ViewGroup?) :
    BaseObservableViewMvc<TripCreationMvc.Listener>(), TripCreationMvc {

    override val mRootView = inflater.inflate(R.layout.fragment_trip_creation, parent, false)!!

    override val rootView: View
        get() = mRootView

    init {
        mRootView.tripCreationStartDateRow.clickWithGuard {
            for (listener in mListeners)
                listener.onStartDateClicked()
        }
        mRootView.tripCreationEndDateRow.clickWithGuard {
            for (listener in mListeners)
                listener.onEndDateClicked()
        }
    }

    override fun createDialog(context: Context): Dialog {
        return AlertDialog.Builder(context)
            .setView(rootView)
            .setTitle(R.string.title_trip_creation)
            .setPositiveButton(R.string.text_ok) { _, _ ->
                for (listener in mListeners)
                    listener.onOkButtonClicked()
            }
            .setNegativeButton(R.string.text_cancel) { _, _ ->
                for (listener in mListeners)
                    listener.onCancelButtonClicked()
            }
            .create()
    }

}
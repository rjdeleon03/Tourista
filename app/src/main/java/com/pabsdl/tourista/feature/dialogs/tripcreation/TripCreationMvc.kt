package com.pabsdl.tourista.feature.dialogs.tripcreation

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import com.pabsdl.tourista.R
import com.pabsdl.tourista.common.base.BaseListener
import com.pabsdl.tourista.common.base.BaseObservableViewMvc
import com.pabsdl.tourista.common.base.ObservableViewMvcDialog
import com.pabsdl.tourista.databinding.FragmentTripCreationBinding
import com.pabsdl.tourista.utils.clickWithGuard
import java.lang.ref.WeakReference

interface TripCreationMvc : ObservableViewMvcDialog<TripCreationMvc.Listener> {

    interface Listener: BaseListener {

        fun onOkButtonClicked()
        fun onCancelButtonClicked()
        fun onStartDateClicked()
        fun onEndDateClicked()
    }
}

class TripCreationMvcImpl(inflater: LayoutInflater, parent: ViewGroup?,
                          viewModel: TripCreationViewModel, lifecycleOwner: LifecycleOwner) :
    BaseObservableViewMvc<TripCreationMvc.Listener>(), TripCreationMvc {

    private val mLifecycleOwner = WeakReference<LifecycleOwner>(lifecycleOwner)
    private val mViewModel = viewModel
    private val mDataBinding = FragmentTripCreationBinding.inflate(inflater, parent, false)
    override val mRootView = mDataBinding.root

    override val rootView: View
        get() = mRootView

    init {
        mDataBinding.viewModel = mViewModel
        mDataBinding.lifecycleOwner = mLifecycleOwner.get()
        mDataBinding.tripCreationStartDateRow.clickWithGuard {
            for (listener in mListeners)
                listener.onStartDateClicked()
        }
        mDataBinding.tripCreationEndDateRow.clickWithGuard {
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
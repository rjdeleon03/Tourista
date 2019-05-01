package com.pabsdl.tourista.common.base

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.pabsdl.tourista.R

@Suppress("UNCHECKED_CAST")
abstract class BaseMvcDialogFragment<MVC: ObservableViewMvcDialog<L>, L : BaseListener> :
    DialogFragment() {

    protected lateinit var mViewMvc: MVC

    abstract fun initializeMvc(inflater: LayoutInflater, container: ViewGroup?)

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return mViewMvc.rootView
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        initializeMvc(LayoutInflater.from(context!!), null)
        mViewMvc.registerListener(this as L)
        return mViewMvc.createDialog(context!!) { dismiss() }
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        mViewMvc.unregisterListener(this as L)
    }
}
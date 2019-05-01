package com.pabsdl.tourista.common.base

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

@Suppress("UNCHECKED_CAST")
abstract class BaseMvcDialogFragment<MVC, L : BaseListener> :
    DialogFragment() where MVC : BaseDialog, MVC: ObservableViewMvc<L> {

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
        return mViewMvc.createDialog(context!!)
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        mViewMvc.unregisterListener(this as L)
    }
}
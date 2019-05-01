package com.pabsdl.tourista.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

@Suppress("UNCHECKED_CAST")
abstract class BaseMvcFragment<MVC: ObservableViewMvc<L>, L : BaseListener> :
    Fragment() {

    protected lateinit var mViewMvc: MVC

    abstract fun initializeMvc(inflater: LayoutInflater, container: ViewGroup?)

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        initializeMvc(inflater, container)
        mViewMvc.registerListener(this as L)
        return mViewMvc.rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mViewMvc.unregisterListener(this as L)
    }
}
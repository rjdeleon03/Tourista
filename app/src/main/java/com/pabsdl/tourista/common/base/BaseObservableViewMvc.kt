package com.pabsdl.tourista.common.base

import android.view.View

abstract class BaseObservableViewMvc<BL : BaseListener> : ObservableViewMvc<BL>{

    protected abstract val mRootView: View
    protected val mListeners = ArrayList<BL>()

    fun <T : View?> findViewById(id: Int): T  = rootView.findViewById<T>(id)

    override fun registerListener(listener: BL) {
        mListeners.add(listener)
    }

    override fun unregisterListener(listener: BL) {
        mListeners.remove(listener)
    }
}
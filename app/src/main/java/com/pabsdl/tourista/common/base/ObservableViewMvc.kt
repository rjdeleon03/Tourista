package com.pabsdl.tourista.common.base

import android.view.View

interface ObservableViewMvc<BL : BaseListener> {

    val rootView: View

    fun registerListener(listener: BL)
    fun unregisterListener(listener: BL)

}
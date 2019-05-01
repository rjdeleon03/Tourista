package com.pabsdl.tourista.common.base

import android.app.Dialog
import android.content.Context

interface ObservableViewMvcDialog<BL : BaseListener> :
    ObservableViewMvc<BL> {

    fun createDialog(context: Context, dismissAction: () -> Unit) : Dialog

}
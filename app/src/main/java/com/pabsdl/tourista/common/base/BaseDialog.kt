package com.pabsdl.tourista.common.base

import android.app.Dialog
import android.content.Context

interface BaseDialog {

    fun createDialog(context: Context) : Dialog

}
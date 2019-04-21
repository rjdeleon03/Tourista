package com.pabsdl.tourista.utils

import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.FragmentActivity

class UIUtils {

    companion object {

        /* Clears the focus and hides the keyboard from fragment*/
        fun clearFocusFromFragment(activity: FragmentActivity) {

            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            val cf = activity.currentFocus!!
            imm!!.hideSoftInputFromWindow(cf.windowToken, 0)
            cf.clearFocus()
        }
    }
}
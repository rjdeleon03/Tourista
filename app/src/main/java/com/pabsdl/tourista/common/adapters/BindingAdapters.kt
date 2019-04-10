package com.pabsdl.tourista.common.adapters

import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import com.google.android.material.textfield.TextInputEditText

@BindingAdapter("android:text")
fun setFloatToText(et: TextInputEditText, f: Float?) {
    if (f == null) {
        et.setText(0f.toString())
        return
    }
    et.setText(f.toString())
}

@InverseBindingAdapter(attribute = "android:text",
    event = "android:textAttrChanged")
fun setTextToFloat(et: TextInputEditText) : Float? {
    return et.text.toString().toFloat()
}
package com.pabsdl.tourista.common.adapters

import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import com.google.android.material.textfield.TextInputEditText

@BindingAdapter("android:text")
fun setFloatToText(et: TextInputEditText, f: Float?) {
    et.setText(f.toString())
}

@InverseBindingAdapter(attribute = "android:text")
fun setTextToFloat(et: TextInputEditText) : Float? {
    return et.text.toString().toFloat()
}
package com.pabsdl.tourista.common.adapters

import android.widget.Button
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import com.google.android.material.textfield.TextInputEditText
import com.pabsdl.tourista.model.VisaInfoData
import com.pabsdl.tourista.view.visainformationresult.VisaInformationResultView

@BindingAdapter("android:text")
fun setFloatToText(et: TextInputEditText, f: Float?) {
    if (f == null) {
        et.setText(0f.toString())
        return
    }

    if (f.toString() != et.text.toString())
        et.setText(String.format("%.2f", f))
}

@InverseBindingAdapter(attribute = "android:text",
    event = "android:textAttrChanged")
fun setTextToFloat(et: TextInputEditText) : Float? {
    return et.text.toString().toFloat()
}

@BindingAdapter("android:visaInfo")
fun setVisaInfoToText(vv: VisaInformationResultView, vi: VisaInfoData?) {
    vv.infoData = vi
}

@BindingAdapter("android:visaInfo")
fun setVisaInfoToButton(bt: Button, vi: VisaInfoData?) {
    bt.isEnabled = vi != null && vi != VisaInfoData.SAME_COUNTRY
}
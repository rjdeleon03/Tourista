package com.pabsdl.tourista.common.adapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.pabsdl.tourista.data.entities.VisaBookmark
import com.pabsdl.tourista.feature.visainformation.VisaInformationBookmarksAdapter
import com.pabsdl.tourista.model.VisaInfoData

class BindingAdapters {

    companion object {

        @JvmStatic
        @BindingAdapter("android:text")
        fun setFloatToText(et: TextInputEditText, f: Float?) {
            if (f == null) {
                et.setText(0f.toString())
                return
            }

            if (f.toString() != et.text.toString())
                et.setText(String.format("%.2f", f))
        }

        @JvmStatic
        @InverseBindingAdapter(attribute = "android:text",
            event = "android:textAttrChanged")
        fun setTextToFloat(et: TextInputEditText) : Float? {
            return et.text.toString().toFloat()
        }

        @JvmStatic
        @BindingAdapter("android:visaInfo")
        fun setVisaInfoToText(tv: TextView, vi: VisaInfoData?) {
            if (vi == null) {
                tv.text = "-"
                return
            }
            tv.text = vi.toString()
        }

        @JvmStatic
        @BindingAdapter("android:visaBookmarks")
        fun setVisaBookmarks(rv: RecyclerView, vb: List<VisaBookmark>?) {
            if (vb == null) return
            (rv.adapter as VisaInformationBookmarksAdapter).setBookmarks(vb)
        }

    }

}
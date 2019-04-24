package com.pabsdl.tourista.feature.visainformation

import com.pabsdl.tourista.common.base.BaseListener
import com.pabsdl.tourista.data.entities.VisaBookmark

interface VisaInformationMvc {

    interface Listener: BaseListener {

        fun onCountryFieldClicked(text: String, reqCode: Int)

        fun onSearchDetailsClicked()

        fun onBookmarkItemClicked(bookmark: VisaBookmark)

        fun onBookmarkItemLongPressed(bookmark: VisaBookmark)
    }
}
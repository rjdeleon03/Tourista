package com.pabsdl.tourista.utils

import com.pabsdl.tourista.model.VisaInfoData

class MiscUtils {

    companion object {

        /* Map an integer to its corresponding visa info enum */
        fun mapIntegerToVisaInfoEnum(int: Int) =
            when(int) {
                -1 -> VisaInfoData.SAME_COUNTRY
                0 -> VisaInfoData.VISA_REQUIRED
                1 -> VisaInfoData.VISA_ON_ARRIVAL
                2 -> VisaInfoData.ETA
                else -> VisaInfoData.VISA_FREE
            }
    }
}
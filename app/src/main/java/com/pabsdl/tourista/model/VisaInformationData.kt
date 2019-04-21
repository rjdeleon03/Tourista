package com.pabsdl.tourista.model

/*
 * Based on https://github.com/ilyankou/passport-index-dataset
 */
enum class VisaInfoData {
    /*
     * 3 = visa-free travel
     * 2 = eTA is required
     * 1 = visa can be obtained on arrival (which Passport Index considers visa-free)
     * 0 = visa is required
     * -1 is for all instances where passport and destination are the same
     */
    SAME_COUNTRY,
    VISA_REQUIRED,
    VISA_ON_ARRIVAL,
    ETA,
    VISA_FREE
}
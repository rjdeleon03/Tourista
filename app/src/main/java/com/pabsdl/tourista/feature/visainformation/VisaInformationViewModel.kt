package com.pabsdl.tourista.feature.visainformation

import androidx.lifecycle.LiveData
import com.pabsdl.tourista.data.entities.VisaBookmark
import com.pabsdl.tourista.model.VisaInfoData

interface VisaInformationViewModel {

    fun getPassportCountry(): LiveData<String>

    fun getDestinationCountry(): LiveData<String>

    fun setPassportCountry(country: String)

    fun setDestinationCountry(country: String)

    fun getVisaInfo(): LiveData<VisaInfoData?>

    fun searchVisaInfo()

    fun getBookmarks(): LiveData<List<VisaBookmark>>

    fun deleteBookmark(bookmark: VisaBookmark)

}
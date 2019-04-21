package com.pabsdl.tourista.feature.visainformation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.pabsdl.tourista.data.AppDatabase
import com.pabsdl.tourista.model.VisaInfoData
import com.pabsdl.tourista.utils.MiscUtils

class VisaInformationRepository(application: Application) {

    private val mDatabase = AppDatabase.getDatabase(application.applicationContext)
    private val mVisaInfo: MediatorLiveData<VisaInfoData?> = MediatorLiveData()

    fun getVisaInfo(): LiveData<VisaInfoData?> = mVisaInfo

    fun searchVisaInfo(srcCountry: String, destCountry: String) {
        mVisaInfo.addSource(
            mDatabase.visaInformationDao().get(srcCountry, destCountry)) {
            mVisaInfo.setValue(MiscUtils.mapIntegerToVisaInfoEnum(it.info))
        }
    }
}
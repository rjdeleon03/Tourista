package com.pabsdl.tourista.feature.visainformation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.pabsdl.tourista.data.AppDatabase
import com.pabsdl.tourista.data.entities.VisaBookmark
import com.pabsdl.tourista.model.VisaInfoData
import com.pabsdl.tourista.utils.MiscUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class VisaInformationRepository(application: Application) {

    private val mDatabase = AppDatabase.getDatabase(application.applicationContext)
    private val mVisaInfo: MediatorLiveData<VisaInfoData?> = MediatorLiveData()

    // region Visa info

    fun getVisaInfo(): LiveData<VisaInfoData?> = mVisaInfo

    fun searchVisaInfo(srcCountry: String, destCountry: String) {
        mVisaInfo.addSource(
            mDatabase.visaInformationDao().get(srcCountry, destCountry)) {
            mVisaInfo.setValue(MiscUtils.mapIntegerToVisaInfoEnum(it.info))
        }
    }

    // endregion

    // region Bookmarks

    fun getBookmarks(): LiveData<List<VisaBookmark>> = mDatabase.visaBookmarkDao().getAll()

    fun deleteBookmark(bookmark: VisaBookmark) {
        CoroutineScope(Job() + Dispatchers.Main).launch(Dispatchers.IO) {
            mDatabase.visaBookmarkDao().delete(bookmark)
        }
    }

    // endregion
}
package com.pabsdl.tourista.feature.webview

import android.app.Application
import com.pabsdl.tourista.data.AppDatabase
import com.pabsdl.tourista.data.entities.VisaBookmark
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class WebViewRepository(application: Application) {

    private val mDatabase = AppDatabase.getDatabase(application.applicationContext)

    fun addBookmark(bookmark: VisaBookmark) {
        CoroutineScope(Job() + Dispatchers.Main).launch(Dispatchers.IO) {
            mDatabase.visaBookmarkDao().insert(bookmark)
        }
    }

    fun updateBookmark(bookmark: VisaBookmark) {
        CoroutineScope(Job() + Dispatchers.Main).launch(Dispatchers.IO) {
            mDatabase.visaBookmarkDao().update(bookmark)
        }
    }

    fun deleteBookmark(bookmark: VisaBookmark) {
        CoroutineScope(Job() + Dispatchers.Main).launch(Dispatchers.IO) {
            mDatabase.visaBookmarkDao().delete(bookmark)
        }
    }
}
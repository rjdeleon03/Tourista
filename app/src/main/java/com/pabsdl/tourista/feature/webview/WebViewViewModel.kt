package com.pabsdl.tourista.feature.webview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.pabsdl.tourista.data.entities.VisaBookmark

class WebViewViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository = WebViewRepository(application)

    fun addBookmark(bookmark: VisaBookmark) = mRepository.addBookmark(bookmark)

    fun updateBookmark(bookmark: VisaBookmark) = mRepository.updateBookmark(bookmark)

    fun deleteBookmark(bookmark: VisaBookmark) = mRepository.addBookmark(bookmark)
}
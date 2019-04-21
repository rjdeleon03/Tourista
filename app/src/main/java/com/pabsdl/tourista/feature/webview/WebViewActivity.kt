package com.pabsdl.tourista.feature.webview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pabsdl.tourista.R
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.google.com/search?q=france+visa+requirements+philippines")
    }
}

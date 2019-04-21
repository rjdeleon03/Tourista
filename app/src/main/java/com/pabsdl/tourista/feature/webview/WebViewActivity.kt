package com.pabsdl.tourista.feature.webview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.pabsdl.tourista.R
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        // TODO: Retrieve this from bundle
        val url = "https://www.google.com/search?q=france+visa+requirements+philippines"

        setSupportActionBar(webToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Loading..."
        supportActionBar?.subtitle = url

        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)
        webView.webViewClient = object: WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                supportActionBar?.title = view?.title
                supportActionBar?.subtitle = webView.url
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        if (webView.canGoBack())
            webView.goBack()
        else
            finish()
        return true
    }

    override fun onBackPressed() {
        if (webView.canGoBack())
            webView.goBack()
        else
            finish()
    }
}

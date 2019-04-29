package com.pabsdl.tourista.feature.webview

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.ViewModelProviders
import com.pabsdl.tourista.Constants
import com.pabsdl.tourista.R
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {

    companion object {

        @JvmStatic
        fun newInstance(context: Context, url: String) {
            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra(Constants.VISA_INFORMATION_SEARCH_KEY, url)
            context.startActivity(intent)
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        if (savedInstanceState == null) {
            val url = intent.getStringExtra(Constants.VISA_INFORMATION_SEARCH_KEY)

            setSupportActionBar(webToolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = ""
            supportActionBar?.subtitle = ""

            webView.settings.javaScriptEnabled = true
            webView.webViewClient = object : WebViewClient() {

                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    supportActionBar?.title = "Loading..."
                    supportActionBar?.subtitle = webView.url
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    supportActionBar?.title = view?.title
                }

                override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                    webView.loadUrl(url)
                    return true
                }
            }
            webView.loadUrl(url)
        }
    }

    // region Back navigation

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

    // endregion

    // region Toolbar menu

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_web_view, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item == null) return true

        when(item.itemId) {
            R.id.menuWebRefresh -> {
                webView.loadUrl(webView.url)
            }
            R.id.menuWebCopyUrl -> {
                /* Copy URL to clipboard */
                val cm = (getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager)
                cm.primaryClip = ClipData.newPlainText("text", webView.url)
            }
            R.id.menuOpenInBrowser -> {
                /* Open in external browser */
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(webView.url))
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    // endregion

    // region State management

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        webView.saveState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        webView.restoreState(savedInstanceState)
    }
    // endregion
}

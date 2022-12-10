package nv.projects.newsapp

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var detailedWebView: WebView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val url = intent.getStringExtra("URL")
        if (url != null) {
            detailedWebView = findViewById(R.id.webView)
            detailedWebView.settings.javaScriptEnabled = true
            detailedWebView.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    progressBar = findViewById(R.id.progressBar)
                    progressBar.visibility = View.GONE
                    detailedWebView.visibility = View.VISIBLE
                }
            }
            detailedWebView.loadUrl(url)
        }
    }
}
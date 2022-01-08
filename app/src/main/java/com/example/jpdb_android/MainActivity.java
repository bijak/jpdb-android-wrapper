package com.example.jpdb_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView myWebView = findViewById(R.id.webview);
        // This setting necessary for autoplaying audio in reviews
        myWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        // These two settings are necessary for Google login to work
        myWebView.getSettings().setUserAgentString("JpdbAndroid");
        myWebView.getSettings().setJavaScriptEnabled(true);

        myWebView.loadUrl("https://jpdb.io/");
        // This keeps links clicked within jpdb from opening up the browser
        // TODO: Investigate - opens patreon/discord links in the app, might be related to why clicking audio is busted
        myWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView viewx, String urlx) {
                viewx.loadUrl(urlx);
                return false;
            }
        });
    }
}
package com.example.notesapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.TaskStackBuilder;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_webview);

       webView = findViewById(R.id.webview);
       String url = getString(R.string.company_url);
       progressDialog = new ProgressDialog(this);
       webView.setWebViewClient(new BrowserClient(progressDialog));

       webView.loadUrl(url);



    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack())
        {
            webView.goBack();

        }
        else
        {
            super.onBackPressed();
        }


    }

    private class BrowserClient extends WebViewClient {

        private ProgressDialog progressDialog;
        public BrowserClient(ProgressDialog progressDialog){
            this.progressDialog = progressDialog;
            progressDialog.setMessage("Loading.........");
            progressDialog.show();


        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            progressDialog.dismiss();
        }
    }
}







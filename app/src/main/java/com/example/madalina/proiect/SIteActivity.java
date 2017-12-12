package com.example.madalina.proiect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class SIteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site);

        String link= getIntent().getStringExtra("link");
        WebView web= (WebView) findViewById(R.id.webviewSite);
        web.loadUrl(link);
    }
}

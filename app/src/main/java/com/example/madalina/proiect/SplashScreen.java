package com.example.madalina.proiect;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it=new Intent(SplashScreen.this,MainActivity.class);
                SplashScreen.this.startActivity(it);
                SplashScreen.this.finish();
            }
        },secondsDelayed*2000);
    }
}

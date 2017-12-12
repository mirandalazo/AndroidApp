package com.example.madalina.proiect;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SiteDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_description);


        AducereInformatii ai=new AducereInformatii(){
            @Override
            protected void onPostExecute(String s) {
                TextView tv=(TextView)findViewById(R.id.tvDescriereSite);
                tv.setText(s);
            }
        };
        String link= getIntent().getStringExtra("link");
        ai.execute(link);

    }


    class AducereInformatii extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            StringBuilder rezultat = new StringBuilder();
            try {
                URL url = new URL(params[0]);
                HttpURLConnection htpp = (HttpURLConnection) url.openConnection();
                InputStream is = htpp.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(isr);


                String linie = null;
                while ((linie = reader.readLine()) != null) {
                    rezultat.append(linie);
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return rezultat.toString();

        }
    }
}

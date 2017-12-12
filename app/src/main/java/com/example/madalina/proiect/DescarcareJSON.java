package com.example.madalina.proiect;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Madalina on 12/5/2016.
 */

public class DescarcareJSON extends AsyncTask<String,Void,List<Local>> {
    @Override
    protected List<Local> doInBackground(String... params) {
        List<Local> listaLocaluriInPlus=new ArrayList<Local>();
        try {

            URL url = new URL(params[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream is = conn.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader reader=new BufferedReader(isr);

            String linie=null;
            StringBuilder builder=new StringBuilder();
            while((linie=reader.readLine())!=null)
            {
                builder.append(linie);
            }

            JSONObject object=new JSONObject(builder.toString());
            JSONObject json=object.getJSONObject("");
            JSONArray lista=json.getJSONArray("");
            for(int i=0;i<lista.length();i++) {
                JSONObject element = lista.getJSONObject(i);
                Local loc=new Local(element.getString("denumire"),
                        element.getString("descriere"),
                        element.getString("site"),
                        element.getString("tip"),
                        Float.parseFloat(element.getString("nota")),
                        null);
                Menu.contor++;
                listaLocaluriInPlus.add(loc);

            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return listaLocaluriInPlus;

    }
}

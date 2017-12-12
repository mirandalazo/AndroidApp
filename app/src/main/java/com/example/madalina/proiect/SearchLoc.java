package com.example.madalina.proiect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SearchLoc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_loc);


         AdaptorLocal adapter=new AdaptorLocal(getApplicationContext(),R.layout.activity_search_loc,Menu.listaLocal);
        ListView v=(ListView) findViewById(R.id.lvLocal);
        v.setAdapter(adapter);

        v.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Local l= Menu.listaLocal.get(position);

                Intent it=new Intent(SearchLoc.this,LocalDetails.class);
                it.putExtra("id",l.getId());
//                it.putExtra("nume",l.getDenumire());
//                it.putExtra("desc",l.getDescriere());

                startActivity(it);

            }
        });

        Button more=(Button)findViewById(R.id.btnMoreLocals);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DownloadXML obiect=new DownloadXML(){
                    @Override
                    protected void onPostExecute(List<Local> locals) {
                        for(Local l:locals)
                        {
                            Menu.listaLocal.add(l);

                        }


                        AdaptorLocal adapter=new AdaptorLocal(getApplicationContext(),R.layout.activity_search_loc,Menu.listaLocal);
                        ListView v=(ListView) findViewById(R.id.lvLocal);
                        //v.setAdapter(null);
                        v.setAdapter(adapter);
                }
                };
                obiect.execute("https://gist.githubusercontent.com/mirandalazo/aacec87eedbaf178381d5e082713cda5/raw/d79838d4f98dcb48d1ff250fdd5a0b0b8caa41fb/local.xml");
            }
        });


        Button btnAlfabetic=(Button)findViewById(R.id.btnAlphabetic);
        btnAlfabetic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Conexiune conexiune=new Conexiune(getApplicationContext());
                conexiune.openConnection();
                Menu.listaLocal.clear();
                Menu.listaLocal=conexiune.getLocaluriAlfabetic();
                AdaptorLocal adapter=new AdaptorLocal(getApplicationContext(),R.layout.activity_search_loc,Menu.listaLocal);
                ListView lv=(ListView) findViewById(R.id.lvLocal);
                lv.setAdapter(adapter);
                conexiune.closeConnection();
            }
        });

        final Spinner spinnerCategorie=(Spinner)findViewById(R.id.spCategory);

        spinnerCategorie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerCategorie.setSelection(position, false);
                Conexiune conexiune=new Conexiune(getApplicationContext());
                conexiune.openConnection();
                Menu.listaLocal.clear();
                if(spinnerCategorie.getSelectedItem().toString().equals("Toate"))
                    Menu.listaLocal=conexiune.getLocaluri();
                else
                    Menu.listaLocal=conexiune.getLocaluriTip(spinnerCategorie.getSelectedItem().toString());
                AdaptorLocal adapter=new AdaptorLocal(getApplicationContext(),R.layout.activity_search_loc,Menu.listaLocal);
                ListView lv=(ListView) findViewById(R.id.lvLocal);
                lv.setAdapter(adapter);
                conexiune.closeConnection();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
             return;

            }
        });


        final Spinner spinnerZona=(Spinner)findViewById(R.id.spDistrict);

        spinnerZona.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerZona.setSelection(position, false);
                Conexiune conexiune=new Conexiune(getApplicationContext());
                conexiune.openConnection();
                Menu.listaLocal.clear();
                if(spinnerZona.getSelectedItem().toString().equals("Toate"))
                    Menu.listaLocal=conexiune.getLocaluri();
                else
                    Menu.listaLocal=conexiune.getLocaluriZona(spinnerZona.getSelectedItem().toString());
                AdaptorLocal adapter=new AdaptorLocal(getApplicationContext(),R.layout.activity_search_loc,Menu.listaLocal);
                ListView lv=(ListView) findViewById(R.id.lvLocal);
                lv.setAdapter(adapter);
                conexiune.closeConnection();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;

            }
        });


    }
}

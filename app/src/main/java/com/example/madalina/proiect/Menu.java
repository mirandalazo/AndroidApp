package com.example.madalina.proiect;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    public static ArrayList<Local> listaLocal=new ArrayList<Local>();
    public static int contor=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnAbout=(Button)findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(Menu.this, AboutActivity.class);
                startActivity(it);
            }
        });




      //  btnAbout.setBackgroundColor(Color.parseColor());


//        Adresa a=new Adresa("Sector 1","Bd. Kiseleff",32);
//        Local l=new Local(contor,"Beraria H","Beraria de pe malul Herastraului","http://www.berariah.ro",null,"Restaurant",a,5);
//        Review rev=new Review(0,"E frumos.Recomand","madalina123",(float)4.5,null);
//        Review rev2=new Review(1,"E urat. nu Recomand","andra123",(float)2.5,null);
//        ArrayList<Review> ar1=new ArrayList<Review>();
//        ar1.add(rev);
//        ar1.add(rev2);
//        l.setRecenzii(ar1);
//
//
//        contor++;
//        Adresa a2=new Adresa("Sector 2","Str. Blanari",14);
//        Local l2=new Local(contor,"Club A","Muzica Rock, oameni pe cinste, petreceri incendiare.","http://www.cluba.ro",null,"Club",a2,5);
//
//        Review rev3=new Review(0,"E frumos si aici.Recomand","miranda123",(float)4.5,null);
//        ArrayList<Review> ar2=new ArrayList<Review>();
//        ar2.add(rev3);
//        l2.setRecenzii(ar2);
//
//        contor++;
//        Adresa a3=new Adresa("Sector 6","Bd. Iuliu Maniu",8);
//        Local l3=new Local(contor,"Restaurant Amada","Locul perfect pentru o cina romantica, sau pentru a serba un eveniment special.","http://www.amadaballroom.ro",null,"Restaurant",a3,4);
//        Review rev4=new Review(0,"E frumos.Recomand","madalina123",(float)4.5,null);
//        ArrayList<Review> ar3=new ArrayList<Review>();
//        ar3.add(rev4);
//        l3.setRecenzii(ar3);
//
//        contor++;
//        listaLocal.add(l);
//        listaLocal.add(l2);
//        listaLocal.add(l3);

        Button btnAdaugaLocal=(Button)findViewById(R.id.btnAddLoc);
        btnAdaugaLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Menu.this,AddLoc.class);
                startActivity(it);
            }
        });


        Button btnCautaLocal=(Button)findViewById(R.id.btnSearchLoc);
        btnCautaLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Conexiune conexiune=new Conexiune(getApplicationContext());
                conexiune.openConnection();
                listaLocal=conexiune.getLocaluri();
                conexiune.closeConnection();
                Intent it=new Intent(Menu.this,SearchLoc.class);
                startActivity(it);
            }
        });


        Button btnBestLocal=(Button)findViewById(R.id.btnBestLoc);
        btnBestLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it=new Intent(Menu.this,GradeGraphic.class);
               startActivity(it);
            }
        });

//        Button btnDelete= (Button)findViewById(R.id.btnPopularLoc);
//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Conexiune conexiune=new Conexiune(getApplicationContext());
//                conexiune.openConnection();
//                conexiune.deleteRow();
//                conexiune.closeConnection();
//            }
//        });




    }
}

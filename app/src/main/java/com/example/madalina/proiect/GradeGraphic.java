package com.example.madalina.proiect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class GradeGraphic extends AppCompatActivity {

     ArrayList<Local> localuri=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Conexiune conexiune=new Conexiune(getApplicationContext());
        conexiune.openConnection();
        localuri=conexiune.getLocaluri();
        conexiune.closeConnection();

        setContentView(new ColumnChartLocals(getApplicationContext(),localuri));
    }
}

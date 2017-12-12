package com.example.madalina.proiect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static int idUtilizator;
    public static String userName=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Conexiune conexiune=new Conexiune(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conexiune.openConnection();
        SharedPreferences sharedPreferences=getPreferences(Context.MODE_PRIVATE);

        ((EditText)findViewById(R.id.ptUser)).setText(sharedPreferences.getString("username",""));
        ((EditText)findViewById(R.id.ptPassword)).setText(sharedPreferences.getString("password",""));


        Button btnContNou = (Button)findViewById(R.id.btnNewUser);
        btnContNou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(MainActivity.this,NewAccount.class);
                startActivity(it);

            }
        });

        Button btnAutentificare=(Button)findViewById(R.id.btnLogIn);
        btnAutentificare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=((EditText)findViewById(R.id.ptUser)).getText().toString();
                String pass=((EditText)findViewById(R.id.ptPassword)).getText().toString();
                if(conexiune.getUtilizator(user,pass)!=null)
                {
                    User userul=conexiune.getUtilizator(user,pass);
                    idUtilizator=userul.getId();
                    userName=userul.getUser();
                    Intent it=new Intent(MainActivity.this,Menu.class);
                    startActivity(it);
                    conexiune.closeConnection();


                    SharedPreferences sp=getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sp.edit();
                    //sharedpref=un fisier unde salvam date
                    editor.putString("username",user);
                    editor.putString("password",pass);
                    editor.commit();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"User sau parola incorecta!",Toast.LENGTH_LONG).show();
                }





            }
        });


    }




}

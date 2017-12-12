package com.example.madalina.proiect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewAccount extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
       final Conexiune conexiune=new Conexiune(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
        conexiune.openConnection();





        Button btnAutentificare=(Button)findViewById(R.id.btnCreateAccount);
        btnAutentificare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editnume=(EditText)findViewById(R.id.ptLastName);
                EditText editprenume=(EditText)findViewById(R.id.ptFirstName);
                EditText edituser=(EditText)findViewById(R.id.ptUserName);
                EditText editmail=(EditText)findViewById(R.id.ptMail);
                EditText editpass=(EditText)findViewById(R.id.ptPasswordProfile);
                EditText editpass2=(EditText)findViewById(R.id.ptPasswordProfile2);

                if(editpass.getText().toString()==null || editpass2.getText().toString()==null )
                {
                    Toast.makeText(getApplicationContext(),"Va rog scrieti parola!",Toast.LENGTH_LONG).show();
                }
                else
                if((editpass.getText().toString()).equals(editpass2.getText().toString())==false )
                {
                    Toast.makeText(getApplicationContext(),"Parola nu coincide cu varianta initiala",Toast.LENGTH_LONG).show();
                }
                else

                {
                    User user=new User(editnume.getText().toString(),editprenume.getText().toString(),edituser.getText().toString()
                    ,editpass.getText().toString(),editmail.getText().toString());
                    conexiune.insereazaUtilizator(user);
                    Toast.makeText(getApplicationContext(),"Inregistrare reusita! Bun venit "+edituser.getText().toString()+"!",Toast.LENGTH_LONG).show();
                    Intent it = new Intent(NewAccount.this, Menu.class);
                    startActivity(it);
                    conexiune.closeConnection();
                }
            }
        });
    }
}

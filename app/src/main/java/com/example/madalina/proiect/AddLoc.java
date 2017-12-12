package com.example.madalina.proiect;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;

public class AddLoc extends AppCompatActivity {

    private ImageButton ImageLocal;
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_loc);

        ImageLocal=(ImageButton)findViewById(R.id.imgUpload);
        ImageLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }


        });


        Button btnAdd=(Button)findViewById(R.id.btnAddNewLoc);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Conexiune conexiune=new Conexiune(getApplicationContext());
             String denumire=((EditText)findViewById(R.id.ptLocName)).getText().toString();
                RadioGroup rgCategorie = (RadioGroup) findViewById(R.id.rgCategory);
                final String value = ((RadioButton)findViewById(rgCategorie.getCheckedRadioButtonId() )).getText().toString();
                String sector=((Spinner)findViewById(R.id.district)).getSelectedItem().toString();
                String strada=((EditText)findViewById(R.id.ptAddStreet)).getText().toString();
                int numar=Integer.parseInt(((EditText)findViewById(R.id.ptAddNumber)).getText().toString());
                String site= ((EditText)findViewById(R.id.ptSite)).getText().toString();
                String desc=((EditText)findViewById(R.id.ptDescription)).getText().toString();

                Adresa adr=new Adresa(sector,strada,numar);


                conexiune.openConnection();
                Local loc=new Local(denumire,desc,site,value,0,adr.toString());
                conexiune.insereazaLocaluri(loc);
                Toast.makeText(getApplicationContext(),denumire+", "+sector+", "+strada+", "+numar+", "+site+", "+value,Toast.LENGTH_SHORT).show();
                conexiune.closeConnection();


            }
        });

    }

    private void selectImage() {

        final CharSequence options[]={"Fotografiez acum!","Imi aleg din galerie!", "Renunt!"};
        AlertDialog.Builder dialog= new AlertDialog.Builder(AddLoc.this);
        dialog.setTitle("Adauga o fotografie");
        dialog.setItems(options,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if(options[item].equals("Fotografiez acum!"))
                {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File f = new File(android.os.Environment.getExternalStorageDirectory(), "Image.jpg");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                    startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);

                }
                else if (options[item].equals("Imi aleg din galerie!"))
                {
                    Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);
                }
                else if (options[item].equals("Renunt!")) {
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }



}

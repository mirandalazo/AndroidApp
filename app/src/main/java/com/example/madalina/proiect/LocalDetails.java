package com.example.madalina.proiect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LocalDetails extends AppCompatActivity {

    public static ArrayList<Review> reviewuri=new ArrayList<Review>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_details);
        final Conexiune conexiune=new Conexiune(getApplicationContext());
        conexiune.openConnection();
//
//        RatingBar ratingBar = (RatingBar)findViewById(R.id.rbRatingUser);
//        ratingBar.setOnTouchListener(new View.OnTouchListener() {
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });
//        ratingBar.setFocusable(false);
//        ratingBar.setEnabled(false);
//
        RatingBar ratingBarM = (RatingBar)findViewById(R.id.rbRatingM);
        ratingBarM.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        ratingBarM.setFocusable(false);
        ratingBarM.setEnabled(false);

      final  int id=getIntent().getExtras().getInt("id");

        Local local=new Local();
        for(Local l:Menu.listaLocal)
        {
            if(l.getId()==id)
                local=l;

        }

        TextView tvNume=(TextView)findViewById(R.id.tvNameM);
        tvNume.setText(local.getDenumire());
        TextView tvCategorie=(TextView)findViewById(R.id.tvCategoryM);
        tvCategorie.setText((local.getTip()));
        TextView tvDesc=(TextView)findViewById(R.id.tvDescriptionM);
        tvDesc.setText(local.getDescriere());
        TextView tvAdresa=(TextView)findViewById(R.id.tvAddressM);
        if(local.getAdresa()!=null)
            tvAdresa.setText(local.getAdresa().toString());
        final TextView tvSite=(TextView)findViewById(R.id.tvSiteM);
        tvSite.setText(local.getSite());
        ratingBarM.setRating(local.getNota());

        reviewuri=(conexiune.getRecenzii(id));
//        for(Review r:Menu.listaLocal.get(id).getRecenzii())
//        {
//            reviewuri.add(r);
//        }
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,reviewuri);
//        ListView lv=(ListView)findViewById(R.id.lvReview);
//        lv.setAdapter(adapter);


        AdaptorReview adaptor=new AdaptorReview(getApplicationContext(),R.layout.activity_local_details,reviewuri);
        ListView v=(ListView) findViewById(R.id.lvReview);
        v.setAdapter(adaptor);
        //Toast.makeText(getApplicationContext(),reviewuri.get(0).getRecenzie(),Toast.LENGTH_LONG).show();

        tvSite.setOnClickListener(new View.OnClickListener() {
              @Override
            public void onClick(View view) {
                Intent it= new Intent(getApplicationContext(),SIteActivity.class);
                it.putExtra("link",tvSite.getText());
                startActivity(it);
            }
        });

        Button btnSite=(Button)findViewById(R.id.btnSite);
        btnSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(LocalDetails.this,SiteDescription.class);
                it.putExtra("link",tvSite.getText());
                startActivity(it);
            }
        });

        Button btnAddRec=(Button)findViewById(R.id.btnAddRec);
        final EditText editrec=(EditText)findViewById(R.id.ptDescription);
        final RatingBar rbRev=(RatingBar)findViewById(R.id.rbRatingUserCurent);
        //rbRev.setRating(int);

        btnAddRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Review r=new Review(editrec.getText().toString(),MainActivity.userName,rbRev.getRating() ,null);
                conexiune.insereazaRecenzii(r,MainActivity.idUtilizator,id);
                reviewuri=(conexiune.getRecenzii(id));
              //  Menu.listaLocal.get(id-1).setRecenzii(reviewuri);
                AdaptorReview adaptor=new AdaptorReview(getApplicationContext(),R.layout.activity_local_details,reviewuri);
                ListView vv=(ListView) findViewById(R.id.lvReview);
                vv.setAdapter(adaptor);
            }
        });

    }
}

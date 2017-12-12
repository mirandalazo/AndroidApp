package com.example.madalina.proiect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RatingBar;

public class ListViewLocal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_local);

        RatingBar ratingBar = (RatingBar)findViewById(R.id.rbLocalNoteList);
        ratingBar.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        ratingBar.setFocusable(false);
        ratingBar.setEnabled(false);
    }
}

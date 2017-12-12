package com.example.madalina.proiect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RatingBar;

public class ListViewReview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_review);

        RatingBar ratingBar2 = (RatingBar)findViewById(R.id.rbRatingUser);
        ratingBar2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        ratingBar2.setFocusable(false);
        ratingBar2.setEnabled(false);
    }
}

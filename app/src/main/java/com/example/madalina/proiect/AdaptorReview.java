package com.example.madalina.proiect;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Madalina on 11/24/2016.
 */

public class AdaptorReview extends ArrayAdapter<Review> {
    public ArrayList<Review> listaR;

    public AdaptorReview(Context context, int resource, ArrayList<Review> lista) {
        super(context, resource,lista);
        this.listaR = lista;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater l=LayoutInflater.from(getContext());
        View v=(View)l.inflate(R.layout.activity_list_view_review,null);

        TextView recenzie=(TextView)v.findViewById(R.id.tvReview);
        TextView utilizator=(TextView)v.findViewById(R.id.tvUserNameRev);
        RatingBar nota=(RatingBar)v.findViewById(R.id.rbRatingUser);

        Review rev=listaR.get(position);
        recenzie.setText(rev.getRecenzie());
        utilizator.setText(rev.getUtilizator());
        nota.setRating(rev.getNota());

        return v;
    }
}

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

public class AdaptorLocal extends ArrayAdapter<Local> {

   public ArrayList<Local> lista;

    public AdaptorLocal(Context context, int resource, ArrayList<Local> arrayLocal) {
        super(context, resource,arrayLocal);
        lista = arrayLocal;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // return super.getView(position, convertView, parent);

        LayoutInflater li= LayoutInflater.from(getContext());
        View lvLocal= (View)li.inflate(R.layout.activity_list_view_local,null);

        TextView tvDenumire=(TextView)lvLocal.findViewById(R.id.tvLocalNameList);
        TextView tvTip=(TextView)lvLocal.findViewById(R.id.tvLocalTypeList);
        RatingBar rbNota=(RatingBar)lvLocal.findViewById(R.id.rbLocalNoteList);

        Local local=lista.get(position);
        tvDenumire.setText(local.getDenumire());
        tvTip.setText(local.getTip());
        rbNota.setRating(local.getNota());

        return lvLocal;

    }
}

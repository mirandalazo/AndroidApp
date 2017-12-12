package com.example.madalina.proiect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Madalina on 12/22/2016.
 */

public class ColumnChartLocals extends View {

    private ArrayList<Local> lista;
    public ColumnChartLocals(Context context, ArrayList<Local> locals) {
        super(context);
        this.lista=locals;

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



        float max=0;
        for(int i=0;i<lista.size();i++) {
            if(max<lista.get(i).getNota());
            max=lista.get(i).getNota();
        }

        int latimeLocal=canvas.getWidth()/lista.size();

        for(int i=0;i<lista.size();i++){
            int inalt=Math.round(canvas.getHeight()*9/10*lista.get(i).getNota()/max);
            ShapeDrawable sp=new ShapeDrawable(new RectShape());
            sp.setBounds(i*latimeLocal,canvas.getHeight()*9/10-inalt,latimeLocal+i*latimeLocal,canvas.getHeight()*9/10);

            sp.getPaint().setColor(Color.rgb((i*125)%256,(i*23)%256,((i+56)*10)%256));
            sp.getPaint().setTextSize(30);

            canvas.drawText(lista.get(i).getDenumire(),i*latimeLocal,canvas.getHeight()*95/100,sp.getPaint());

            sp.draw(canvas);



        }
    }
}

package com.example.madalina.proiect;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.webkit.ConsoleMessage;
import android.widget.Toast;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Madalina on 12/21/2016.
 */

public class Conexiune {

    private Context ctx;
    private DataBaseHelper helper;
//    private int id_user;
//    private int id_local;
    SQLiteDatabase db;

    public  Conexiune(Context ctx) {

        this.ctx = ctx;
        helper = new DataBaseHelper(ctx);


    }

    public void openConnection() {
        db=helper.getWritableDatabase();
    }

    public void closeConnection(){
        db.close();
        helper.close();
    }

    public void insereazaUtilizator(User u){
        ContentValues cv=new ContentValues();
        cv.put("nume",u.getNume());
        cv.put("prenume",u.getPrenume());
        cv.put("user",u.getUser());
        cv.put("parola",u.getParola());
        cv.put("mail",u.getMail());
        cv.put("poza", String.valueOf(u.getPoza()));
        db.insert("users",null,cv);
    }

    public void insereazaLocaluri(Local local){
        ContentValues cv=new ContentValues();
        cv.put("nume",local.getDenumire());
        cv.put("descriere",local.getDescriere());
        cv.put("site",local.getSite());
        cv.put("tip",local.getTip());
        cv.put("adresa",local.getAdresa().toString());
        cv.put("poza", String.valueOf(local.getPoza()));
        db.insert("locals",null,cv);
    }

    public void deleteRow()
    {

       // db.execSQL("DELETE FROM recenzii ");
        db.execSQL("DROP TABLE IF EXISTS utilizatori" );
        db.execSQL("DROP TABLE IF EXISTS localuri");
        db.execSQL("DROP TABLE IF EXISTS recenzii" );


    }


    public void insereazaRecenzii(Review r, int idU, int idL){
        ContentValues cv=new ContentValues();
        cv.put("recenzie",r.getRecenzie());
        cv.put("nota",r.getNota());
        cv.put("id_user",idU);
        cv.put("id_local",idL);

        db.insert("reviews",null,cv);
    }



    User getUtilizatori(int idU)
    {
        User user=null;
        Cursor cursor =db.query("users",
                new String[]{"nume","prenume","user","parola","mail"},
                "id=?",new String[]{""+idU},null,null,null);


        if(cursor.moveToFirst()) {
            do {
                user = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));

            }
            while (cursor.moveToNext());
        }
        return  user;
    }

    User getUtilizator(String userr, String parola)
    {

        User user=null;
        Cursor cursor =db.query("users",
                new String[]{"id","nume","prenume","user","parola","mail"},
                "user=? AND parola=?" ,new String[]{userr,parola},null,null,null);


        if(cursor.moveToFirst())
        {
            user=new User(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getInt(0));


        }

            return  user;
    }


    ArrayList<Review> getRecenzii(int idL)
    {
        ArrayList<Review> lista=new ArrayList<Review>();
        Cursor cursor =db.query("reviews",
                new String[]{"recenzie","nota","id_user","id_local"},
                "id_local=?",new String[]{""+idL},
                null,null,null);



        if(cursor.moveToFirst()) {
            cursor.moveToFirst();
            do {
                String nume_u=null;
                int id_u = cursor.getInt(2);
                if(getUtilizatori(id_u)!=null)
                     nume_u = getUtilizatori(id_u).getNume();
                lista.add(new Review(cursor.getString(0), nume_u, cursor.getFloat(1), null));

            }
            while (cursor.moveToNext());
        }

        return  lista;
    }


    ArrayList<Local> getLocaluri()
    {
        ArrayList<Local> lista=new ArrayList<Local>();
        Cursor cursor =db.query("locals",
                new String[]{"id","nume","descriere","site","tip","adresa"},
                null,null,null,null,null);
        if(cursor.moveToFirst())

        {
            cursor.moveToFirst();
            do {
                int idL=cursor.getInt(0);
                ArrayList<Review> recenzii = null;
               recenzii= getRecenzii(idL);

                if(recenzii.size()!=0) {
                    float nota = 0;
                    for (Review r : recenzii) {
                        nota += r.getNota();
                    }
                    nota = nota / recenzii.size();
                    lista.add(new Local(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), nota, cursor.getString(5), recenzii,cursor.getInt(0)));
                }
                else
                {
                    lista.add(new Local(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), 0, cursor.getString(5),cursor.getInt(0)));
                }

            }
            while (cursor.moveToNext());
        }
        return  lista;
    }



    ArrayList<Local> getLocaluriAlfabetic()
    {
        ArrayList<Local> lista=new ArrayList<Local>();
        Cursor cursor =db.query("locals",
                new String[]{"id","nume","descriere","site","tip","adresa"},
                null,null,null,null,"nume");
        if(cursor.moveToFirst())

        {
            cursor.moveToFirst();
            do {
                int idL=cursor.getInt(0);
                ArrayList<Review> recenzii = null;
                recenzii= getRecenzii(idL);

                if(recenzii.size()!=0) {
                    float nota = 0;
                    for (Review r : recenzii) {
                        nota += r.getNota();
                    }
                    nota = nota / recenzii.size();
                    lista.add(new Local(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), nota, cursor.getString(5), recenzii,cursor.getInt(0)));
                }
                else
                {
                    lista.add(new Local(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), 0, cursor.getString(5),cursor.getInt(0)));
                }

            }
            while (cursor.moveToNext());
        }
        return  lista;
    }


    ArrayList<Local> getLocaluriTip(String tip)
    {
        ArrayList<Local> lista=new ArrayList<Local>();
        Cursor cursor =db.query("locals",
                new String[]{"id","nume","descriere","site","tip","adresa"},
                "tip=?",new String[]{""+tip} ,null,null,null);
        if(cursor.moveToFirst())

        {
            cursor.moveToFirst();
            do {
                int idL=cursor.getInt(0);
                ArrayList<Review> recenzii = null;
                recenzii= getRecenzii(idL);

                if(recenzii.size()!=0) {
                    float nota = 0;
                    for (Review r : recenzii) {
                        nota += r.getNota();
                    }
                    nota = nota / recenzii.size();
                    lista.add(new Local(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), nota, cursor.getString(5), recenzii,cursor.getInt(0)));
                }
                else
                {
                    lista.add(new Local(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), 0, cursor.getString(5),cursor.getInt(0)));
                }

            }
            while (cursor.moveToNext());
        }
        return  lista;
    }



    ArrayList<Local> getLocaluriZona(String zona)
    {
        ArrayList<Local> lista=new ArrayList<Local>();
        Cursor cursor =db.query("locals",
                new String[]{"id","nume","descriere","site","tip","adresa"},
                null,null,null,null,null);
        if(cursor.moveToFirst())

        {
            cursor.moveToFirst();
            do {
                int idL=cursor.getInt(0);
                ArrayList<Review> recenzii = null;
                recenzii= getRecenzii(idL);

                if(cursor.getString(5).contains(zona))

                {
                    if (recenzii.size() != 0) {
                        float nota = 0;
                        for (Review r : recenzii) {
                            nota += r.getNota();
                        }
                        nota = nota / recenzii.size();

                        lista.add(new Local(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), nota, cursor.getString(5), recenzii, cursor.getInt(0)));
                    } else {
                        lista.add(new Local(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), 0, cursor.getString(5), cursor.getInt(0)));
                    }
                }

            }
            while (cursor.moveToNext());
        }
        return  lista;
    }
    }

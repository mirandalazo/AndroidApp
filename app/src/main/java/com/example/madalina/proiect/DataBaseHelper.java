package com.example.madalina.proiect;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Madalina on 12/21/2016.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "NightOut";
    private static final String TABLE_UTILIZATORI = "users";
    private static final String TABLE_LOCALURI = "locals";
    private static final String TABLE_RECENZII = "reviews";

    private static final String CREATE_TABLE_UTILIZATORI = "create table if not exists "
            +  TABLE_UTILIZATORI+ "(id integer primary key autoincrement, nume text not null, prenume text not null," +
            "user text not null, parola text , mail text, poza blob )";

    private static final String CREATE_TABLE_LOCALURI = "create table if not exists "
            +  TABLE_LOCALURI+ "(id integer primary key autoincrement, nume text not null, descriere text," +
            "site text, tip text not null, adresa text, poza blob )";

    private static final String CREATE_TABLE_RECENZII = "create table if not exists "
            +  TABLE_RECENZII+ "(id integer primary key autoincrement, recenzie text not null, nota real not null," +
            "id_user integer, id_local integer, foreign key(id_user) references "+TABLE_UTILIZATORI+"(id), " +
            " foreign key(id_local) references "+TABLE_LOCALURI+"(id))";



    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_UTILIZATORI);
        db.execSQL(CREATE_TABLE_LOCALURI);
        db.execSQL(CREATE_TABLE_RECENZII);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UTILIZATORI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCALURI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECENZII);

        onCreate(db);

    }
}

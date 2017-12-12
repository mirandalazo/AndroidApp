package com.example.madalina.proiect;

import android.graphics.Bitmap;

/**
 * Created by Madalina on 11/24/2016.
 */

public class Review {
    private int id;
    private String recenzie;
    private String utilizator;
    private float nota;
    private Bitmap poza;

    public Review(int id,String recenzie, String utilizator, float nota, Bitmap poza) {
        this.id=id;
        this.recenzie = recenzie;
        this.utilizator = utilizator;
        this.nota = nota;
        this.poza = poza;
    }

    public Review(String recenzie, String utilizator, float nota, Bitmap poza) {
        this.recenzie = recenzie;
        this.utilizator = utilizator;
        this.nota = nota;
        this.poza = poza;
    }

    public int getId() {
        return id;
    }

    public String getRecenzie() {
        return recenzie;
    }

    public String getUtilizator() {
        return utilizator;
    }

    public float getNota() {
        return nota;
    }

    public Bitmap getPoza() {
        return poza;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRecenzie(String recenzie) {
        this.recenzie = recenzie;
    }

    public void setUtilizator(String utilizator) {
        this.utilizator = utilizator;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public void setPoza(Bitmap poza) {
        this.poza = poza;
    }

    @Override
    public String toString() {
        return "Review{" +
                ", recenzie='" + recenzie + '\'' +
                ", utilizator='" + utilizator + '\'' +
                ", nota=" + nota +
                '}';
    }
}

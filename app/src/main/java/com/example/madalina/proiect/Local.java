package com.example.madalina.proiect;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by Madalina on 11/24/2016.
 */

public class Local {

    private String denumire;
    private String descriere;
    private String site;
    private Bitmap poza;
    private String tip;
    private float nota;
    private String adresa;
    private  int id;
    private ArrayList<Review> recenzii;

    public Local() {
        id=0;
    }

    public Local( String denumire, String descriere, String site, String tip, float nota,String adresa) {

        this.denumire = denumire;
        this.descriere = descriere;
        this.site = site;
        this.tip = tip;
        this.adresa=adresa;
        this.nota=nota;
        this.recenzii=new ArrayList<Review>();

    }

    public Local( String denumire, String descriere, String site, String tip, float nota,String adresa,int id) {

        this.denumire = denumire;
        this.descriere = descriere;
        this.site = site;
        this.tip = tip;
        this.adresa=adresa;
        this.nota=nota;
        this.recenzii=new ArrayList<Review>();
        this.id=id;
    }


    public Local(String denumire, String descriere, String site, String tip, float nota, String adresa, ArrayList<Review> recenzii,int id) {
        this.denumire = denumire;
        this.descriere = descriere;
        this.site = site;
        this.tip = tip;
        this.nota = nota;
        this.adresa = adresa;
        this.recenzii = recenzii;
        this.id=id;
}

    public void setRecenzii(ArrayList<Review> recenzii) {
        this.recenzii = recenzii;
    }

    public ArrayList<Review> getRecenzii() {
        return recenzii;
    }

    public int getId() {
        return id;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public float getNota() {
        return nota;
    }

    public String getDenumire() {
        return denumire;
    }

    public String getDescriere() {
        return descriere;
    }

    public String getSite() {
        return site;
    }

    public String getTip() {
        return tip;
    }

    public Bitmap getPoza() {
        return poza;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setPoza(Bitmap poza) {
        this.poza = poza;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }


    @Override
    public String toString() {
        return "Local{" +
                "denumire='" + denumire + '\'' +
                ", descriere='" + descriere + '\'' +
                ", site='" + site + '\'' +
                ", tip='" + tip + '\'' +
                ", nota=" + nota +
                ", adresa=" + adresa +
                '}';
    }
}

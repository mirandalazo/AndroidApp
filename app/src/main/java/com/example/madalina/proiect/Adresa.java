package com.example.madalina.proiect;

/**
 * Created by Madalina on 11/24/2016.
 */

public class Adresa {
    private String sector;
    private String strada;
    private int numar;

    public Adresa(String sector, String strada, int numar) {
        this.sector = sector;
        this.strada = strada;
        this.numar = numar;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public String getSector() {
        return sector;
    }

    public String getStrada() {
        return strada;
    }

    public int getNumar() {
        return numar;
    }

    @Override
    public String toString() {
        return
                "Sector " + sector  +
                ", str. '" + strada +
                ", nr. " + numar ;
    }
}

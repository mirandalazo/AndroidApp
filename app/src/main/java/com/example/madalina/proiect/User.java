package com.example.madalina.proiect;

import android.graphics.Bitmap;

/**
 * Created by Madalina on 12/21/2016.
 */

public class User {
    private String nume;
    private String prenume;
    private String parola;
    private String mail;
    private String user;
    private Bitmap poza;
    private int id;

    public User(String nume, String prenume, String user, String parola, String mail) {
        this.nume = nume;
        this.prenume = prenume;
        this.user = user;
        this.parola = parola;
        this.mail = mail;
    }

    public User(String nume, String prenume, String user, String parola, String mail,int id) {
        this.nume = nume;
        this.prenume = prenume;
        this.user = user;
        this.parola = parola;
        this.mail = mail;
        this.id=id;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getParola() {
        return parola;
    }

    public String getMail() {
        return mail;
    }

    public String getUser() {
        return user;
    }

    public Bitmap getPoza() {
        return poza;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPoza(Bitmap poza) {
        this.poza = poza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", parola='" + parola + '\'' +
                ", mail='" + mail + '\'' +
                ", user='" + user + '\'' +
                ", poza=" + poza +
                '}';
    }
}

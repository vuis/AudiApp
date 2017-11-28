package com.example.marco.audirs7;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marco on 5.4.2016..
 */
public class Korisnik implements Parcelable {
    private String ime;
    private String prezime;
    private String email;
    private String grad;

    @Override
    public int describeContents() {
        int result = ime.hashCode();
        return result;
    }

    public Korisnik(String ime, String prezime, String email, String grad) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.grad = grad;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        List<Object> listaObjekata = new ArrayList<Object>();
        listaObjekata.add(ime);
        listaObjekata.add(prezime);
        listaObjekata.add(email);
        listaObjekata.add(grad);
        dest.writeList(listaObjekata);
    }

    public static final Creator<Korisnik> CREATOR = new Creator<Korisnik>() {
        @Override
        public Korisnik createFromParcel(Parcel source) {
            return new Korisnik(source);
        }

        @Override
        public Korisnik[] newArray(int size) {
            return new Korisnik[size];
        }

    };

    public Korisnik(Parcel source) {
        List<Object> objektiKlase = new ArrayList<Object>();
        source.readList(objektiKlase, null);
        this.ime = (String) objektiKlase.get(0);
        this.prezime = (String) objektiKlase.get(1);
        this.email = (String) objektiKlase.get(2);
        this.grad = (String) objektiKlase.get(3);
    }
}

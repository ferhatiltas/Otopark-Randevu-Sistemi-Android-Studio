package com.ferhatiltas.mycarpark;

public class Model {
    String id,ad,kAd,email,sifre;

    public Model() {

    }

    public Model(String id, String ad, String kAd, String email, String sifre) {
        this.id = id;
        this.ad = ad;
        this.kAd = kAd;
        this.email = email;
        this.sifre = sifre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getkAd() {
        return kAd;
    }

    public void setkAd(String kAd) {
        this.kAd = kAd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}

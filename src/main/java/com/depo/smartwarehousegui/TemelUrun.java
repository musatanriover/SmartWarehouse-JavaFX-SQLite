package com.depo.smartwarehousegui;

public abstract class TemelUrun implements Urun {
    private String ad;
    private double fiyat;
    private int stokAdedi;

    public TemelUrun(String ad, double fiyat, int stokAdedi) {
        this.ad = ad;
        this.fiyat = fiyat;
        this.stokAdedi = stokAdedi;
    }

    @Override
    public String getAd() {
        return ad;
    }

    @Override
    public double getFiyat() {
        return fiyat;
    }

    @Override
    public int getStokAdedi() {
        return stokAdedi;
    }

    @Override
    public void stokAzalt(int adet) {
        if (this.stokAdedi >= adet) {
            this.stokAdedi -= adet;
        }
    }
}
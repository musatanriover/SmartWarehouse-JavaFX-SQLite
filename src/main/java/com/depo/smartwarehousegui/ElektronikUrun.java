package com.depo.smartwarehousegui;

public class ElektronikUrun extends TemelUrun {
    private int garantiSuresiAy;

    public ElektronikUrun(String ad, double fiyat, int stokAdedi, int garantiSuresiAy) {
        super(ad, fiyat, stokAdedi);
        this.garantiSuresiAy = garantiSuresiAy;
    }

    @Override
    public double kdvDahilFiyatHesapla() {
        return getFiyat() * 1.20; // %20 KDV
    }

    public int getGarantiSuresiAy() {
        return garantiSuresiAy;
    }
}
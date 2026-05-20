package com.depo.smartwarehousegui;

public interface Urun {
    String getAd();
    double getFiyat();
    int getStokAdedi();
    void stokAzalt(int adet);
    double kdvDahilFiyatHesapla();
}
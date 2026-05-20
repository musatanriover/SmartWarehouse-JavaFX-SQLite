package com.depo.smartwarehousegui;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField urunAdiField;

    @FXML
    private TextField adetField;

    @FXML
    private TextArea bilgiEkrani;

    private DepoYonetici yonetici;

    @FXML
    public void initialize() {

        VeritabaniYardimcisi.tablolariOlustur();

        VeritabaniYardimcisi.veritabaninaUrunEkle(new ElektronikUrun("Asus ROG Laptop", 30000, 5, 24));
        VeritabaniYardimcisi.veritabaninaUrunEkle(new ElektronikUrun("İphone 15 Pro", 60000, 3, 12));

        yonetici = new DepoYonetici();


        bilgiEkrani.appendText("Sistem Başlatıldı. Veritabanı bağlantısı aktif.\n");
        bilgiEkrani.appendText(("-----------------------------------------------\n"));
    }

    @FXML
    protected void onSiparisVerButtonClick() {

        String urunAdi = urunAdiField.getText();
        String adetMetni = adetField.getText();

        if (urunAdi.isEmpty() || adetMetni.isEmpty()) {
            bilgiEkrani.appendText("X HATA: Lütfen ürün adı ve adet giriniz!\n");
            return;
        }

        try {

            int adet = Integer.parseInt(adetMetni);

            yonetici.siparisAl(urunAdi, adet);

            bilgiEkrani.appendText("BAŞARILI: " + adet + " adet '" + urunAdi + "' siparişi alındı.\n");

        } catch (NumberFormatException e) {
            bilgiEkrani.appendText("X HATA: Adet kısmına sadece rakam giriniz!\n" + e.getMessage() + "\n");
        } catch (StokYetersizException e) {
            bilgiEkrani.appendText("STOK HATASI: " + e.getMessage() + "\n");
        } catch (UrunBulunamadiException e) {
            bilgiEkrani.appendText("ÜRÜN HATASI: " + e.getMessage() + "\n");
        }

        urunAdiField.clear();
        adetField.clear();
    }
}
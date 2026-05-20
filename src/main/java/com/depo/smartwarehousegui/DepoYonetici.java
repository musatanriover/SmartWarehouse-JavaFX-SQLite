package com.depo.smartwarehousegui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepoYonetici {

    public void siparisAl(String urunAdi, int adet) throws UrunBulunamadiException, StokYetersizException {
        String bulSorgu = "SELECT stok_adedi FROM urunler WHERE ad = ?";

        String guncelleSorgu = "UPDATE urunler SET stok_adedi = stok_adedi - ? WHERE ad = ?";

        try (Connection conn = VeritabaniYardimcisi.baglantiKur();
            PreparedStatement bulStmt = conn.prepareStatement(bulSorgu)){

            bulStmt.setString(1, urunAdi);
            ResultSet rs = bulStmt.executeQuery();

            if (!rs.next()) {
                throw new UrunBulunamadiException("'" + urunAdi + "' isimli ürün veritabanında bulunamadı!");
            }

            int mevcutStok = rs.getInt("stok_adedi");

            if (mevcutStok < adet) {
                throw new StokYetersizException(urunAdi + " için stok yetersiz. Veritabanıdaki Mevcut Stok: " + mevcutStok);
            }

            try (PreparedStatement guncelleStmt = conn.prepareStatement(guncelleSorgu)){
                guncelleStmt.setInt(1, adet);
                guncelleStmt.setString(2, urunAdi);
                guncelleStmt.executeUpdate();

            }
        } catch (SQLException e) {
            System.out.println(" Veritabanı işlem hatası: " + e.getMessage());
        }
    }
}
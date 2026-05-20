package com.depo.smartwarehousegui;

import java.sql.*;

public class VeritabaniYardimcisi {

    private static final String URL = "jdbc:sqlite:depo.db";

    public static Connection baglantiKur() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Veritabanı bağlantı hatası: " + e.getMessage());
        }
        return conn;
    }

    public static void tablolariOlustur() {
        String sql = "CREATE TABLE IF NOT EXISTS urunler (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " ad TEXT NOT NULL,\n"
                + " fiyat REAL NOT NULL,\n"
                + " stok_adedi INTEGER NOT NULL,\n"
                + " garanti_ay INTEGER\n"
                + ")";

        try (Connection conn = baglantiKur();
             Statement stmt = conn.createStatement()){

            stmt.execute(sql);
            System.out.println(" Veritabanı ve tablolar hazır!");
        } catch (SQLException e) {
            System.out.println(" Tablo oluşturma hatası: " + e.getMessage());
        }
    }

    public static void veritabaninaUrunEkle(Urun urun) {

        String sql = "INSERT INTO urunler (ad, fiyat, stok_adedi) VALUES (?, ?, ?)";

        try (Connection conn = baglantiKur();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, urun.getAd());
            pstmt.setDouble(2, urun.getFiyat());
            pstmt.setInt(3, urun.getStokAdedi());

            pstmt.executeUpdate();
            System.out.println(" Veritabanı başarıyla kaydedildi: " + urun.getAd());
        } catch (SQLException e) {
            System.out.println(" Kayıt hatası (ürün zaten var olabilir): " + e.getMessage());
        }

    }
}
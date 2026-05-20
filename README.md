# Akıllı Depo Yönetim Sistemi 📦

Bu proje, Nesne Yönelimli Programlama (OOP) prensipleri ve modern veritabanı mimarisi kullanılarak geliştirilmiş bir masaüstü stok ve sipariş yönetim uygulamasıdır. Arka uç süreçlerinde hataya dayanıklı bir sistem kurgulanmış ve veritabanı güvenliği ön planda tutulmuştur.

## 🚀 Öne Çıkan Özellikler

* **Kalıcı ve Gömülü Veritabanı:** Veriler geçici bellekte (RAM) değil, sisteme entegre hafif bir SQLite veritabanında (`depo.db`) güvenle ve kalıcı olarak tutulur. Harici bir sunucu kurulumu gerektirmez.
* **SQL Injection Koruması:** Veritabanı ile haberleşen tüm sorgularda `PreparedStatement` mimarisi kullanılarak üst düzey güvenlik sağlanmıştır.
* **Özel Hata Yönetimi (Exception Handling):** Stok yetersizliği veya veritabanında bulunmayan ürün sorguları gibi uç durumlar için sisteme özel Exception sınıfları (Custom Exceptions) tasarlanmış ve çökme riskleri ortadan kaldırılmıştır.
* **Modern Masaüstü Arayüzü:** JavaFX teknolojisi ile geliştirilen sade, hızlı ve kullanıcı dostu bir kontrol paneli sunar.

## 🛠️ Kullanılan Teknolojiler

* **Programlama Dili:** Java
* **Arayüz (GUI):** JavaFX
* **Veritabanı Motoru:** SQLite
* **Veritabanı Köprüsü:** JDBC (Java Database Connectivity)
* **Bağımlılık Yönetimi:** Maven

## ⚙️ Kurulum ve Çalıştırma

Projeyi yerel makinenizde test etmek için aşağıdaki adımları izleyebilirsiniz:

1. Projeyi bilgisayarınıza klonlayın:
   ```bash
   git clone [https://github.com/musatanriover/SmartWarehouse-JavaFX-SQLite.git](https://github.com/musatanriover/SmartWarehouse-JavaFX-SQLite.git)

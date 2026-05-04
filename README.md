# 📚 Kütüphane Yönetim Sistemi - Veritabanı Tasarımı

Bu proje, bir kütüphane sisteminin temel işleyişini modellemek amacıyla PostgreSQL kullanılarak geliştirilmiş bir veritabanı yönetim sistemidir. Proje kapsamında tablo yapıları (DDL), veri manipülasyonları (DML) ve örnek sorgular yer almaktadır.

## 🛠 Kullanılan Teknolojiler
* **Veritabanı:** PostgreSQL
* **Araçlar:** pgAdmin 4, VS Code
* **Dil:** SQL (Structured Query Language)

## 📊 Veritabanı Tasarımı (ER Diyagramı)

Veritabanı tasarımı yapılırken ilişkisel model prensiplerine sadık kalınmıştır. Tablolar arasındaki anahtar (Foreign Key) bağlantıları ile veri bütünlüğü sağlanmıştır.

> **Not:** Hazırladığım ER diyagramına aşağıdan ulaşabilirsiniz:

<img width="1343" height="1386" alt="image" src="https://github.com/user-attachments/assets/d522725e-2eae-43a8-82ec-db7ec48e9882" />

---

## 📖 SQL Kavramları Hakkında Bilgi

Bu projede kullanılan temel SQL bileşenleri aşağıda açıklanmıştır:

### 1. DDL (Data Definition Language - Veri Tanımlama Dili)
Veritabanının yapısını oluşturmak ve değiştirmek için kullanılır.
* **CREATE:** Yeni tablolar ve veritabanı oluşturur.
* **ALTER:** Mevcut tabloların yapısında (kolon ekleme/silme) değişiklik yapar.

### 2. DML (Data Manipulation Language - Veri İşleme Dili)
Tablo içerisindeki veriler üzerinde işlem yapmak için kullanılır.
* **INSERT:** Tabloya yeni veriler ekler.
* **UPDATE:** Mevcut verileri günceller.
* **DELETE:** Verileri siler.

### 3. DQL (Data Query Language - Veri Sorgulama Dili)
Veritabanından bilgi çekmek ve analiz yapmak için kullanılır.
* **SELECT:** Verileri listeler.
* **WHERE:** Belirli kriterlere göre filtreleme yapar.
* **LIKE / ILIKE:** Metin bazlı arama (maskeleme) yapar.
* **Aggregate Functions:** `COUNT`, `SUM`, `AVG`, `MIN`, `MAX` gibi fonksiyonlarla hesaplamalar yapar.

---

## 🚀 Proje İçeriği

Proje içerisinde aşağıdaki tablolar ve aralarındaki ilişkiler tanımlanmıştır:
- **ogrenciler**: Üye öğrencilerin kayıtları (Ad, Soyad, Bölüm vb.).
- **kitaplar**: Kütüphane envanterindeki eserler ve stok durumları.
- **gorevliler**: İşlemleri yürüten personel bilgileri.
- **odunc_islemleri**: Hangi öğrencinin hangi kitabı aldığını takip eden merkezi tablo.
- **cezalar**: Gecikmiş iadeler için uygulanan yaptırımlar.

---

## 💻 Kurulum ve Kullanım

1. Bu repoyu bilgisayarınıza indirin.
2. `kutuphane_sistemi.sql` dosyasını pgAdmin 4 veya tercih ettiğiniz bir SQL editörü ile açın.
3. Sorguları sırasıyla çalıştırarak tabloları oluşturun ve örnek verileri yükleyin.

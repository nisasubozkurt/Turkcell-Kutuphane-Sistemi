CREATE TABLE gorevliler (
    id SERIAL PRIMARY KEY,
    ad VARCHAR(50) NOT NULL,
    soyad VARCHAR(50) NOT NULL,
    unvan VARCHAR(50),
    email VARCHAR(100) UNIQUE
);

CREATE TABLE ogrenciler (
    id SERIAL PRIMARY KEY,
    ad VARCHAR(50) NOT NULL,
    soyad VARCHAR(50) NOT NULL,
    ogrenci_no VARCHAR(20) UNIQUE NOT NULL,
    bolum VARCHAR(100),
    kayit_tarihi TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE kitaplar (
    id SERIAL PRIMARY KEY,
    baslik VARCHAR(200) NOT NULL,
    yazar VARCHAR(100) NOT NULL,
    isbn VARCHAR(20) UNIQUE,
    sayfa_sayisi INT,
    stok_adedi INT DEFAULT 1
);

CREATE TABLE odunc_islemleri (
    id SERIAL PRIMARY KEY,
    kitap_id INTEGER NOT NULL,
    ogrenci_id INTEGER NOT NULL,
    gorevli_id INTEGER NOT NULL,
    verilis_tarihi DATE DEFAULT CURRENT_DATE,
    teslim_tarihi DATE, -- Planlanan teslim tarihi
    iade_tarihi DATE,   -- Gerçekleşen iade tarihi
    FOREIGN KEY (kitap_id) REFERENCES kitaplar(id),
    FOREIGN KEY (ogrenci_id) REFERENCES ogrenciler(id),
    FOREIGN KEY (gorevli_id) REFERENCES gorevliler(id)
);


CREATE TABLE cezalar (
    id SERIAL PRIMARY KEY,
    ogrenci_id INTEGER NOT NULL,
    odunc_id INTEGER NOT NULL,
    miktar DECIMAL(10, 2) NOT NULL,
    odeme_durumu BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (ogrenci_id) REFERENCES ogrenciler(id),
    FOREIGN KEY (odunc_id) REFERENCES odunc_islemleri(id)
);


INSERT INTO ogrenciler (ad, soyad, ogrenci_no, bolum) VALUES ('Nisasu', 'Bozkurt', '20261001', 'Yazılım Mühendisliği');
INSERT INTO ogrenciler (ad, soyad, ogrenci_no, bolum) VALUES ('Su', 'Bozkurt', '20261002', 'Bilgisayar Mühendisliği');
INSERT INTO ogrenciler (ad, soyad, ogrenci_no, bolum) VALUES ('Can', 'Yılmaz', '20261003', 'Hukuk');
INSERT INTO ogrenciler (ad, soyad, ogrenci_no, bolum) VALUES ('Elif', 'Demir', '20261004', 'Mimarlık');
INSERT INTO ogrenciler (ad, soyad, ogrenci_no, bolum) VALUES ('Mert', 'Akın', '20261005', 'Tıp');

UPDATE ogrenciler SET bolum = 'Yapay Zeka Mühendisliği' WHERE ad = 'Su';

INSERT INTO gorevliler (ad, soyad, unvan) VALUES ('Hasan', 'Çetin', 'Kütüphane Müdürü');
INSERT INTO gorevliler (ad, soyad, unvan) VALUES ('Derya', 'Sönmez', 'Memur');
INSERT INTO gorevliler (ad, soyad, unvan) VALUES ('Murat', 'Güler', 'Arşiv Sorumlusu');
INSERT INTO gorevliler (ad, soyad, unvan) VALUES ('Selin', 'Işık', 'Gece Vardiyası Sorumlusu');
INSERT INTO gorevliler (ad, soyad, unvan) VALUES ('Burak', 'Turan', 'Stajyer');

SELECT * FROM gorevliler WHERE unvan = 'Kütüphane Müdürü';

INSERT INTO kitaplar (baslik, yazar, isbn, sayfa_sayisi, stok_adedi) VALUES ('Java Programming', 'Herbert Schildt', '111222', 800, 10);
INSERT INTO kitaplar (baslik, yazar, isbn, sayfa_sayisi, stok_adedi) VALUES ('Veritabanı Sistemleri', 'Ramez Elmasri', '333444', 500, 3);
INSERT INTO kitaplar (baslik, yazar, isbn, sayfa_sayisi, stok_adedi) VALUES ('Nutuk', 'Mustafa Kemal Atatürk', '555666', 600, 15);
INSERT INTO kitaplar (baslik, yazar, isbn, sayfa_sayisi, stok_adedi) VALUES ('Temiz Kod', 'Robert C. Martin', '777888', 460, 5);
INSERT INTO kitaplar (baslik, yazar, isbn, sayfa_sayisi, stok_adedi) VALUES ('Küçük Prens', 'Antoine de Saint-Exupéry', '999000', 100, 20);

SELECT * FROM kitaplar ORDER BY sayfa_sayisi DESC LIMIT 1;

INSERT INTO odunc_islemleri (kitap_id, ogrenci_id, gorevli_id, verilis_tarihi) VALUES (1, 1, 2, '2026-04-01');
INSERT INTO odunc_islemleri (kitap_id, ogrenci_id, gorevli_id, verilis_tarihi) VALUES (4, 2, 2, '2026-04-05');
INSERT INTO odunc_islemleri (kitap_id, ogrenci_id, gorevli_id, verilis_tarihi) VALUES (2, 3, 1, '2026-04-10');
INSERT INTO odunc_islemleri (kitap_id, ogrenci_id, gorevli_id, verilis_tarihi) VALUES (3, 4, 3, '2026-04-15');
INSERT INTO odunc_islemleri (kitap_id, ogrenci_id, gorevli_id, verilis_tarihi, iade_tarihi) VALUES (5, 5, 4, '2026-04-10', '2026-04-20');

SELECT * FROM odunc_islemleri WHERE iade_tarihi IS NULL;

INSERT INTO cezalar (ogrenci_id, odunc_id, miktar) VALUES (1, 1, 50.00);
INSERT INTO cezalar (ogrenci_id, odunc_id, miktar) VALUES (2, 2, 25.50);
INSERT INTO cezalar (ogrenci_id, odunc_id, miktar, odeme_durumu) VALUES (3, 3, 10.00, TRUE);
INSERT INTO cezalar (ogrenci_id, odunc_id, miktar) VALUES (4, 4, 100.00);
INSERT INTO cezalar (ogrenci_id, odunc_id, miktar) VALUES (1, 1, 15.00);

SELECT SUM(miktar) FROM cezalar;

SELECT * FROM ogrenciler WHERE ad ILIKE '%su%';
SELECT * FROM ogrenciler WHERE bolum LIKE '%Mühendisliği';
SELECT COUNT(*) FROM kitaplar WHERE sayfa_sayisi > 500;
SELECT SUM(miktar) FROM cezalar WHERE odeme_durumu = FALSE;
SELECT baslik, yazar, sayfa_sayisi FROM kitaplar ORDER BY sayfa_sayisi DESC;
SELECT * FROM ogrenciler WHERE soyad = 'Bozkurt';
SELECT MIN(miktar) FROM cezalar;
SELECT DISTINCT unvan FROM gorevliler ORDER BY unvan ASC;


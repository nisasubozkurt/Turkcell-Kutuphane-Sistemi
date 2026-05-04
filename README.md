# 📚 Kütüphane Yönetim Sistemi - Veritabanı Tasarımı & Backend Mimarisi

Bu proje, bir kütüphane sisteminin temel işleyişini modellemek amacıyla geliştirilmiştir. İlk aşamada PostgreSQL ile veritabanı tasarımı yapılmış, ardından **Spring Boot** kullanılarak **CQRS (Command Query Responsibility Segregation)** mimarisi ile modern bir backend uygulamasına dönüştürülmüştür.

## 🛠 Kullanılan Teknolojiler
* **Backend:** Spring Boot 4.0.6, Java 21
* **Veritabanı:** PostgreSQL
* **ORM:** Spring Data JPA (Hibernate)
* **Mimari:** CQRS (Command Query Responsibility Segregation)
* **Araçlar:** Postman, pgAdmin 4, Docker
* **Kütüphaneler:** Lombok, Jakarta Validation

## 🏗️ Backend Mimarisi (CQRS)
Uygulama, veri okuma ve yazma işlemlerini birbirinden ayırarak performans ve bakımı kolay bir yapı sunar:
* **Commands:** Veri üzerinde değişiklik yapan işlemler (Kitap ekleme, ödünç alma, iade etme).
* **Queries:** Veri okuma ve listeleme işlemleri (Tüm kayıtları getirme, ID ile sorgulama).
* **Handlers:** Gelen komut ve sorguları işleyen merkezi iş mantığı katmanı.

## 📊 Veritabanı Tasarımı (ER Diyagramı)

Veritabanı tasarımı yapılırken ilişkisel model prensiplerine sadık kalınmıştır. Tablolar arasındaki anahtar (Foreign Key) bağlantıları ile veri bütünlüğü sağlanmıştır.

> **Not:** Hazırladığım ER diyagramına aşağıdan ulaşabilirsiniz:

<img width="1343" height="1386" alt="image" src="https://github.com/user-attachments/assets/d522725e-2eae-43a8-82ec-db7ec48e9882" />

---

## 📡 API Uç Noktaları (Endpoints)

### Öğrenci İşlemleri
* `POST /api/students/add` - Yeni öğrenci ekler.
* `GET /api/students/getall` - Tüm öğrencileri listeler.
* `GET /api/students/{id}` - ID ile spesifik öğrenci detayını getirir.

### Kitap İşlemleri
* `POST /api/books/add` - Envantere yeni kitap ekler.
* `GET /api/books/getall` - Tüm kitapları listeler.

### Ödünç Alma & İade İşlemleri
* `POST /api/borrowings/add` - Kitabı öğrenciye ödünç verir (Student ve Book ilişkisi kurar).
* `GET /api/borrowings/getall` - Ödünç alma kayıtlarını ilişkili verilerle (Öğrenci ve Kitap detayları) listeler.
* `DELETE /api/borrowings/return/{id}` - Kitabı iade eder ve kaydı sonlandırır.

---

## 📖 SQL & Veri Yönetimi Hakkında Bilgi

Bu projede kullanılan temel SQL ve JPA bileşenleri aşağıda açıklanmıştır:

### 1. DDL (Data Definition Language)
Hibernate üzerinden otomatik tablo oluşturma (Auto-DDL) ve PostgreSQL üzerinde manuel tablolar.
* **CREATE:** Yeni tabloların ve `ManyToOne` ilişkilerinin tanımlanması.

### 2. DML (Data Manipulation Language)
* **INSERT:** Command Handler'lar aracılığıyla veritabanına veri girişi.
* **DELETE:** `ReturnBookCommandHandler` ile iade edilen kayıtların silinmesi.

### 3. DQL (Data Query Language)
* **SELECT:** Query Handler'lar üzerinden optimize edilmiş sorgularla verilerin API'ye sunulması.

---

## 💻 Kurulum ve Kullanım

1. Bu repoyu bilgisayarınıza `git clone` ile indirin.
2. Docker üzerinden PostgreSQL veritabanınızı başlatın.
3. `src/main/resources/application.yaml` dosyasındaki veritabanı bağlantı bilgilerini düzenleyin.
4. Terminalde `mvn spring-boot:run` komutunu çalıştırarak uygulamayı başlatın.
5. API testleri için Postman koleksiyonunu kullanabilirsiniz.
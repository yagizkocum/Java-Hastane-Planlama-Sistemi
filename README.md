# 🏥 Hastane Planlama ve Çizelgeleme Sistemi

Java tabanlı, konsol (CLI) üzerinden çalışan, nesne yönelimli programlama (OOP) ilkelerine ve temiz mimari (Clean Architecture) prensiplerine uygun olarak tasarlanmış bir **Hastane Planlama ve Çizelgeleme Sistemi** projesidir.

Proje; hasta triyaj önceliklendirmesi, doktor ve ameliyathane durum yönetimi ile verilerin kalıcı saklanması (File I/O) süreçlerini yönetir.

---

## 🎯 Proje Özellikleri

- **Hasta Önceliklendirme:** Triyaj seviyesi, yaş ve kronik hastalık parametrelerini kullanarak dinamik öncelik puanı hesaplayan sıralama algoritması.
- **Kalıcı Veri Saklama:** Seri durumdaki verilerin dosya sistemine (`hastalar.dat`) kaydedilmesi ve uygulama başlatıldığında otomatik yüklenmesi.
- **Konsol Arayüzü (CLI):** Kolay kullanılabilir metin tabanlı etkileşimli menü.
- **Birim Testleri (Unit Tests):** JUnit 5 kütüphanesi ile yazılmış 8 adet kapsayıcı birim testi.

---

## 🏗️ Mimari ve Tasarım Prensipleri

### 1. Nesne Yönelimli Programlama (OOP)
- **Kapsülleme (Encapsulation):** Tüm sınıf alanları `private` / `protected` erişim belirleyicileri ile korunmuş, erişim metotlarla sınırlandırılmıştır.
- **Kalıtım (Inheritance):** `Hasta` ve `Doktor` sınıfları soyut `Kisi` sınıfından türetilmiştir.
- **Soyutlama (Abstraction):** `Kisi` soyut sınıfı ve `VeriDeposu`, `CizelgelemeStratejisi` arayüzleri (interface) ile katmanlar arası bağımlılıklar soyutlanmıştır.
- **Çok Biçimlilik (Polymorphism):** Raporlama ve önceliklendirme algoritmalarında dinamik bağlanma (dynamic binding) kullanılmıştır.

### 2. SOLID Prensipleri
- **Single Responsibility Principle (SRP):** Sınıflar yalnızca kendi iş alanlarından sorumludur (`DosyaVeriDeposu` sadece I/O, `AcilOncelikCizelgeleyici` sadece sıralama yapar).
- **Open/Closed Principle (OCP):** Yeni bir çizelgeleme algoritması eklemek mevcut koda dokunmadan `CizelgelemeStratejisi` arayüzünü uygulamakla mümkündür.
- **Liskov Substitution Principle (LSP):** `Doktor` ve `Hasta` nesneleri alt tür olarak `Kisi` referansı yerine kullanılabilir.
- **Dependency Inversion Principle (DIP):** `HastaneYonetici` üst modülü somut sınıflara değil, arayüzlere bağımlıdır.

### 3. Tasarım Kalıpları (Design Patterns)
- **Factory Pattern:** `HastaFactory` sınıfı üzerinden nesne üretimi ve doğrulama mantığı merkezi hale getirilmiştir.
- **Strategy Pattern:** `CizelgelemeStratejisi` arayüzü sayesinde farklı önceliklendirme algoritmaları dinamik olarak değiştirilebilir.

---

## 🧮 Algoritma Mantığı

Sistemdeki hastalar aşağıdaki formüle göre hesaplanan **Öncelik Puanı** üzerinden sıralanır:

$$\text{Puan} = (6 - \text{Triyaj}) \times 20 + \text{Yaş Bonusu} + \text{Kronik Bonusu}$$

- **Triyaj Seviyesi (1-5):** 1 (En Acil) ile 5 (Poliklinik) arasında değer alır.
- **Yaş Bonusu:** 65 yaş ve üzeri için $+15$ puan.
- **Kronik Hastalık Bonusu:** Kronik rahatsızlığı bulunan hastalar için $+10$ puan.

---

## 📐 UML Sınıf Diyagramı

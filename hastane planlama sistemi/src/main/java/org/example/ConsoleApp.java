package org.example;

import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) {
        VeriDeposu veriDeposu = new DosyaVeriDeposu();
        CizelgelemeStratejisi strateji = new AcilOncelikCizelgeleyici();
        HastaneYonetici yonetici = new HastaneYonetici(veriDeposu, strateji);

        // Örnek başlangıç verileri
        yonetici.doktorEkle(new Doktor("D1", "Dr. Ahmet", 45, "Genel Cerrahi"));
        yonetici.ameliyathaneEkle(new Ameliyathane("AMELIYATHANE-1"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== HASTANE PLANLAMA SISTEMI ===");
            System.out.println("1. Hasta Ekle");
            System.out.println("2. Öncelikli Hasta Listesini Göster");
            System.out.println("3. Çıkış");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine();

            if (secim == 1) {
                System.out.print("ID: "); String id = scanner.nextLine();
                System.out.print("Ad: "); String ad = scanner.nextLine();
                System.out.print("Yaş: "); int yas = scanner.nextInt();
                System.out.print("Triyaj (1-Acil, 5-Poliklinik): "); int triyaj = scanner.nextInt();
                System.out.print("Kronik Hastalık Var mı? (true/false): "); boolean kronik = scanner.nextBoolean();
                Hasta h = hastaFactory.hastaOlustur(id, ad, yas, triyaj, kronik);
                yonetici.hastaEkle(h);
                System.out.println("Hasta başarıyla eklendi ve kaydedildi.");
            } else if (secim == 2) {
                System.out.println("\n--- Öncelik Sırasına Göre Hastalar ---");
                for (Hasta h : yonetici.getOncelikliHastaListesi()) {
                    System.out.println(h.getDetayliBilgi());
                }
            } else if (secim == 3) {
                System.out.println("Sistemden çıkılıyor...");
                break;
            }
        }
        scanner.close();
    }
}
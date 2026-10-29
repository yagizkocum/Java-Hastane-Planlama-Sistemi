package org.example;

public class hastaFactory {
    public static Hasta hastaOlustur(String id, String ad, int yas, int triyaj, boolean kronik) {
        if (triyaj < 1 || triyaj > 5) {
            throw new IllegalArgumentException("Triyaj seviyesi 1-5 arasında olmalıdır.");
        }
        return new Hasta(id, ad, yas, triyaj, kronik);
    }
}
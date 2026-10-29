package org.example;

public class Hasta extends Kisi {
    private int triyajSeviyesi; // 1 (Çok Acil) - 5 (Poliklinik)
    private boolean kronikHastalik;
    private int oncelikPuani;

    public Hasta(String id, String ad, int yas, int triyajSeviyesi, boolean kronikHastalik) {
        super(id, ad, yas);
        this.triyajSeviyesi = triyajSeviyesi;
        this.kronikHastalik = kronikHastalik;
        this.oncelikPuani = hesaplaOncelikPuani();
    }

    public int hesaplaOncelikPuani() {
        int puan = (6 - triyajSeviyesi) * 20;
        if (getYas() >= 65) puan += 15;
        if (kronikHastalik) puan += 10;
        return puan;
    }

    public int getTriyajSeviyesi() { return triyajSeviyesi; }
    public boolean isKronikHastalik() { return kronikHastalik; }
    public int getOncelikPuani() { return oncelikPuani; }

    @Override
    public String getDetayliBilgi() {
        return String.format("Hasta [ID: %s, Ad: %s, Yaş: %d, Triyaj: %d, Öncelik Puanı: %d]",
                getId(), getAd(), getYas(), triyajSeviyesi, oncelikPuani);
    }
}
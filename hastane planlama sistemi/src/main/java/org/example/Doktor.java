package org.example;

public class Doktor extends Kisi {
    private String uzmanlikAlani;
    private boolean musait;

    public Doktor(String id, String ad, int yas, String uzmanlikAlani) {
        super(id, ad, yas);
        this.uzmanlikAlani = uzmanlikAlani;
        this.musait = true;
    }

    public String getUzmanlikAlani() { return uzmanlikAlani; }
    public boolean isMusait() { return musait; }
    public void setMusait(boolean musait) { this.musait = musait; }

    @Override
    public String getDetayliBilgi() {
        return String.format("Doktor [ID: %s, Ad: %s, Uzmanlık: %s, Müsait: %s]",
                getId(), getAd(), uzmanlikAlani, musait ? "Evet" : "Hayır");
    }
}

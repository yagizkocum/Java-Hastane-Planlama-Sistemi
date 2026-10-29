package org.example;
import java.io.Serializable;

public abstract class Kisi implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String ad;
    private int yas;

    public Kisi(String id, String ad, int yas) {
        this.id = id;
        this.ad = ad;
        this.yas = yas;
    }

    public String getId() { return id; }
    public String getAd() { return ad; }
    public int getYas() { return yas; }

    public abstract String getDetayliBilgi();
}

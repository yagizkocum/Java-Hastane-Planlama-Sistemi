package org.example;

import java.util.ArrayList;

import java.util.List;

public class HastaneYonetici {
    private List<Hasta> hastalar;
    private List<Doktor> doktorlar;
    private List<Ameliyathane> ameliyathaneler;
    private VeriDeposu veriDeposu;
    private CizelgelemeStratejisi cizelgeleyici;

    public HastaneYonetici(VeriDeposu veriDeposu, CizelgelemeStratejisi cizelgeleyici) {
        this.veriDeposu = veriDeposu;
        this.cizelgeleyici = cizelgeleyici;
        this.hastalar = veriDeposu.hastalariYukle();
        this.doktorlar = new ArrayList<>();
        this.ameliyathaneler = new ArrayList<>();
    }

    public void hastaEkle(Hasta hasta) {
        hastalar.add(hasta);
        veriDeposu.hastaKaydet(hastalar);
    }

    public List<Hasta> getOncelikliHastaListesi() {
        return cizelgeleyici.sirala(hastalar);
    }

    public void doktorEkle(Doktor doktor) { doktorlar.add(doktor); }
    public void ameliyathaneEkle(Ameliyathane a) { ameliyathaneler.add(a); }
    public List<Doktor> getDoktorlar() { return doktorlar; }
    public List<Ameliyathane> getAmeliyathaneler() { return ameliyathaneler; }
}
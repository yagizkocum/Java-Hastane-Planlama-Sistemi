package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HastaneSistemiTest {

    private Hasta hastaAcil;
    private Hasta hastaNormal;

    @BeforeEach
    void setUp() {
        hastaAcil = hastaFactory.hastaOlustur("H1", "Mehmet", 70, 1, true);
        hastaNormal = hastaFactory.hastaOlustur("H2", "Ayşe", 25, 4, false);
    }

    @Test
    void testHastaOncelikPuaniHesaplama() {
        // (6 - 1) * 20 + 15 (yaş >= 65) + 10 (kronik) = 100 + 15 + 10 = 125
        assertEquals(125, hastaAcil.getOncelikPuani());
    }

    @Test
    void testhastaFactoryGecerliObje() {
        assertNotNull(hastaAcil);
        assertEquals("Mehmet", hastaAcil.getAd());
    }

    @Test
    void testhastaFactoryGecersizTriyaj() {
        assertThrows(IllegalArgumentException.class, () -> {
            hastaFactory.hastaOlustur("H3", "Ali", 30, 6, false);
        });
    }

    @Test
    void testAcilOncelikCizelgelemeAlgoritmasi() {
        List<Hasta> liste = new ArrayList<>();
        liste.add(hastaNormal); // Puan: (6-4)*20 = 40
        liste.add(hastaAcil);   // Puan: 125

        AcilOncelikCizelgeleyici cizelgeleyici = new AcilOncelikCizelgeleyici();
        List<Hasta> sirali = cizelgeleyici.sirala(liste);

        assertEquals("H1", sirali.get(0).getId()); // En yüksek puanlı ilk sırada olmalı
    }

    @Test
    void testDoktorDurumGuncelleme() {
        Doktor d = new Doktor("D1", "Dr. Can", 40, "Kardiyoloji");
        assertTrue(d.isMusait());
        d.setMusait(false);
        assertFalse(d.isMusait());
    }

    @Test
    void testAmeliyathaneDurumGuncelleme() {
        Ameliyathane a = new Ameliyathane("A1");
        assertFalse(a.isDolumu());
        a.setDolumu(true);
        assertTrue(a.isDolumu());
    }

    @Test
    void testPolimorfikKisiDetay() {
        Kisi k = new Doktor("D2", "Dr. Ece", 38, "Nöroloji");
        assertTrue(k.getDetayliBilgi().contains("Dr. Ece"));
    }

    @Test
    void testHastaEklemeVeListeleme() {
        VeriDeposu mockDepo = new VeriDeposu() {
            private List<Hasta> db = new ArrayList<>();
            @Override public void hastaKaydet(List<Hasta> h) { this.db = h; }
            @Override public List<Hasta> hastalariYukle() { return db; }
        };

        HastaneYonetici yonetici = new HastaneYonetici(mockDepo, new AcilOncelikCizelgeleyici());
        yonetici.hastaEkle(hastaAcil);
        assertEquals(1, yonetici.getOncelikliHastaListesi().size());
    }
}
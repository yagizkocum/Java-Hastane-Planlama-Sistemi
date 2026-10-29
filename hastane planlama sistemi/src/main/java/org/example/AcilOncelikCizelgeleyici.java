package org.example;

import java.util.ArrayList;
import java.util.List;

public class AcilOncelikCizelgeleyici implements CizelgelemeStratejisi {
    @Override
    public List<Hasta> sirala(List<Hasta> hastalar) {
        List<Hasta> sirali = new ArrayList<>(hastalar);
        // Insertion / TimSort Mantığı ile Öncelik Puanına Göre Azalan Sıralama
        sirali.sort((h1, h2) -> Integer.compare(h2.getOncelikPuani(), h1.getOncelikPuani()));
        return sirali;
    }
}
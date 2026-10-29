package org.example;

import java.util.List;

public interface VeriDeposu {
    void hastaKaydet(List<Hasta> hastalar);
    List<Hasta> hastalariYukle();
}
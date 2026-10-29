package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DosyaVeriDeposu implements VeriDeposu {
    private final String DOSYA_ADI = "hastalar.dat";

    @Override
    @SuppressWarnings("unchecked")
    public void hastaKaydet(List<Hasta> hastalar) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DOSYA_ADI))) {
            oos.writeObject(hastalar);
        } catch (IOException e) {
            System.err.println("Veri kaydetme hatası: " + e.getMessage());
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Hasta> hastalariYukle() {
        File file = new File(DOSYA_ADI);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DOSYA_ADI))) {
            return (List<Hasta>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}

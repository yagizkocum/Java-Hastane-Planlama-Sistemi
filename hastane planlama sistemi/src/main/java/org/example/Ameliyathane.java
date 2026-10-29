package org.example;

import java.io.Serializable;

public class Ameliyathane implements Serializable {
    private static final long serialVersionUID = 1L;
    private String salonId;
    private boolean dolumu;

    public Ameliyathane(String salonId) {
        this.salonId = salonId;
        this.dolumu = false;
    }

    public String getSalonId() { return salonId; }
    public boolean isDolumu() { return dolumu; }
    public void setDolumu(boolean dolumu) { this.dolumu = dolumu; }
}

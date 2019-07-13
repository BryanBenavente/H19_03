package modelo;

import java.io.Serializable;

public class Equipo implements Serializable{
    
    private int IDEQU;
    private String NOMEQUI;
    private String DESCEQU;
    private String CATEQUI;
    private double PREEQUI;
    private String ESTEQU; 

    public int getIDEQU() {
        return IDEQU;
    }

    public void setIDEQU(int IDEQU) {
        this.IDEQU = IDEQU;
    }

    public String getNOMEQUI() {
        return NOMEQUI;
    }

    public void setNOMEQUI(String NOMEQUI) {
        this.NOMEQUI = NOMEQUI;
    }

    public String getDESCEQU() {
        return DESCEQU;
    }

    public void setDESCEQU(String DESCEQU) {
        this.DESCEQU = DESCEQU;
    }

    public String getCATEQUI() {
        return CATEQUI;
    }

    public void setCATEQUI(String CATEQUI) {
        this.CATEQUI = CATEQUI;
    }

    public double getPREEQUI() {
        return PREEQUI;
    }

    public void setPREEQUI(double PREEQUI) {
        this.PREEQUI = PREEQUI;
    }

    public String getESTEQU() {
        return ESTEQU;
    }

    public void setESTEQU(String ESTEQU) {
        this.ESTEQU = ESTEQU;
    }
    
}

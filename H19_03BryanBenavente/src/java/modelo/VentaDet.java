package modelo;

import java.io.Serializable;

public class VentaDet implements Serializable{
    
    private int IDVENDET;
    private String IDVEN;
    private String IDEQU;
    private int CANT;
    private double PREVEN;

    public VentaDet(String IDVEN, String IDEQU, int CANT, double PREVEN) {
        this.IDVEN = IDVEN;
        this.IDEQU = IDEQU;
        this.CANT = CANT;
        this.PREVEN = PREVEN;
    }    
    
    public VentaDet() {
    }   
    
    public int getIDVENDET() {
        return IDVENDET;
    }

    public void setIDVENDET(int IDVENDET) {
        this.IDVENDET = IDVENDET;
    }

    public String getIDVEN() {
        return IDVEN;
    }

    public void setIDVEN(String IDVEN) {
        this.IDVEN = IDVEN;
    }

    public String getIDEQU() {
        return IDEQU;
    }

    public void setIDEQU(String IDEQU) {
        this.IDEQU = IDEQU;
    }

    public int getCANT() {
        return CANT;
    }

    public void setCANT(int CANT) {
        this.CANT = CANT;
    }

    public double getPREVEN() {
        return PREVEN;
    }

    public void setPREVEN(double PREVEN) {
        this.PREVEN = PREVEN;
    }
            
}

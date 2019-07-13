package modelo;

import java.io.Serializable;

public class VentaDet implements Serializable{
    
    private int IDVENDET;
    private String IDVEN;
    private String IDEQU;
    private int CANT;

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
            
}

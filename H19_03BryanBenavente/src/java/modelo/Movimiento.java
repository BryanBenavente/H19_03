package modelo;

import java.util.Date;

public class Movimiento {
    
    private int IDPER;
    private String NOMPER;
    private String IDEQU;
    private Date FECMOV;
    private int CANTEQU;
    private String ESTMOV;
    private String TIPMOV;

    public int getIDPER() {
        return IDPER;
    }

    public void setIDPER(int IDPER) {
        this.IDPER = IDPER;
    }

    public String getNOMPER() {
        return NOMPER;
    }

    public void setNOMPER(String NOMPER) {
        this.NOMPER = NOMPER;
    }

    public String getIDEQU() {
        return IDEQU;
    }

    public void setIDEQU(String IDEQU) {
        this.IDEQU = IDEQU;
    }
    
    public Date getFECMOV() {
        return FECMOV;
    }

    public void setFECMOV(Date FECMOV) {
        this.FECMOV = FECMOV;
    }

    public int getCANTEQU() {
        return CANTEQU;
    }

    public void setCANTEQU(int CANTEQU) {
        this.CANTEQU = CANTEQU;
    }

    public String getESTMOV() {
        return ESTMOV;
    }

    public void setESTMOV(String ESTMOV) {
        this.ESTMOV = ESTMOV;
    }

    public String getTIPMOV() {
        return TIPMOV;
    }

    public void setTIPMOV(String TIPMOV) {
        this.TIPMOV = TIPMOV;
    }

}

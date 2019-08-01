package modelo;

import java.io.Serializable;

public class Equipo implements Serializable{
    
    private int IDEQU;
    private String NOMEQUI;
    private String DESCEQU;
    private String CATEQUI;
    private String ESTEQU; 
    private String MAREQU;
    private String IMGEQU;
    private int CANTEQU;
    
    //Variables de tabla Precio
    private double PRECOM;
    private double PREVEN;
    private String ESTPRE;
    
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

    public String getESTEQU() {
        return ESTEQU;
    }

    public void setESTEQU(String ESTEQU) {
        this.ESTEQU = ESTEQU;
    }

    public String getMAREQU() {
        return MAREQU;
    }

    public void setMAREQU(String MAREQU) {
        this.MAREQU = MAREQU;
    }

    public String getIMGEQU() {
        return IMGEQU;
    }

    public void setIMGEQU(String IMGEQU) {
        this.IMGEQU = IMGEQU;
    }

    public int getCANTEQU() {
        return CANTEQU;
    }

    public void setCANTEQU(int CANTEQU) {
        this.CANTEQU = CANTEQU;
    }

    public double getPRECOM() {
        return PRECOM;
    }

    public void setPRECOM(double PRECOM) {
        this.PRECOM = PRECOM;
    }

    public double getPREVEN() {
        return PREVEN;
    }

    public void setPREVEN(double PREVEN) {
        this.PREVEN = PREVEN;
    }

    public String getESTPRE() {
        return ESTPRE;
    }

    public void setESTPRE(String ESTPRE) {
        this.ESTPRE = ESTPRE;
    }
    
}

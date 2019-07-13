package modelo;

import java.io.Serializable;

public class Sucursal implements Serializable{
    
    private int IDSUC;
    private String NOMSUC;
    private String DESCSUC;
    private String DIRSUC;
    private String CODUBI;
    private String ESTSUC;

    public int getIDSUC() {
        return IDSUC;
    }

    public void setIDSUC(int IDSUC) {
        this.IDSUC = IDSUC;
    }

    public String getNOMSUC() {
        return NOMSUC;
    }

    public void setNOMSUC(String NOMSUC) {
        this.NOMSUC = NOMSUC;
    }

    public String getDESCSUC() {
        return DESCSUC;
    }

    public void setDESCSUC(String DESCSUC) {
        this.DESCSUC = DESCSUC;
    }

    public String getDIRSUC() {
        return DIRSUC;
    }

    public void setDIRSUC(String DIRSUC) {
        this.DIRSUC = DIRSUC;
    }

    public String getCODUBI() {
        return CODUBI;
    }

    public void setCODUBI(String CODUBI) {
        this.CODUBI = CODUBI;
    }

    public String getESTSUC() {
        return ESTSUC;
    }

    public void setESTSUC(String ESTSUC) {
        this.ESTSUC = ESTSUC;
    }
        
}

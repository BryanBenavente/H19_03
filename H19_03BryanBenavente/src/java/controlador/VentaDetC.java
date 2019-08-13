package controlador;

import dao.VentaDetImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.VentaDet;
import services.Reporte;

@Named(value = "ventaDetC")
@SessionScoped
public class VentaDetC implements Serializable {

    private VentaDet ventaDet;
    private VentaDetImpl dao;
    private List<VentaDet> listVentd;
    private Reporte reporte;

    public VentaDetC() {
        ventaDet = new VentaDet();
        dao = new VentaDetImpl();
        listVentd = new ArrayList();
        reporte = new Reporte();
    }
    
    public void registrar() {
        try {
            dao.codig(ventaDet);
            dao.agregarP(ventaDet);            
            limpiar();
        } catch (Exception e) {
            System.out.println("Error al registraC: " + e.getMessage());
        }
    }
        
    public void registrarC(){
        try {
            dao.registrar();
            dao.registrarM();
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Registro ingresado con éxito"));
            limpiar();
        } catch (Exception e) {
            System.out.println("Error al registrarC: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "No se pudo registrar"));
        }
    }
           
    public List<VentaDet> listar(){
        try {
            listVentd = dao.listar();
        } catch (Exception e) {
            System.out.println("Error al listarC: " + e.getMessage());
        }
        return listVentd;
    }
    
    public List<String> completar(String consulta){
        return dao.completar(consulta);
    }
    
    public void limpiar(){
        ventaDet = new VentaDet();
    }

    public void reporteVenta(){
        try {            
            dao.codig(ventaDet);
            System.out.println(ventaDet.getIDVEN());
            HashMap<String, Object> parameters = new HashMap();
            parameters.put("IDVEN", ventaDet.getIDVEN()); 
            reporte.exportarBolet(parameters);
        } catch (Exception e) {
            System.out.println("Error en reporteVenta: " + e.getMessage());
        }
    }
    
    
    //Generado
    public VentaDet getVentaDet() {
        return ventaDet;
    }

    public void setVentaDet(VentaDet ventaDet) {
        this.ventaDet = ventaDet;
    }

    public VentaDetImpl getDao() {
        return dao;
    }

    public void setDao(VentaDetImpl dao) {
        this.dao = dao;
    }

    public List<VentaDet> getListVentd() {
        return listVentd;
    }

    public void setListVentd(List<VentaDet> listVentd) {
        this.listVentd = listVentd;
    }

}

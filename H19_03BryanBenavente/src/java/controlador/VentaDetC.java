package controlador;

import dao.VentaDetImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.VentaDet;

@Named(value = "ventaDetC")
@SessionScoped
public class VentaDetC implements Serializable {

    private VentaDet ventaDet;
    private VentaDetImpl dao;
    private List<VentaDet> listVentd;
    
    public VentaDetC() {
        ventaDet = new VentaDet();
        dao = new VentaDetImpl();
        listVentd = new ArrayList();
    }
    
    public void registrarC(){
        try {
            dao.registrar(ventaDet);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Registro ingresado con éxito"));
            limpiar();
        } catch (Exception e) {
            System.out.println("Error al registrarC: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "No se pudo registrar"));
        }
    }
    
    public void modificarC(){
        try {
            dao.modificar(ventaDet);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Registro modificado con éxito"));
            limpiar();
        } catch (Exception e) {
            System.out.println("Error al modificarC: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "No se pudo realizar la modificación"));
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

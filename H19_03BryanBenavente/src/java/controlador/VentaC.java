package controlador;

import dao.VentaImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Venta;

@Named(value = "ventaC")
@SessionScoped
public class VentaC implements Serializable {

    private Venta venta;
    private VentaImpl dao; 
    private List<Venta> listaVent;
    private Date time;

    
    public VentaC() {
        venta = new Venta();
        dao = new VentaImpl();
        listaVent = new ArrayList();
        time = new Date();        
    }   
    
    public void registrarC(){
        try {
            dao.codigoV(venta);
            venta.setFECVEN(time);
            dao.registrar(venta);
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
            dao.modificar(venta);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Registro modificado con éxito"));
            limpiar();
        } catch (Exception e) {
            System.out.println("Error al modificarC: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "No se pudo realizar la modificación"));
        }
    }
    
    public void eliminarC(Venta venta){
        try {
            dao.eliminar(venta);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Registro eliminado con éxito"));
        } catch (Exception e) {
            System.out.println("Error al eliminarC: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "No se pudo eliminar el registro"));
        }
    }
    
    public List<String> completar(String consulta){
        return dao.completar(consulta);
    }
    
    public List<Venta> listar(){
        try {
            listaVent = dao.listar();
        } catch (Exception e) {
            System.out.println("Error al listarC: " + e.getMessage());
        }
        return listaVent;
    }
    
    public void limpiar(){
        venta = new Venta();
    }
       
            
    //Generado
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public VentaImpl getDao() {
        return dao;
    }

    public void setDao(VentaImpl dao) {
        this.dao = dao;
    }

    public List<Venta> getListaVent() {
        return listaVent;
    }

    public void setListaVent(List<Venta> listaVent) {
        this.listaVent = listaVent;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    
}

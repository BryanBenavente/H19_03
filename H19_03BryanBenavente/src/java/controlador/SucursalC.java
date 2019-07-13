package controlador;

import dao.SucursalImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Sucursal;

@Named(value = "sucursalC")
@SessionScoped
public class SucursalC implements Serializable {

    private Sucursal sucursal;
    private SucursalImpl dao;
    private List<Sucursal> listaSuc;
    
    public SucursalC() {
        sucursal = new Sucursal();
        dao = new SucursalImpl();
        listaSuc = new ArrayList();
    }
    
    public void registrarC(){
        try {
            dao.registrar(sucursal);
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
            dao.modificar(sucursal);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Registro modificado con éxito"));
            limpiar();
        } catch (Exception e) {
            System.out.println("Error al modificarC: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "No se pudo realizar la modificación"));
        }
    }
    
    public void eliminarC(Sucursal sucursal){
        try {
            dao.eliminar(sucursal);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Registro eliminado con éxito"));
        } catch (Exception e) {
            System.out.println("Error al eliminarC: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "No se pudo eliminar el registro"));
        }
    }
    
    public List<Sucursal> listar(){
        try {
            listaSuc = dao.listar();
        } catch (Exception e) {
            System.out.println("Error al listarC: " + e.getMessage());
        }
        return listaSuc;
    }
    
    public void limpiar(){
        sucursal = new Sucursal();
    }
    
    
    //Generado
    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public SucursalImpl getDao() {
        return dao;
    }

    public void setDao(SucursalImpl dao) {
        this.dao = dao;
    }

    public List<Sucursal> getListaSuc() {
        return listaSuc;
    }

    public void setListaSuc(List<Sucursal> listaSuc) {
        this.listaSuc = listaSuc;
    }
    
}

package controlador;

import dao.EquipoImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Equipo;

@Named(value = "equipoC")
@SessionScoped
public class EquipoC implements Serializable {

    private Equipo equipo;
    private EquipoImpl dao;
    private List<Equipo> listaEqup;
    
    public EquipoC() {
        equipo = new Equipo();
        dao = new EquipoImpl();
        listaEqup = new ArrayList();
    }
    
    public void registrarC(){
        try {
            dao.registrar(equipo);
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
            dao.modificar(equipo);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Registro modificado con éxito"));
            limpiar();
        } catch (Exception e) {
            System.out.println("Error al modificarC: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "No se pudo realizar la modificación"));
        }
    }
    
    public void eliminarC(Equipo equipo){
        try {
            dao.eliminar(equipo);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Registro eliminado con éxito"));
        } catch (Exception e) {
            System.out.println("Error al eliminarC: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "No se pudo eliminar el registro"));
        }
    }
    
    public List<Equipo> listar(){
        try {
            listaEqup = dao.listar();
        } catch (Exception e) {
            System.out.println("Error al listarC: " + e.getMessage());
        }
        return listaEqup;
    }
    
    public void limpiar(){
        equipo = new Equipo();
    }
    
    
    
    //Generado
    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public EquipoImpl getDao() {
        return dao;
    }

    public void setDao(EquipoImpl dao) {
        this.dao = dao;
    }

    public List<Equipo> getListaEqup() {
        return listaEqup;
    }

    public void setListaEqup(List<Equipo> listaEqup) {
        this.listaEqup = listaEqup;
    }
    
}

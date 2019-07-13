package controlador;

import dao.PersonaImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Persona;

@Named(value = "personaC")
@SessionScoped
public class PersonaC implements Serializable {

    private Persona persona;
    private PersonaImpl dao;
    private List<Persona> listaPers;
    
    public PersonaC() {
        persona = new Persona();
        dao = new PersonaImpl();
        listaPers = new ArrayList();
    }
    
    public void registrarC(){
        try {
            dao.registrar(persona);
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
            dao.modificar(persona);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Registro modificado con éxito"));
            limpiar();
        } catch (Exception e) {
            System.out.println("Error al modificarC: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "No se pudo realizar la modificación"));
        }
    }
    
    public void eliminarC(Persona persona){
        try {
            dao.eliminar(persona);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Registro eliminado con éxito"));
        } catch (Exception e) {
            System.out.println("Error al eliminarC: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "No se pudo eliminar el registro"));
        }
    }
    
    public List<Persona> listar(){
        try {
            listaPers = dao.listar();
        } catch (Exception e) {
            System.out.println("Error al listarC: " + e.getMessage());
        }
        return listaPers;
    }
    
    public void limpiar(){
        persona = new Persona();
    }
    
    
    
    //Generado
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public PersonaImpl getDao() {
        return dao;
    }

    public void setDao(PersonaImpl dao) {
        this.dao = dao;
    }

    public List<Persona> getListaPers() {
        return listaPers;
    }

    public void setListaPers(List<Persona> listaPers) {
        this.listaPers = listaPers;
    }
    
}

package controlador;

import dao.LoginImpl;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import modelo.Persona;
import services.Encriptacion;

@Named(value = "loginC")
@SessionScoped
public class LoginC implements Serializable {

    private LoginImpl dao;
    private Persona logn;
    private VentaC vnt;

    private String user, pass;
    private Encriptacion en;

    public LoginC() {
        dao = new LoginImpl();
        logn = new Persona();
        en = new Encriptacion();
        vnt = new VentaC();
    }

    public void ingresar() throws Exception {
        try {
            logn = dao.startSession(user, Encriptacion.encriptar(pass));            
            if (logn != null) {
                switch (logn.getTIPPER()) {
                    case "A":
                        setLogn(logn);
                        FacesContext.getCurrentInstance().getExternalContext().redirect("/H19_03BryanBenavente/faces/template/Inicio.xhtml");
                        break;
                    case "J":
                        setLogn(logn);
                        FacesContext.getCurrentInstance().getExternalContext().redirect("/H19_03BryanBenavente/faces/template/Inicio.xhtml");
                        break;
                    case "V":
                        setLogn(logn);
                        FacesContext.getCurrentInstance().getExternalContext().redirect("/H19_03BryanBenavente/faces/template/Inicio.xhtml");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }    
    
    public void cerrarSesion() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        FacesContext.getCurrentInstance().getExternalContext().redirect("/H19_03BryanBenavente/faces/index.xhtml");
        logn = new Persona();
    }

    public void securitySession() throws IOException {
        if (logn.getUSUPER() == null) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/H19_03BryanBenavente/faces/index.xhtml");
        }
    }

    //Generado
    public LoginImpl getDao() {
        return dao;
    }

    public void setDao(LoginImpl dao) {
        this.dao = dao;
    }

    public Persona getLogn() {
        return logn;
    }

    public void setLogn(Persona logn) {
        this.logn = logn;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}

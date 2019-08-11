package controlador;

import dao.EquipoImpl;
import dao.PrecioImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Equipo;
import services.Reporte;

@Named(value = "equipoC")
@SessionScoped
public class EquipoC implements Serializable {

    private Equipo equipo;
    private EquipoImpl dao;
    private PrecioImpl daoP;
    private List<Equipo> listaEqup;
    private List<Equipo> equipSuc;
    private Reporte reporte;

    //Variables
    private double pr1, pr2;

    public EquipoC() {
        equipo = new Equipo();
        dao = new EquipoImpl();
        daoP = new PrecioImpl();
        listaEqup = new ArrayList();
        reporte = new Reporte();
    }

    public void registrarC() {
        try {
            if (getPr2() > getPr1()) {
                dao.registrar(equipo);
                registrar();
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Registro ingresado con éxito"));
                limpiar();
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Verificar los precios"));
                limpio();
            }
        } catch (Exception e) {
            System.out.println("Error al registrarC: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "No se pudo registrar"));
        }
    }

    public void registrar() {
        try {
            equipo.setPRECOM(pr1);
            equipo.setPREVEN(pr2);
            daoP.codig(equipo);
            daoP.registrar(equipo);
            limpio();
        } catch (Exception e) {
            System.out.println("Error al registrarC: " + e.getMessage());
        }
    }

    public void modificarC() {
        try {
            if (equipo.getPRECOM() < equipo.getPREVEN()) {
                dao.modificar(equipo);
                daoP.eliminar(equipo);
                daoP.registrar(equipo);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Registro modificado con éxito"));
                limpiar();
                limpio();
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Verificar los precios"));
                limpio();
            }
        } catch (Exception e) {
            System.out.println("Error al modificarC: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "No se pudo realizar la modificación"));
        }
    }

    public void eliminarC(Equipo equipo) {
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

    public List<Equipo> listar() {
        try {
            listaEqup = dao.listar();
            equipSuc = dao.list();
        } catch (Exception e) {
            System.out.println("Error al listarC: " + e.getMessage());
        }
        return listaEqup;
    }

    public void limpiar() {
        equipo = new Equipo();
    }

    public void limpio() {
        setPr1(0.0);
        setPr2(0.0);
    }    

    public void reportEqp(){
        try {            
            HashMap<String, Object> parameters = new HashMap();
            reporte.exportarEquip(parameters);
        } catch (Exception e) {
            System.out.println("Error en reportEqp: " + e.getMessage());
        }
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

    public PrecioImpl getDaoP() {
        return daoP;
    }

    public void setDaoP(PrecioImpl daoP) {
        this.daoP = daoP;
    }

    public double getPr1() {
        return pr1;
    }

    public void setPr1(double pr1) {
        this.pr1 = pr1;
    }

    public double getPr2() {
        return pr2;
    }

    public void setPr2(double pr2) {
        this.pr2 = pr2;
    }

    public List<Equipo> getEquipSuc() {
        return equipSuc;
    }

    public void setEquipSuc(List<Equipo> equipSuc) {
        this.equipSuc = equipSuc;
    }

}
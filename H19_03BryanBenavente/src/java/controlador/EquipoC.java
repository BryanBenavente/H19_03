package controlador;

import dao.EquipoImpl;
import dao.PrecioImpl;
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
    private PrecioImpl daoP;
    private List<Equipo> listaEqup;
    private List<Integer> columns;

    //Variables
    private double pr1, pr2;

    public EquipoC() {
        equipo = new Equipo();
        dao = new EquipoImpl();
        daoP = new PrecioImpl();
        listaEqup = new ArrayList();
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

    public void increment() {
        if (columns.size() < 20) {
            columns.add(columns.size() + 1);
        }
    }

    public void decrease() {
        if (columns.size() > 1) {
            columns.remove(columns.size() - 1);
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

    public List<Integer> getColumns() {
        return columns;
    }

    public void setColumns(List<Integer> columns) {
        this.columns = columns;
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

}

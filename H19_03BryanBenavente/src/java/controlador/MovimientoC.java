package controlador;

import dao.MovimientoImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Movimiento;

@Named(value = "movimientoC")
@SessionScoped
public class MovimientoC implements Serializable {

    private Movimiento movimiento;
    private MovimientoImpl dao;
    private List<Movimiento> equipo;
    private List<Movimiento> persona;
    private Date fecha;

    public MovimientoC() {
        movimiento = new Movimiento();
        dao = new MovimientoImpl();
        fecha = new Date();
        equipo = dao.lista();          
        persona = dao.listaPer();
    }

    public void registrar() {
        try {     
            movimiento.setFECMOV(fecha);
            dao.registrar(movimiento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Registro", "Ingresado con éxito"));
            limpiar();
        } catch (Exception e) {
            System.out.println("Error al registrarC: " + e.getMessage());
        }
    }

    public void limpiar(){
        movimiento = new Movimiento();
    }

    //GENERADO
    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public MovimientoImpl getDao() {
        return dao;
    }

    public void setDao(MovimientoImpl dao) {
        this.dao = dao;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Movimiento> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<Movimiento> equipo) {
        this.equipo = equipo;
    }

    public List<Movimiento> getPersona() {
        return persona;
    }

    public void setPersona(List<Movimiento> persona) {
        this.persona = persona;
    }

}

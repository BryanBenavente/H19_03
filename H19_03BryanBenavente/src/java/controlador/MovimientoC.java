package controlador;

import dao.MovimientoImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import modelo.Movimiento;

@Named(value = "movimientoC")
@SessionScoped
public class MovimientoC implements Serializable {

    private Movimiento movimiento;
    private MovimientoImpl dao;
    private Date fecha;
    
    public MovimientoC() {
        movimiento = new Movimiento();
        dao = new MovimientoImpl();
        fecha = new Date();
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
        
}

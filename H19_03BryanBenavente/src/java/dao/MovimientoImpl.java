package dao;

import java.sql.PreparedStatement;
import java.util.List;
import modelo.Movimiento;

public class MovimientoImpl extends Conexion implements ICRUD<Movimiento>{

    @Override
    public void registrar(Movimiento movimiento) throws Exception {
        String sql ="INSERT INTO VENTA.MOVIMIENTO() VALUES()";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, movimiento.getIDPER());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en registrarMov: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Movimiento movimiento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Movimiento movimiento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Movimiento> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

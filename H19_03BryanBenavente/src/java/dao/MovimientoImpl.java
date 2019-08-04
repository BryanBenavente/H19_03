package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.Movimiento;

public class MovimientoImpl extends Conexion{

    public void registrar(Movimiento movimiento) throws Exception {
        String sql ="INSERT INTO VENTA.MOVIMIENTO(IDPER, IDEQU, FECMOV, CANTMOV, TIPMOV, ESTMOV) VALUES(?,?,?,?,'I','A')";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);            
            ps.setInt(1, movimiento.getIDPER());
            ps.setString(2, this.codigoEq(movimiento.getIDEQU()));
            SimpleDateFormat forma = new SimpleDateFormat("yyyy/MM/dd");
            ps.setString(3, forma.format(movimiento.getFECMOV()));
            ps.setInt(4, movimiento.getCANTEQU());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en registrarMov: " + e.getMessage());
        }
    }
           
    public List<Movimiento> listaPer() {
        List<Movimiento> lista;
        Movimiento movimiento;
        String sql = "SELECT IDPER, NOMPER FROM PERSONA.PERSONA WHERE ESTPER = 'A' and TIPPER = 'J'";
        try {
            lista = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                movimiento = new Movimiento();
                movimiento.setIDPER(rs.getInt("IDPER"));
                movimiento.setNOMPER(rs.getString("NOMPER"));
                lista.add(movimiento);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en lista movimientoI: " + e.getMessage());
            return null;
        }
        return lista;
    }
    
        public String codigoEq(String dato) {
        ResultSet rs;
        String sql = "SELECT IDEQU FROM VENTA.EQUIPO WHERE NOMEQUI LIKE ?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, dato);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("IDEQU");
            }
        } catch (Exception e) {
            System.out.println("Error al obtener código " + e.getMessage());
            return null;
        }
        return sql;
    }

    public List<String> completarEq(String consulta) {
        ResultSet rs;
        List<String> lista;
        String sql = "SELECT \n"
                + "	EQ.IDEQU, EQ.NOMEQUI\n"
                + "FROM VENTA.EQUIPO AS EQ \n"
                + "WHERE ESTEQU = 'A' and NOMEQUI LIKE ? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, "%" + consulta + "%");
            lista = new ArrayList();
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("NOMEQUI"));
            }
            ps.close();
            return lista;
        } catch (Exception e) {
            System.out.println("Error al buscar persona: " + e.getMessage());
            return null;
        }
    }
    
}

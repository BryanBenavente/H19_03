package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.VentaDet;

public class VentaDetImpl extends Conexion {

    public void registrar(VentaDet ventaDet) throws Exception {
        try {
            String sql = "INSERT INTO VENTA.VENTA_DETALLE (IDVEN, IDPRO, CANT)"
                    + "VALUES(?,?,?)";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, ventaDet.getIDVEN());
            ps.setString(2, ventaDet.getIDEQU());
            ps.setInt(3, ventaDet.getCANT());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al registrar VdI: " + e.getMessage());
        }
    }

    public void modificar(VentaDet ventaDet) throws Exception {
        try {
            String sql = "UPDATE VENTA.VENTA_DETALLE SET IDEQU=?, CANT=? WHERE IDVEN=?"
                    + "VALUES(?,?,?)";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, ventaDet.getIDEQU());
            ps.setInt(2, ventaDet.getCANT());
            ps.setString(3, ventaDet.getIDVEN());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al modificar VdI: " + e.getMessage());
        }
    }

    public List<VentaDet> listar() throws Exception {
        List<VentaDet> lista;
        VentaDet venta;
        String sql = "SELECT * FROM VENTA.VENTA_DETALLE";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            lista = new ArrayList();
            while (rs.next()) {
                venta = new VentaDet();
                venta.setIDVEN(rs.getString("IDVEN"));
                venta.setIDEQU(rs.getString("IDEQU"));
                venta.setCANT(rs.getInt("CANT"));
                lista.add(venta);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error al listar VdI: " + e.getMessage());
            return null;
        }
        return lista;
    }

    public String codigo(String dato) {
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

    public List<String> completar(String consulta) {
        ResultSet rs;
        List<String> lista;
        String sql = "SELECT NOMEQUI FROM VENTA.EQUIPO WHERE NOMEQUI LIKE ? ";
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

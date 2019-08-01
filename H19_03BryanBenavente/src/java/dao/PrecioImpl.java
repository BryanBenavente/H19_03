package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Equipo;

public class PrecioImpl extends Conexion {

    public void registrar(Equipo equipo) throws Exception {
        String sql = "INSERT INTO VENTA.PRECIO(IDEQU, PRECOM, PREVEN, ESTPRE) VALUES (?,?,?,'A')";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, equipo.getIDEQU());
            ps.setDouble(2, equipo.getPRECOM());
            ps.setDouble(3, equipo.getPREVEN());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al registrar Precio: " + e.getMessage());
        }
    }

    public void eliminar(Equipo equipo) throws Exception {
        String sql = "UPDATE VENTA.PRECIO SET ESTPRE = 'I' WHERE IDEQU =?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);                        
            ps.setInt(1, equipo.getIDEQU());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar Precio: " + e.getMessage());
        }
    }

    public void codig(Equipo equipo) throws Exception {
        ResultSet rs;
        try {
            String sql = "SELECT MAX(IDEQU) AS IDEQU FROM VENTA.EQUIPO";
            rs = this.conectar().createStatement().executeQuery(sql);
            while (rs.next()) {
                equipo.setIDEQU(rs.getInt("IDEQU"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error CodigoDAO codig(): " + e.getMessage());
        }
    }
    
}

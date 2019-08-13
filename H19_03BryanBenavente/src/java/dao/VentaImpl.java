package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.Venta;

public class VentaImpl extends Conexion implements ICRUD<Venta> {

    @Override
    public void registrar(Venta venta) throws Exception {
        try {
            String sql = "INSERT INTO VENTA.VENTA (IDVEN, IDPER, FECVEN, ESTVEN)"
                    + "VALUES(?,?,?,'A')";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, venta.getIDVEN());
            ps.setString(2, codigo(venta.getIDPER()));
            SimpleDateFormat forma = new SimpleDateFormat("yyyy/MM/dd");
            ps.setString(3, forma.format(venta.getFECVEN()));
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al registrar VI: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Venta venta) throws Exception {
        try {
            String sql = "UPDATE VENTA.VENTA SET IDPER=?, FECVEN=?, ESTVEN=? WHERE IDVEN =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, venta.getIDPER());
            SimpleDateFormat forma = new SimpleDateFormat("yyyy/MM/dd");
            ps.setString(2, forma.format(venta.getFECVEN()));
            ps.setString(3, venta.getESTVEN());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al modificar VI: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Venta venta) throws Exception {
        try {
            String sql = "UPDATE VENTA.VENTA SET ESTVEN='I' WHERE IDVEN =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, venta.getESTVEN());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar VI: " + e.getMessage());
        }
    }

    @Override
    public List<Venta> listar() throws Exception {
        List<Venta> lista;
        Venta venta;
        String sql = "SELECT * FROM VENTA.VENTA";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            lista = new ArrayList();
            while (rs.next()) {
                venta = new Venta();
                venta.setIDVEN(rs.getInt("IDVEN"));
                venta.setIDPER(rs.getString("IDPER"));
                venta.setFECVEN(rs.getDate("FECVEN"));
                venta.setESTVEN(rs.getString("ESTVEN"));
                lista.add(venta);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error al listar SI: " + e.getMessage());
            return null;
        }
        return lista;
    }

    public String codigo(String dato) {
        ResultSet rs;
        String sql = "SELECT IDPER FROM PERSONA.PERSONA WHERE CONCAT(NOMPER,' ', APEPER) LIKE ?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, dato);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("IDPER");
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
        String sql = "SELECT CONCAT(NOMPER,' ', APEPER) AS PERSONA FROM PERSONA.PERSONA WHERE ESTPER = 'A' AND CONCAT(NOMPER,' ', APEPER) LIKE ?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, "%" + consulta + "%");
            lista = new ArrayList();
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("PERSONA"));
            }
            ps.close();
            return lista;
        } catch (Exception e) {
            System.out.println("Error al buscar persona: " + e.getMessage());
            return null;
        }
    }

    public void codigoV(Venta venta) throws Exception {
        try {
            String res = "";
            String sql = "SELECT TOP(1) MAX(IDVEN) AS IDVEN FROM VENTA.VENTA";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            res = rs.getString(1);
            if (res == null) {
                venta.setIDVEN(Integer.parseInt("1"));
            } else {
                int a = Integer.parseInt(res);
                int cod = a + 1;
                venta.setIDVEN(cod);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error CodigoDAO: " + e.getMessage());
        }
    }

}

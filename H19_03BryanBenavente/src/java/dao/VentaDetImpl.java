package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.VentaDet;

public class VentaDetImpl extends Conexion {

    private List<VentaDet> datos;
    private double precio;
    
    public VentaDetImpl() {
        datos = new ArrayList();
    }

    public void agregarP(VentaDet ventaDet) {
        try {
            datos.add(new VentaDet(ventaDet.getIDVEN(), ventaDet.getIDEQU(), ventaDet.getCANT(), getPrecio()));
        } catch (Exception e) {
            System.out.println("Error al agregarP " + e.getMessage());
        }
    }

    public void limpiar() {
        datos = new ArrayList();
    }

    public double total() {
        try {
            double quantity = 0.0;
            for (VentaDet p : datos) {
                quantity += p.getCANT() * p.getPREVEN();
            }
            return quantity;
        } catch (Exception e) {
            System.out.println("Error en Servicios total(): " + e.getMessage());
            return 0.0;
        }
    }

    public void delete(int index) {
        datos.remove(index);
    }

    public void registrar() throws Exception {
        try {
            String sql = "INSERT INTO VENTA.VENTA_DETALLE (IDVEN, IDEQU, CANT)"
                    + "VALUES(?,?,?)";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            int insertions = 0;
            for (VentaDet u : datos) {
                ps.setString(1, u.getIDVEN());
                ps.setString(2, this.codigo(u.getIDEQU()));
                ps.setInt(3, u.getCANT());
                ps.executeUpdate();                
            }
            ps.close();
            limpiar();
        } catch (Exception e) {
            System.out.println("Error al registrar VdI: " + e.getMessage());
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
        String sql = "SELECT \n"
                + "	EQ.IDEQU, EQ.NOMEQUI, PR.PREVEN\n"
                + "FROM VENTA.EQUIPO AS EQ\n"
                + "	LEFT JOIN VENTA.PRECIO AS PR\n"
                + "		ON EQ.IDEQU = PR.IDEQU\n"
                + "WHERE PR.ESTPRE = 'A' AND NOMEQUI LIKE ? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, "%" + consulta + "%");
            lista = new ArrayList();
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("NOMEQUI"));
                setPrecio(Double.parseDouble(rs.getString("PREVEN")));
            }
            ps.close();
            return lista;
        } catch (Exception e) {
            System.out.println("Error al buscar persona: " + e.getMessage());
            return null;
        }
    }

    //BUSCAR CODIGO DE VENTA
    public void codig(VentaDet detVenta) throws Exception {
        ResultSet rs;
        try {
            String sql = "SELECT MAX(IDVEN) AS IDVEN FROM Venta.VENTA";
            rs = this.conectar().createStatement().executeQuery(sql);
            while (rs.next()) {
                detVenta.setIDVEN(rs.getString("IDVEN"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error CodigoDAO codig(): " + e.getMessage());
        }
    }
    
    
    
    //Generado
    public List<VentaDet> getDatos() {
        return datos;
    }

    public void setDatos(List<VentaDet> datos) {
        this.datos = datos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}

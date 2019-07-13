package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Equipo;

public class EquipoImpl extends Conexion implements ICRUD<Equipo>{

    @Override
    public void registrar(Equipo equipo) throws Exception {
        try {
            String sql = "INSERT INTO VENTA.EQUIPO (NOMEQUI, DESCEQU, CATEQUI, PREEQUI)"
                    + "VALUES(?,?,?,?)";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, equipo.getNOMEQUI());
            ps.setString(2, equipo.getDESCEQU());
            ps.setString(3, equipo.getCATEQUI());
            ps.setDouble(4, equipo.getPREEQUI());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al registrar EI: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Equipo equipo) throws Exception {
        try {
            String sql = "UPDATE VENTA.EQUIPO SET NOMEQUI=?, DESCEQU=?, CATEQUI=?, PREEQUI=? where IDEQU =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, equipo.getNOMEQUI());
            ps.setString(2, equipo.getDESCEQU());
            ps.setString(3, equipo.getCATEQUI());
            ps.setDouble(4, equipo.getPREEQUI());
            ps.setInt(5, equipo.getIDEQU());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al modificar EI: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Equipo equipo) throws Exception {
        try {
            String sql = "UPDATE VENTA.EQUIPO SET ESTEQU='I' where IDEQU =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, equipo.getIDEQU());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al modificar SI: " + e.getMessage());
        }
    }

    @Override
    public List<Equipo> listar() throws Exception {
        List<Equipo> lista;
        Equipo equipo;
        String sql ="SELECT * FROM Venta.EQUIPO";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            lista = new ArrayList();
            while(rs.next()){
                equipo = new Equipo();
                equipo.setIDEQU(rs.getInt("IDEQU"));
                equipo.setNOMEQUI(rs.getString("NOMEQUI"));
                equipo.setDESCEQU(rs.getString("DESCEQU"));
                equipo.setCATEQUI(rs.getString("CATEQUI"));
                equipo.setPREEQUI(rs.getDouble("PREEQUI"));
                equipo.setESTEQU(rs.getString("ESTEQU"));
                lista.add(equipo);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error al listar SI: " + e.getMessage());
            return null;
        }
        return lista;
    }
    
}

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Sucursal;

public class SucursalImpl extends Conexion implements ICRUD<Sucursal>{

    @Override
    public void registrar(Sucursal sucursal) throws Exception {
        try {
            String sql = "INSERT INTO PERSONA.SUCURSAL (NOMSUC, DESCSUC, DIRSUC, CODUBI, ESTSUC)"
                    + "VALUES(?,?,?,?,'A')";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, sucursal.getNOMSUC());
            ps.setString(2, sucursal.getDESCSUC());
            ps.setString(3, sucursal.getDIRSUC());
            ps.setString(4, sucursal.getCODUBI());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al registrar SI: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Sucursal sucursal) throws Exception {
        try {
            String sql = "UPDATE PERSONA.SUCURSAL SET NOMSUC=?, DESCSUC=?, DIRSUC=?, CODUBI=?, ESTSUC=? where IDSUC =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, sucursal.getNOMSUC());
            ps.setString(2, sucursal.getDESCSUC());
            ps.setString(3, sucursal.getDIRSUC());
            ps.setString(4, sucursal.getCODUBI());
            ps.setString(5, sucursal.getESTSUC());
            ps.setInt(6, sucursal.getIDSUC());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al modificar SI: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Sucursal sucursal) throws Exception {
        try {
            String sql = "UPDATE PERSONA.SUCURSAL SET ESTSUC='I' where IDSUC =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, sucursal.getIDSUC());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al modificar SI: " + e.getMessage());
        }
    }

    @Override
    public List<Sucursal> listar() throws Exception {
        List<Sucursal> lista;
        Sucursal sucursal;
        String sql ="SELECT * FROM PERSONA.SUCURSAL";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            lista = new ArrayList();
            while(rs.next()){
                sucursal = new Sucursal();
                sucursal.setIDSUC(rs.getInt("IDSUC"));
                sucursal.setNOMSUC(rs.getString("NOMSUC"));
                sucursal.setDESCSUC(rs.getString("DESCSUC"));
                sucursal.setDIRSUC(rs.getString("DIRSUC"));
                sucursal.setCODUBI(rs.getString("CODUBI"));
                sucursal.setESTSUC(rs.getString("ESTSUC"));
                lista.add(sucursal);
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

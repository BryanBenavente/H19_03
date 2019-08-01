package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Equipo;

public class EquipoImpl extends Conexion implements ICRUD<Equipo> {

    @Override
    public void registrar(Equipo equipo) throws Exception {
        try {
            String sql = "INSERT INTO VENTA.EQUIPO (NOMEQUI, MAREQU, DESCEQU, CATEQUI, IMGEQU)"
                    + "VALUES(?,?,?,?,?)";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, equipo.getNOMEQUI());
            ps.setString(2, equipo.getMAREQU());
            ps.setString(3, equipo.getDESCEQU());
            ps.setString(4, equipo.getCATEQUI());
            ps.setString(5, equipo.getIMGEQU());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al registrar EI: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Equipo equipo) throws Exception {
        try {
            String sql = "UPDATE VENTA.EQUIPO SET NOMEQUI=?, MAREQU=?, DESCEQU=?, CATEQUI=?, IMGEQU=? where IDEQU =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, equipo.getNOMEQUI());
            ps.setString(2, equipo.getMAREQU());
            ps.setString(3, equipo.getDESCEQU());
            ps.setString(4, equipo.getCATEQUI());
            ps.setString(5, equipo.getIMGEQU());
            ps.setInt(6, equipo.getIDEQU());
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
        String sql = "SELECT \n"
                + "	EQ.IDEQU, EQ.NOMEQUI, EQ.DESCEQU, \n"
                + "	EQ.CATEQUI, EQ.ESTEQU, EQ.MAREQU,\n"
                + "	EQ.IMGEQU, EQ.CANTEQU, PE.ESTPRE,\n"
                + "	PE.PRECOM, PE.PREVEN\n"
                + "FROM VENTA.EQUIPO AS EQ\n"
                + "	left join VENTA.PRECIO AS PE\n"
                + "		ON PE.IDEQU = EQ.IDEQU\n"
                + "WHERE PE.ESTPRE = 'A'\n"
                + "ORDER BY EQ.IDEQU";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            lista = new ArrayList();
            while (rs.next()) {
                equipo = new Equipo();
                equipo.setIDEQU(rs.getInt("IDEQU"));
                equipo.setNOMEQUI(rs.getString("NOMEQUI"));
                equipo.setDESCEQU(rs.getString("DESCEQU"));
                equipo.setCATEQUI(rs.getString("CATEQUI"));
                equipo.setESTEQU(rs.getString("ESTEQU"));
                equipo.setMAREQU(rs.getString("MAREQU"));
                equipo.setIMGEQU(rs.getString("IMGEQU"));
                equipo.setCANTEQU(rs.getInt("CANTEQU"));
                equipo.setESTPRE(rs.getString("ESTPRE"));
                equipo.setPRECOM(rs.getDouble("PRECOM"));
                equipo.setPREVEN(rs.getDouble("PREVEN"));
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

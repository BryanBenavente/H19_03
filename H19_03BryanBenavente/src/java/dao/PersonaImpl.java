package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Persona;
import services.Encriptacion;

public class PersonaImpl extends Conexion implements ICRUD<Persona>{

    Encriptacion enc = new Encriptacion();
    
    @Override
    public void registrar(Persona persona) throws Exception {
        try {            
            String sql = "INSERT INTO PERSONA.PERSONA(NOMPER, APEPER, DNIPER, CELPER, DIRPER, CODUBI, TIPPER, IDSUC, USUPER, PASPER) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, persona.getNOMPER());
            ps.setString(2, persona.getAPEPER());
            ps.setString(3, persona.getDNIPER());
            ps.setString(4, persona.getCELPER());
            ps.setString(5, persona.getDIRPER());
            ps.setString(6, persona.getCODUBI());
            ps.setString(7, persona.getTIPPER());
            if(persona.getIDSUC() != null){
                ps.setString(8, persona.getIDSUC());
            } else {
                ps.setString(8, null);
            }
            ps.setString(9, persona.getUSUPER());
            ps.setString(10, enc.encriptar(persona.getPASPER()));
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al registrar PI: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Persona persona) throws Exception {
        try {
            String sql = "UPDATE PERSONA.PERSONA SET NOMPER=?, APEPER=?, DNIPER=?, CELPER=?, DIRPER=?, CODUBI=?, TIPPER=?, USUPER=?, PASPER =? "
                    + "WHERE IDPER =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, persona.getNOMPER());
            ps.setString(2, persona.getAPEPER());
            ps.setString(3, persona.getDNIPER());
            ps.setString(4, persona.getCELPER());
            ps.setString(5, persona.getDIRPER());
            ps.setString(6, persona.getCODUBI());
            ps.setString(7, persona.getTIPPER());
            ps.setString(8, persona.getUSUPER());
            if(persona.getPASPER() != null){
               ps.setString(9, enc.encriptar(persona.getPASPER()));
            } else {
                ps.setString(9, "");
            }
            ps.setInt(10, persona.getIDPER());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al modificar PI: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Persona persona) throws Exception {
        try {
            String sql = "UPDATE PERSONA.PERSONA SET ESTPER ='I' WHERE IDPER =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, persona.getIDPER());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar PI: " + e.getMessage());
        }
    }

    @Override
    public List<Persona> listar() throws Exception {
        List<Persona> lista;
        Persona persona;
        String sql ="SELECT * FROM PERSONA.PERSONA where ESTPER = 'A'";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            lista = new ArrayList();
            while(rs.next()){
                persona = new Persona();
                persona.setIDPER(rs.getInt("IDPER"));
                persona.setNOMPER(rs.getString("NOMPER"));
                persona.setAPEPER(rs.getString("APEPER"));
                persona.setDNIPER(rs.getString("DNIPER"));
                persona.setCELPER(rs.getString("CELPER"));
                persona.setDIRPER(rs.getString("DIRPER"));
                persona.setCODUBI(rs.getString("CODUBI"));
                persona.setTIPPER(rs.getString("TIPPER"));
                persona.setIDSUC(rs.getString("IDSUC"));
                persona.setUSUPER(rs.getString("USUPER"));
                persona.setPASPER(rs.getString("PASPER"));
                persona.setESTPER(rs.getString("ESTPER"));
                lista.add(persona);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error al listar PI: " + e.getMessage());
            return null;
        }
        return lista;
    }
    
    public List<Persona> lista() throws Exception {
        List<Persona> lista;
        Persona persona;
        String sql = "SELECT IDSUC, NOMSUC FROM PERSONA.SUCURSAL WHERE ESTSUC = 'A'";
        try {
            lista = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                persona = new Persona();
                persona.setIDSUC(rs.getString("IDSUC"));
                persona.setNOMSUC(rs.getString("NOMSUC"));
                lista.add(persona);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en lista movimientoI: " + e.getMessage());
            return null;
        }
        return lista;
    }
    
}

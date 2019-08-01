package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Persona;

public class LoginImpl extends Conexion{

    public Persona startSession(String User, String Pass) {
        try {
            Persona login = null;
            ResultSet rs;
            String sql = "SELECT IDPER, NOMPER, APEPER, TIPPER FROM PERSONA.PERSONA where USUPER =? and PASPER =?";
            PreparedStatement ps = this.conectar().prepareCall(sql);
            ps.setString(1, User);
            ps.setString(2, Pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                login = new Persona();
                login.setIDPER(rs.getInt("IDPER"));
                login.setNOMPER(rs.getString("NOMPER"));
                login.setAPEPER(rs.getString("APEPER"));
                login.setTIPPER(rs.getString("TIPPER"));
                login.setUSUPER(User);
                login.setPASPER(Pass);
            }
            return login;
        } catch (Exception e) {
            System.out.println("ERROR EN LoginPImpl: " + e.getMessage());
            return null;
        }
    }
    
}

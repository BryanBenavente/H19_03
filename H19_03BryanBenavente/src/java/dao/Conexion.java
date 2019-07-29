package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    
    private Connection cn;
    
    public Connection conectar(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            cn = DriverManager.getConnection("jdbc:sqlserver://bryanvg.database.windows.net; databaseName=VENTA;"
//                    + "user=bryanbenavente; password=Bryanbc17");
            cn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-D35JLBTN; databaseName=VENTA;"
                    + "user=sa; password=bryan");
        } catch (Exception e) {
            System.out.println("Error al conectar " + e.getMessage());
        }
        return cn;
    }
    
//    public static void main(String[] args) {
//        Conexion con = new Conexion();
//        con.conectar();
//        if(con != null)
//            JOptionPane.showConfirmDialog(null, "Conectado");
//    }
    
}

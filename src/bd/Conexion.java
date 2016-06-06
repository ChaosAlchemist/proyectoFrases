package bd;

import java.sql.*;

public class Conexion {
    private Connection con;
    private Statement sen;
    private ResultSet rs; 
    
    public Conexion(String server, String bd, String user, String pass) throws SQLException{
        String protocolo = "jdbc:mysql://";
        String lineaUser = "user="+user;
        String lineaPass = "password="+pass;
        
        
        String url = protocolo + 
                server + "/" + 
                bd + "?" + 
                lineaUser + "&" +
                lineaPass;
        
        System.out.println(url);        
        con = DriverManager.getConnection(url);
    }
    
    public void ejecutar(String query) throws SQLException{
        sen=con.createStatement();
        sen.executeUpdate(query);
        sen.close();
    }
    

    public ResultSet ejecutarSelect(String query) throws SQLException{
 
        sen=con.createStatement(); 
        rs=sen.executeQuery(query);
        return rs;        
    }
    
    public void desconectar() throws SQLException{
        sen.close();
    }
}
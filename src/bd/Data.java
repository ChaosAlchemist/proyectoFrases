/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Emilio
 */
public class Data {
    private Conexion c;
    private String query;
    private ResultSet rs;    
    
    public Data() throws SQLException{
        c = new Conexion(
            "localhost", //servidor
            "db_frases", //base de datos 
            "root", //permiso
            "123456" //clave
        );
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import data.*;

/**
 *
 * @author Emilio
 */
public class Data {
    private Conexion c;
    private String q;
    private ResultSet rs;    
    
    public Data() throws SQLException{
        c = new Conexion(
            "localhost", //servidor
            "db_frases", //base de datos 
            "root", //permiso
            "123456" //clave
        );
    }

    public void insertar(Object o){
        if(o instanceof Personaje){
            q = "insert into personajes values (null,'"+((Personaje) o).getNombre()+"');";
        }else if(o instanceof Accion){
            q = "insert into accion values (null,'"+((Accion) o).getAccion()+"');";
        }else{
            q = "insert into lugar values (null,'"+((Lugar) o).getLugar()+"');";
        }
    }
    
}

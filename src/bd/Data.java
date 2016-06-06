/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import data.*;
import java.util.Random;

/**
 *
 * @author Emilio
 */
public class Data {

    private Conexion c;
    private String q;
    private ResultSet rs;
    private Random rd;
    private static final int PERSONAJE=1;
    private static final int ACCION=2;
    private static final int LUGAR=3;

    public Data() throws SQLException {
        c = new Conexion(
                "localhost", //servidor
                "db_frases", //base de datos 
                "root", //permiso
                "123456" //clave
        );
        rd=new Random();        
    }
    
    private int getRango(int tipo) throws SQLException{
        int rango=0;
        switch(tipo){
            case PERSONAJE:
                q="select max(id) from personajes";
                rs=c.ejecutarSelect(q);
                
                if(rs.next()){
                    rango=rs.getInt(1);
                }                
                break;                
            case ACCION:
                q="select max(id) from acciones";
                rs=c.ejecutarSelect(q);
                
                if(rs.next()){
                    rango=rs.getInt(1);
                }                          
                break;
            case LUGAR:
                q="select max(id) from lugares";
                rs=c.ejecutarSelect(q);
                
                if(rs.next()){
                    rango=rs.getInt(1);
                }                          
                break;
        }
        return rango;        
    }    

    public void insertar(Object o) throws SQLException {
        if (o instanceof Personaje) {
            q = "insert into personajes values (null,'" + ((Personaje) o).getNombre() + "');";
        } else if (o instanceof Accion) {
            q = "insert into acciones values (null,'" + ((Accion) o).getAccion() + "');";
        } else {
            q = "insert into lugares values (null,'" + ((Lugar) o).getLugar() + "');";
        }

        c.ejecutar(q);
    }

    public String generarFrase(int id) throws SQLException {
        String frase = "";
        int idPersonaje=rd.nextInt(getRango(PERSONAJE));
        int idAccion=rd.nextInt(getRango(ACCION));
        int idLugar=rd.nextInt(getRango(LUGAR));
        // Nombre        
        q = "select nombre from personajes where id = " + idPersonaje;
        c.ejecutarSelect(q);
        frase += q;

        // Acción        
        q = "select accion from acciones where id = " + idAccion;
        c.ejecutarSelect(q);
        frase += q;

        // Lugar        
        q = "select lugar from lugares where id = " + idLugar;
        c.ejecutarSelect(q);
        frase += q;
        
        return frase;

    }

}

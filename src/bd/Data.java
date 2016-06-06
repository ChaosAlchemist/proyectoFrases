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
    public static final int PERSONAJE = 1;
    public static final int ACCION = 2;
    public static final int LUGAR = 3;

    public Data() throws SQLException {
        c = new Conexion(
                "localhost", //servidor
                "db_frases", //base de datos 
                "root", //permiso
                "" //clave
        );
        rd = new Random();
    }

    public int getRango(int tipo) throws SQLException {
        int rango = 0;
        switch (tipo) {
            case PERSONAJE:
                q = "select max(id) from personajes";
                rs = c.ejecutarSelect(q);

                if (rs.next()) {
                    rango = rs.getInt(1);
                }
                break;
            case ACCION:
                q = "select max(id) from acciones";
                rs = c.ejecutarSelect(q);

                if (rs.next()) {
                    rango = rs.getInt(1);
                }
                break;
            case LUGAR:
                q = "select max(id) from lugares";
                rs = c.ejecutarSelect(q);

                if (rs.next()) {
                    rango = rs.getInt(1);
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
        } else if (o instanceof Lugar) {
            q = "insert into lugares values (null,'" + ((Lugar) o).getLugar() + "');";
        }

        System.out.println(q);
        c.ejecutar(q);
    }

    public int generarRandom(int min, int max) {
        int num = (rd.nextInt(max - min) + min);
        return num;
    }

    public String generarFrase() throws SQLException {
        String frase = "";
        String palabra = "";
        int r = 0;

        // Nombre        
        r = generarRandom(1, getRango(PERSONAJE)+1);
        q = "select nombre from personajes where id = " + r;
        rs = c.ejecutarSelect(q);
        
        if (rs.next()) {
            palabra = rs.getString(1);
        }
        
        frase += (palabra + " ");
        c.desconectar();
        
        
        // Acción
        r = generarRandom(1, getRango(ACCION)+1);
        q = "select accion from acciones where id = " + r;
        rs = c.ejecutarSelect(q);
        
        if (rs.next()) {
            palabra = rs.getString(1);
        }
        
        frase += (palabra + " ");
        c.desconectar();
        
        // Lugar        
        r = generarRandom(1, getRango(LUGAR)+1);
        q = "select lugar from lugares where id = " + r;
        rs = c.ejecutarSelect(q);
        if (rs.next()) {
            palabra = rs.getString(1);
        }
        
        frase += (palabra + " ");
        c.desconectar();

        return frase;

    }

}

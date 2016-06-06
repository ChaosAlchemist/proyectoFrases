/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Emilio
 */
public class Personaje {
    private int id;
    private String nobmre;

    public Personaje(String nobmre) {
        this.nobmre = nobmre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNobmre() {
        return nobmre;
    }

    public void setNobmre(String nobmre) {
        this.nobmre = nobmre;
    }
    
    
}

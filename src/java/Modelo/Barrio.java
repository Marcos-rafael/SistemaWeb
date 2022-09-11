/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Marcos
 */
public class Barrio {
    int id;
    String nombre_barrio;
    String idciudad;

    public Barrio() {
    }

    public Barrio(int id, String nombre_barrio, String idciudad) {
        this.id = id;
        this.nombre_barrio = nombre_barrio;
        this.idciudad = idciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_barrio() {
        return nombre_barrio;
    }

    public void setNombre_barrio(String nombre_barrio) {
        this.nombre_barrio = nombre_barrio;
    }

    public String getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(String idciudad) {
        this.idciudad = idciudad;
    }
    
    
    
}

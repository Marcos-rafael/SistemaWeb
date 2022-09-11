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
public class Cargo {
    private int id;
    private String nombrecargo;
    private boolean estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrecargo() {
        return nombrecargo;
    }

    public void setNombrecargo(String nombrecargo) {
        this.nombrecargo = nombrecargo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
}

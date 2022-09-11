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
public class Departamento {
    int id;
    String nombreDepartamento;
    
    public Departamento() {
    
    }

    public Departamento(int id, String nombreDepartamento) {
        this.id = id;
        this.nombreDepartamento = nombreDepartamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }    
}

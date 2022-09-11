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
public class Comisaria {
    int id;
    String nombre_comisaria;
    String telefono;
    String direccion;
    String cod_departamento;
    String cod_ciudad;
    String cod_barrio;
    String estado;
    
    public Comisaria() {
    
    }

    public Comisaria(int id, String nombre_comisaria, String telefono, String direccion, String cod_departamento, String cod_ciudad, String cod_barrio, String estado) {
        this.id = id;
        this.nombre_comisaria = nombre_comisaria;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cod_departamento = cod_departamento;
        this.cod_ciudad = cod_ciudad;
        this.cod_barrio = cod_barrio;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_comisaria() {
        return nombre_comisaria;
    }

    public void setNombre_comisaria(String nombre_comisaria) {
        this.nombre_comisaria = nombre_comisaria;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCod_departamento() {
        return cod_departamento;
    }

    public void setCod_departamento(String cod_departamento) {
        this.cod_departamento = cod_departamento;
    }

    public String getCod_ciudad() {
        return cod_ciudad;
    }

    public void setCod_ciudad(String cod_ciudad) {
        this.cod_ciudad = cod_ciudad;
    }

    public String getCod_barrio() {
        return cod_barrio;
    }

    public void setCod_barrio(String cod_barrio) {
        this.cod_barrio = cod_barrio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}

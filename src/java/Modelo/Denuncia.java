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
public class Denuncia {
    int id;
    int item;
    String tipoobjetod;
    String seried;
    String descripciond;
    String cedula;
    String nombre;
    String apellido;
    String nacionalidad;
    String estadocivil;
    String edad;
    String profesion;
    String direccion;
    String departamento;
    String ciudad;
    String barrio;
    String telefono;
    String fecha_hecho;
    String hora_hecho;
    String fecha_denuncia;
    String direccion_hecho;
    String firma;
    
    public Denuncia(){
    }

    public Denuncia(int id, int item, String tipoobjetod, String seried, String descripciond, String cedula, String nombre, String apellido, String nacionalidad, String estadocivil, String edad, String profesion, String direccion, String departamento, String ciudad, String barrio, String telefono, String fecha_hecho, String hora_hecho, String fecha_denuncia, String direccion_hecho, String firma) {
        this.id = id;
        this.item = item;
        this.tipoobjetod = tipoobjetod;
        this.seried = seried;
        this.descripciond = descripciond;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.estadocivil = estadocivil;
        this.edad = edad;
        this.profesion = profesion;
        this.direccion = direccion;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.barrio = barrio;
        this.telefono = telefono;
        this.fecha_hecho = fecha_hecho;
        this.hora_hecho = hora_hecho;
        this.fecha_denuncia = fecha_denuncia;
        this.direccion_hecho = direccion_hecho;
        this.firma = firma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getTipoobjetod() {
        return tipoobjetod;
    }

    public void setTipoobjetod(String tipoobjetod) {
        this.tipoobjetod = tipoobjetod;
    }

    public String getSeried() {
        return seried;
    }

    public void setSeried(String seried) {
        this.seried = seried;
    }

    public String getDescripciond() {
        return descripciond;
    }

    public void setDescripciond(String descripciond) {
        this.descripciond = descripciond;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_hecho() {
        return fecha_hecho;
    }

    public void setFecha_hecho(String fecha_hecho) {
        this.fecha_hecho = fecha_hecho;
    }

    public String getHora_hecho() {
        return hora_hecho;
    }

    public void setHora_hecho(String hora_hecho) {
        this.hora_hecho = hora_hecho;
    }

    public String getFecha_denuncia() {
        return fecha_denuncia;
    }

    public void setFecha_denuncia(String fecha_denuncia) {
        this.fecha_denuncia = fecha_denuncia;
    }

    public String getDireccion_hecho() {
        return direccion_hecho;
    }

    public void setDireccion_hecho(String direccion_hecho) {
        this.direccion_hecho = direccion_hecho;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public Object setDireccion_hecho(DenunciaDAO dedao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

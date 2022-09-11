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
public class Personas {
    int id;
    String tipodocumento;
    String numerodocumento;
    String nombre;
    String apellido;
    String nacionalidad;
    String fechanacimiento;
    String sexo;
    String estadocivil;
    String telefono;
    String email;
    String iddepartamento;
    String idciudad;
    String idbarrio;
    String direccion;
    String numerocasa;
    
    public Personas(){   
    }

    public Personas(int id, String tipodocumento, String numerodocumento, String nombre, String apellido, String nacionalidad, String fechanacimiento, String sexo, String estadocivil, String telefono, String email, String iddepartamento, String idciudad, String idbarrio, String direccion, String numerocasa) {
        this.id = id;
        this.tipodocumento = tipodocumento;
        this.numerodocumento = numerodocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.fechanacimiento = fechanacimiento;
        this.sexo = sexo;
        this.estadocivil = estadocivil;
        this.telefono = telefono;
        this.email = email;
        this.iddepartamento = iddepartamento;
        this.idciudad = idciudad;
        this.idbarrio = idbarrio;
        this.direccion = direccion;
        this.numerocasa = numerocasa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
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

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(String iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(String idciudad) {
        this.idciudad = idciudad;
    }

    public String getIdbarrio() {
        return idbarrio;
    }

    public void setIdbarrio(String idbarrio) {
        this.idbarrio = idbarrio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumerocasa() {
        return numerocasa;
    }

    public void setNumerocasa(String numerocasa) {
        this.numerocasa = numerocasa;
    }
    
    }

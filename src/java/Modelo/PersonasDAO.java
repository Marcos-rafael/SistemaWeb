/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class PersonasDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Personas buscar(String cedula) {
        Personas p = new Personas();
        String sql = "select * from persona where numerodocumento=" + cedula;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setTipodocumento(rs.getString(2));
                p.setNumerodocumento(rs.getString(3));
                p.setNombre(rs.getString(4));
                p.setApellido(rs.getString(5));
                p.setNacionalidad(rs.getString(6));
                p.setFechanacimiento(rs.getString(7));
                p.setSexo(rs.getString(8));
                p.setEstadocivil(rs.getString(9));
                p.setTelefono(rs.getString(10));
                p.setEmail(rs.getString(11));
                p.setIddepartamento(rs.getString(12));
                p.setIdciudad(rs.getString(13));
                p.setIdbarrio(rs.getString(14));
                p.setDireccion(rs.getString(15));
                p.setNumerocasa(rs.getString(16));
            }
        } catch (Exception e) {
        }
        return p;
    }
    //Operaciones CRUD

    public List listar() {
        String sql = "select p.idpersona, p.tipodocumento, p.numerodocumento, p.nombre, p.apellido, n.nombre_nacionalidad,\n"
                + "p.fechanacimiento, p.sexo, p.estadocivil, p.telefono, p.email, d.nombre_departamento,\n"
                + "c.nombreciudad, b.nombrebarrio, p.direccion, p.numerocasa\n"
                + "from persona p, departamento d, ciudad c, barrio b, nacionalidad n\n"
                + "where p.iddepartamento = d.iddepartamento\n"
                + "and p.idciudad = c.idciudad\n"
                + "and p.idbarrio = b.idbarrio\n"
                + "and p.nacionalidad = n.cod_nacionalidad";
        List<Personas> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Personas pers = new Personas();
                pers.setId(rs.getInt(1));
                pers.setTipodocumento(rs.getString(2));
                pers.setNumerodocumento(rs.getString(3));
                pers.setNombre(rs.getString(4));
                pers.setApellido(rs.getString(5));
                pers.setNacionalidad(rs.getString(6));
                pers.setFechanacimiento(rs.getString(7));
                pers.setSexo(rs.getString(8));
                pers.setEstadocivil(rs.getString(9));
                pers.setTelefono(rs.getString(10));
                pers.setEmail(rs.getString(11));
                pers.setIddepartamento(rs.getString(12));
                pers.setIdciudad(rs.getString(13));
                pers.setIdbarrio(rs.getString(14));
                pers.setDireccion(rs.getString(15));
                pers.setNumerocasa(rs.getString(16));
                lista.add(pers);
            }
        } catch (SQLException e) {
        }
        return lista;
    }

    public int agregar(Personas p) {
        String sql = "INSERT INTO persona(tipodocumento, numerodocumento, nombre, apellido, nacionalidad, fechanacimiento, sexo, estadocivil, telefono, email, iddepartamento, idciudad, idbarrio, direccion, numerocasa) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getTipodocumento());
            ps.setString(2, p.getNumerodocumento());
            ps.setString(3, p.getNombre());
            ps.setString(4, p.getApellido());
            ps.setString(5, p.getNacionalidad());
            ps.setString(6, p.getFechanacimiento());
            ps.setString(7, p.getSexo());
            ps.setString(8, p.getEstadocivil());
            ps.setString(9, p.getTelefono());
            ps.setString(10, p.getEmail());
            ps.setString(11, p.getIddepartamento());
            ps.setString(12, p.getIdciudad());
            ps.setString(13, p.getIdbarrio());
            ps.setString(14, p.getDireccion());
            ps.setString(15, p.getNumerocasa());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public Personas listarId(int id) {
        Personas per = new Personas();
        String sql = "select * from persona where idpersona=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                per.setTipodocumento(rs.getString(2));
                per.setNumerodocumento(rs.getString(3));
                per.setNombre(rs.getString(4));
                per.setApellido(rs.getString(5));
                per.setNacionalidad(rs.getString(6));
                per.setFechanacimiento(rs.getString(7));
                per.setSexo(rs.getString(8));
                per.setEstadocivil(rs.getString(9));
                per.setTelefono(rs.getString(10));
                per.setEmail(rs.getString(11));
                per.setIddepartamento(rs.getString(12));
                per.setIdciudad(rs.getString(13));
                per.setIdbarrio(rs.getString(14));
                per.setDireccion(rs.getString(15));
                per.setNumerocasa(rs.getString(16));
            }
        } catch (Exception e) {
        }
        return per;
    }

    public int actualizar(Personas p) {
        String sql = "UPDATE persona SET tipodocumento=?,numerodocumento=?,nombre=?,apellido=?,nacionalidad=?,fechanacimiento=?,sexo=?,estadocivil=?,telefono=?,email=?,iddepartamento=?,idciudad=?,idbarrio=?,direccion=?,numerocasa=? WHERE idpersona=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getTipodocumento());
            ps.setString(2, p.getNumerodocumento());
            ps.setString(3, p.getNombre());
            ps.setString(4, p.getApellido());
            ps.setString(5, p.getNacionalidad());
            ps.setString(6, p.getFechanacimiento());
            ps.setString(7, p.getSexo());
            ps.setString(8, p.getEstadocivil());
            ps.setString(9, p.getTelefono());
            ps.setString(10, p.getEmail());
            ps.setString(11, p.getIddepartamento());
            ps.setString(12, p.getIdciudad());
            ps.setString(13, p.getIdbarrio());
            ps.setString(14, p.getDireccion());
            ps.setString(15, p.getNumerocasa());
            ps.setInt(16, p.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public void delete(int id) {
        String sql = "delete from persona where idpersona=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}

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
public class CiudadDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public List listar() {
        String sql="select c.idciudad, c.nombreciudad, d.nombre_departamento from ciudad c, departamento d where c.iddepartamento = d.iddepartamento";
        List<Ciudad>lista=new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ciudad ciud=new Ciudad();
                ciud.setId(rs.getInt(1));
                ciud.setNombre_ciudad(rs.getString(2));
                ciud.setIdDepartamento(rs.getString(3));
                lista.add(ciud);
            }
        } catch (SQLException e) {
        }
        return lista;
    }

    public int agregar(Ciudad c) {
        String sql = "insert into ciudad (nombreciudad,  iddepartamento) values(?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre_ciudad());
            ps.setString(2, c.getIdDepartamento());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public Ciudad listarId(int id) {
        Ciudad ciu = new Ciudad();
        String sql = "select * from ciudad where idciudad="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ciu.setNombre_ciudad(rs.getString(2));
                ciu.setIdDepartamento(rs.getString(3));
            }

        } catch (Exception e) {   
        }
        return ciu;
    }

    public int actualizar(Ciudad c) {
        String sql = "update ciudad set nombreciudad=?, iddepartamento=? where idciudad=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre_ciudad());
            ps.setString(2, c.getIdDepartamento());
            ps.setInt(3, c.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public void delete(int id) {
        String sql = "delete from ciudad where idciudad="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }
}

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
public class BarrioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public List listar() {
        String sql="select b.idbarrio, b.nombrebarrio, c.nombreciudad from barrio b, ciudad c\n" +
        "where b.idciudad = c.idciudad";
        List<Barrio>lista=new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Barrio bar=new Barrio();
                bar.setId(rs.getInt(1));
                bar.setNombre_barrio(rs.getString(2));
                bar.setIdciudad(rs.getString(3));
                lista.add(bar);
            }
        } catch (SQLException e) {
        }
        return lista;
    }

    public int agregar(Barrio b) {
        String sql = "insert into barrio (nombrebarrio,  idciudad) values(?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, b.getNombre_barrio());
            ps.setString(2, b.getIdciudad());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public Barrio listarId(int id) {
        Barrio bar = new Barrio();
        String sql = "select * from barrio where idbarrio="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                bar.setNombre_barrio(rs.getString(2));
                bar.setIdciudad(rs.getString(3));
            }

        } catch (Exception e) {   
        }
        return bar;
    }

    public int actualizar(Barrio b) {
        String sql = "update barrio set nombrebarrio=?, idciudad=? where idbarrio=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, b.getNombre_barrio());
            ps.setString(2, b.getIdciudad());
            ps.setInt(3, b.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public void delete(int id) {
        String sql = "delete from barrio where idbarrio="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }
}

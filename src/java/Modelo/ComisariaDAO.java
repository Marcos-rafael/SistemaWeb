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
public class ComisariaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listar() {
        String sql="select co.cod_comisaria, co.nombre_comisaria, co.telefono, co.cod_direccion,\n" +
                   "d.nombre_departamento, c.nombreciudad, b.NOMBREBARRIO, co.estado\n" +
                   "from comisaria co, departamento d, ciudad c, barrio b \n" +
                   "where co.cod_departamento = d.iddepartamento\n" +
                   "and co.cod_ciudad = c.idciudad\n" +
                   "and co.cod_barrio = b.idbarrio";
        List<Comisaria>lista=new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Comisaria comi=new Comisaria();
                comi.setId(rs.getInt(1));
                comi.setNombre_comisaria(rs.getString(2));
                comi.setTelefono(rs.getString(3));
                comi.setDireccion(rs.getString(4));
                comi.setCod_departamento(rs.getString(5));
                comi.setCod_ciudad(rs.getString(6));
                comi.setCod_barrio(rs.getString(7));
                comi.setEstado(rs.getString(8));
                lista.add(comi);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    public int agregar(Comisaria c) {
        String sql = "insert into comisaria (nombre_comisaria,  telefono, cod_direccion, cod_departamento, cod_ciudad, cod_barrio, estado) values(?,?,?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, c.getNombre_comisaria());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getDireccion());
            ps.setString(4, c.getCod_departamento());
            ps.setString(5, c.getCod_ciudad());
            ps.setString(6, c.getCod_barrio());
            ps.setString(7, c.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public Comisaria listarId(int id) {
        Comisaria comi = new Comisaria();
        String sql = "select * from comisaria where cod_comisaria="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                comi.setNombre_comisaria(rs.getString(2));
                comi.setTelefono(rs.getString(3));
                comi.setDireccion(rs.getString(4));
                comi.setCod_departamento(rs.getString(5));
                comi.setCod_ciudad(rs.getString(6));
                comi.setCod_barrio(rs.getString(7));
                comi.setEstado(rs.getString(8));
            }

        } catch (Exception e) {   
        }
        return comi;
    }

    public int actualizar(Comisaria c) {
        String sql = "update comisaria set nombre_comisaria=?, telefono=?, cod_direccion=?, cod_departamento=?, cod_ciudad=?, cod_barrio=?, estado=? where cod_comisaria=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, c.getNombre_comisaria());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getDireccion());
            ps.setString(4, c.getCod_departamento());
            ps.setString(5, c.getCod_ciudad());
            ps.setString(6,c.getCod_barrio());
            ps.setString(7, c.getEstado());
            ps.setInt(8, c.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public void delete(int id) {
        String sql = "delete from comisaria where cod_comisaria="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }
}

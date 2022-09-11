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
public class DepartamentoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listar(){
        String sql="select * from departamento";
        List<Departamento>lista=new ArrayList<>();
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Departamento dep=new Departamento();
                dep.setId(rs.getInt(1));
                dep.setNombreDepartamento(rs.getString(2));
                lista.add(dep);                
            } 
        }catch (SQLException e){
        }
        return lista;
    }
    public int agregar (Departamento d){
        String sql = "insert into departamento (nombre_departamento) values(?)";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, d.getNombreDepartamento());
            ps.executeUpdate();
        }catch (Exception e){          
        }
        return r;
    }
    public Departamento listarId(int id){
        Departamento depa=new Departamento();
        String sql= "select * from departamento where iddepartamento="+id;
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                depa.setNombreDepartamento(rs.getString(2));               
            }
            
        }catch (Exception e){  
        }
        return depa;
    }
    public int actualizar(Departamento d){
        String sql = "update departamento set nombre_departamento=? where iddepartamento=?";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, d.getNombreDepartamento());
            ps.setInt(2,d.getId());
            ps.executeUpdate();
        }catch (Exception e){
        }
        return r;
    }
    public void delete(int id){
        String sql = "delete from departamento where iddepartamento="+id;
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){ 
            
        }
    }
}

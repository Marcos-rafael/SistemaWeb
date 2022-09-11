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

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Usuario validar(String usuario, String password){
        Usuario usu=new Usuario();
        String sql="select * from usuario where usuario=? and password=?";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, password);
            rs=ps.executeQuery();
            while(rs.next()){
                usu.setId(rs.getInt("idusuario"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setPassword(rs.getString("password"));
                usu.setEstado(rs.getString("estado"));
            }
        }catch(SQLException ex){  
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usu;
    }
    //Operaciones CRUD
    public List listar(){
        String sql="select * from usuario";
        List<Usuario>lista=new ArrayList<>();
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Usuario us=new Usuario();
                us.setId(rs.getInt(1));
                us.setUsuario(rs.getString(2));
                us.setPassword(rs.getString(3));
                us.setCargo(rs.getString(4));
                us.setEstado(rs.getString(5));
                lista.add(us);                
            } 
        }catch (SQLException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
        
    public int agregar (Usuario u){
        String sql = "insert into usuario (usuario, password, cargo, estado) values(?,?,?,?)";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getCargo());
            ps.setString(4, u.getEstado());
            ps.executeUpdate();
        }catch (Exception e){          
        }
        return r;
    }
    public Usuario listarId(int id){
        Usuario usua=new Usuario();
        String sql= "select * from usuario where idusuario="+id;
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                usua.setUsuario(rs.getString(2));
                usua.setPassword(rs.getString(3));
                usua.setCargo(rs.getString(4));
                usua.setEstado(rs.getString(5));               
            }            
        }catch (Exception e){  
        }
        return usua;
    }
    public int actualizar(Usuario u){
        String sql = "update usuario set usuario=?, password=?, cargo=?, estado=? where idusuario=?";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getCargo());
            ps.setString(4, u.getEstado());
            ps.setInt(5, u.getId());
            ps.executeUpdate();
        }catch (Exception e){          
        }
        return r;
    }
    public void delete(int id){
        String sql = "delete from usuario where idusuario="+id;
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){     
        }
    }
}

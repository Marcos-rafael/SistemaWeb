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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


/**
 *
 * @author Marcos
 */
public class DenunciaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public List listar() {
        String sql="select * from denuncia_cabecera";
        List<Denuncia>lista=new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Denuncia denun=new Denuncia();
                denun.setId(rs.getInt(1));
                denun.setCedula(rs.getString(2));
                denun.setNombre(rs.getString(3));
                denun.setApellido(rs.getString(4));
                denun.setNacionalidad(rs.getString(5));
                denun.setEstadocivil((rs.getString(6)));
                denun.setDireccion(rs.getString(7));
                denun.setCiudad(rs.getString(8));
                denun.setBarrio(rs.getString(9));
                denun.setTelefono(rs.getString(10));
                denun.setFecha_denuncia(rs.getString(11));
                denun.setFirma(rs.getString(12));
                lista.add(denun);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
    
    public String IdDenuncia(){
        String iddenuncia="";
        String sql="select max(iddenuncia) from denuncia_cabecera";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                iddenuncia=rs.getString(1);
            }
        } catch (Exception e){
        }
        return iddenuncia;
    }
    
    public int guardaDenuncia(Denuncia den){
        String sql="insert into denuncia_cabecera(cedula, nombre, apellido, nacionalidad, estado_civil, direccion, ciudad, barrio, telefono, fecha_denuncia)values(?,?,?,?,?,?,?,?,?,?)";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, den.getCedula());
            ps.setString(2, den.getNombre());
            ps.setString(3, den.getApellido());
            ps.setString(4, den.getNacionalidad());
            ps.setString(5, den.getEstadocivil());
            ps.setString(6, den.getDireccion());
            ps.setString(7, den.getCiudad());
            ps.setString(8, den.getBarrio());
            ps.setString(9, den.getTelefono());
            ps.setString(10,den.getFecha_denuncia());
            ps.executeUpdate();
        }catch (Exception e){
        }
        return r;
    }
    
    public int guardarDetalledenuncia(Denuncia denuncia){
        String sql= "insert into denuncia_detalle(iddenuncia_cabecera, tipo_objeto, serie, descripcion) values (?,?,?,?)";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, denuncia.getId()); 
            ps.setString(2, denuncia.getTipoobjetod());
            ps.setString(3, denuncia.getSeried());
            ps.setString(4, denuncia.getDescripciond());
            ps.executeUpdate();
        }catch (Exception e){
        }
        return r;
    }
    public String GenerarSerie(){
        String numeroserie="";
        String sql="select max(numeroserie) from denuncia_cabecera";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                numeroserie=rs.getString(1);
            }
        }catch (Exception e){
        }
        return numeroserie;
    }
    
    public String fecha(){
        Date fecha=new Date();
        SimpleDateFormat formatofecha=new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);
    }
}

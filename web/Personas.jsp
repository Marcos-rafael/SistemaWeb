<%-- 
    Document   : Personas
    Created on : 15/04/2022, 06:10:29 PM
    Author     : Marcos
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="config.Conexion"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Mantenimiento de Personas</title>
    </head>
    <body>
        <div class="container">
            <div class="card col-sm-12">
                <div class="card-boby">
                    <form action="Controlador?menu=Personas" method="POST">
                        <div class="card-header">Carga de persona</div>
                        <div class="form-group d-flex">
                            <div class="col-sm-2">
                                <label>Tipo Documento</label>
                                <select name="txttipodocumento" onchange="#)" value="${personas.getTipodocumento()}" class="form-control" data-placeholder="Seleccione...">
                                    <option value="0">Seleccione...</option>
                                    <option>Cedula</option>
                                    <option>Pasaporte</option>
                                </select>
                            </div>
                            <div class="col-sm-2">
                                <label>Cedula</label>
                                <input type="text" value="${personas.getNumerodocumento()}" name="txtcedula"  class="form-control" required="">
                            </div>
                            <div class="col-sm-2">
                                <label>Nombres</label>
                                <input type="text" value="${personas.getNombre()}" name="txtnombre" class="form-control" required="">
                            </div>
                            <div class="col-sm-2">
                                <label>Apellidos</label>
                                <input type="text" value="${personas.getApellido()}" name="txtapellido" class="form-control" required="">
                            </div>                     
                            <div class="col-sm-2">
                                <label>Nacionalidad</label>
                                <select name="txtnacionalidad" onchange="#)" value="${personas.getNacionalidad()}" class="form-control" data-placeholder="Seleccione...">
                                    <option value="" disabled selected> Seleccione Nacionalidad... </option>
                                    <%
                                        Conexion conexion = new Conexion();
                                        Connection conn = null;
                                        try {
                                            String Query = "Select * from nacionalidad";
                                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                                            conn = conexion.Conexion();
                                            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/denuncia_policial", "root", "");
                                            Statement stm = conn.createStatement();
                                            ResultSet rs = stm.executeQuery(Query);
                                            while (rs.next()) {
                                    %>
                                    <option value="<%=rs.getString("cod_nacionalidad")%>">
                                        <%=rs.getString("nombre_nacionalidad")%> 
                                    </option>
                                    <%
                                            }
                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                            out.println("Error " + ex.getMessage());
                                        }
                                        conexion.cierraConexion(conn);
                                    %>
                                </select>
                            </div>
                            <div class="col-sm-2">
                                <label>Fecha Nacimiento</label>
                                <input type="date" value="${personas.getFechanacimiento()}" name="txtfechanacimiento" class="form-control" required="">
                            </div>
                        </div>
                        <div class="form-group d-flex">                       
                            <div class="col-sm-2">
                                <label>Sexo</label>
                                <select name="txtsexo" onchange="#)" value="${personas.getSexo()}" class="form-control" data-placeholder="Seleccione...">
                                    <option value="0">Seleccione...</option>
                                    <option>Masculino</option>
                                    <option>Femenino</option>
                                </select>
                            </div>
                            <div class="col-sm-2">
                                <label>Estado Civil</label>
                                <select name="txtestadocivil" onchange="#)" value="${personas.getEstadocivil()}" class="form-control" data-placeholder="Seleccione...">
                                    <option value="0">Seleccione...</option>
                                    <option>Soltera/o</option>
                                    <option>Casada/o</option>
                                    <option>Viuda/o</option>
                                    <option>Divorciada/o</option>
                                    <option>Concuvina/o</option>
                                </select>
                            </div>
                            <div class="col-sm-2">
                                <label>Telefono</label>
                                <input type="text" value="${personas.getTelefono()}" name="txttelefono" class="form-control" required="">
                            </div>
                            <div class="col-sm-2">
                                <label>Email</label>
                                <input type="text" value="${personas.getEmail()}" name="txtemail" class="form-control" required="">
                            </div>
                            <div class="col-sm-2">
                                <label>Departamento</label>
                                <!--input type="text" value="${personas.getIddepartamento()}" name="txtdepartamento" class="form-control" required=""-->
                                <select name="txtdepartamento" value="${personas.getIddepartamento()}" class="form-control" required="">
                                    <option value="" disabled selected> Seleccione... </option>
                                    <%
                                        try {
                                            String Query = "Select * from departamento";
                                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                                            conn = conexion.Conexion();
                                            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/denuncia_policial", "root", "");
                                            Statement stm = conn.createStatement();
                                            ResultSet rs = stm.executeQuery(Query);
                                            while (rs.next()) {
                                    %>
                                    <option value="<%=rs.getString("iddepartamento")%>">
                                        <%=rs.getString("nombre_departamento")%> 
                                    </option>
                                    <%
                                            }
                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                            out.println("Error " + ex.getMessage());
                                        }
                                        conexion.cierraConexion(conn);
                                    %>
                                </select>
                            </div>
                            <div class="col-sm-2">
                                <label>Ciudad</label>
                                <!--input type="text" value="${personas.getIdciudad()}" name="txtciudad" class="form-control" required=""-->
                                <select name="txtciudad" value="${personas.getIdciudad()}" class="form-control" required="">
                                    <option value="" disabled selected> Seleccione... </option>
                                    <%
                                        try {
                                            String Query = "Select * from ciudad";
                                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                                            conn = conexion.Conexion();
                                            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/denuncia_policial", "root", "");
                                            Statement stm = conn.createStatement();
                                            ResultSet rs = stm.executeQuery(Query);
                                            while (rs.next()) {
                                    %>
                                    <option value="<%=rs.getString("idciudad")%>">
                                        <%=rs.getString("nombreciudad")%> 
                                    </option>
                                    <%
                                            }
                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                            out.println("Error " + ex.getMessage());
                                        }
                                        conexion.cierraConexion(conn);
                                    %>
                                </select>
                            </div>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-2">
                                <label>Barrio</label>
                                <!--input type="text" value="${personas.getIdbarrio()}" name="txtbarrio" class="form-control" required=""-->
                                <select name="txtbarrio" value="${personas.getIdbarrio()}" class="form-control" required="">
                                    <option value="" disabled selected> Seleccione... </option>
                                    <%
                                        try {
                                            String Query = "Select * from barrio";
                                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                                            conn = conexion.Conexion();
                                            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/denuncia_policial", "root", "");
                                            Statement stm = conn.createStatement();
                                            ResultSet rs = stm.executeQuery(Query);
                                            while (rs.next()) {
                                    %>
                                    <option value="<%=rs.getString("idbarrio")%>">
                                        <%=rs.getString("nombrebarrio")%> 
                                    </option>
                                    <%
                                            }
                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                            out.println("Error " + ex.getMessage());
                                        }
                                        conexion.cierraConexion(conn);
                                    %>
                                </select>
                            </div>
                            <div class="col-sm-5">
                                <label>Dirección</label>
                                <input type="text" value="${personas.getDireccion()}" name="txtdireccion" class="form-control" required="">
                            </div>
                            <div class="col-sm-2">
                                <label>Numero de Casa</label>
                                <input type="text" value="${personas.getNumerocasa()}" name="txtnrocasa" class="form-control" required="">
                            </div>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
                <br>
                <div class="container">    
                    <div class="card-boby">
                        <div class="card-header">Mantenimiento de persona</div>
                        <table class="table table-hover">
                            <thead>
                                <tr> 
                                    <th>Codigo</th>
                                    <th>Tipo Doc.</th>
                                    <th>Cedula</th>
                                    <th>Nombres</th>
                                    <th>Apellidos</th>
                                    <th>Telefono</th>
                                    <th>Email</th>
                                    <th>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="pers" items="${persona}">
                                    <tr>
                                        <td>${pers.getId()}</td>
                                        <td>${pers.getTipodocumento()}</td>
                                        <td>${pers.getNumerodocumento()}</td>
                                        <td>${pers.getNombre()}</td>
                                        <td>${pers.getApellido()}</td>
                                        <td>${pers.getTelefono()}</td>
                                        <td>${pers.getEmail()}</td>
                                        <td>
                                            <a class="btn btn-warning" href="Controlador?menu=Personas&accion=Editar&id=${pers.getId()}">Editar</a>
                                            <a class="btn btn-danger" href="Controlador?menu=Personas&accion=Delete&id=${pers.getId()}">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>

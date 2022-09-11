<%-- 
    Document   : Barrio
    Created on : 17/04/2022, 09:31:20 AM
    Author     : Marcos
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="config.Conexion"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Barrio</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-boby">
                    <form action="Controlador?menu=Barrio" method="POST">
                        <div class="card-header">Carga de Barrio</div>
                        <div class="form-group">
                            <label>Descripción Barrio</label>
                            <input type="text" value= "${barrio.getNombre_barrio()}" name="txtbarrio" class="form-control" required="">
                        </div>
                        <div class="form-group">
                            <label>Ciudad</label>
                            <!--input type="text" value= "" name="txtciudad" class="form-control" required=""-->
                            <select type="text" value= "${barrio.getIdciudad()}" name="txtciudad" class="form-control" required="">
                                <option value="" disabled selected> Seleccione... </option>
                                <%
                                    Conexion conexion = new Conexion();
                                    Connection conn = null;
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
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="card-header">Mantenimiento de Barrio</div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Barrio</th>
                            <th>Ciudad</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="bar" items="${barrios}">
                            <tr>
                                <td>${bar.getId()}</td>
                                <td>${bar.getNombre_barrio()}</td>
                                <td>${bar.getIdciudad()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Barrio&accion=Editar&id=${bar.getId()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Barrio&accion=Delete&id=${bar.getId()}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>

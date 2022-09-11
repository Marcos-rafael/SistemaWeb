<%-- 
    Document   : Usuario
    Created on : 15/04/2022, 05:06:46 PM
    Author     : Marcos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carga de Usuario</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-boby">
                    <form action="Controlador?menu=Usuario" method="POST">
                        <div class="card-header">Carga de Usuario</div>
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" value="${usuario.getUsuario()}" name="txtusuario" class="form-control" required="">
                        </div>
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="text" value="${usuario.getPassword()}" name="txtpass" class="form-control" required="">
                        </div>
                        <div class="form-group">
                            <label>Cargo</label>
                            <select class="form-control form-control-sm" value="${usuario.getCargo()}" name="txtcargo" class="form-control" required="">
                                <option>Agente</option>
                                <option>Visita</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <select class="form-control form-control-sm" value="${usuario.getEstado()}" name="txtestado" class="form-control" required="">
                                <option>Activo</option>
                                <option>Inactivo</option>
                            </select>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="card-header">Mantenimiento de Usuario</div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Usuario</th>
                            <th>Contraseña</th>
                            <th>Cargo</th>
                            <th>Estado</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="usu" items="${usuarios}">
                            <tr>
                                <td>${usu.getId()}</td>
                                <td>${usu.getUsuario()}</td>
                                <td>${usu.getPassword()}</td>
                                <td>${usu.getCargo()}</td>
                                <td>${usu.getEstado()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Usuario&accion=Editar&id=${usu.getId()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Usuario&accion=Delete&id=${usu.getId()}">Delete</a>
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

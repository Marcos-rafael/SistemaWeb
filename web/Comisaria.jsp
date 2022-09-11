<%-- 
    Document   : Comisaria
    Created on : 21/05/2022, 07:57:37 PM
    Author     : Marcos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Mantenimiento de Comisaria</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-boby">
                    <form action="Controlador?menu=Comisaria" method="POST">
                        <div class="card-header">Carga de Comisaria</div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6">
                                <label>Nombre Comisaria</label>
                                <input type="text" value= "${comisaria.getNombre_comisaria()}" name="txtcomisaria" class="form-control" required="">
                            </div>
                            <div class="col-sm-6">
                                <label>Telefono</label>
                                <input type="text" value= "${comisaria.getTelefono()}" name="txttelefono" class="form-control" required="">
                            </div>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-12">
                                <label>Direccion</label>
                                <input type="text" value= "${comisaria.getDireccion()}" name="txtdireccion" class="form-control" required="">
                            </div>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6">
                                <label>Departamento</label>
                                <input type="text" value= "${comisaria.getCod_departamento()}" name="txtdepartamento" class="form-control" required="">
                            </div>
                            <div class="col-sm-6">
                                <label>Ciudad</label>
                                <input type="text" value= "${comisaria.getCod_ciudad()}" name="txtciudad" class="form-control" required="">
                            </div>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6">
                                <label>Barrio</label>
                                <input type="text" value= "${comisaria.getCod_barrio()}" name="txtbarrio" class="form-control" required="">
                            </div>
                            <div class="col-sm-2">
                                <label>Estado</label>
                                <input type="text" value= "${comisaria.getEstado()}" name="txtestado" class="form-control" required="">
                            </div>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="card-header">Mantenimiento de Comisaria</div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Nombre Comisaria</th>
                            <th>Telefono</th>
                            <th>Direccion</th>
                            <th>Departamento</th>
                            <th>Ciudad</th>
                            <th>Barrio</th>
                            <th>Estado</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="comi" items="${comisarias}">
                            <tr>
                                <td>${comi.getId()}</td>
                                <td>${comi.getNombre_comisaria()}</td>
                                <td>${comi.getTelefono()}</td>
                                <td>${comi.getDireccion()}</td>
                                <td>${comi.getCod_departamento()}</td>
                                <td>${comi.getCod_ciudad()}</td>
                                <td>${comi.getCod_barrio()}</td>
                                <td>${comi.getEstado()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Comisaria&accion=Editar&id=${comi.getId()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Comisaria&accion=Delete&id=${comi.getId()}">Delete</a>
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

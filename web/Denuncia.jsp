<%-- 
    Document   : Denuncia
    Created on : 16/05/2022, 09:38:25 PM
    Author     : Marcos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="config.Conexion"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Denuncia Policial</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="card col-sm-12">
                <div class="card-boby">
                    <form action="Controlador?menu=Denuncia" method="POST">
                        <div class="card-header">Constancia de Pérdida de Documentos</div><br>
                        <div class="form-group d-flex">
                            <div class="col-sm-2">
                                <label>Cedula</label>
                                <input type="text" name="txtcedula" value="${persona.getNumerodocumento()}" placeholder="Cedula" class="form-control" required="">
                                <button type="submit" name="accion" value="Buscar" class=" Btn btn-outline-info" style="display: none">Buscar</button> 
                            </div>
                            <div class="col-sm-2">
                                <label>Nombre</label>
                                <input type="text" value="${persona.getNombre()}" placeholder="Nombre" name="txtnombre" class="form-control" readonly ="readonly">
                            </div>
                            <div class="col-sm-2">
                                <label>Apellido</label>
                                <input type="text" value="${persona.getApellido()}" placeholder="Apellido" name="txtapellido" class="form-control" readonly ="readonly">
                            </div>
                            <div class="col-md-2">
                                <label>Nacionalidad</label>
                                <input type="text" value="${persona.getNacionalidad()}" placeholder="Nacionalidad" name="txtnacionalidad" class="form-control" readonly ="readonly">
                            </div>
                            <div class="col-md-2">
                                <label>Estado Civil</label>
                                <input type="text" value="${persona.getEstadocivil()}" placeholder="Estado Civil" name="txtestadocivil" class="form-control" readonly ="readonly">
                            </div>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-4">
                                <label>Dirección</label>
                                <input type="text" value="${persona.getDireccion()}" placeholder="Dirección" name="txtdireccion" class="form-control">
                            </div>
                            <div class="col-sm-2">
                                <label>Ciudad</label>
                                <input type="text" value="${persona.getIdciudad()}" placeholder="Ciudad" name="txtciudad" class="form-control" >
                            </div>
                            <div class="col-sm-2">
                                <label>Barrio</label>
                                <input type="text" value="${persona.getIdbarrio()}" placeholder="Barrio" name="txtbarrio" class="form-control">
                            </div>
                            <div class="col-sm-2">
                                <label>Telefono</label>
                                <input type="text" value="${persona.getTelefono()}" placeholder="Telefono" name="txttelefono" class="form-control">
                            </div>
                        </div>
                        
                        <div class="card-header">Detalle del hecho</div><br>
                        <div class="form-group d-flex">
                            <div class="col-sm-3">
                                <label>Tipo de Objeto</label>
                                <select name="txtobjeto" onchange="#)" class="form-control" data-placeholder="Seleccione...">
                                    <option value="0">Seleccione...</option>
                                    <option>Cedula de Indetidad</option>
                                    <option>Targeta de Credito</option>
                                    <option>Targeta de Dedito</option>
                                    <option>Registro de Conducir</option>
                                </select>
                            </div>
                            <div class="col-sm-2">
                                <label>Nº de Serie</label>
                                <input type="text" value="" placeholder="Nº Serie" name="txtserie" class="form-control">
                            </div>
                            <div class="col-sm-2">
                                <label>Descripción</label>
                                <input type="tex" value="" placeholder="Descripción" name="txtdescripcion" class="form-control" style="width: 100%">
                            </div>

                            <div class="card-group">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-info" style="height: 40px ">Agregar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-boby">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Tipo Objeto</th>
                                    <th>Nº de Serie</th>
                                    <th>Descripción</th>
                                    <th>Acción</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getTipoobjetod()}</td>
                                        <td>${list.getSeried()}</td>
                                        <td>${list.getDescripciond()}</td>
                                        <td>
                                            <a href="#" class="btn btn-warning">Editar</a>
                                            <a href="#" class="btn btn-danger">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer">
                        <div class="col m-6">
                            <a href="Controlador?menu=Denuncia&accion=GenerarDenuncia" class="btn btn-success">Generar Denuncia</a>
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>

<%-- 
    Document   : ListarDenuncia
    Created on : 17/08/2022, 07:24:24 PM
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Denuncias Ciudadanas</title>
    </head>
    <body>
        <div class="container">    
                    <div class="card-boby">
                        <div class="card-header">Lista de Denuncias Ciudadanas</div>
                        <table class="table table-hover">
                            <thead>
                                <tr> 
                                    <th>Codigo</th>
                                    <th>Cedula</th>
                                    <th>Nombres</th>
                                    <th>Apellidos</th>
                                    <th>Nacionalidad</th>
                                    <th>Direccion</th>
                                    <th>Telefono</th>
                                    <th>Fecha Denuncia</th>
                                    <th>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="denuncia" items="${denuncia}">
                                    <tr>
                                        <td>${denuncia.getId()}</td>
                                        <td>${denuncia.getCedula}</td>
                                        <td>${denuncia.getNombre()}</td>
                                        <td>${denuncia.getApellido()}</td>
                                        <td>${denuncia.getNacionalidad()}</td>                                 
                                        <td>${denuncia.getDireccion()}</td>
                                        <td>${denuncia.getTelefono()}</td>
                                        <td>${denuncia.getFecha_denuncia()}</td>
                                        <td>
                                            <a class="btn btn-warning" href="Controlador?menu=Denuncia&accion=Editar&id=${denuncia.getId()}">Editar</a>
                                            <a class="btn btn-danger" href="Controlador?menu=Denuncia&accion=Delete&id=${denuncia.getId()}">Delete</a>
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

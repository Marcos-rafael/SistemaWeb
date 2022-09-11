<%-- 
    Document   : Principal
    Created on : 15/04/2022, 10:24:07 AM
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Menu Principal</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="nav-link" href="#">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Institucion" target="myFrame">Institución</a>
                    </li>
                    <div class="dropdown">
                        <a class="btn btn-outline-light" href="#" role="button" id="dropdownMenuLink" style="border:none" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Servicies
                        </a>

                        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <a style="margin-left: 10px; border: none" class="dropdown-item" href="Controlador?menu=Usuario&accion=Listar" target="myFrame">Usuario</a>
                            <a style="margin-left: 10px; border: none" class="dropdown-item" href="Controlador?menu=Departamento&accion=Listar" target="myFrame">Departamento</a>
                            <a style="margin-left: 10px; border: none" class="dropdown-item" href="Controlador?menu=Ciudad&accion=Listar" target="myFrame">Ciudad</a>
                            <a style="margin-left: 10px; border: none" class="dropdown-item" href="Controlador?menu=Barrio&accion=Listar" target="myFrame">Barrio</a>
                            <a style="margin-left: 10px; border: none" class="dropdown-item" href="Controlador?menu=Comisaria&accion=Listar" target="myFrame">Comisaria</a>
                        </div>
                    </div>
                    <div class="dropdown">
                        <a class="btn btn-outline-light" href="#" role="button" id="dropdownMenuLink" style="border:none" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Denuncia Ciudadana
                        </a>

                        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <a style="margin-left: 10px; border: none" class="dropdown-item" href="Controlador?menu=Denuncia&accion=default" target="myFrame">Realizar Denuncia</a>
                            <a style="margin-left: 10px; border: none" class="dropdown-item" href="Controlador?menu=Denuncia&accion=Listar" target="myFrame">Listar denuncia</a>
                        </div>
                    </div>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Personas&accion=Listar" target="myFrame">Personas</a>
                    </li>
                    

                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light"  href="Controlador?menu=Seguimiento&accion=Listar" target="myFrame">Seguimiento</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light"  href="Controlador?menu=Institucion" target="myFrame">Contactos</a>
                    </li>
                </ul>
            </div>
            <div class="dropdown">
                <button style="border:none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${usuario.getUsuario()}
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <a class="dropdown-item" href="#">
                        <img src="img/user.png" alt="60" width="60"/>
                    </a>
                    <a class="dropdown-item" href="#">${usuario.getCargo()}</a>
                    <form action ="Validar" method="POST">
                        <Button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                    </form>
                </div>
            </div>
        </nav>
        <div class="m-4" style="height: 900px; ">
            <iframe name="myFrame" style="height: 100%; width: 100%;" frameborder="0"></iframe>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>

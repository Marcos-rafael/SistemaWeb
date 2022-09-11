<%-- 
    Document   : Inicio
    Created on : 04/07/2022, 08:21:47 PM
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="accordion" id="accordionExample">
            <div class="card">
                <div class="card-header" id="headingOne">
                    <h2 class="mb-0">
                        <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            Violencia domestica.
                        </button>
                    </h2>
                </div>
                <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                    <div class="main-content">
                        <div class="card-box">
                            <div class="negrita">
                                Que es?
                            </div><p>
                            <div class="txt-content">
                                Constituye violencia doméstica toda acción u omisión, directa o indirecta, 
                                que por cualquier medio menoscabe, limitando ilegítimamente el libre ejercicio
                                o goce de los derechos humanos de una persona, causada por otra con la cual tenga 
                                o haya tenido una relación de noviazgo o con la cual tenga o haya tenido una relación 
                                afectiva basada en la cohabitación y originada por parentesco, por matrimonio o 
                                por unión de hecho. (Art )
                            </div>
                            <div class="txt-content negrita">
                                Que se necesita para realizarla?
                            </div><p>
                            <div class="txt-content">
                                Siempre que se considere víctima, testigo o perjudicado de un hecho ilícito, puede radicar la denuncia.
                            </div>
                            <div class="txt-content negrita">
                                De quien depende?
                            </div>
                            <div class="txt-content">
                                Ministerio del Interior.
                            </div>
                            <div class="txt-content negrita">
                                ¿Dónde y cuando se realiza el trámite?
                            </div>
                            <div class="txt-content">
                                De acuerdo a cada circunstancia, dicha denuncia puede iniciarse en forma verbal
                                o en la web y luego ser ratificada. Lista comisarías.
                            </div>
                            <div class="txt-content negrita">
                                Costo:
                            </div>
                            <div class="txt-content">
                                No tiene
                            </div>  
                            <div class="txt-content negrita">
                                Forma de solicitud: De forma personal
                            </div>
                            <div class="txt-content negrita">
                                Otros datos de interés:
                            </div>
                            <div class="txt-content">
                                Formalidad de presentación: De acuerdo a cada circunstancia, dicha denuncia
                                puede iniciarse en forma verbal y luego formalizarse por escrito.
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header" id="headingTwo">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                Hurto en interior de viviendas, comercios u otros establecimiento.
                            </button>
                        </h2>
                    </div>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                        <div class="card-body">
                            Some placeholder content for the second accordion panel. This panel is hidden by default.
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header" id="headingThree">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                Hurtos de vehículos e interior de vehículos
                            </button>
                        </h2>
                    </div>
                    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                        <div class="card-body">
                            And lastly, the placeholder content for the third and final accordion panel. This panel is hidden by default.
                        </div>
                    </div>
                </div>
            </div>
            <div class="main-content">
                <div class="text-box">
                    <div class="title">
                        <h2 id="titulo-superior">Bienvenido al sistema de denuncias en línea</h2>
                    </div>
                    <div class="txt-content"
                         <p>Mediante este sistema usted podrá denunciar por internet los siguientes hechos:</p>
                        <ul class="txt-ul">
                            <li class="txt-li">
                                Violencia domestica
                                <a href="texto-violencia.jsp" title="Violencia Domestica"> más...</a>
                            </li>
                            <li class="txt-li">
                                Hurto en interior de viviendas, comercios u otros establecimiento
                                <a href="texto-hurto.jsp" title="Hurto en interior de viviendas, comercios u otros establecimiento"> más...</a>
                            </li>
                            <li class="txt-li">
                                Hurtos de vehículos e interior de vehículos
                                <a href="texto-vehiculo.jsp" title="Hurtos de vehículos e interior de vehículos"> más...</a>
                            </li>
                            <li class="txt-li">
                                Hurto o extravío de documentos
                                <a href="texto-documento.jsp" title="Hurto o extravío de documentos"> más...</a>
                            </li>
                            <li class="txt-li">
                                Hurto o extravío de celular
                                <a href="texto-celular.jsp" title="Hurto o extravío de celular"> más...</a>
                            </li>
                            <li class="txt-li">
                                Hurto o extravío de arma
                                <a href="texto-arma.jsp" title="Hurto o extravío de arma"> más...</a>
                            </li>
                            <li class="txt-li">
                                Rapiña
                                <a href="texto-rapiña.jsp" title="Rapiña"> más...</a>
                            </li>
                        </ul>
                        <p>
                            <span class="negrita">
                                Una vez hecha la denuncia por Internet, para que la misma tenga validez jurídica,
                                deberá ratificarse mediante firma en un plazo de 48 horas en la comisaría más próxima.
                            </span>
                        </p>
                    </div>
                </div> 
                <div id="aviso-legal" class="text-box">
                    <div class="title">
                        <h2> Aviso Legal</h2>
                    </div>
                    <div class="txt-content">
                        <p>
                            El uso inadecuado de este sistema, simulando ser víctima de una infracción penal o denunciando un hecho 
                            inexistente que provoque actuaciones procesales, puede originar responsabilidades penales.
                        </p>
                        <ul>
                            <li>
                                <a class="art-179" href="articulo291.jsp" title="Artículo 291">
                                    <span class="negrita"> Artículo 291. </span>
                                    (Simulación de un hecho punible)
                                </a>
                            </li>
                            <li>
                                <a class="art-180" href="articulo242.jsp" title="Artículo 242">
                                    <span class="negrita"> Artículo 242. </span>
                                    (Testimonio falso)
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="footer">
                <div class="wrap">
                    <p>MINISTERIO DEL INTERIOR República del Paraguay | Tel.:123 1234</p>
                </div>
            </div>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>

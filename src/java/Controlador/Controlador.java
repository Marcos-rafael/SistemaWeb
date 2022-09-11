/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Barrio;
import Modelo.BarrioDAO;
import Modelo.Ciudad;
import Modelo.CiudadDAO;
import Modelo.Comisaria;
import Modelo.ComisariaDAO;
import Modelo.Denuncia;
import Modelo.DenunciaDAO;
import Modelo.Departamento;
import Modelo.DepartamentoDAO;
import Modelo.Personas;
import Modelo.PersonasDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import config.GenerarSerie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcos
 */
public class Controlador extends HttpServlet {

    Usuario usu = new Usuario();
    UsuarioDAO udao = new UsuarioDAO();
    int ide;
    Departamento dep = new Departamento();
    DepartamentoDAO ddao = new DepartamentoDAO();
    Ciudad ciu = new Ciudad();
    CiudadDAO cdao = new CiudadDAO();
    Barrio bar = new Barrio();
    BarrioDAO bdao = new BarrioDAO();
    Comisaria comi = new Comisaria();
    ComisariaDAO codao = new ComisariaDAO();
    Personas per = new Personas();
    PersonasDAO pdao = new PersonasDAO();

    Denuncia d = new Denuncia();
    List<Denuncia> lista = new ArrayList<>();
    int item;
    int cod;
    String tipoObjeto;
    String serie;
    String descripcion;
    
    String fechad;
    String numeroserie;
    DenunciaDAO dedao = new DenunciaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }

        if (menu.equals("Usuario")) {
            switch (accion) {
                case "Listar":
                    List lista = udao.listar();
                    request.setAttribute("usuarios", lista);
                    break;
                case "Agregar":
                    String usua = request.getParameter("txtusuario");
                    String pass = request.getParameter("txtpass");
                    String car = request.getParameter("txtcargo");
                    String est = request.getParameter("txtestado");
                    usu.setUsuario(usua);
                    usu.setPassword(pass);
                    usu.setCargo(car);
                    usu.setEstado(est);
                    udao.agregar(usu);
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Usuario u = udao.listarId(ide);
                    request.setAttribute("usuario", u);
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String usua1 = request.getParameter("txtusuario");
                    String pass1 = request.getParameter("txtpass");
                    String car1 = request.getParameter("txtcargo");
                    String est1 = request.getParameter("txtestado");
                    usu.setUsuario(usua1);
                    usu.setPassword(pass1);
                    usu.setCargo(car1);
                    usu.setEstado(est1);
                    usu.setId(ide);
                    udao.actualizar(usu);
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    udao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Usuario.jsp").forward(request, response);
        }
        if (menu.equals("Denuncia")) {
            switch (accion) {
                case "Buscar":
                    String cedula = request.getParameter("txtcedula");
                    per.setNumerodocumento(cedula);
                    per = pdao.buscar(cedula);
                    request.setAttribute("persona", per);
                    
                    break;
                case "Agregar":
                    request.setAttribute("persona", per);
                    item = item + 1;
                    tipoObjeto = request.getParameter("txtobjeto");
                    serie = request.getParameter("txtserie");
                    descripcion = request.getParameter("txtdescripcion");
                    d=new Denuncia();
                    d.setItem(item);
                    d.setTipoobjetod(tipoObjeto);
                    d.setSeried(serie);
                    d.setDescripciond(descripcion);
                    lista.add(d);
                    request.setAttribute("lista", lista);
                    
                    break;
                case "GenerarDenuncia":
                    //Guardar Denuncia             
                    d.setCedula(per.getNumerodocumento());
                    d.setNombre(per.getNombre());
                    d.setApellido(per.getApellido());
                    d.setNacionalidad(per.getNacionalidad());
                    d.setEstadocivil(per.getEstadocivil());
                    d.setDireccion(per.getDireccion());
                    d.setCiudad(per.getIdciudad());
                    d.setBarrio(per.getIdbarrio());
                    d.setTelefono(per.getTelefono());
                    d.setFecha_denuncia(dedao.fecha());
                    
                    dedao.guardaDenuncia(d);
                    //Guarda Detalle denuncia
                    int idd=Integer.parseInt(dedao.IdDenuncia());
                    for(int i = 0; i < lista.size(); i++){
                        d=new Denuncia();
                        d.setId(idd);
                        d.setTipoobjetod(lista.get(i).getTipoobjetod());
                        d.setSeried(lista.get(i).getSeried());
                        d.setDescripciond(lista.get(i).getDescripciond());
                        
                        dedao.guardarDetalledenuncia(d); 
                    }
                default:
                    request.getRequestDispatcher("Denuncia.jsp").forward(request, response);
            }
            request.getRequestDispatcher("Denuncia.jsp").forward(request, response);
        }

        if (menu.equals("Personas")) {
            switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("persona", lista);
                    break;
                case "Agregar":
                    String tipodocu = request.getParameter("txttipodocumento");
                    String cedula = request.getParameter("txtcedula");
                    String nombre = request.getParameter("txtnombre");
                    String apellido = request.getParameter("txtapellido");
                    String nacionalidad = request.getParameter("txtnacionalidad");
                    String fechanacimiento = request.getParameter("txtfechanacimiento");
                    String sexo = request.getParameter("txtsexo");
                    String estadocivil = request.getParameter("txtestadocivil");
                    String telefono = request.getParameter("txttelefono");
                    String email = request.getParameter("txtemail");
                    String departamento = request.getParameter("txtdepartamento");
                    String ciudad = request.getParameter("txtciudad");
                    String barrio = request.getParameter("txtbarrio");
                    String direccion = request.getParameter("txtdireccion");
                    String nrocasa = request.getParameter("txtnrocasa");
                    per.setTipodocumento(tipodocu);
                    per.setNumerodocumento(cedula);
                    per.setNombre(nombre);
                    per.setApellido(apellido);
                    per.setNacionalidad(nacionalidad);
                    per.setFechanacimiento(fechanacimiento);
                    per.setSexo(sexo);
                    per.setEstadocivil(estadocivil);
                    per.setTelefono(telefono);
                    per.setEmail(email);
                    per.setIddepartamento(departamento);
                    per.setIdciudad(ciudad);
                    per.setIdbarrio(barrio);
                    per.setDireccion(direccion);
                    per.setNumerocasa(nrocasa);
                    pdao.agregar(per);
                    request.getRequestDispatcher("Controlador?menu=Personas&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Personas p = pdao.listarId(ide);
                    request.setAttribute("personas", p);
                    request.getRequestDispatcher("Controlador?menu=Personas&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String tipodocu1 = request.getParameter("txttipodocumento");
                    String cedula1 = request.getParameter("txtcedula");
                    String nombre1 = request.getParameter("txtnombre");
                    String apellido1 = request.getParameter("txtapellido");
                    String nacionalidad1 = request.getParameter("txtnacionalidad");
                    String fechanacimiento1 = request.getParameter("txtfechanacimiento");
                    String sexo1 = request.getParameter("txtsexo");
                    String estadocivil1 = request.getParameter("txtestadocivil");
                    String telefono1 = request.getParameter("txttelefono");
                    String email1 = request.getParameter("txtemail");
                    String departamento1 = request.getParameter("txtdepartamento");
                    String ciudad1 = request.getParameter("txtciudad");
                    String barrio1 = request.getParameter("txtbarrio");
                    String direccion1 = request.getParameter("txtdireccion");
                    String nrocasa1 = request.getParameter("txtnrocasa");
                    per.setTipodocumento(tipodocu1);
                    per.setNumerodocumento(cedula1);
                    per.setNombre(nombre1);
                    per.setApellido(apellido1);
                    per.setNacionalidad(nacionalidad1);
                    per.setFechanacimiento(fechanacimiento1);
                    per.setSexo(sexo1);
                    per.setEstadocivil(estadocivil1);
                    per.setTelefono(telefono1);
                    per.setEmail(email1);
                    per.setIddepartamento(departamento1);
                    per.setIdciudad(ciudad1);
                    per.setIdbarrio(barrio1);
                    per.setDireccion(direccion1);
                    per.setNumerocasa(nrocasa1);
                    per.setId(ide);
                    pdao.actualizar(per);
                    request.getRequestDispatcher("Controlador?menu=Personas&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    pdao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Personas&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Personas.jsp").forward(request, response);
        }
        if (menu.equals("Institucion")) {
            request.getRequestDispatcher("Institucion.jsp").forward(request, response);
        }
        if (menu.equals("Comisaria")) {
            switch (accion) {
                case "Listar":
                    List lista = codao.listar();
                    request.setAttribute("comisarias", lista);
                    break;
                case "Agregar":
                    String comisaria = request.getParameter("txtcomisaria");
                    String telefono = request.getParameter("txttelefono");
                    String direccion = request.getParameter("txtdireccion");
                    String departamento = request.getParameter("txtdepartamento");
                    String ciudad = request.getParameter("txtciudad");
                    String barrio = request.getParameter("txtbarrio");
                    String estado = request.getParameter("txtestado");
                    comi.setNombre_comisaria(comisaria);
                    comi.setTelefono(telefono);
                    comi.setDireccion(direccion);
                    comi.setCod_departamento(departamento);
                    comi.setCod_ciudad(ciudad);
                    comi.setCod_barrio(barrio);
                    comi.setEstado(estado);
                    codao.agregar(comi);
                    request.getRequestDispatcher("Controlador?menu=Comisaria&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Comisaria c = codao.listarId(ide);
                    request.setAttribute("comisaria", c);
                    request.getRequestDispatcher("Controlador?menu=Comisaria&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String comisaria1 = request.getParameter("txtcomisaria");
                    String telefono1 = request.getParameter("txttelefono");
                    String direccion1 = request.getParameter("txtdireccion");
                    String departamento1 = request.getParameter("txtdepartamento");
                    String ciudad1 = request.getParameter("txtciudad");
                    String barrio1 = request.getParameter("txtbarrio");
                    String estado1 = request.getParameter("txtestado");
                    comi.setNombre_comisaria(comisaria1);
                    comi.setTelefono(telefono1);
                    comi.setDireccion(direccion1);
                    comi.setCod_departamento(departamento1);
                    comi.setCod_ciudad(ciudad1);
                    comi.setCod_barrio(barrio1);
                    comi.setEstado(estado1);
                    comi.setId(ide);
                    codao.actualizar(comi);
                    request.getRequestDispatcher("Controlador?menu=Comisaria&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    codao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Comisaria&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Comisaria.jsp").forward(request, response);
        }
        if (menu.equals("Departamento")) {
            switch (accion) {
                case "Listar":
                    List lista = ddao.listar();
                    request.setAttribute("departamentos", lista);
                    break;
                case "Agregar":
                    String departamento = request.getParameter("txtdepartamento");
                    dep.setNombreDepartamento(departamento);
                    ddao.agregar(dep);
                    request.getRequestDispatcher("Controlador?menu=Departamento&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Departamento d = ddao.listarId(ide);
                    request.setAttribute("departamento", d);
                    request.getRequestDispatcher("Controlador?menu=Departamento&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String departamento1 = request.getParameter("txtdepartamento");
                    dep.setNombreDepartamento(departamento1);
                    dep.setId(ide);
                    ddao.actualizar(dep);
                    request.getRequestDispatcher("Controlador?menu=Departamento&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    ddao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Departamento&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Departamento.jsp").forward(request, response);
        }
        if (menu.equals("Ciudad")) {
            switch (accion) {
                case "Listar":
                    List lista = cdao.listar();
                    request.setAttribute("ciudades", lista);
                    break;
                case "Agregar":
                    String ciudad = request.getParameter("txtciudad");
                    String depa = request.getParameter("txtdepartamento");
                    ciu.setNombre_ciudad(ciudad);
                    ciu.setIdDepartamento(depa);
                    cdao.agregar(ciu);
                    request.getRequestDispatcher("Controlador?menu=Ciudad&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Ciudad d = cdao.listarId(ide);
                    request.setAttribute("ciudad", d);
                    request.getRequestDispatcher("Controlador?menu=Ciudad&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String ciudad1 = request.getParameter("txtciudad");
                    String depa1 = request.getParameter("txtdepartamento");
                    ciu.setNombre_ciudad(ciudad1);
                    ciu.setIdDepartamento(depa1);
                    ciu.setId(ide);
                    cdao.actualizar(ciu);
                    request.getRequestDispatcher("Controlador?menu=Ciudad&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    cdao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Ciudad&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Ciudad.jsp").forward(request, response);
        }
        if (menu.equals("Barrio")) {
            switch (accion) {
                case "Listar":
                    List lista = bdao.listar();
                    request.setAttribute("barrios", lista);
                    break;
                case "Agregar":
                    String barrio = request.getParameter("txtbarrio");
                    String ciud = request.getParameter("txtciudad");
                    bar.setNombre_barrio(barrio);
                    bar.setIdciudad(ciud);
                    bdao.agregar(bar);
                    request.getRequestDispatcher("Controlador?menu=Barrio&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Barrio d = bdao.listarId(ide);
                    request.setAttribute("barrio", d);
                    request.getRequestDispatcher("Controlador?menu=Barrio&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String barrio1 = request.getParameter("txtbarrio");
                    String ciud1 = request.getParameter("txtciudad");
                    bar.setNombre_barrio(barrio1);
                    bar.setIdciudad(ciud1);
                    bar.setId(ide);
                    bdao.actualizar(bar);
                    request.getRequestDispatcher("Controlador?menu=Barrio&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    bdao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Barrio&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Barrio.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
              String accion = request.getParameter("accion");
                if(accion.equals("registrar")){  
                    String Nusuario = request.getParameter("usuario");
                    String correo = request.getParameter("correo");
                    String contra = request.getParameter("contra");
                    Usuario usuario = Usuario.getUser();
                    usuario.setNombre(Nusuario);
                    usuario.setCorreo(correo);
                    usuario.setContrasenia(contra);
                    HttpSession sesion = request.getSession();
                    sesion.setAttribute("user", usuario);
                    Conexion conexion = new Conexion();
                    conexion.registrar(usuario);
                    response.sendRedirect("index.jsp");
                }else{
                    if(accion.equals("ingresar")){
                        String Nusuario = request.getParameter("usuario");
                        String correo = request.getParameter("correo");
                        String contra = request.getParameter("contra");
                        Usuario usuario = Usuario.getUser();
                        usuario.setNombre(Nusuario);
                        usuario.setCorreo(correo);
                        usuario.setContrasenia(contra);
                        Conexion conexion = new Conexion();
                        String nombreUsuarioBD = conexion.NombreDeUsuario(usuario);
                        if(Nusuario.equals(nombreUsuarioBD)){
                        usuario.setCorreo(conexion.Correo(usuario));
                        HttpSession sesion = request.getSession();
                        sesion.setAttribute("user", usuario);
                    response.sendRedirect("index.jsp");
                    }
               }
            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

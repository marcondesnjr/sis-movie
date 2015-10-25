package io.github.marcondesnjr.sismovie.servlets;

import io.github.marcondesnjr.sismovie.Administrador;
import io.github.marcondesnjr.sismovie.ArquivoManager;
import io.github.marcondesnjr.sismovie.SisMovie;
import io.github.marcondesnjr.sismovie.dao.PersistenceException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
@MultipartConfig
public class CadastrarFilme extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Administrador usrLog = (Administrador) request.getAttribute("usrLog");
        String titulo = request.getParameter("titulo");
        String sinopse = request.getParameter("sinopse");
        String ano = request.getParameter("ano");
        List<String> generos = Arrays.asList(request.getParameterValues("genero"));
        List<String> atores = Arrays.asList(request.getParameterValues("ator"));
        List<String> diretores = Arrays.asList(request.getParameterValues("diretor"));
        Part fotoPart = request.getPart("foto");
        String fotoPath;
        if (fotoPart != null) {
            fotoPath = ArquivoManager.salvarFotoFilme(fotoPart, titulo);
        } else {
            fotoPath = ArquivoManager.DEFAUT_FOTO_PERFIL;
        }
        try {
            SisMovie.cadastrarFilme(usrLog, fotoPath, titulo, sinopse, ano, generos, atores, diretores);
        } catch (PersistenceException ex) {
            response.sendError(333);
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

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.sismovie.commands;

import io.github.marcondesnjr.sismovie.Amizade;
import io.github.marcondesnjr.sismovie.Usuario;
import io.github.marcondesnjr.sismovie.dao.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class Home implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        try {
            new LoadEstados().execute(request, response);
            Usuario usr = (Usuario) request.getSession().getAttribute("usrLog");
            request.setAttribute("solicitacoes", Amizade.getSolicitacoesRecebidas(usr));
            request.setAttribute("usuarios", Amizade.getAmigos(usr));
            return "pages/home.jsp";
        } catch (PersistenceException ex) {
            return ErrorPages.PERSISTENCE_ERROR.getPAGE();
        }
    }
}

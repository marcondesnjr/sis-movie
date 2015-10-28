package io.github.marcondesnjr.sismovie.commands;

import io.github.marcondesnjr.sismovie.Amizade;
import io.github.marcondesnjr.sismovie.SisMovie;
import io.github.marcondesnjr.sismovie.Usuario;
import io.github.marcondesnjr.sismovie.dao.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class SolicitarAmizade implements Command{

    public String execute(HttpServletRequest request, HttpServletResponse response){
        try {
            String email = request.getParameter("email");
            Usuario dest = SisMovie.localizarUsuario(email);
            Usuario rem = (Usuario) request.getSession().getAttribute("usrLog");
            Amizade.addSolicitacao(rem, dest);
            return "control?command=ExibirUsuario&email="+email;
        } catch (PersistenceException ex) {
            return ErrorPages.PERSISTENCE_ERROR.getPAGE();
        }
    }
}

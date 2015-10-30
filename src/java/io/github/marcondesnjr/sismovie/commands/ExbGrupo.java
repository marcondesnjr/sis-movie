
package io.github.marcondesnjr.sismovie.commands;

import io.github.marcondesnjr.sismovie.Grupo;
import io.github.marcondesnjr.sismovie.dao.PersistenceException;
import io.github.marcondesnjr.sismovie.gerenciadordados.GerenciadorGrupo;
import io.github.marcondesnjr.sismovie.gerenciadordados.GerenciadorParticipantes;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class ExbGrupo implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Grupo gp = GerenciadorGrupo.localizar(id);
            gp = GerenciadorParticipantes.carregarParticipantes(gp);
            request.setAttribute("grupo", gp);
            return "exbGrupo";
        } catch (PersistenceException ex) {
            Logger.getLogger(ExbGrupo.class.getName()).log(Level.SEVERE, null, ex);
            return "persistenceError";
        }
    }
    
}

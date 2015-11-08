
package io.github.marcondesnjr.sismovie.commands;

import io.github.marcondesnjr.sismovie.Usuario;
import io.github.marcondesnjr.sismovie.dao.PersistenceException;
import io.github.marcondesnjr.sismovie.gerenciadordados.GerenciadorUsuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class RemUsuario implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Usuario usr = (Usuario) request.getSession().getAttribute("usrLog");
            GerenciadorUsuario.excluir(usr.getEmail());
            response.sendRedirect(request.getContextPath()+"/logoff/");
            return null;
        } catch (IOException ex) {
            Logger.getLogger(RemUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return "ioError";
        } catch (PersistenceException ex) {
            Logger.getLogger(RemUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return "persistenceError";
        }
    }
    
}

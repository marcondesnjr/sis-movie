package io.github.marcondesnjr.sismovie.commands;



import io.github.marcondesnjr.sismovie.SisMovie;
import io.github.marcondesnjr.sismovie.Usuario;
import io.github.marcondesnjr.sismovie.dao.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class ExbUsuario implements Command{

 
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String email = request.getParameter("email");
        try{
            Usuario usr = SisMovie.localizarUsuario(email);
            if(usr != null){
                request.setAttribute("usuario", usr);
                return "pages/usr.jsp";         
            }
            else
                return ErrorPages.NOT_FOUND.getPAGE();
        }catch(PersistenceException ex){
            return ErrorPages.PERSISTENCE_ERROR.getPAGE();
        }
            
    }
}

package io.github.marcondesnjr.sismovie.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class InitCadastrarFilme implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        return "pages/cadastrar-filme.jsp";
    
    }
    
    
    
}

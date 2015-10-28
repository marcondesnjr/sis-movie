
package io.github.marcondesnjr.sismovie.gerenciadordados;

import io.github.marcondesnjr.sismovie.Administrador;
import io.github.marcondesnjr.sismovie.Usuario;
import io.github.marcondesnjr.sismovie.dao.AlreadyExistsException;
import io.github.marcondesnjr.sismovie.dao.CriadorFabrica;
import io.github.marcondesnjr.sismovie.dao.PersistenceException;
import io.github.marcondesnjr.sismovie.dao.DAOUsuario;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class GerenciadorUsuario {
    
    public static void salvar(Usuario usr) throws PersistenceException, AlreadyExistsException{
        DAOUsuario dao = CriadorFabrica.criarFabrica(CriadorFabrica.BANCO_DE_DADOS)
                .criarDaoUsuario();
        dao.persistir(usr);
        try{dao.close();} catch (Exception ex){}
    }
    
    public static void salvar(Administrador adm) throws PersistenceException, AlreadyExistsException{
         DAOUsuario dao = CriadorFabrica.criarFabrica(CriadorFabrica.BANCO_DE_DADOS)
                .criarDaoUsuario();
         dao.persistir(adm);
         try{dao.close();} catch (Exception ex){}
    }

    public static Usuario localizar(String login, String senha) throws PersistenceException{
        DAOUsuario dao = CriadorFabrica.criarFabrica(CriadorFabrica.BANCO_DE_DADOS)
                .criarDaoUsuario();
        Usuario usr = dao.localizar(login, senha);
        try{dao.close();} catch (Exception ex){}
        return usr;
    }
    
    public static Usuario localizar(String login) throws PersistenceException{
        DAOUsuario dao = CriadorFabrica.criarFabrica(CriadorFabrica.BANCO_DE_DADOS)
                .criarDaoUsuario();
        Usuario usr = dao.localizar(login);
        try{dao.close();} catch (Exception ex){}
        return usr;
    }
    
    public static List<Usuario> localizar() throws PersistenceException{
        DAOUsuario dao = CriadorFabrica.criarFabrica(CriadorFabrica.BANCO_DE_DADOS)
                .criarDaoUsuario();
        List<Usuario> usrs = dao.localizar();
        try{dao.close();} catch (Exception ex){}
        return usrs;
    }
    
    public static List<Usuario> perquisarNome(String nome) throws PersistenceException{
        String[] nomes = nome.split(" ");
        Set<Usuario> usr = new HashSet<>();
        DAOUsuario dao = CriadorFabrica.criarFabrica(CriadorFabrica.BANCO_DE_DADOS)
                .criarDaoUsuario();
        for (String nome1 : nomes) {
            usr.addAll(dao.perquisarNome(nome1));
        }
        try{dao.close();} catch (Exception ex){}
        return Arrays.asList(usr.toArray(new Usuario[0]));
    }
    
}

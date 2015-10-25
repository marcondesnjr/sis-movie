
package io.github.marcondesnjr.sismovie.gerenciadordados;

import io.github.marcondesnjr.sismovie.Administrador;
import io.github.marcondesnjr.sismovie.Usuario;
import io.github.marcondesnjr.sismovie.dao.AlreadyExistsException;
import io.github.marcondesnjr.sismovie.dao.CriadorFabrica;
import io.github.marcondesnjr.sismovie.dao.PersistenceException;
import io.github.marcondesnjr.sismovie.dao.UsuarioDAO;
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
        CriadorFabrica.criarFabrica(CriadorFabrica.BANCO_DE_DADOS)
                .criarDaoUsuario().persistir(usr);       
    }
    
    public static void salvar(Administrador adm) throws PersistenceException, AlreadyExistsException{
        CriadorFabrica.criarFabrica(CriadorFabrica.BANCO_DE_DADOS)
                .criarDaoUsuario().persistir(adm);
    }

    public static Usuario localizar(String login, String senha) throws PersistenceException{
        UsuarioDAO dao = CriadorFabrica.criarFabrica(CriadorFabrica.BANCO_DE_DADOS)
                .criarDaoUsuario();
        return dao.localizar(login, senha);
    }
    
    public static Usuario localizar(String login) throws PersistenceException{
        UsuarioDAO dao = CriadorFabrica.criarFabrica(CriadorFabrica.BANCO_DE_DADOS)
                .criarDaoUsuario();
        return dao.localizar(login);
    }
    
    public static List<Usuario> localizar() throws PersistenceException{
        UsuarioDAO dao = CriadorFabrica.criarFabrica(CriadorFabrica.BANCO_DE_DADOS)
                .criarDaoUsuario();
        return dao.localizar();
    }
    
    public static List<Usuario> perquisarNome(String nome) throws PersistenceException{
        String[] nomes = nome.split(" ");
        Set<Usuario> usr = new HashSet<>();
        UsuarioDAO dao = CriadorFabrica.criarFabrica(CriadorFabrica.BANCO_DE_DADOS)
                .criarDaoUsuario();
        for (String nome1 : nomes) {
            usr.addAll(dao.perquisarNome(nome1));
        }
        return Arrays.asList(usr.toArray(new Usuario[0]));
    }
    
}

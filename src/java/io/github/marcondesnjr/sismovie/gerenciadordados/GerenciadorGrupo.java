
package io.github.marcondesnjr.sismovie.gerenciadordados;

import io.github.marcondesnjr.sismovie.Grupo;
import io.github.marcondesnjr.sismovie.dao.CriadorFabrica;
import io.github.marcondesnjr.sismovie.dao.DAOGrupo;
import io.github.marcondesnjr.sismovie.dao.PersistenceException;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class GerenciadorGrupo {
    public static Grupo salvar(Grupo grp) throws PersistenceException{
        try(DAOGrupo dao = CriadorFabrica.criarFabrica(CriadorFabrica.BANCO_DE_DADOS).criarDAOGrupo()){
            return dao.persiste(grp);
        }
    }
    
    public static Grupo localizar(int id) throws PersistenceException{
        try(DAOGrupo dao = CriadorFabrica.criarFabrica(CriadorFabrica.BANCO_DE_DADOS).criarDAOGrupo()){
            return dao.localiza(id);
        }
    }
}

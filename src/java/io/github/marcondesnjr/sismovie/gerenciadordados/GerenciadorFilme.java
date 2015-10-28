
package io.github.marcondesnjr.sismovie.gerenciadordados;

import io.github.marcondesnjr.sismovie.Filme;
import io.github.marcondesnjr.sismovie.dao.CriadorFabrica;
import io.github.marcondesnjr.sismovie.dao.DAOFilme;
import io.github.marcondesnjr.sismovie.dao.PersistenceException;
import java.util.List;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class GerenciadorFilme {
    public static List<Filme> lastFilmes(int n) throws PersistenceException{
        DAOFilme dao = CriadorFabrica.criarFabrica(CriadorFabrica.BANCO_DE_DADOS).criarDaoFilme();
        try{dao.close();}catch(Exception ex){}
        return dao.localizarUltimos(10);
    }
    
    public static void salvar(Filme fl) throws PersistenceException{
        DAOFilme dao = CriadorFabrica.criarFabrica(CriadorFabrica.BANCO_DE_DADOS).criarDaoFilme();
        dao.persistir(fl);
        try{dao.close();}catch(Exception ex){}
    }
}

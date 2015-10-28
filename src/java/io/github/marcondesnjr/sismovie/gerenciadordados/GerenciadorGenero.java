package io.github.marcondesnjr.sismovie.gerenciadordados;

import io.github.marcondesnjr.sismovie.dao.CriadorFabrica;
import io.github.marcondesnjr.sismovie.dao.DAOGenero;
import io.github.marcondesnjr.sismovie.dao.PersistenceException;
import java.util.List;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class GerenciadorGenero {
    public void salvar(String gen) throws PersistenceException{
        DAOGenero dao = CriadorFabrica.criarFabrica(CriadorFabrica.BANCO_DE_DADOS)
                .criarDAOGenero();
        dao.persistir(gen);
        try{dao.close();}catch(Exception ex){}
    }
    
    public static List<String> todosGeneros() throws PersistenceException{
        DAOGenero dao = CriadorFabrica.criarFabrica(CriadorFabrica.BANCO_DE_DADOS).criarDAOGenero();
        List<String> gen = dao.todosGeneros();
        try{dao.close();}catch(Exception ex){}
        return gen;
        
    }
}


package io.github.marcondesnjr.sismovie.gerenciadordados;

import io.github.marcondesnjr.sismovie.dao.CriadorFabrica;
import io.github.marcondesnjr.sismovie.dao.PersistenceException;
import java.util.List;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class GerenciadorGenero {
    public void salvar(String gen) throws PersistenceException{
        CriadorFabrica.criarFabrica(CriadorFabrica.BANCO_DE_DADOS)
                .criarDAOGenero().persistir(gen);
    }
    
    public static List<String> todosGeneros() throws PersistenceException{
        return CriadorFabrica.criarFabrica(CriadorFabrica.BANCO_DE_DADOS)
                .criarDAOGenero().todosGeneros();
    }
}

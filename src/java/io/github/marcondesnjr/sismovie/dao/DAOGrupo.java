package io.github.marcondesnjr.sismovie.dao;

import io.github.marcondesnjr.sismovie.Grupo;
import io.github.marcondesnjr.sismovie.Usuario;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public interface DAOGrupo extends AutoCloseable{
    public Grupo persiste(Grupo grp) throws PersistenceException;
    public Grupo localiza(int id) throws PersistenceException;
    @Override
    public void close();    
}

package io.github.marcondesnjr.sismovie.dao;

import io.github.marcondesnjr.sismovie.Filme;
import java.util.List;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public interface DAOFilme extends AutoCloseable{
    
    public void persistir(Filme fl) throws PersistenceException;
    public void excluir (int id) throws PersistenceException;
    public Filme localizar (int id) throws PersistenceException;
    public void localizar (String nome) throws PersistenceException;
    public void localizarGen (String genero) throws PersistenceException;
    public void update(Filme fl) throws PersistenceException;
    public List<Filme> localizarUltimos(int num) throws PersistenceException;
    @Override
    public void close();
}

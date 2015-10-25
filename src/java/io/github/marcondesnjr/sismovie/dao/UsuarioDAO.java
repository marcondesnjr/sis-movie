package io.github.marcondesnjr.sismovie.dao;

import io.github.marcondesnjr.sismovie.Administrador;
import io.github.marcondesnjr.sismovie.Usuario;
import java.util.List;

public interface UsuarioDAO {

    public void persistir(Usuario usuario) throws PersistenceException, AlreadyExistsException;

    public Usuario excluir(Usuario usuario);

    public List<Usuario> listar();

    public Usuario localizar(String login) throws PersistenceException;

    public List<Usuario> localizarNome(String nome);

    public Usuario localizar(String login, String senha) throws PersistenceException;

    public void persistir(Administrador adm) throws PersistenceException, AlreadyExistsException;
    
    public List<Usuario> localizar() throws PersistenceException;
    
    public List<Usuario> perquisarNome(String nome) throws PersistenceException;
}

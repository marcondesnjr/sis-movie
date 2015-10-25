package io.github.marcondesnjr.sismovie.dao;

public interface FabricaDAO {


  public UsuarioDAO criarDaoUsuario();
  public FilmeDAO criarDaoFilme();
  public DAOGenero criarDAOGenero();
  public DAOEstado criarDAOEstado();
}
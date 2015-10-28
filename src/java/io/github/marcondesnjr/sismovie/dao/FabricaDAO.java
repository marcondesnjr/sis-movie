package io.github.marcondesnjr.sismovie.dao;

public interface FabricaDAO {


  public DAOUsuario criarDaoUsuario();
  public DAOFilme criarDaoFilme();
  public DAOGenero criarDAOGenero();
  public DAOEstado criarDAOEstado();
  public DAOAmizade criarDAOAmizade();
}
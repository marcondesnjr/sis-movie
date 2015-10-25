package io.github.marcondesnjr.sismovie;

import io.github.marcondesnjr.sismovie.gerenciadordados.GerenciadorFilme;
import io.github.marcondesnjr.sismovie.gerenciadordados.GerenciadorUsuario;
import io.github.marcondesnjr.sismovie.dao.AlreadyExistsException;
import io.github.marcondesnjr.sismovie.dao.PersistenceException;
import java.sql.SQLException;
import java.time.LocalDate;

public class Administrador extends Usuario {

    public Administrador(String nome, String sobrenome, String email, String senha,
            LocalDate dataNasc, String cidade, Estado estado) {
        super(nome, sobrenome, email, senha, dataNasc, cidade, estado);
    }


  public void adicionarFilme(Filme filme) throws PersistenceException{
      GerenciadorFilme.salvar(filme);
  }

  public Filme removerFilme(int id) {
  return null;
  }

  public void criarAdministrador(Administrador adm) throws PersistenceException, AlreadyExistsException {
      GerenciadorUsuario.salvar(adm);
  }

  public Administrador removerAdministrador(String email) {
  return null;
  }

}
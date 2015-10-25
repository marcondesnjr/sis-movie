package io.github.marcondesnjr.sismovie;
import io.github.marcondesnjr.sismovie.gerenciadordados.GerenciadorFilme;
import io.github.marcondesnjr.sismovie.gerenciadordados.GerenciadorUsuario;
import io.github.marcondesnjr.sismovie.gerenciadordados.GerenciadorGenero;
import io.github.marcondesnjr.sismovie.gerenciadordados.GerenciadorEstado;
import io.github.marcondesnjr.sismovie.dao.AlreadyExistsException;
import io.github.marcondesnjr.sismovie.dao.PersistenceException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class SisMovie {
    
    public static void cadastrarUsuario(String foto, String nome, String sobrenome, String email, String senha, LocalDate dataNasc, String cidade, Estado estado) throws PersistenceException, AlreadyExistsException {
        Usuario usr = new Usuario(nome, sobrenome, email, senha, dataNasc, cidade, estado);
        usr.setFoto(foto);
        GerenciadorUsuario.salvar(usr);
    }

    public static Usuario realizarLogin(String login, String senha) throws SQLException, PersistenceException {
        return GerenciadorUsuario.localizar(login, senha);
        
    }
    
    public static Usuario localizarUsuario(String login) throws PersistenceException{
        return GerenciadorUsuario.localizar(login);

    }
    
    public void convidarAmigo(String login) throws SQLException{

    }

    public void realizarLogoff(){
    }
    
    public static void cadastrarAdministrador(Administrador resp, Administrador novo) throws NotAdministradorException, PersistenceException, AlreadyExistsException{
        resp.criarAdministrador(novo);
    }

    public void cadastrarGrupo() {
    }
    
    public static void cadastrarFilme(Administrador adm, String foto, String titulo, String sinopse, String ano,
            List<String> gen, List<String> at, List<String> dr) throws PersistenceException{
            Filme fl = new Filme(foto, titulo, sinopse, Year.of(Integer.parseInt(ano)));
            fl.setAtores(at);
            fl.setGeneros(gen);
            fl.setDiretores(dr);
            adm.adicionarFilme(fl);
    }
    
    public static List<Filme> lastFilmes() throws SQLException, PersistenceException{
        return GerenciadorFilme.lastFilmes(10);
    }
    
    public static List<String> todosGeneros() throws PersistenceException{
        return GerenciadorGenero.todosGeneros();
    }

    public static List<Estado> todosEstados() throws PersistenceException{
        return GerenciadorEstado.todosEstados();
    }
    
    public static List<String> todosNomesEstados() throws PersistenceException{
        List<Estado> ests = todosEstados();
        List<String> nomes = new ArrayList<>();
        for (Estado est : ests) {
            nomes.add(est.toString());
        }
        return nomes;
    }
    
    public static Estado getEstadoPelaSigla(String sigla) throws PersistenceException{
        List<Estado> ests = todosEstados();
        for (Estado est : ests) {
            if(est.toString().equals(sigla))
                return est;
        }
        return null;
    }
    
    public static List<Usuario> todosUsuarios() throws PersistenceException{
        return GerenciadorUsuario.localizar();
    }
    
    public static List<Usuario> pesquisarPorNome(String nome) throws PersistenceException{
        return GerenciadorUsuario.perquisarNome(nome);
    }
}

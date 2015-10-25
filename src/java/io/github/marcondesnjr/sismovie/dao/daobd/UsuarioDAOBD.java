package io.github.marcondesnjr.sismovie.dao.daobd;

import io.github.marcondesnjr.sismovie.dao.AlreadyExistsException;
import io.github.marcondesnjr.sismovie.Administrador;
import io.github.marcondesnjr.sismovie.Estado;
import io.github.marcondesnjr.sismovie.Usuario;
import io.github.marcondesnjr.sismovie.dao.PersistenceException;
import io.github.marcondesnjr.sismovie.dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOBD implements UsuarioDAO {

    private final Connection conn;
    private final int TIPO_USUARIO = 0;
    private final int TIPO_ADM = 1;

    public UsuarioDAOBD(Connection conn) {
        this.conn = conn;
    }
    
    
    @Override
    public void persistir(Usuario usuario) throws PersistenceException {
        try {
            persitirTipos(usuario, TIPO_USUARIO);
        } catch (AlreadyExistsException ex) {
            throw new PersistenceException(ex);
        }
    }

    private void persitirTipos(Usuario usuario, int tipo) throws AlreadyExistsException, PersistenceException{
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO USUARIO VALUES (?,?,?,?,?,?,?,?,?,?)")) {
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getNome());
            ps.setString(4, usuario.getSobrenome());
            ps.setString(5, usuario.getApelido());
            ps.setString(6, usuario.getFoto());
            ps.setDate(7, Date.valueOf(usuario.getDataNasc()));
            ps.setString(8, usuario.getCidade());
            ps.setString(9, usuario.getEstado().name());
            ps.setInt(10, tipo);
            ps.executeUpdate();
            conn.commit();
            conn.close();
        } catch (SQLException ex) {
            Usuario usr = localizar(usuario.getEmail());
            if(usr != null){
                throw new AlreadyExistsException(ex);
            }
            throw new PersistenceException(ex);
        }
    }

    @Override
    public Usuario excluir(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario localizar(String login) throws PersistenceException {
        try {
            Usuario usr = localizarDoTipo(login, TIPO_USUARIO);
            if (usr == null)
                usr = localizarDoTipo(login, TIPO_ADM);
            return usr;
        } catch (SQLException ex) {
            throw new PersistenceException(ex);
        }
    }
 
    private Usuario localizarDoTipo(String login, int tipo) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM USUARIO WHERE email = ? AND adm = ?")) {
            ps.setString(1, login);
            ps.setInt(2, tipo);
            try(ResultSet rs = ps.executeQuery()){
                List<Usuario> usr = constructUser(rs);
                return usr.size() > 0?usr.get(0):null;
            }
        }
    }

    @Override
    public List<Usuario> localizarNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario localizar(String login, String senha) throws PersistenceException {
        try {
            Usuario usr = localizarDoTipo(login, senha, TIPO_USUARIO);
            if (usr == null)
                usr = localizarDoTipo(login, senha, TIPO_ADM);
            return usr;
        } catch (SQLException ex) {
            throw new PersistenceException(ex);
        }
    }

    private Usuario localizarDoTipo(String login, String senha, int tipo) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM USUARIO WHERE email = ? AND senha = ? AND adm = ?")) {
            ps.setString(1, login);
            ps.setString(2, senha);
            ps.setInt(3, tipo);
            try(ResultSet rs = ps.executeQuery()){
                List<Usuario> usr = constructUser(rs);
                return usr.size() > 0? usr.get(0):null;
            }
        }
    }

    @Override
    public void persistir(Administrador adm) throws PersistenceException ,AlreadyExistsException{
        persitirTipos(adm, TIPO_ADM);
    }

    @Override
    public List<Usuario> localizar() throws PersistenceException {
        String sql = "SELECT * FROM USUARIO";
        try(Statement stm = conn.createStatement()){
            try(ResultSet rs = stm.executeQuery(sql)){
                return constructUser(rs);
            }
        } catch (SQLException ex) {
            throw new PersistenceException(ex);
        }
    }

    @Override
    public List<Usuario> perquisarNome(String nome) throws PersistenceException {
        String sql = "SELECT * FROM USUARIO WHERE nome ILIKE ? OR sobrenome ILIKE ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, "%" + nome + "%");
            ps.setString(2, "%" + nome + "%");
           try(ResultSet rs = ps.executeQuery()){
               return constructUser(rs);
           } 
        } catch (SQLException ex) {
            throw new PersistenceException(ex);
        }
    }
    
    
    private List<Usuario> constructUser(ResultSet rs) throws SQLException{
        List<Usuario> usrs = new ArrayList<>();
                while(rs.next()){
                    String nome = rs.getString("nome");
                    String sobrenome = rs.getString("sobrenome");
                    String email = rs.getString("email");
                    String apelido = rs.getString("apelido");
                    LocalDate dataNasc = rs.getDate("dt_nasc").toLocalDate();
                    String foto = rs.getString("foto");
                    String cidade = rs.getString("cidade");
                    Estado estado = Estado.valueOf(rs.getString("estado"));
                    int adm = rs.getInt("adm");
                    Usuario usr;
                    if(adm == 1){
                        usr = new Administrador(nome, sobrenome, email, null, dataNasc, cidade, estado);
                    }
                    else{
                        usr = new Usuario(nome, sobrenome, email, null, dataNasc, cidade, estado);
                    }
                    usr.setFoto(foto);
                    usr.setApelido(apelido);
                    usrs.add(usr);
                }
                return usrs;
    }
    

}

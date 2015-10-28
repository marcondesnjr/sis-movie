package io.github.marcondesnjr.sismovie.dao.daobd;

import io.github.marcondesnjr.sismovie.Filme;
import io.github.marcondesnjr.sismovie.dao.DAOFilme;
import io.github.marcondesnjr.sismovie.dao.PersistenceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class DAOBDFilme implements DAOFilme {

    private Connection conn;

    public DAOBDFilme(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void persistir(Filme fl) throws PersistenceException {
        String sql = "INSERT INTO FILME(foto, titulo, sinopse, ano) VALUES (?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, fl.getFoto());
            ps.setString(2, fl.getTitulo());
            ps.setString(3, fl.getSinopse());
            ps.setInt(4, fl.getAno().getValue());
            ps.executeUpdate();
            try(ResultSet rs = ps.getGeneratedKeys()){
                if(rs.next()){
                    fl.setId(rs.getInt("id"));
                }
            }
            DAOBDGeneroFilme daoGen = new DAOBDGeneroFilme(conn);
            for (String gen : fl.getGeneros()) {
                daoGen.persistir(fl, gen);
            }
            DAOBDAtor daoAt = new DAOBDAtor(conn);
            for (String ator : fl.getAtores()) {
                daoAt.persistir(fl, ator);
            }
            DAOBDDiretor daoDR = new DAOBDDiretor(conn);
            for(String dir: fl.getDiretores()){
                daoDR.persiste(fl, dir);
            }
            conn.commit();
        }catch(Exception ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                throw new PersistenceException("Erro ao realizar ROLLBACK",ex);
            }
            throw new PersistenceException(ex);
        }
    }

    @Override
    public void excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void localizar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void localizar(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void localizarGen(String genero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Filme fl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void close() {

    }

    @Override
    public List<Filme> localizarUltimos(int num) throws PersistenceException {
        try(PreparedStatement ps = conn.prepareStatement("SELECT * FROM FILME ORDER BY id LIMIT ?")){
            ps.setInt(1, num);
            try(ResultSet rs = ps.executeQuery()){
                List<Filme> films = new ArrayList();
                DAOBDGeneroFilme daoGF= new DAOBDGeneroFilme(conn);
                DAOBDAtor daoAt = new DAOBDAtor(conn);
                DAOBDDiretor daoD = new DAOBDDiretor(conn);
                while(rs.next()){
                    String foto = rs.getString("foto");
                    String titulo = rs.getString("titulo");
                    String sinopse = rs.getString("sinopse");
                    Year ano = Year.of(rs.getInt("ano"));
                    Filme fl = new Filme(foto, titulo, sinopse, ano);
                    fl.setGeneros(daoGF.localizarGeneroFilme(fl));
                    fl.setAtores(daoAt.localizarAtorFilme(fl));
                    fl.setDiretores(daoD.localizarDiretorFilme(fl));
                    films.add(fl);
                }
                conn.commit();
                return films;
            }
        } catch (SQLException ex) {
            try {
                conn.rollback();
                throw new PersistenceException(ex);
            } catch (SQLException ex1) {
                throw new PersistenceException("Erro ao tentar realizar ROLLBACK",ex1);
            }
        }
    }

    private class DAOBDGeneroFilme {

        private final Connection conn;

        public DAOBDGeneroFilme(Connection conn) {
            this.conn = conn;
        }

        public void persistir(Filme fl, String gen) throws SQLException {
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO GENERO_FILME VALUES (?,?)")) {
                ps.setInt(1, fl.getId());
                ps.setString(2, gen);
                ps.executeUpdate();
            }
        }
        
        public List<String> localizarGeneroFilme(Filme fl) throws SQLException{
            String sql = "SELECT genero "
                    + "FROM GENERO_FILME "
                    + "WHERE id_filme = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, fl.getId());
                List<String> generos = new ArrayList<>();
                try(ResultSet rs = ps.executeQuery()){
                    if(rs.next()){
                        generos.add(rs.getString("genero"));
                    }
                    return generos;
                }
            }
        }
        
    }

    private class DAOBDAtor {

        private final Connection conn;

        public DAOBDAtor(Connection conn) {
            this.conn = conn;
        }

        public void persistir(Filme fl, String ator) throws SQLException {
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO ATOR_FILME VALUES (?,?)")) {
                ps.setInt(1, fl.getId());
                ps.setString(2, ator);
                ps.executeUpdate();
            }
        }
        
        public List<String> localizarAtorFilme(Filme fl) throws SQLException{
            String sql = "SELECT ator "
                    + "FROM ATOR_FILME "
                    + "WHERE id_filme = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, fl.getId());
                List<String> atores = new ArrayList<>();
                try(ResultSet rs = ps.executeQuery()){
                    if(rs.next()){
                        atores.add(rs.getString("ator"));
                    }
                    return atores;
                }
            }
        }
    }

    private static class DAOBDDiretor {

        private final Connection conn;
        
        public DAOBDDiretor(Connection conn) {
            this.conn = conn;
        }
        
        public void persiste(Filme fl, String diretor) throws SQLException{
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO DIRETOR_FILME VALUES (?,?)")) {
                ps.setInt(1, fl.getId());
                ps.setString(2, diretor);
                ps.executeUpdate();
            }
        }
        
        public List<String> localizarDiretorFilme(Filme fl) throws SQLException{
            String sql = "SELECT diretor "
                    + "FROM DIRETOR_FILME "
                    + "WHERE id_filme = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, fl.getId());
                List<String> diretores = new ArrayList<>();
                try(ResultSet rs = ps.executeQuery()){
                    if(rs.next()){
                        diretores.add(rs.getString("diretor"));
                    }
                    return diretores;
                }
            }
        }
        
    }

}

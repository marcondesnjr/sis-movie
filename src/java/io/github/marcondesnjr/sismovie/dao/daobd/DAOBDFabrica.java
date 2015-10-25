
package io.github.marcondesnjr.sismovie.dao.daobd;

import io.github.marcondesnjr.sismovie.dao.DAOEstado;
import io.github.marcondesnjr.sismovie.dao.DAOGenero;
import io.github.marcondesnjr.sismovie.dao.FabricaDAO;
import io.github.marcondesnjr.sismovie.dao.FilmeDAO;
import io.github.marcondesnjr.sismovie.dao.UsuarioDAO;
import java.sql.Connection;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class DAOBDFabrica implements FabricaDAO{

    private Connection conn;
    
    public DAOBDFabrica(Connection conn) {
        this.conn = conn;
    }
 
    @Override
    public UsuarioDAO criarDaoUsuario() {
        return new UsuarioDAOBD(conn);
    }

    @Override
    public FilmeDAO criarDaoFilme() {
        return new DAOBDFilme(conn);
    }

    @Override
    public DAOGenero criarDAOGenero() {
        return new DAOBDGenero(conn);
    }

    @Override
    public DAOEstado criarDAOEstado() {
        return new DAOBDEstado(conn);
    }
    
}

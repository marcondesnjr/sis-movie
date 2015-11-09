
package io.github.marcondesnjr.sismovie.tags;

import io.github.marcondesnjr.sismovie.Filme;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class AllMiniature extends SimpleTagSupport {

    public static final String TIPO_USUARIO = "usuario";
    public static final String TIPO_FILME = "filme";
    
    private List<Filme> lista;
    @Override
    public void doTag() throws JspException {
        if(lista != null){
            try {
                JspWriter out = getJspContext().getOut();
                out.print("<div class=\"container container-filme\">");
                out.print("<div class=\"row\">");
                for (Filme filme : lista) {
                    out.print("<div class=\"col-sm-3\">");
                    out.print("<img src=\"" +filme.getFoto()+ "\" onclick=\"setFormValue('filme-ref',"+filme.getId()+"\">");
                    out.print("</div>");
                }
                out.print("</div>");
                out.print("</div>");
            } catch (IOException ex) {
                Logger.getLogger(AllMiniature.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Filme> getLista() {
        return lista;
    }

    public void setLista(List<Filme> lista) {
        this.lista = lista;
    }

    
    
    
}

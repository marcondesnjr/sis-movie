package io.github.marcondesnjr.sismovie.commands;

import io.github.marcondesnjr.sismovie.Estado;
import io.github.marcondesnjr.sismovie.SisMovie;
import io.github.marcondesnjr.sismovie.dao.AlreadyExistsException;
import io.github.marcondesnjr.sismovie.dao.PersistenceException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.UploadContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
@MultipartConfig
public class SingIn implements Command{

    public String execute(HttpServletRequest request, HttpServletResponse response){
        try {
            
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Configure a repository (to ensure a secure temp location is used)
            ServletContext servletContext = request.getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(1000 * 1024);
            upload.setFileSizeMax(1000 * 1024);

            // Parse the request
            List<FileItem> items = upload.parseRequest(createRequestContext(request));
            Map<String,String> param = new HashMap<>();
            File uploadedFile = null;
            for (FileItem item : items) {
                if (!item.isFormField()) {
                    String path = this.getClass().getClassLoader().getResource("").getPath();
                    String fullPath = URLDecoder.decode(path, "UTF-8");
                    String pathArr[] = fullPath.split("/WEB-INF/classes/");
                    fullPath = pathArr[0];
                    String imgPath = new File(fullPath).getPath() + File.separator +
                            "img_perfil";
                    File uploadedDiretory = new File(imgPath);
                    uploadedFile = File.createTempFile("perfil", ".jpg", uploadedDiretory);
                    item.write(uploadedFile);
                }
                else{
                    param.put(item.getFieldName(), item.getString());
                }
            }
            
            String nome = param.get("nome");
            String sobrenome = param.get("sobrenome");
            String email =  param.get("email");
            String senha =  param.get("senha");
            String data =  param.get("dataNasc");
            String cidade = param.get("cidade");
            Estado est = SisMovie.getEstadoPelaSigla(param.get("estado"));
            LocalDate dataNasc = LocalDate.parse(data);
            String foto = uploadedFile != null? "img_perfil" + File.separator + uploadedFile.getName(): null;
            
            if(param.get("adm") != null &&  param.get("adm").equals("1")){
                
            }
            else{
                SisMovie.cadastrarUsuario(foto,nome, sobrenome, email, senha, dataNasc, cidade, est);
            }
            
            response.sendRedirect("control?command=Index");
            
            return null;
        } catch (AlreadyExistsException ex) {
            return null;
        }catch (Exception ex) {
            return null;
        }

    }

    private RequestContext createRequestContext(HttpServletRequest req) {
        return new UploadContext() {
            @Override
            public String getCharacterEncoding() {
                return req.getCharacterEncoding();
            }

            @Override
            public String getContentType() {
                return req.getContentType();
            }

            @Override
            public InputStream getInputStream() throws IOException {
                InputStream in = req.getInputStream();
                if (in == null) {
                    throw new IOException("Missing content in the request");
                }
                return req.getInputStream();
            }

            @Override
            public long contentLength() {
                return req.getContentLength();
            }
        };
    }
}

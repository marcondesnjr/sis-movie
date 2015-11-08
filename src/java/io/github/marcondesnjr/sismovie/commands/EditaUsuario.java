/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.sismovie.commands;

import io.github.marcondesnjr.sismovie.Estado;
import io.github.marcondesnjr.sismovie.Permissao;
import io.github.marcondesnjr.sismovie.SisMovie;
import io.github.marcondesnjr.sismovie.Usuario;
import io.github.marcondesnjr.sismovie.dao.AlreadyExistsException;
import io.github.marcondesnjr.sismovie.dao.PersistenceException;
import io.github.marcondesnjr.sismovie.dao.PhotoUpload;
import io.github.marcondesnjr.sismovie.gerenciadordados.GerenciadorUsuario;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
@MultipartConfig
public class EditaUsuario implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Map<String,String> param = new HashMap<>();
            
            File uploadedFile = PhotoUpload.upload(request, SingIn.DIRETORY_PERFIL, "perfil", ".jpg", param);
            
            String nome = param.get("nome");
            String sobrenome = param.get("sobrenome");
            String senha =  param.get("senha");
            String senhaOld = param.get("senhaOld");
            String data =  param.get("dataNasc");
            String cidade = param.get("cidade");
            String apelido = param.get("apelido");
            Estado est = SisMovie.getEstadoPelaSigla(param.get("estado"));
            LocalDate dataNasc = LocalDate.parse(data);
//            String foto = uploadedFile != null? SingIn.DIRETORY_PERFIL +"/"+ uploadedFile.getName(): null;
            
            Usuario usrLog = (Usuario) request.getSession().getAttribute("usrLog");
            Usuario usr = GerenciadorUsuario.localizar(usrLog.getEmail(), senhaOld);
            if(usr != null){
    //            usr.setFoto(foto);
                if(nome != null)
                    usr.setNome(nome);
                if(nome != null)
                    usr.setSobrenome(sobrenome);
                if(nome != null)
                    usr.setSenha(senha);
                if(nome != null)
                    usr.setDataNasc(dataNasc);
                if(nome != null)
                    usr.setCidade(cidade);
                if(nome != null)
                    usr.setEstado(est);
                usr.setApelido(apelido);
                GerenciadorUsuario.atualizar(usr);
            }
            
            response.sendRedirect(request.getContextPath()+"/home/");
            return null;
        } catch (PersistenceException | IOException ex) {
            Logger.getLogger(EditaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            try{response.sendError(600);}catch(Exception e){}
            return null;
        }
    }
    
    
    
}

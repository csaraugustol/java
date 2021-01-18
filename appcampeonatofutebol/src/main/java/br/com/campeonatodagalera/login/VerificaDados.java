/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.campeonatodagalera.login;

import br.com.campeonatodagalera.dao.UsuarioDao;
import java.sql.SQLException;

/**
 *
 * @author cesar
 */
public class VerificaDados {
    
    public static Usuario verificaLogin(String usuario, String senha) throws ClassNotFoundException, SQLException{
        
        Usuario user = new UsuarioDao().buscaUsuarioSenha(usuario, senha);
        
        if(user != null) {
            return user;
        }else{
            return null;
        }
        
    }
    
}

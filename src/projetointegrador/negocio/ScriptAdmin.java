/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetointegrador.negocio;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import projetointegrador.persistencia.DaoGenerico;

/**
 *
 * @author enzob
 */
public class ScriptAdmin {
    
    public static void scriptInicial () throws NoSuchAlgorithmException, UnsupportedEncodingException {
    DaoGenerico <Usuario> dao = new DaoGenerico <> ();        
        List<Usuario> lista = dao.read(Usuario.class, "FROM Usuario");
        boolean adminExist = false;
        
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getUsuario() != null && lista.get(i).getUsuario().equals("admin")) {
                adminExist = true;
            }
        }
        
        if (adminExist == false) {
            CriptografarSenha cripto = new CriptografarSenha();
            String senha = cripto.cripto("admin");
            Usuario usu = new Usuario ("admin", "admin", null, "admin", "admin", "admin", senha);
            dao.create(usu);
        }
    }
    
}

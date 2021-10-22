/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetointegrador.negocio;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import projetointegrador.persistencia.DaoGenerico;

/**
 *
 * @author enzob
 */
public class ScriptAdmin {
    
    public static void scriptInicial () throws NoSuchAlgorithmException, UnsupportedEncodingException {
        
        //Método que verifica se o cargo e a conta ADMIN existem, caso não existam cria uma
        //To do: A conta deverá ter a senha alterada no primeiro login
        
        DaoGenerico dao = new DaoGenerico <> ();
        
        List<Cargos> listaCargo = dao.read(Cargos.class, "FROM Cargos");
        boolean adminCargoExist = false;
        
        for (int i = 0; i < listaCargo.size(); i++) {
            if (listaCargo.get(i).getNome() != null && listaCargo.get(i).getNome().equals("admin")) {
                adminCargoExist = true;
            }            
        }
        
        if (adminCargoExist == false) {
            Cargos cargo = new Cargos ("admin", "Administrador do sistema", 5);
            dao.create(cargo);
        }
        
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
            
            List<Cargos> cargoLista1 = dao.read(Cargos.class, "FROM Cargos WHERE nome='admin'");
            
            Usuario usu = new Usuario ("admin", "admin", Calendar.getInstance(), "admin", "admin", "admin", senha, cargoLista1.get(0));
            dao.create(usu);
        }       
        
    }
}

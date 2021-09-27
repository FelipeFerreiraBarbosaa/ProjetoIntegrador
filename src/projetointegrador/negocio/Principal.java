
package projetointegrador.negocio;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import projetointegrador.apresentacao.Menu;
import projetointegrador.apresentacao.TelaLogin;
import projetointegrador.persistencia.DaoGenerico;

public class Principal {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        
        
        //Script que verificar a existencia de uma conta admin/admin e cria caso não exista (Só por enquanto k)
        ScriptAdmin.scriptInicial();        
        
        //Menu tela = new Menu();
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
    }
}

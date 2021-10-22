
package projetointegrador.negocio;
/**
 *
 * @author Felipe
 */
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import projetointegrador.apresentacao.Menu;
import projetointegrador.apresentacao.TelaLogin;
import projetointegrador.persistencia.DaoGenerico;

public class Principal {
    static Logger log = Logger.getLogger(Principal.class.getName());
    
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        
        PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\projetointegrador\\log4j.properties"); 
        org.apache.log4j.MDC.put("User_data", "Pré-Login");
        
        //Script que verificar a existencia de uma conta admin/admin e cria caso não exista (Só por enquanto k)
        ScriptAdmin.scriptInicial();
        log.info("Script funcionando");
        
        //Menu tela = new Menu();
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
    }
}

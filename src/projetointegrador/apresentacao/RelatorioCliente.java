
package projetointegrador.apresentacao;

import java.util.HashMap;
import projetointegrador.reports.Report;

/**
 *
 * @author Felipe
 */
public class RelatorioCliente implements Report {

    private String nomeIni;
    private String nomeFinal;

    public String getNomeIni() {
        return nomeIni;
    }

    public void setNomeIni(String nomeIni) {
        this.nomeIni = nomeIni;
    }

    public String getNomeFinal() {
        return nomeFinal;
    }

    public void setNomeFinal(String nomeFinal) {
        this.nomeFinal = nomeFinal;
    }
    
    @Override
    public HashMap getParameters() {
    HashMap map = new HashMap();
    map.put("nomeIni",nomeIni.trim());
    map.put("nomeFinal",nomeFinal.trim()+"zzzzzzzzzzzz");
    return map;
    
    }

    @Override
    public String getPath() {
        return "/projetointegrador/reports/RelatorioCliente.jrxml";
    }
    
}

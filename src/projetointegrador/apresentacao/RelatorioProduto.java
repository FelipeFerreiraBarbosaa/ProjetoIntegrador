
package projetointegrador.apresentacao;

import java.util.HashMap;
import projetointegrador.negocio.Categoria;
import projetointegrador.reports.Report;

/**
 *
 * @author Felipe
 */
public class RelatorioProduto implements Report {

    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    @Override
    public HashMap getParameters() {
        HashMap map = new HashMap();
        
        map.put ("idCategoria", categoria.getIdCategoria());
        map.put ("descrCategoria", categoria.getDescricaoCategoria());
        return map;
    }
    

    @Override
    public String getPath() {
       return "/projetointegrador/reports/RelatorioProduto.jrxml";
    }
    
}

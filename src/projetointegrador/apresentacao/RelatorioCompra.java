
package projetointegrador.apresentacao;

import java.util.Date;
import java.util.HashMap;
import projetointegrador.negocio.Fornecedor;
import projetointegrador.reports.Report;

public class RelatorioCompra implements Report
{
    private Date data1;
    private Date data2;
    private Fornecedor fornecedor;

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getData1()
    {
        return data1;
    }

    public void setData1(Date data1)
    {
        this.data1 = data1;
    }

    public Date getData2()
    {
        return data2;
    }

    public void setData2(Date data2)
    {
        this.data2 = data2;
    }
    
    @Override
    public HashMap getParameters()
    {
        HashMap map = new HashMap();
        map.put("data1", this.data1);
        map.put("data2", this.data2);
        map.put("nomeFornecedor", this.fornecedor );
        return map;
    }

    @Override
    public String getPath()
    {
         return "/projetointegrador/reports/RelatorioCompra.jrxml";
    }
    public String toString() {
        return data1+";"+data2;
    }
    
}

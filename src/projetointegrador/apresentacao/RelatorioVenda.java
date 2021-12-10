
package projetointegrador.apresentacao;

import java.util.Date;
import java.util.HashMap;
import projetointegrador.reports.Report;

public class RelatorioVenda implements Report
{
    private Date data1;
    private Date data2;

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
        return map;
    }

    @Override
    public String getPath()
    {
         return "/projetointegrador/reports/RelatorioVenda.jrxml";
    }
    public String toString() {
        return data1+";"+data2;
    }
    
}

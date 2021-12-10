
package projetointegrador.reports;

import java.sql.Connection;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import projetointegrador.HibernateUtil;

/**
 *
 * @author Felipe
 */
public class ReportManager {
    
    private Connection dbConnection;
    

    public ReportManager(Connection dbConnection)
    {
        this.dbConnection = dbConnection;
    }

    public ReportManager()
    {
        this.dbConnection = null;
    }
    
    public void setDataBaseConnection(Connection dbConnection)
    {
        this.dbConnection = dbConnection;
    }
    
    public void createReport( Report report ) throws HibernateException, SQLException
    {
        try
        {
            // Compilar o relatório do formato XML gerando um objeto JasperReport
            JasperReport jasperReport = JasperCompileManager.compileReport(getClass().getResourceAsStream( report.getPath() ));

            // Gera o relatório efetivamente
            JasperPrint print = JasperFillManager.fillReport(jasperReport, report.getParameters(), HibernateUtil.getConnection() );

            // Exibir o relatório
            JasperViewer.viewReport(print,false);
        } 
        catch (JRException ex)
        {
            
        }
    }
}

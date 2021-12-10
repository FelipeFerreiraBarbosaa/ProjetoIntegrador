/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetointegrador.tableModel;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import projetointegrador.negocio.CalendarFactory;
import projetointegrador.negocio.Logs;

/**
 *
 * @author enzob
 */
public class LogsAuditsTableModel implements TableModel {
    
    List <Logs> lista;
    
    public LogsAuditsTableModel (List <Logs> lista) {

        this.lista = lista;
        
    } 

    public List<Logs> getListaLogs() {
        return lista;
    }

    public void setAlLogin(List <Logs> lista) {
        this.lista = lista;
    }


    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String[] def = {"Data", "Descrição", "Usuário"};
        return def[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        
        return String.class;     
        
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Logs logs = lista.get (rowIndex);
        CalendarFactory cl = new CalendarFactory();
        String calendarString = cl.CalendarToString(logs.getDated());
        
        Object[] def = {calendarString, logs.getMessage(), logs.getUser()};
        return def[columnIndex];        
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetointegrador.tableModel;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import projetointegrador.negocio.Cargos;

/**
 *
 * @author enzob
 */
public class CargosTableModel implements TableModel {
    
    List <Cargos> lista;
    
    public CargosTableModel (List <Cargos> lista) {

        this.lista = lista;
        
    } 

    public List<Cargos> getListaUsuario() {
        return lista;
    }

    public void setAlLogin(List <Cargos> lista) {
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
        String[] def = {"Nome", "Descrição", "Nivel Permissão"};
        return def[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        
        if(columnIndex == 2) {
            return int.class;
        } else {
            return String.class;
        }      
        
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Cargos cargos = lista.get (rowIndex);
        Object[] def = {cargos.getNome(), cargos.getDesc(), cargos.getNivelPerm()};
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

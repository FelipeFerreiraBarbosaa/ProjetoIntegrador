package projetointegrador.tabelas;

import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import projetointegrador.negocio.Usuario;

public class UsuarioTableModel extends AbstractTableModel {
    
    private String colunas[] = {"Usuário", "Nome", "E-mail"};
    private List<Usuario> dados;    
    
    @Override
    public int getRowCount() {
        if(dados == null){
            return 0;
        }
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int l, int c) {
        Usuario usuario = dados.get(l);
        switch (c) {
            case 0:
                return usuario.getUsuario();
            case 1:
                return usuario.getNomeCompleto();
            case 2:
                return usuario.getEmail();
            default:
                throw new IndexOutOfBoundsException("Coluna inexistente!");
        }
    }

    @Override
    public String getColumnName(int c) {
        return colunas[c];
    }

    @Override
    public boolean isCellEditable(int l, int c) {
        return false;
    }

    public void setDados(List<Usuario> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Usuario getRowValue(int l) {
        return dados.get(l);
    }
    
}

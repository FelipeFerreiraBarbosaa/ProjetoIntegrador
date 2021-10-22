package projetointegrador.tableModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import projetointegrador.negocio.Itemvenda;


public class TableModelItemVenda extends AbstractTableModel {

    //Declaração de variáveis.
    private final List<Itemvenda> linhas;
    private final String[] colunas;

    //Declaração de variáveis que compoem os campos da tabela.
    private static final int produtoItem = 0;
    private static final int valorItem = 1;

    /**
     * @see Construtor padrão. Inicializa as linhas da coluna como nulo e define
     * as colunas com os valores do objeto.
     */
    public TableModelItemVenda() {
        linhas = new ArrayList<>();
        colunas = new String[]{"Produto", "Valor"};
    }

   
    public TableModelItemVenda(List<Itemvenda> itens) {
        linhas = new ArrayList<>(itens);
        colunas = new String[]{"Produto", "Valor"};
    }

    //Gets and Sets
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case produtoItem:
                return String.class;
            case valorItem:
                return BigDecimal.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Itemvenda item = linhas.get(rowIndex);
        switch (columnIndex) {
            case produtoItem:
                return item.getProduto().getDescricaoProduto();
            case valorItem:
                return item.getValorItemVenda();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Itemvenda item = linhas.get(rowIndex);
        switch (columnIndex) {
            case produtoItem:
                item.getProduto().setDescricaoProduto((String) aValue);
                break;
            case valorItem:
                item.setValorItemVenda((BigDecimal) (aValue));
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public Itemvenda getItem(int rowIndex) {
        return linhas.get(rowIndex);
    }

  
    public void addItem(Itemvenda item) {
        linhas.add(item);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

   
    public void addListaItens(List<Itemvenda> itens) {
        int indice = getRowCount();
        linhas.addAll(itens);
        fireTableRowsInserted(indice, indice + itens.size());
    }

    
  
    public void removeItem(int rowIndex) {
        linhas.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }
}
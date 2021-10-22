package projetointegrador.tableModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import projetointegrador.negocio.Pagamento;


public class TableModelPagamento extends AbstractTableModel {

    //Declaração de variáveis.
    private final List<Pagamento> linhas;
    private final String[] colunas;

    //Declaração de variáveis que compoem os campos da tabela.
    private static final int statusPagamento = 0;
    private static final int descricaoPagamento = 1;
    private static final int valorPagamento = 2;
    private static final int dataPagamento = 3;

   
    public TableModelPagamento() {
        linhas = new ArrayList<>();
        colunas = new String[]{" ", "Pagamento", "Valor", "Data"};
    }

   
    public TableModelPagamento(List<Pagamento> pagamentos) {
        linhas = new ArrayList<>(pagamentos);
        colunas = new String[]{" ", "Pagamento", "Valor", "Data"};
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
            case statusPagamento:
                return Boolean.class;
            case descricaoPagamento:
                return String.class;
            case valorPagamento:
                return BigDecimal.class;
            case dataPagamento:
                return Date.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pagamento pagamento = linhas.get(rowIndex);
        switch (columnIndex) {
            case statusPagamento:
                return pagamento.getStatusPagamento();
            case descricaoPagamento:
                return pagamento.getDescricaoPagamento();
            case valorPagamento:
                return pagamento.getValorPagamento();
            case dataPagamento:
                return pagamento.getDataPagamento();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Pagamento pagamento = linhas.get(rowIndex);
        switch (columnIndex) {
            case statusPagamento:
                pagamento.setStatusPagamento((Boolean) aValue);
                break;
            case descricaoPagamento:
                pagamento.setDescricaoPagamento((String) (aValue));
                break;
            case valorPagamento:
                pagamento.setValorPagamento((BigDecimal) (aValue));
                break;
            case dataPagamento:
                pagamento.setDataPagamento((Date) (aValue));
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public Pagamento getPagamento(int rowIndex) {
        return linhas.get(rowIndex);
    }

    /**
     * @see Método que adiciona uma nova linha com os valores do objeto recebido
     * como parâmetro.
     * @param pagamento
     */
    public void addPagamento(Pagamento pagamento) {
        linhas.add(pagamento);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /**
     * @see Método que adiciona uma lista de linhas com a lista de objetos
     * recebida como parâmetro.
     * @param pagamentos
     */
    public void addListaPagamentos(List<Pagamento> pagamentos) {
        int indice = getRowCount();
        linhas.addAll(pagamentos);
        fireTableRowsInserted(indice, indice + pagamentos.size());
    }

    /**
     * @see Método que remove linha da tabela atravez do index rebecido como
     * parâmetro.
     * @param rowIndex numero da linha da tabela.
     */
    public void removePagamento(int rowIndex) {
        linhas.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    /**
     * @see Método que remove todas as linhas da tabela.
     */
    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }
}

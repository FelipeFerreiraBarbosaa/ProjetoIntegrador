package projetointegrador.tableModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import projetointegrador.negocio.Categoria;
import projetointegrador.negocio.Fornecedor;
import projetointegrador.negocio.Produto;


public class TableModelProduto extends AbstractTableModel {

    //Declaração de variáveis.
    private final List<Produto> linhas;
    private final String[] colunas;

    //Declaração de variáveis que compoem os campos da tabela.
    private static final int descricaoProduto = 0;
    private static final int categoriaProduto = 1;
    private static final int fornecedorProduto = 2;
    private static final int codigoProduto = 3;
    private static final int criacaoProduto = 4;
    private static final int atualizacaoProduto = 5;

  
    public TableModelProduto() {
        linhas = new ArrayList<>();
        colunas = new String[]{"Produto", "Categoria", "Fornecedor", "Codigo", "Criação", "Atualização"};
    }

   
    public TableModelProduto(List<Produto> produtos) {
        linhas = new ArrayList<>(produtos);
        colunas = new String[]{"Produto", "Categoria", "Fornecedor", "Codigo", "Criação", "Atualização"};
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
            case descricaoProduto:
                return String.class;
            case categoriaProduto:
                return String.class;
            case fornecedorProduto:
                return String.class;
            case codigoProduto:
                return String.class;
            case criacaoProduto:
                return Date.class;
            case atualizacaoProduto:
                return Date.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = linhas.get(rowIndex);
        switch (columnIndex) {
            case descricaoProduto:
                return produto.getDescricaoProduto();
            case categoriaProduto:
                if (produto.getCategoria() != null) {
                    return produto.getCategoria().getDescricaoCategoria();
                } else {
                    return null;
                }
            case fornecedorProduto:
                if (produto.getFornecedor() != null) {
                    return produto.getFornecedor().getNomeFornecedor();
                } else {
                    return null;
                }
            case codigoProduto:
                return produto.getCodigoProduto();
            case criacaoProduto:
                return produto.getCriacaoProduto();
            case atualizacaoProduto:
                return produto.getAtualizacaoProduto();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Produto produto = linhas.get(rowIndex);
        switch (columnIndex) {
            case descricaoProduto:
                produto.setDescricaoProduto((String) aValue);
                break;
            case categoriaProduto:
                produto.setCategoria((Categoria) aValue);
                break;
            case fornecedorProduto:
                produto.setFornecedor((Fornecedor) aValue);
                break;
            case codigoProduto:
                produto.setCodigoProduto((String) aValue);
                break;
            case criacaoProduto:
                produto.setCriacaoProduto((Date) (aValue));
                break;
            case atualizacaoProduto:
                produto.setAtualizacaoProduto((Date) (aValue));
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public Produto getProduto(int rowIndex) {
        return linhas.get(rowIndex);
    }


    public void addProduto(Produto produto) {
        linhas.add(produto);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    
    public void addListaProdutos(List<Produto> produtos) {
        int indice = getRowCount();
        linhas.addAll(produtos);
        fireTableRowsInserted(indice, indice + produtos.size());
    }

    
    public void removeProduto(int rowIndex) {
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

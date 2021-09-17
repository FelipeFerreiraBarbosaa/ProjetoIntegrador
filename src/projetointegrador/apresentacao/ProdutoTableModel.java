package projetointegrador.apresentacao;


import projetointegrador.negocio.Produto;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ProdutoTableModel extends AbstractTableModel {

    private String colunas[] = {"Nome", "Preço de Compra", "Preço de Venda","Quantidade","Descrção"};
    private List<Produto> dados;

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
        Produto produto = dados.get(l);
        switch (c) {
            case 0:
                return produto.getName();
            case 1:
                return produto.getpCusto();
            case 2:
                return produto.getpVenda();
            case 3:
                return produto.getQuantidade();
            case 4:
                return produto.getDescricao();
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

    public void setDados(List<Produto> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Produto getRowValue(int l) {
        return dados.get(l);
    }
}

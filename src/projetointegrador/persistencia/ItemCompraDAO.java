package projetointegrador.persistencia;


import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import projetointegrador.apresentacao.TelaLogin;
import projetointegrador.negocio.Compra;
import projetointegrador.negocio.Itemcompra;
import projetointegrador.negocio.Produto;
import projetointegrador.persistencia.GenericDAO;

public class ItemCompraDAO {

    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TelaLogin.class.getName());
    
    public Produto buscarProduto(Integer idProduto) {
        GenericDAO<Produto> produtoDAO = new GenericDAO<>();
        ArrayList<Produto> produtosVO = new ArrayList<>(produtoDAO.consultar(new Produto()));
        return produtosVO.get(idProduto);
    }

    
    public String[] buscarNomeProdutos() {
        GenericDAO<Produto> produtoDAO = new GenericDAO<>();
        ArrayList<Produto> produtosVO = new ArrayList<>(produtoDAO.consultar(new Produto()));
        ArrayList<String> array = new ArrayList<>();
        array.add("PRODUTO");
        produtosVO.stream().forEach((aux) -> {
            array.add(aux.getDescricaoProduto());
        });
        String[] Arr = new String[array.size()];
        Arr = array.toArray(Arr);
        return Arr;
    }

   
    public Itemcompra inserirItem(Compra compra, Produto produto, String quantidade, String valor) {
        try {
            GenericDAO<Itemcompra> itemDAO = new GenericDAO<>();
            Itemcompra itemVO = new Itemcompra();

            itemVO.setCompra(compra);
            itemVO.setProduto(produto);
            try {
                itemVO.setQuantidadeItemCompra(new Integer(quantidade));
            } catch (Exception e) {
                itemVO.setQuantidadeItemCompra(1);
            }
            try {
                itemVO.setValorItemCompra(new BigDecimal(valor));
            } catch (Exception e) {
                itemVO.setValorItemCompra(produto.getVendaProduto().multiply(new BigDecimal(itemVO.getQuantidadeItemCompra())));
            }
            itemVO.setCriacaoItemCompra(new Date());
            itemVO.setAtualizacaoItemCompra(new Date());
            
            log.info("Item inserido com sucesso");

            return itemVO;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            log.error("Erro ao inserir item");
            return null;
        }
    }

   
    public Boolean alterarItem(Itemcompra itemVO, String quantidade, String valor) {
        try {
            try {
                itemVO.setQuantidadeItemCompra(new Integer(quantidade));
            } catch (Exception e) {
                itemVO.setQuantidadeItemCompra(1);
            }
            try {
                itemVO.setValorItemCompra(new BigDecimal(valor));
            } catch (Exception e) {
                itemVO.setValorItemCompra(itemVO.getProduto().getVendaProduto().multiply(new BigDecimal(itemVO.getQuantidadeItemCompra())));
            }
            itemVO.setAtualizacaoItemCompra(new Date());
            log.info("Item alterado com sucesso");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            log.error("Erro ao alterar o item");
            return false;
        }
    }

    
    public boolean validarCampos(JPanel panel) {
        Component componentes[] = panel.getComponents();
        boolean erro = true;
        for (Component c : componentes) {
            if (c instanceof JTextField) {
                if (((JTextField) c).isEnabled()) {
                    if (((JTextField) c).getText().trim().equals("")) {
                        ((JTextField) c).setBorder(new LineBorder(Color.RED));
                        erro = false;
                    } else {
                        ((JTextField) c).setBorder(new LineBorder(Color.LIGHT_GRAY));
                    }
                } else {
                    ((JTextField) c).setBorder(new LineBorder(Color.LIGHT_GRAY));
                }
            }
        }
        return erro;
    }
}

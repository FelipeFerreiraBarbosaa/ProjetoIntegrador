package projetointegrador.persistencia;

import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import projetointegrador.apresentacao.TelaLogin;
import projetointegrador.negocio.Compra;
import projetointegrador.negocio.Fornecedor;
import projetointegrador.negocio.Itemcompra;
import projetointegrador.negocio.Produto;
import projetointegrador.persistencia.GenericDAO;

public class CompraDAO {
    
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TelaLogin.class.getName());

    public List<Produto> buscarInventario() {
        GenericDAO<Produto> produtoDAO = new GenericDAO<>();
        ArrayList<Produto> produtosVO = new ArrayList<>(produtoDAO.consultar(new Produto()));
        return produtosVO;
    }

    public List<Compra> buscarCompras() {
        GenericDAO<Compra> compraDAO = new GenericDAO<>();
        ArrayList<Compra> comprasVO = new ArrayList<>(compraDAO.consultar(new Compra()));
        return comprasVO;
    }

    public Fornecedor buscarFornecedor(Integer idCliente) {
        GenericDAO<Fornecedor> clienteDAO = new GenericDAO<>();
        ArrayList<Fornecedor> clientesVO = new ArrayList<>(clienteDAO.consultar(new Fornecedor()));
        return clientesVO.get(idCliente);
    }

    public String[] buscarNomeFornecedores() {
        GenericDAO<Fornecedor> fornecedorDAO = new GenericDAO<>();
        ArrayList<Fornecedor> fornecedoresVO = new ArrayList<>(fornecedorDAO.consultar(new Fornecedor()));
        ArrayList<String> array = new ArrayList<>();
        array.add("FORNECEDOR");
        fornecedoresVO.stream().forEach((categoriasVO1) -> {
            array.add(categoriasVO1.getNomeFornecedor());
        });
        String[] Arr = new String[array.size()];
        Arr = array.toArray(Arr);
        return Arr;
    }

    public Boolean excluirCompra(Long idCompra) {
        try {
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esta Compra?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
                try {
                    GenericDAO<Compra> compraDAO = new GenericDAO<>();
                    Compra compraVO = compraDAO.consultar("idCompra", idCompra, new Compra());
                    ArrayList<Itemcompra> itens = buscarItens(idCompra);
                    GenericDAO<Itemcompra> itemDAO = new GenericDAO<>();
                    itens.stream().forEach((iten) -> {
                        itemDAO.apagar(iten);
                    });
                    compraDAO.apagar(compraVO);
                    JOptionPane.showMessageDialog(null, "Compra excluida com sucesso.", "Secesso", JOptionPane.INFORMATION_MESSAGE);
                    log.info("Compra excluída com sucesso");
                    return true;
                } catch (Exception e) {
                    log.error("Erro ao excluir compra");
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CompraBO/excluirCompra/" + e, "Error", JOptionPane.ERROR_MESSAGE);
            log.error("Erro ao excluir compra");
            return false;
        }
    }

    public Boolean finalizarCompra(Integer idFornecedor, String valor, Integer parcelas, String vencimento, ArrayList<Itemcompra> itens) {
        try {
            GenericDAO<Compra> compraDAO = new GenericDAO<>();
            Compra compraVO = new Compra();

            if (idFornecedor > 0) {
                compraVO.setFornecedor(buscarFornecedor(idFornecedor - 1));
            }
            compraVO.setValorCompra(new BigDecimal(valor));
            compraVO.setParcelasCompra(parcelas);
            try {
                compraVO.setVencimentoCompra(new SimpleDateFormat("yyyy/MM/dd").parse(vencimento));
            } catch (Exception e) {
                compraVO.setVencimentoCompra(new Date());
            }
            compraVO.setCriacaoCompra(new Date());
            compraVO.setAtualizacaoCompra(new Date());
            compraDAO.inserir(compraVO);

            GenericDAO<Itemcompra> itemDAO = new GenericDAO<>();
            itens.stream().forEach((iten) -> {
                iten.setCompra(compraVO);
                itemDAO.inserir(iten);
            });
            JOptionPane.showMessageDialog(null, "Compra finalizada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            log.info("Compra finalizada com sucesso");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CompraBO/finalizarCompra/" + e, "Error", JOptionPane.ERROR_MESSAGE);
            log.error("Erro ao finalizar compra");
            return false;
        }
    }

    public void excluirCompra(Long idCompra, ArrayList<Itemcompra> itens) {
        try {
            GenericDAO<Compra> compraDAO = new GenericDAO<>();
            compraDAO.apagar(compraDAO.consultar("idCompra", idCompra, new Compra()));
            GenericDAO<Itemcompra> itemDAO = new GenericDAO<>();
            itens.stream().forEach((iten) -> {
                itemDAO.apagar(itemDAO.consultar("idItem", iten.getIdItemCompra(), new Itemcompra()));
            });
        } catch (Exception e) {

        }
    }

    public ArrayList<Itemcompra> buscarItens(Long idVenda) {
        GenericDAO<Itemcompra> itemDAO = new GenericDAO<>();
        List<Itemcompra> itens = itemDAO.consultar(new Itemcompra());
        ArrayList<Itemcompra> itensVenda = new ArrayList<>();
        itens.stream().filter((iten) -> (Objects.equals(iten.getCompra().getIdCompra(), idVenda))).forEach((iten) -> {
            itensVenda.add(iten);
        });
        return itensVenda;
    }

    public Boolean verificarEstoque(ArrayList<Itemcompra> itens) {
        Boolean retorno = true;
        for (Itemcompra iten : itens) {
            BigDecimal aux = new BigDecimal(iten.getProduto().getEstoqueProduto()).add(new BigDecimal(iten.getQuantidadeItemCompra()));
            if (aux.compareTo(new BigDecimal(iten.getProduto().getMaximoProduto())) > 0) {
                retorno = false;
            }
        }
        return retorno;
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
            if (c instanceof JPasswordField) {
                if (((JPasswordField) c).isEnabled()) {
                    if (((JPasswordField) c).getText().trim().equals("")) {
                        ((JPasswordField) c).setBorder(new LineBorder(Color.RED));
                        erro = false;
                    } else {
                        ((JPasswordField) c).setBorder(new LineBorder(Color.LIGHT_GRAY));
                    }
                } else {
                    ((JPasswordField) c).setBorder(new LineBorder(Color.LIGHT_GRAY));
                }
            }
        }
        return erro;
    }
    
    public Boolean alterarCompra(Long idCompra, Integer idFornecedor, String valor, Integer parcelas, String vencimento, ArrayList<Itemcompra> itens) {
        try {
            
            GenericDAO<Compra> compraDAO = new GenericDAO<>();
            Compra compraVO = new Compra();
            compraVO = compraDAO.consultar("idCompra", idCompra, new Compra());

            if (idFornecedor > 0) {
                compraVO.setFornecedor(buscarFornecedor(idFornecedor - 1));
            }
            compraVO.setValorCompra(new BigDecimal(valor));
            compraVO.setParcelasCompra(parcelas);
            try {
                compraVO.setVencimentoCompra(new SimpleDateFormat("yyyy/MM/dd").parse(vencimento));
            } catch (Exception e) {
                compraVO.setVencimentoCompra(new Date());
            }
            compraVO.setCriacaoCompra(new Date());
            compraVO.setAtualizacaoCompra(new Date());
            compraDAO.atualizar(compraVO);

            
            
            JOptionPane.showMessageDialog(null, "Compra Alterada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            log.info("Compra alterada com sucesso");
            
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CompraBO/alterarCompra/" + e, "Error", JOptionPane.ERROR_MESSAGE);
            log.error("Erro ao alterar compra");
            return false;
        }
    }
    public Boolean excluirCompra1(Long idCompra) {
        try {
            GenericDAO<Compra> compraDAo = new GenericDAO<>();

            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esta Compra?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
                try {
                    Compra compra = compraDAo.consultar("idCompra", idCompra, new Compra());
                    compraDAo.apagar(compra);
                    JOptionPane.showMessageDialog(null, "Compra excluida com sucesso.", "Secesso", JOptionPane.INFORMATION_MESSAGE);
                    log.info("Compra excluida com sucesso.");
                    return true;
                } catch (Exception e) {
                    log.error("Erro ao excluir compra");
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            log.error("Erro ao excluir compra");
            return false;
        }
    }
}

package projetointegrador.persistencia;

import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
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
import projetointegrador.negocio.Cliente;
import projetointegrador.negocio.Itemvenda;
import projetointegrador.negocio.Venda;
import projetointegrador.persistencia.GenericDAO;

/**
 *
 * @author Felipe
 */

public class VendaDAO {

    public Cliente buscarCliente(Integer idCliente) {
        GenericDAO<Cliente> clienteDAO = new GenericDAO<>();
        ArrayList<Cliente> clientesVO = new ArrayList<>(clienteDAO.consultar(new Cliente()));
        return clientesVO.get(idCliente);
    }

    public String[] buscarNomeClientes() {
        GenericDAO<Cliente> clienteDAO = new GenericDAO<>();
        ArrayList<Cliente> clientesVO = new ArrayList<>(clienteDAO.consultar(new Cliente()));
        ArrayList<String> array = new ArrayList<>();
        array.add("CLIENTE");
        clientesVO.stream().forEach((categoriasVO1) -> {
            array.add(categoriasVO1.getNomeCliente());
        });
        String[] Arr = new String[array.size()];
        Arr = array.toArray(Arr);
        return Arr;
    }

    public List<Venda> buscarVendas() {
        GenericDAO<Venda> vendaDAO = new GenericDAO<>();
        ArrayList<Venda> vendasVO = new ArrayList<>(vendaDAO.consultar(new Venda()));
        return vendasVO;
    }

    public Boolean excluirVenda(Long idVenda) {
        try {
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esta Venda?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
                try {
                    GenericDAO<Venda> vendaDAO = new GenericDAO<>();
                    Venda vendaVO = vendaDAO.consultar("idVenda", idVenda, new Venda());
                    ArrayList<Itemvenda> itens = buscarItens(idVenda);
                    GenericDAO<Itemvenda> itemDAO = new GenericDAO<>();
                    itens.stream().forEach((iten) -> {
                        itemDAO.apagar(iten);
                    });
                    vendaDAO.apagar(vendaVO);
                    JOptionPane.showMessageDialog(null, "Venda excluida com sucesso.", "Secesso", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public Boolean finalizarVenda(Integer idCliente, String valor, Integer parcelas, String vencimento, ArrayList<Itemvenda> itens) {
        try {
            GenericDAO<Venda> vendaDAO = new GenericDAO<>();
            Venda vendaVO = new Venda();

            if (idCliente > 0) {
                vendaVO.setCliente(buscarCliente(idCliente - 1));
            }
            vendaVO.setValorVenda(new BigDecimal(valor));
            vendaVO.setParcelasVenda(parcelas);
            try {
                vendaVO.setVencimentoVenda(new SimpleDateFormat("yyyy/MM/dd").parse(vencimento));
            } catch (Exception e) {
                vendaVO.setVencimentoVenda(new Date());
            }
            vendaVO.setCriacaoVenda(new Date());
            vendaVO.setAtualizacaoVenda(new Date());
            vendaDAO.inserir(vendaVO);

            GenericDAO<Itemvenda> itemDAO = new GenericDAO<>();
            itens.stream().forEach((iten) -> {
                iten.setVenda(vendaVO);
                itemDAO.inserir(iten);
            });
            JOptionPane.showMessageDialog(null, "Venda finalizada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void excluirVenda(Long idVenda, ArrayList<Itemvenda> itens) {
        try {
            GenericDAO<Venda> vendaDAO = new GenericDAO<>();
            vendaDAO.apagar(vendaDAO.consultar("idVenda", idVenda, new Venda()));
            GenericDAO<Itemvenda> itemDAO = new GenericDAO<>();
            itens.stream().forEach((iten) -> {
                itemDAO.apagar(itemDAO.consultar("idItem", iten.getIdItemVenda(), new Itemvenda()));
            });
        } catch (Exception e) {

        }
    }

    public ArrayList<Itemvenda> buscarItens(Long idVenda) {
        GenericDAO<Itemvenda> itemDAO = new GenericDAO<>();
        List<Itemvenda> itens = itemDAO.consultar(new Itemvenda());
        ArrayList<Itemvenda> itensVenda = new ArrayList<>();
        itens.stream().filter((iten) -> (Objects.equals(iten.getVenda().getIdVenda(), idVenda))).forEach((iten) -> {
            itensVenda.add(iten);
        });
        return itensVenda;
    }

    public Boolean alterarVenda(Long idVenda, Integer idCliente, String valor, Integer parcelas, String vencimento, ArrayList<Itemvenda> itens) {
        try {

            GenericDAO<Venda> vendaDAO = new GenericDAO<>();
            Venda vendaVO = new Venda();
            vendaVO = vendaDAO.consultar("idVenda", idVenda, new Venda());

            if (idCliente > 0) {
                vendaVO.setCliente(buscarCliente(idCliente - 1));
            }
            vendaVO.setValorVenda(new BigDecimal(valor));
            vendaVO.setParcelasVenda(parcelas);
            try {
                vendaVO.setVencimentoVenda(new SimpleDateFormat("yyyy/MM/dd").parse(vencimento));
            } catch (Exception e) {
                vendaVO.setVencimentoVenda(new Date());
            }
            vendaVO.setCriacaoVenda(new Date());
            vendaVO.setAtualizacaoVenda(new Date());
            vendaDAO.atualizar(vendaVO);

            JOptionPane.showMessageDialog(null, "Venda Alterada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CompraBO/alterarVenda/" + e, "Error", JOptionPane.ERROR_MESSAGE);
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
}

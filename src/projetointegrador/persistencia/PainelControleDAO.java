package projetointegrador.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import projetointegrador.apresentacao.TelaLogin;
import projetointegrador.negocio.Categoria;
import projetointegrador.negocio.Cliente;
import projetointegrador.negocio.Contato;
import projetointegrador.negocio.Endereco;
import projetointegrador.negocio.Fornecedor;
import projetointegrador.negocio.Produto;
import projetointegrador.persistencia.GenericDAO;

/**
 *
 * @author Felipe
 */

public class PainelControleDAO {

    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TelaLogin.class.getName());
    
    public List<Cliente> buscarClientes() {
        GenericDAO<Cliente> clienteDAO = new GenericDAO();
        ArrayList<Cliente> clientesVO = new ArrayList<>(clienteDAO.consultar(new Cliente()));
        return clientesVO;
    }

    public List<Fornecedor> buscarFornecedores() {
        GenericDAO<Fornecedor> fornecedorDAO = new GenericDAO<>();
        ArrayList<Fornecedor> fornecedoresVO = new ArrayList<>(fornecedorDAO.consultar(new Fornecedor()));
        return fornecedoresVO;
    }

    public List<Categoria> buscarCategorias() {
        GenericDAO<Categoria> categoriaDAO = new GenericDAO<>();
        ArrayList<Categoria> categoriasVO = new ArrayList<>(categoriaDAO.consultar(new Categoria()));
        return categoriasVO;
    }

    public List<Produto> buscarProdutos() {
        GenericDAO<Produto> produtoDAO = new GenericDAO<>();
        ArrayList<Produto> produtosVO = new ArrayList<>(produtoDAO.consultar(new Produto()));
        return produtosVO;
    }

    public Boolean excluirCliente(Long idCliente) {
        try {
            GenericDAO<Cliente> clienteDAO = new GenericDAO<>();
            GenericDAO<Contato> contatoDAO = new GenericDAO<>();
            GenericDAO<Endereco> enderecoDAO = new GenericDAO<>();

            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este Cliente?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
                try {
                    Cliente clienteVO = clienteDAO.consultar("idCliente", idCliente, new Cliente());
                    Contato contatoVO = contatoDAO.consultar("idContato", clienteVO.getContato().getIdContato(), new Contato());
                    Endereco enderecoVO = enderecoDAO.consultar("idEndereco", clienteVO.getEndereco().getIdEndereco(), new Endereco());
                    clienteDAO.apagar(clienteVO);
                    contatoDAO.apagar(contatoVO);
                    enderecoDAO.apagar(enderecoVO);
                    JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso.", "Secesso", JOptionPane.INFORMATION_MESSAGE);
                    log.info("Cliente excluido com sucesso");
                    return true;
                } catch (Exception e) {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            log.error("Erro ao excluir cliente");
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public Boolean excluirFornecedor(Long idFornecedor) {
        try {
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este Fornecedor?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
                try {
                    GenericDAO<Fornecedor> fornecedorDAO = new GenericDAO<>();

                    GenericDAO<Contato> contatoDAO = new GenericDAO<>();
                    GenericDAO<Endereco> enderecoDAO = new GenericDAO<>();
                    Fornecedor fornecedorVO = fornecedorDAO.consultar("idFornecedor", idFornecedor, new Fornecedor());
                    Contato contatoVO = contatoDAO.consultar("idContato", fornecedorVO.getContato().getIdContato(), new Contato());
                    Endereco enderecoVO = enderecoDAO.consultar("idEndereco", fornecedorVO.getEndereco().getIdEndereco(), new Endereco());
                    fornecedorDAO.apagar(fornecedorVO);
                    contatoDAO.apagar(contatoVO);
                    enderecoDAO.apagar(enderecoVO);
                    log.info("Fornecedor excluido com sucesso");
                    JOptionPane.showMessageDialog(null, "Fornecedor excluido com sucesso.", "Secesso", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            log.error("Erro ao excluir fornecedor");
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public Boolean excluirCategoria(Long idCategoria) {
        try {
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esta Categoria?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
                try {
                    GenericDAO<Categoria> categoriaDAO = new GenericDAO<>();
                    Categoria categoriaVO = categoriaDAO.consultar("idCategoria", idCategoria, new Categoria());
                    categoriaDAO.apagar(categoriaVO);
                    JOptionPane.showMessageDialog(null, "Categoria excluida com sucesso.", "Secesso", JOptionPane.INFORMATION_MESSAGE);
                    log.info("Categoria excluida com sucesso");
                    return true;
                } catch (Exception e) {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            log.error("Erro ao excluir categoria");
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public Boolean excluirProduto(Long idProduto) {
        try {
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este Produto?", "Alerta", JOptionPane.YES_NO_OPTION) == 0) {
                try {
                    GenericDAO<Produto> produtoDAO = new GenericDAO<>();
                    Produto produtoVO = produtoDAO.consultar("idProduto", idProduto, new Produto());
                    produtoDAO.apagar(produtoVO);
                    log.info("Produto excluido com sucesso");
                    JOptionPane.showMessageDialog(null, "Produto excluido com sucesso.", "Secesso", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            log.error("Erro ao excluir produto");
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}

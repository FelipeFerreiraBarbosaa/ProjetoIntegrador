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
import projetointegrador.apresentacao.TelaLogin;
import projetointegrador.negocio.Cliente;
import projetointegrador.negocio.Contato;
import projetointegrador.negocio.Endereco;
import projetointegrador.persistencia.GenericDAO;

/**
 *
 * @author Felipe
 */
public class ClienteDAO {

    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TelaLogin.class.getName());
    
    public Boolean inserirCliente(String cliente, String nome, String email, String telefone, String celular,String endereco, String cep, String complemento, String numero, String bairro, String cidade, String estado, String cpf) {
        try {
            GenericDAO<Cliente> clienteDAO = new GenericDAO<>();
            Cliente clienteVO = new Cliente();
            clienteVO.setNomeCliente(cliente);
            clienteVO.setCpfCliente(cpf);
           

            clienteVO.setCriacaoCliente(new Date());
            clienteVO.setAtualizacaoCliente(new Date());

            

            GenericDAO<Contato> contatoDAO = new GenericDAO<>();
            Contato contatoVO = new Contato();
            contatoVO.setNomeContato(nome);
            contatoVO.setEmailContato(email);
            contatoVO.setTelefoneContato(telefone);
            contatoVO.setCelularContato(celular);
            contatoVO.setCriacaoContato(new Date());
            contatoVO.setAtualizacaoContato(new Date());
            if (contatoDAO.atualizar(contatoVO)) {
                clienteVO.setContato(contatoDAO.consultar("idContato", contatoVO.getIdContato(), contatoVO));
            }

            GenericDAO<Endereco> enderecoDAO = new GenericDAO<>();
            Endereco enderecoVO = new Endereco();
            enderecoVO.setEnderecoEndereco(endereco);
            enderecoVO.setCepEndereco(cep);
            enderecoVO.setComplementoEndereco(complemento);
            enderecoVO.setNumeroEndereco(numero);
            enderecoVO.setCidadeEndereco(cidade);
            enderecoVO.setBairroEndereco(bairro);
            enderecoVO.setEstadoEndereco(estado);
            enderecoVO.setCriacaoEndereco(new Date());
            enderecoVO.setAtualizacaoEndereco(new Date());
            if (enderecoDAO.atualizar(enderecoVO)) {
                clienteVO.setEndereco(enderecoDAO.consultar("idEndereco", enderecoVO.getIdEndereco(), enderecoVO));
            }

            if (clienteDAO.inserir(clienteVO)) {
                JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                log.info("Cliente inserido com sucesso");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            log.error("Erro ao inserir o cliente");
            return false;
        }
    }

    
    public Boolean alterarCliente(Long idCliente, String cliente, String nome, String email, String telefone, String celular,  String endereco, String cep, String complemento, String numero, String bairro, String cidade, String estado, String cpf) {
        try {
            GenericDAO<Cliente> clienteDAO = new GenericDAO<>();
            Cliente clienteVO = clienteDAO.consultar("idCliente", idCliente, new Cliente());
            clienteVO.setNomeCliente(cliente);
            clienteVO.setCpfCliente(cpf);
            clienteVO.setAtualizacaoCliente(new Date());
            GenericDAO<Contato> contatoDAO = new GenericDAO<>();
            Contato contatoVO = contatoDAO.consultar("idContato", clienteVO.getContato().getIdContato(), new Contato());
            contatoVO.setNomeContato(nome);
            contatoVO.setEmailContato(email);
            contatoVO.setTelefoneContato(telefone);
            contatoVO.setCelularContato(celular);
            contatoVO.setAtualizacaoContato(new Date());
            if (contatoDAO.atualizar(contatoVO)) {
                clienteVO.setContato(contatoVO);
            }

            GenericDAO<Endereco> enderecoDAO = new GenericDAO<>();
            Endereco enderecoVO = enderecoDAO.consultar("idEndereco", clienteVO.getEndereco().getIdEndereco(), new Endereco());
            enderecoVO.setEnderecoEndereco(endereco);
            enderecoVO.setCepEndereco(cep);
            enderecoVO.setComplementoEndereco(complemento);
            enderecoVO.setNumeroEndereco(numero);
            enderecoVO.setCidadeEndereco(cidade);
            enderecoVO.setBairroEndereco(bairro);
            enderecoVO.setEstadoEndereco(estado);
            enderecoVO.setAtualizacaoEndereco(new Date());
            if (enderecoDAO.atualizar(enderecoVO)) {
                clienteVO.setEndereco(enderecoVO);
            }

            if (clienteDAO.atualizar(clienteVO)) {
                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                log.info("Cliente alterado com sucesso");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            log.error("Erro ao inserir cliente");
            return false;
        }
    }


    public Cliente buscarCliente(Integer idCliente) {
        GenericDAO<Cliente> clienteDAO = new GenericDAO<>();
        ArrayList<Cliente> clientesVO = new ArrayList<>(clienteDAO.consultar(new Cliente()));
        return clientesVO.get(idCliente);
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

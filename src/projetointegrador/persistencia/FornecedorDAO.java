package projetointegrador.persistencia;


import java.awt.Color;
import java.awt.Component;
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
import projetointegrador.negocio.Contato;
import projetointegrador.negocio.Endereco;
import projetointegrador.negocio.Fornecedor;
import projetointegrador.persistencia.GenericDAO;

/**
 *
 * @author Felipe
 */
public class FornecedorDAO {

    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TelaLogin.class.getName());
    
    public Boolean inserirFornecedor(String fornecedor, String nome, String email, String telefone, String celular, String endereco, String cep, String complemento, String numero, String bairro, String cidade, String estado, String cnpj) {
        try {
            GenericDAO<Fornecedor> fornecedorDAO = new GenericDAO<>();
            Fornecedor fornecedorVO = new Fornecedor();
            fornecedorVO.setNomeFornecedor(fornecedor);
            fornecedorVO.setCnpjFornecedor(cnpj);
            fornecedorVO.setCriacaoFornecedor(new Date());
            fornecedorVO.setAtualizacaoFornecedor(new Date());

           

            GenericDAO<Contato> contatoDAO = new GenericDAO<>();
            Contato contatoVO = new Contato();
            contatoVO.setNomeContato(nome);
            contatoVO.setEmailContato(email);
            contatoVO.setTelefoneContato(telefone);
            contatoVO.setCelularContato(celular);
            contatoVO.setCriacaoContato(new Date());
            contatoVO.setAtualizacaoContato(new Date());
            if (contatoDAO.inserir(contatoVO)) {
                fornecedorVO.setContato(contatoDAO.consultar("idContato", contatoVO.getIdContato(), contatoVO));
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
            if (enderecoDAO.inserir(enderecoVO)) {
                fornecedorVO.setEndereco(enderecoDAO.consultar("idEndereco", enderecoVO.getIdEndereco(), enderecoVO));
            }

            if (fornecedorDAO.inserir(fornecedorVO)) {
                JOptionPane.showMessageDialog(null, "Fornecedor inserido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                log.info("Fornecedor inserido com sucesso");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            log.error("Erro ao inserir o fornecedor");
            return false;
        }
    }

   
    public Boolean alterarFornecedor(Long idFornecedor, String fornecedor, String nome, String email, String telefone, String celular, String endereco, String cep, String complemento, String numero, String bairro, String cidade, String estado, String cnpj) {
        try {
            GenericDAO<Fornecedor> fornecedorDAO = new GenericDAO<>();
            Fornecedor fornecedorVO = fornecedorDAO.consultar("idFornecedor", idFornecedor, new Fornecedor());
            fornecedorVO.setNomeFornecedor(fornecedor);
            fornecedorVO.setCnpjFornecedor(cnpj);
            fornecedorVO.setAtualizacaoFornecedor(new Date());

            

            GenericDAO<Contato> contatoDAO = new GenericDAO<>();
            Contato contatoVO = contatoDAO.consultar("idContato", fornecedorVO.getContato().getIdContato(), new Contato());
            contatoVO.setNomeContato(nome);
            contatoVO.setEmailContato(email);
            contatoVO.setTelefoneContato(telefone);
            contatoVO.setCelularContato(celular);
            contatoVO.setAtualizacaoContato(new Date());
            if (contatoDAO.atualizar(contatoVO)) {
                fornecedorVO.setContato(contatoVO);
            }

            GenericDAO<Endereco> enderecoDAO = new GenericDAO<>();
            Endereco enderecoVO = enderecoDAO.consultar("idEndereco", fornecedorVO.getEndereco().getIdEndereco(), new Endereco());
            enderecoVO.setEnderecoEndereco(endereco);
            enderecoVO.setCepEndereco(cep);
            enderecoVO.setComplementoEndereco(complemento);
            enderecoVO.setNumeroEndereco(numero);
            enderecoVO.setCidadeEndereco(cidade);
            enderecoVO.setBairroEndereco(bairro);
            enderecoVO.setEstadoEndereco(estado);
            enderecoVO.setAtualizacaoEndereco(new Date());
            if (enderecoDAO.atualizar(enderecoVO)) {
                fornecedorVO.setEndereco(enderecoVO);
            }

            if (fornecedorDAO.atualizar(fornecedorVO)) {
                JOptionPane.showMessageDialog(null, "Fornecedor alterado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                log.info("Fornecedor alterado com sucesso");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
             log.error("Erro ao alterar o fornecedor");
            return false;
        }
    }

         public Fornecedor buscarFornecedor(Integer idFornecedor) {
        GenericDAO<Fornecedor> fornecedorDao = new GenericDAO<>();
        ArrayList<Fornecedor> fornecedoresVo = new ArrayList<>(fornecedorDao.consultar(new Fornecedor()));
        return fornecedoresVo.get(idFornecedor);
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

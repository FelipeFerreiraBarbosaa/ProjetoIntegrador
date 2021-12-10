package projetointegrador.persistencia;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import projetointegrador.apresentacao.TelaLogin;
import projetointegrador.negocio.Categoria;
import projetointegrador.persistencia.GenericDAO;

/**
 *
 * @author Felipe
 */

public class CategoriaDAO {
    
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TelaLogin.class.getName());

    public Boolean inserirCategoria(String descricao) {
        try {
            GenericDAO<Categoria> categoriaDAO = new GenericDAO();
            Categoria categoriaVO = new Categoria();
            categoriaVO.setDescricaoCategoria(descricao);
            categoriaVO.setCriacaoCategoria(new Date());
            categoriaVO.setAtualizacaoCategoria(new Date());
            if (categoriaDAO.inserir(categoriaVO)) {
                JOptionPane.showMessageDialog(null, "Categoria inserida com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                log.info("Categoria inserida com sucesso.");
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            log.error("Erro ao inserir categoria");
            return false;
        }
    }

    public Boolean alterarCategoria(Long idCategoria, String descricao) {
        try {
            GenericDAO<Categoria> categoriaDAO = new GenericDAO();
            Categoria categoriaVO = categoriaDAO.consultar("idCategoria", idCategoria, new Categoria());
            categoriaVO.setDescricaoCategoria(descricao);
            categoriaVO.setAtualizacaoCategoria(new Date());
            if (categoriaDAO.atualizar(categoriaVO)) {
                JOptionPane.showMessageDialog(null, "Categoria alterada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                log.info("Categoria alterada com sucesso.");
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            log.error("Erro ao alterar categoria");
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

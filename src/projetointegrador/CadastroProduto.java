package projetointegrador;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import projetointegrador.HibernateUtil;
import projetointegrador.Produto;

/**
 *
 * @author Felipe Ferreira
 */
public class CadastroProduto extends javax.swing.JInternalFrame {

    private Produto produto;
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private boolean novo;

    public CadastroProduto() throws DataBaseException {
        initComponents();
        carregarGrade();
        novo = false;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfNome = new javax.swing.JFormattedTextField();
        tfPreçoCompra = new javax.swing.JFormattedTextField();
        tfPreçoVenda = new javax.swing.JFormattedTextField();
        tfDescricao = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        sQTDE = new javax.swing.JSpinner();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Grade = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Produto");
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Formulário")));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Preço de Compra:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Preço de Venda:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Quantidade:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Descrição:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfPreçoVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(tfPreçoCompra)
                    .addComponent(sQTDE, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(tfDescricao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfPreçoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfPreçoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sQTDE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/novo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setContentAreaFilled(false);
        btnNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNovo.setDefaultCapable(false);
        btnNovo.setFocusable(false);
        btnNovo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovo.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btnNovo.setMaximumSize(new java.awt.Dimension(45, 43));
        btnNovo.setMinimumSize(new java.awt.Dimension(45, 43));
        btnNovo.setPreferredSize(new java.awt.Dimension(45, 43));
        btnNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setContentAreaFilled(false);
        btnSalvar.setDefaultCapable(false);
        btnSalvar.setFocusable(false);
        btnSalvar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvar.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btnSalvar.setMaximumSize(new java.awt.Dimension(51, 43));
        btnSalvar.setMinimumSize(new java.awt.Dimension(51, 43));
        btnSalvar.setPreferredSize(new java.awt.Dimension(51, 43));
        btnSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setContentAreaFilled(false);
        btnExcluir.setDefaultCapable(false);
        btnExcluir.setFocusable(false);
        btnExcluir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btnExcluir.setMaximumSize(new java.awt.Dimension(51, 43));
        btnExcluir.setMinimumSize(new java.awt.Dimension(51, 43));
        btnExcluir.setPreferredSize(new java.awt.Dimension(51, 43));
        btnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setDefaultCapable(false);
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btnCancelar.setMaximumSize(new java.awt.Dimension(63, 43));
        btnCancelar.setMinimumSize(new java.awt.Dimension(63, 43));
        btnCancelar.setPreferredSize(new java.awt.Dimension(63, 43));
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        Grade.setAutoCreateRowSorter(true);
        Grade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Grade.setModel(new ProdutoTableModel());
        Grade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GradeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Grade);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        produto = new Produto();
        habilitarFormulario(true);
        btnExcluir.setEnabled(false);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Session sessao = null;
        if (validarFormulario()) {
            produto.setName(tfNome.getText().trim());
            produto.setpCusto((Double) tfPreçoCompra.getValue());
            produto.setpVenda((Double) tfPreçoVenda.getValue());
            produto.setQuantidade((int) sQTDE.getValue());
            produto.setDescricao(tfDescricao.getText());

            if (produto.getId() == 0) {
                try {

                    sessao = HibernateUtil.getSessionFactory().openSession();
                    Transaction transacao = sessao.beginTransaction();
                    //Produto p = new Produto();
                    //p.setId(null);
                    //p.setName(tfNome.getText());
                    //p.setpCusto((Double) tfPreçoCompra.getValue());
                    //p.setpVenda((Double) tfPreçoVenda.getValue());
                    //p.setQuantidade((int) sQTDE.getValue());
                    //p.setDescricao(tfDescricao.getText());
                    sessao.save(produto);
                    transacao.commit();
                    JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
                    sessao.close();

                } catch (HibernateException hibEx) {
                    hibEx.printStackTrace();
                }
            } else {
                try {
                    produtoDAO.edit(produto);
                    atualizarTabela();
                    sessao.close();
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao alterar o produto.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
               
            }
           atualizarTabela();
        }
                
                
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        /*List resultado = null;
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            int id;
            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Código do produto a ser EXCLUÍDO:", "Excluir", JOptionPane.PLAIN_MESSAGE));
            org.hibernate.Query query = sessao.createQuery("FROM produto WHERE id = " + id);
            resultado = query.list();
            for (Object obj : resultado) {
                Produto p = (Produto) obj;
                sessao.delete(p);
                transacao.commit();
                JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!");
            }
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        }*/
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o produto " + produto.getName() + "?");
        if (opcao == 0) {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            dao.delete(produto);
            
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }

        atualizarTabela();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        habilitarFormulario(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void GradeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GradeMouseClicked
        if (evt.getClickCount() == 2) {
            ProdutoTableModel tm = (ProdutoTableModel) Grade.getModel();
            produto = tm.getRowValue(Grade.getRowSorter().convertRowIndexToModel(Grade.getSelectedRow()));

            tfNome.setValue(produto.getName());
            tfPreçoCompra.setValue(produto.getpCusto());
            tfPreçoVenda.setValue(produto.getpVenda());
            sQTDE.setValue(produto.getQuantidade());
            tfDescricao.setValue(produto.getDescricao());

            habilitarFormulario(true);
        }
    }//GEN-LAST:event_GradeMouseClicked
    public void habilitarFormulario(boolean ativo) {
        btnNovo.setEnabled(!ativo);
        btnSalvar.setEnabled(ativo);
        btnExcluir.setEnabled(ativo);
        btnCancelar.setEnabled(ativo);
        tfNome.setEnabled(ativo);
        tfPreçoCompra.setEnabled(ativo);
        tfPreçoVenda.setEnabled(ativo);
        tfDescricao.setEnabled(ativo);
        sQTDE.setEnabled(ativo);
        Grade.setEnabled(!ativo);

        if (!ativo) {
            limpaFormulario();
        }
    }

    private void limpaFormulario() {
        produto = null;
        tfNome.setValue("");
        tfPreçoCompra.setValue(new Double(0));
        tfPreçoVenda.setValue(new Double(0));
        sQTDE.setValue(0);
        tfDescricao.setValue("");

    }

    private boolean validarFormulario() {
        if (tfNome.getText().trim().length() < 2) {
            JOptionPane.showMessageDialog(this, "Nome inválido.", "Alerta", JOptionPane.WARNING_MESSAGE);
            tfNome.requestFocus();
            return false;
        }
        if (tfDescricao.getText().trim().length() < 2) {
            JOptionPane.showMessageDialog(this, "Descrição inválida.", "Alerta", JOptionPane.WARNING_MESSAGE);
            tfNome.requestFocus();
            return false;
        }
        if (((Double) tfPreçoCompra.getValue()) <= 0) {
            JOptionPane.showMessageDialog(this, "Preço de compra inválido.", "Alerta", JOptionPane.WARNING_MESSAGE);
            tfPreçoCompra.requestFocus();
            return false;
        }
        if (((Double) tfPreçoVenda.getValue()) <= 0) {
            JOptionPane.showMessageDialog(this, "Preço de venda inválido.", "Alerta", JOptionPane.WARNING_MESSAGE);
            tfPreçoVenda.requestFocus();
            return false;
        }
        if (((Double) tfPreçoVenda.getValue()) <= ((Double) tfPreçoCompra.getValue())) {
            JOptionPane.showMessageDialog(this, "Preço de venda menor que preço de compra.", "Alerta", JOptionPane.WARNING_MESSAGE);
            tfPreçoVenda.requestFocus();
            return false;
        }
        if ((int) sQTDE.getValue() <= 0) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida.", "Alerta", JOptionPane.WARNING_MESSAGE);
            tfPreçoVenda.requestFocus();
            return false;
        } else {
        }
        return true;
    }

    public void carregarGrade() throws DataBaseException {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        ProdutoTableModel tm = (ProdutoTableModel) Grade.getModel();
        try {
            tm.setDados(produtoDAO.readAll());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar grade.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizarTabela() {
        ArrayList<Produto> produtos = new ArrayList();
        try {
            ProdutoDAO dao = DaoFactory.newProdutoDAO();
            produtos = dao.readAll();
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }

        ProdutoTableModel tableModel = (ProdutoTableModel) Grade.getModel();

        tableModel.setDados(produtos);
        Grade.revalidate();
        Grade.repaint();
    }
   

    
    
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Grade;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner sQTDE;
    private javax.swing.JFormattedTextField tfDescricao;
    private javax.swing.JFormattedTextField tfNome;
    private javax.swing.JFormattedTextField tfPreçoCompra;
    private javax.swing.JFormattedTextField tfPreçoVenda;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetointegrador.apresentacao;

import java.awt.Cursor;
import java.math.BigDecimal;
import java.util.ArrayList;
import projetointegrador.persistencia.ItemVendaDAO;
import projetointegrador.negocio.Itemvenda;

/**
 *
 * @author Felipe
 */
public class TelaItemVenda extends javax.swing.JDialog {

    private final TelaVenda viewVenda;

    //Declaração de variáveis(Value Object).
    private Itemvenda itemVO;
    private final ArrayList<Itemvenda> itens;
    private BigDecimal valor;

    //Declaração de variáveis(Business Object).
    private final ItemVendaDAO itemBO;
    
    
    public TelaItemVenda(TelaVenda viewVenda, ArrayList<Itemvenda> itens) {
        this.viewVenda = viewVenda;
        this.itemBO = new ItemVendaDAO();
        this.itens = itens;
        this.itemVO = new Itemvenda();
        initComponents();
        btnAlterar.setVisible(false);
    }
    
    public TelaItemVenda(TelaVenda viewVenda, Itemvenda item, Boolean alterar) {
        //Inicialização dos componentes padrões do JDialog.
        this.viewVenda = viewVenda;
        this.itemBO = new ItemVendaDAO();
        this.itemVO = item;
        this.itens = null;
        initComponents();
        btnCadastrar.setVisible(false);
        btnAlterar.setVisible(false);

        //Definindo Modelo com Produto para os JComboBox.
        ArrayList<String> array = new ArrayList<>();
        String[] Arr = new String[array.size()];
        if (item.getProduto() != null) {
            array.add(item.getProduto().getDescricaoProduto());
        } else {
            array.add("PRODUTO");
        }
        Arr = array.toArray(Arr);
        cbProduto.setModel(new javax.swing.DefaultComboBoxModel(Arr));
        cbProduto.setEnabled(false);

        //Definindo valores quantidade e valor
        tfQuantidade.setText(item.getQuantidadeItemVenda().toString());
        tfValor.setText(item.getValorItemVenda().toString());
        tfBuscarProduto.setText(item.getProduto().getCodigoProduto());
        tfBuscarProduto.setEditable(false);
        btnBuscarProduto.setEnabled(false);
        if (alterar) {
            btnAlterar.setVisible(true);
            tfQuantidade.setEnabled(true);
            valor = new BigDecimal(tfValor.getText()).divide(new BigDecimal(tfQuantidade.getText()));
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCorpo = new javax.swing.JPanel();
        pnItem = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfQuantidade = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        tfValor = new javax.swing.JFormattedTextField();
        tfBuscarProduto = new javax.swing.JTextField();
        btnBuscarProduto = new javax.swing.JButton();
        cbProduto = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();

        pnCorpo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Quantidade");

        tfQuantidade.setForeground(new java.awt.Color(102, 102, 102));
        tfQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("########.##"))));
        tfQuantidade.setEnabled(false);
        tfQuantidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfQuantidadeKeyReleased(evt);
            }
        });

        jLabel3.setText("Valor do Item");

        tfValor.setEditable(false);
        tfValor.setForeground(new java.awt.Color(102, 102, 102));
        tfValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("########.##"))));
        tfValor.setText("0,0");
        tfValor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        tfBuscarProduto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfBuscarProduto.setForeground(new java.awt.Color(102, 102, 102));
        tfBuscarProduto.setText("Código");
        tfBuscarProduto.setPreferredSize(new java.awt.Dimension(59, 19));

        btnBuscarProduto.setText("Buscar");
        btnBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProdutoActionPerformed(evt);
            }
        });

        cbProduto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbProduto.setForeground(new java.awt.Color(102, 102, 102));
        cbProduto.setModel(new javax.swing.DefaultComboBoxModel(itemBO.buscarNomeProdutos()));
        cbProduto.setFocusable(false);
        cbProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnItemLayout = new javax.swing.GroupLayout(pnItem);
        pnItem.setLayout(pnItemLayout);
        pnItemLayout.setHorizontalGroup(
            pnItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnItemLayout.createSequentialGroup()
                        .addGroup(pnItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnItemLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfBuscarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(14, 14, 14)
                        .addComponent(btnBuscarProduto))
                    .addComponent(cbProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnItemLayout.setVerticalGroup(
            pnItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnItemLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProduto))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel1.setText("Produto");

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/finalizar.png"))); // NOI18N
        btnCadastrar.setText("Inserir");
        btnCadastrar.setContentAreaFilled(false);
        btnCadastrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCadastrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadastrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/salvar.png"))); // NOI18N
        btnAlterar.setText("Editar");
        btnAlterar.setContentAreaFilled(false);
        btnAlterar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCorpoLayout = new javax.swing.GroupLayout(pnCorpo);
        pnCorpo.setLayout(pnCorpoLayout);
        pnCorpoLayout.setHorizontalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(pnCorpoLayout.createSequentialGroup()
                                .addComponent(btnCadastrar)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnCorpoLayout.setVerticalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCorpoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCadastrar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnCorpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnCorpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantidadeKeyReleased
        try {
            if (tfValor.getText().length() > 0 && cbProduto.getSelectedIndex() > 0) {
                tfValor.setText(new BigDecimal(tfQuantidade.getText()).multiply(itemBO.buscarProduto(cbProduto.getSelectedIndex() - 1).getVendaProduto()).toString());
            } else {
                tfValor.setText("0,0");
            }
        } catch (Exception e) {

        }
        if (!cbProduto.isEnabled()) {
            try {
                if (tfValor.getText().length() > 0) {
                    tfValor.setText(new BigDecimal(tfQuantidade.getText()).multiply(valor).toString());
                } else {
                    tfValor.setText("0,0");
                }
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_tfQuantidadeKeyReleased

    private void cbProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProdutoActionPerformed
        if (cbProduto.getSelectedIndex() != 0) {
            tfQuantidade.setEnabled(true);
        } else {
            tfQuantidade.setEnabled(false);
        }
        tfQuantidade.setText("");
        tfValor.setText("0,0");
    }//GEN-LAST:event_cbProdutoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        btnCadastrar.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (itemBO.validarCampos(pnItem)) {
            if (itemBO.alterarItem(itemVO, tfQuantidade.getText(), tfValor.getText())) {
                viewVenda.atualizarPagina();
                this.dispose();
            }
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnCadastrar.setEnabled(true);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        btnCadastrar.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (itemBO.validarCampos(pnItem) && cbProduto.getSelectedIndex() > 0) {
            itemVO = itemBO.inserirItem(null, itemBO.buscarProduto(cbProduto.getSelectedIndex() - 1), tfQuantidade.getText(), tfValor.getText());
            if (itemVO != null) {
                itens.add(itemVO);
                viewVenda.atualizarPagina();
                this.dispose();
            }
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnCadastrar.setEnabled(true);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProdutoActionPerformed
       
    }//GEN-LAST:event_btnBuscarProdutoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscarProduto;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox cbProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel pnCorpo;
    private javax.swing.JPanel pnItem;
    private javax.swing.JTextField tfBuscarProduto;
    private javax.swing.JFormattedTextField tfQuantidade;
    private javax.swing.JFormattedTextField tfValor;
    // End of variables declaration//GEN-END:variables
}


package projetointegrador.apresentacao;

import java.awt.Cursor;
import java.util.ArrayList;
import projetointegrador.negocio.Produto;
import projetointegrador.persistencia.ProdutoDAO;

/**
 *
 * @author Felipe
 */
public class CadastroProduto extends javax.swing.JDialog {

    private final TelaDeControle controle;
    private Produto produto;
    private ProdutoDAO produtoBO;

    
    
    
    public CadastroProduto(TelaDeControle viewPainelControle) {
        this.produtoBO = new ProdutoDAO();
        initComponents();
        this.controle = viewPainelControle;
        btnEditarProduto.setVisible(false);
        
    }
  
    
     public CadastroProduto( TelaDeControle viewPainelControle, Produto produto, Boolean alterar) {
        this.produtoBO = new ProdutoDAO();
        initComponents();
        this.controle = viewPainelControle;
        this.produto = produto;
        btnCadastrarProduto.setVisible(false);
        lbTitulo.setText("Alterar Produto");

        tfDescricao.setText(produto.getDescricaoProduto());
        tfCodigo.setText(produto.getCodigoProduto());
        tfValorCusto.setText(produto.getCustoProduto().toString());
        tfValorVenda.setText(produto.getVendaProduto().toString());
        tfMinimo.setText(produto.getMinimoProduto().toString());
        tfMaximo.setText(produto.getMaximoProduto().toString());
        tfEstoque.setText(produto.getEstoqueProduto().toString());

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel(produtoBO.buscarNomeCategorias()));
        cbFornecedor.setModel(new javax.swing.DefaultComboBoxModel(produtoBO.buscarNomeFornecedores()));

        //Definindo como não editável.
        if (!alterar) {
            btnEditarProduto.setVisible(false);
            lbTitulo.setText("Produto");
            tfDescricao.setEditable(false);
            tfCodigo.setEditable(false);
            tfValorCusto.setEditable(false);
            tfValorVenda.setEditable(false);
            tfMinimo.setEditable(false);
            tfMaximo.setEditable(false);
            tfEstoque.setEditable(false);
            cbCategoria.setEnabled(false);
            cbFornecedor.setEnabled(false);

            //Carregar os combo box
            ArrayList<String> array = new ArrayList<>();
            String[] Arr = new String[array.size()];
            if (produto.getCategoria() != null) {
                array.add(produto.getCategoria().getDescricaoCategoria());
            } else {
                array.add("CATEGORIA");
            }
            Arr = array.toArray(Arr);
            cbCategoria.setModel(new javax.swing.DefaultComboBoxModel(Arr));
            array.clear();
            if (produto.getFornecedor() != null) {
                array.add(produto.getFornecedor().getNomeFornecedor());
            } else {
                array.add("FORNECEDOR");
            }
            Arr = array.toArray(Arr);
            cbFornecedor.setModel(new javax.swing.DefaultComboBoxModel(Arr));
        }
    }

  


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        pnObrigatorio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JFormattedTextField();
        pnProduto = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        tfValorCusto = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        tfValorVenda = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        tfMaximo = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        tfMinimo = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        tfEstoque = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbFornecedor = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnCadastrarProduto = new javax.swing.JButton();
        btnEditarProduto = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(531, 531));

        lbTitulo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbTitulo.setText("Novo Produto");

        pnObrigatorio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Descrição");

        javax.swing.GroupLayout pnObrigatorioLayout = new javax.swing.GroupLayout(pnObrigatorio);
        pnObrigatorio.setLayout(pnObrigatorioLayout);
        pnObrigatorioLayout.setHorizontalGroup(
            pnObrigatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnObrigatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnObrigatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnObrigatorioLayout.setVerticalGroup(
            pnObrigatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnObrigatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pnProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Produto");

        jLabel3.setText("Código do Produto");

        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("(opcional)");

        jLabel5.setText("Valor de Custo");

        jLabel6.setText("Valor de Venda");

        tfValorVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfValorVendaActionPerformed(evt);
            }
        });

        jLabel7.setText("Quantidade Maxima (Estoque)");

        jLabel8.setText("Quantidade Minima (Estoque)");

        jLabel9.setText("Estoque Inicial");

        jLabel10.setText("Categoria");

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel(produtoBO.buscarNomeCategorias()));
        cbCategoria.setFocusable(false);

        jLabel11.setText("Fornecedor");

        cbFornecedor.setModel(new javax.swing.DefaultComboBoxModel(produtoBO.buscarNomeFornecedores()));
        cbFornecedor.setFocusable(false);

        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("(opcional)");

        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("(opcional)");

        javax.swing.GroupLayout pnProdutoLayout = new javax.swing.GroupLayout(pnProduto);
        pnProduto.setLayout(pnProdutoLayout);
        pnProdutoLayout.setHorizontalGroup(
            pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnProdutoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnProdutoLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12))
                            .addComponent(cbCategoria, 0, 444, Short.MAX_VALUE)
                            .addComponent(cbFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnProdutoLayout.createSequentialGroup()
                        .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnProdutoLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4))
                            .addGroup(pnProdutoLayout.createSequentialGroup()
                                .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnProdutoLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13))
                                    .addComponent(jLabel3)
                                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(tfMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnProdutoLayout.createSequentialGroup()
                                        .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(tfMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9)))
                                    .addGroup(pnProdutoLayout.createSequentialGroup()
                                        .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))))))
                        .addContainerGap(21, Short.MAX_VALUE))))
        );
        pnProdutoLayout.setVerticalGroup(
            pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCadastrarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/novo.png"))); // NOI18N
        btnCadastrarProduto.setText("Cadastrar");
        btnCadastrarProduto.setContentAreaFilled(false);
        btnCadastrarProduto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCadastrarProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadastrarProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarProdutoActionPerformed(evt);
            }
        });

        btnEditarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/salvar.png"))); // NOI18N
        btnEditarProduto.setText("Editar");
        btnEditarProduto.setContentAreaFilled(false);
        btnEditarProduto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEditarProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditarProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCadastrarProduto)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbTitulo)
                        .addGap(401, 401, 401))
                    .addComponent(pnObrigatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnObrigatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrarProduto, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditarProduto, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarProdutoActionPerformed
         btnCadastrarProduto.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        produtoBO = new ProdutoDAO();
        if (produtoBO.validarCampos(pnObrigatorio)) {
            if (produtoBO.inserirProduto(cbCategoria.getSelectedIndex(), cbFornecedor.getSelectedIndex(), tfDescricao.getText(), tfCodigo.getText(), tfValorCusto.getText(), tfValorVenda.getText(), tfMinimo.getText(), tfMaximo.getText(), tfEstoque.getText())) {
                controle.atualizarTabelas();
                this.dispose();
            }
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnCadastrarProduto.setEnabled(true);
    }//GEN-LAST:event_btnCadastrarProdutoActionPerformed

    private void btnEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProdutoActionPerformed
       btnCadastrarProduto.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        produtoBO = new ProdutoDAO();
        if (produtoBO.validarCampos(pnObrigatorio)) {
            if (produtoBO.alterarProduto(produto.getIdProduto(), cbCategoria.getSelectedIndex(), cbFornecedor.getSelectedIndex(), tfDescricao.getText(), tfCodigo.getText(), tfValorCusto.getText(), tfValorVenda.getText(), tfMinimo.getText(), tfMaximo.getText(), tfEstoque.getText())) {
                controle.atualizarTabelas();
                this.dispose();
            }
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnCadastrarProduto.setEnabled(true);
    }//GEN-LAST:event_btnEditarProdutoActionPerformed

    private void tfValorVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValorVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfValorVendaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarProduto;
    private javax.swing.JButton btnEditarProduto;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel pnObrigatorio;
    private javax.swing.JPanel pnProduto;
    private javax.swing.JFormattedTextField tfCodigo;
    private javax.swing.JFormattedTextField tfDescricao;
    private javax.swing.JFormattedTextField tfEstoque;
    private javax.swing.JFormattedTextField tfMaximo;
    private javax.swing.JFormattedTextField tfMinimo;
    private javax.swing.JFormattedTextField tfValorCusto;
    private javax.swing.JFormattedTextField tfValorVenda;
    // End of variables declaration//GEN-END:variables
}

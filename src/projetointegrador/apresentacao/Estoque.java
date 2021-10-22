package projetointegrador.apresentacao;

import java.awt.Cursor;
import projetointegrador.persistencia.CompraDAO;
import projetointegrador.persistencia.VendaDAO;
import projetointegrador.tableModel.TableModelCompra;
import projetointegrador.tableModel.TableModelInventario;
import projetointegrador.tableModel.TableModelVenda;

/**
 *
 * @author Felipe
 */
public class Estoque extends javax.swing.JInternalFrame {

    private TelaCompra viewCompra;
    private CompraDAO compraBO;
    private TableModelCompra tabelaCompra;
    private TableModelInventario tabelaInventario;
    
    private TelaVenda viewVenda;
    private VendaDAO vendaBO;
    private TableModelVenda tabelaVenda;

    public Estoque() {
        initComponents();
        atualizarTabelas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        pnInventario = new javax.swing.JPanel();
        btnAtualizarIventario = new javax.swing.JButton();
        lbResultadosIventario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbIventario = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        pnCompras = new javax.swing.JPanel();
        btnNovaCompra = new javax.swing.JButton();
        btnExcluirCompras = new javax.swing.JToggleButton();
        btnAlterarCompras = new javax.swing.JButton();
        btnVisualizarCompras = new javax.swing.JButton();
        lbResultadosCompras = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCompras = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        pnVendas = new javax.swing.JPanel();
        btnNovaVenda = new javax.swing.JButton();
        btnExcluirVendas = new javax.swing.JToggleButton();
        btnAlterarVendas = new javax.swing.JButton();
        btnVisualizarVendas = new javax.swing.JButton();
        lbResultadosVendas = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbVendas = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Estoque");

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane2.setFocusable(false);
        jTabbedPane2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        btnAtualizarIventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/buscar-foco.png"))); // NOI18N
        btnAtualizarIventario.setText("Atualizar");
        btnAtualizarIventario.setContentAreaFilled(false);
        btnAtualizarIventario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAtualizarIventario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAtualizarIventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarIventarioActionPerformed(evt);
            }
        });

        lbResultadosIventario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbResultadosIventario.setForeground(new java.awt.Color(102, 102, 102));
        lbResultadosIventario.setText("0 resultados, mostrando todos.");

        tbIventario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbIventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbIventario.setFocusable(false);
        tbIventario.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tbIventario.setShowVerticalLines(false);
        tbIventario.getTableHeader().setReorderingAllowed(false);
        tbIventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbIventarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbIventario);
        cabecalho = tbIventario.getTableHeader();
        cabecalho.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
        cabecalho.setForeground(new java.awt.Color(102,102,102));

        javax.swing.GroupLayout pnInventarioLayout = new javax.swing.GroupLayout(pnInventario);
        pnInventario.setLayout(pnInventarioLayout);
        pnInventarioLayout.setHorizontalGroup(
            pnInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                    .addGroup(pnInventarioLayout.createSequentialGroup()
                        .addGroup(pnInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAtualizarIventario, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbResultadosIventario))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnInventarioLayout.setVerticalGroup(
            pnInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAtualizarIventario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbResultadosIventario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Inventario", jPanel1);

        btnNovaCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/novo.png"))); // NOI18N
        btnNovaCompra.setText("Nova Compra");
        btnNovaCompra.setContentAreaFilled(false);
        btnNovaCompra.setDefaultCapable(false);
        btnNovaCompra.setFocusable(false);
        btnNovaCompra.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNovaCompra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovaCompra.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaCompraActionPerformed(evt);
            }
        });

        btnExcluirCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/excluir.png"))); // NOI18N
        btnExcluirCompras.setText("Excluir Compra");
        btnExcluirCompras.setContentAreaFilled(false);
        btnExcluirCompras.setFocusable(false);
        btnExcluirCompras.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExcluirCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluirCompras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluirCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirComprasActionPerformed(evt);
            }
        });

        btnAlterarCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/salvar.png"))); // NOI18N
        btnAlterarCompras.setText("Editar Compra");
        btnAlterarCompras.setContentAreaFilled(false);
        btnAlterarCompras.setFocusable(false);
        btnAlterarCompras.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAlterarCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterarCompras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAlterarCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarComprasActionPerformed(evt);
            }
        });

        btnVisualizarCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/buscar-foco.png"))); // NOI18N
        btnVisualizarCompras.setText("Visualizar Compra");
        btnVisualizarCompras.setContentAreaFilled(false);
        btnVisualizarCompras.setFocusable(false);
        btnVisualizarCompras.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVisualizarCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVisualizarCompras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVisualizarCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarComprasActionPerformed(evt);
            }
        });

        lbResultadosCompras.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbResultadosCompras.setForeground(new java.awt.Color(102, 102, 102));
        lbResultadosCompras.setText("0 resultados, mostrando todos.");

        tbCompras.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbCompras.setFocusable(false);
        tbCompras.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tbCompras.setShowVerticalLines(false);
        tbCompras.getTableHeader().setReorderingAllowed(false);
        tbCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbComprasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbCompras);

        javax.swing.GroupLayout pnComprasLayout = new javax.swing.GroupLayout(pnCompras);
        pnCompras.setLayout(pnComprasLayout);
        pnComprasLayout.setHorizontalGroup(
            pnComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnComprasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                    .addGroup(pnComprasLayout.createSequentialGroup()
                        .addGroup(pnComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnComprasLayout.createSequentialGroup()
                                .addComponent(btnNovaCompra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluirCompras)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterarCompras)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVisualizarCompras))
                            .addComponent(lbResultadosCompras))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnComprasLayout.setVerticalGroup(
            pnComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnComprasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovaCompra)
                    .addComponent(btnExcluirCompras)
                    .addComponent(btnAlterarCompras)
                    .addComponent(btnVisualizarCompras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbResultadosCompras)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Compras", jPanel2);

        btnNovaVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/novo.png"))); // NOI18N
        btnNovaVenda.setText("Nova Venda");
        btnNovaVenda.setContentAreaFilled(false);
        btnNovaVenda.setDefaultCapable(false);
        btnNovaVenda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNovaVenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovaVenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaVendaActionPerformed(evt);
            }
        });

        btnExcluirVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/excluir.png"))); // NOI18N
        btnExcluirVendas.setText("Excluir Venda");
        btnExcluirVendas.setContentAreaFilled(false);
        btnExcluirVendas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExcluirVendas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluirVendas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluirVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirVendasActionPerformed(evt);
            }
        });

        btnAlterarVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/salvar.png"))); // NOI18N
        btnAlterarVendas.setText("Editar Venda");
        btnAlterarVendas.setContentAreaFilled(false);
        btnAlterarVendas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAlterarVendas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterarVendas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAlterarVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarVendasActionPerformed(evt);
            }
        });

        btnVisualizarVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/buscar-foco.png"))); // NOI18N
        btnVisualizarVendas.setText("Visualizar Venda");
        btnVisualizarVendas.setContentAreaFilled(false);
        btnVisualizarVendas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVisualizarVendas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVisualizarVendas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVisualizarVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarVendasActionPerformed(evt);
            }
        });

        lbResultadosVendas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbResultadosVendas.setForeground(new java.awt.Color(102, 102, 102));
        lbResultadosVendas.setText("0 resultados, mostrando todos.");

        tbVendas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbVendas.setFocusable(false);
        tbVendas.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tbVendas.setShowVerticalLines(false);
        tbVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVendasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbVendas);

        javax.swing.GroupLayout pnVendasLayout = new javax.swing.GroupLayout(pnVendas);
        pnVendas.setLayout(pnVendasLayout);
        pnVendasLayout.setHorizontalGroup(
            pnVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnVendasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(pnVendasLayout.createSequentialGroup()
                        .addGroup(pnVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbResultadosVendas)
                            .addGroup(pnVendasLayout.createSequentialGroup()
                                .addComponent(btnNovaVenda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluirVendas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterarVendas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVisualizarVendas)))
                        .addGap(0, 224, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnVendasLayout.setVerticalGroup(
            pnVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnVendasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovaVenda)
                    .addComponent(btnExcluirVendas)
                    .addComponent(btnAlterarVendas)
                    .addComponent(btnVisualizarVendas))
                .addGap(18, 18, 18)
                .addComponent(lbResultadosVendas)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Vendas", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarIventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarIventarioActionPerformed
        btnAtualizarIventario.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        atualizarTabelas();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnAtualizarIventario.setEnabled(true);
    }//GEN-LAST:event_btnAtualizarIventarioActionPerformed

    private void btnNovaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaCompraActionPerformed
        viewCompra = new TelaCompra(this);
        viewCompra.setVisible(true);
    }//GEN-LAST:event_btnNovaCompraActionPerformed

    private void btnExcluirComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirComprasActionPerformed
        if (tbCompras.getSelectedRow() != -1) {
            TableModelCompra modelo = (TableModelCompra) tbCompras.getModel();
            if (compraBO.excluirCompra1(modelo.getCompra(tbCompras.getSelectedRow()).getIdCompra())) {
                atualizarTabelas();
            }
        }
    }//GEN-LAST:event_btnExcluirComprasActionPerformed

    private void btnAlterarComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarComprasActionPerformed
        if (tbCompras.getSelectedRow() != -1) {
            TableModelCompra modelo = (TableModelCompra) tbCompras.getModel();
            viewCompra = new TelaCompra(this, modelo.getCompra(tbCompras.getSelectedRow()), true);
            viewCompra.setVisible(true);
        }
    }//GEN-LAST:event_btnAlterarComprasActionPerformed

    private void btnVisualizarComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarComprasActionPerformed
         if (tbCompras.getSelectedRow() != -1) {
            TableModelCompra modelo = (TableModelCompra) tbCompras.getModel();
            viewCompra = new TelaCompra(this, modelo.getCompra(tbCompras.getSelectedRow()), false);
            viewCompra.setVisible(true);
        }
    }//GEN-LAST:event_btnVisualizarComprasActionPerformed

    private void btnNovaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaVendaActionPerformed
        viewVenda = new TelaVenda(this);
        viewVenda.setVisible(true);
    }//GEN-LAST:event_btnNovaVendaActionPerformed

    private void btnExcluirVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirVendasActionPerformed
        if (tbVendas.getSelectedRow() != -1) {
            TableModelVenda modelo = (TableModelVenda) tbVendas.getModel();
            if (vendaBO.excluirVenda(modelo.getVenda(tbVendas.getSelectedRow()).getIdVenda())) {
                atualizarTabelas();
            }
        }
    }//GEN-LAST:event_btnExcluirVendasActionPerformed

    private void btnAlterarVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarVendasActionPerformed
       if (tbVendas.getSelectedRow() != -1) {
            TableModelVenda modelo = (TableModelVenda) tbVendas.getModel();
            viewVenda = new TelaVenda(this, modelo.getVenda(tbVendas.getSelectedRow()), true);
            viewVenda.setVisible(true);
        }
    }//GEN-LAST:event_btnAlterarVendasActionPerformed

    private void btnVisualizarVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarVendasActionPerformed
        if (tbVendas.getSelectedRow() != -1) {
            TableModelVenda modelo = (TableModelVenda) tbVendas.getModel();
            viewVenda = new TelaVenda(this, modelo.getVenda(tbVendas.getSelectedRow()), false);
            viewVenda.setVisible(true);
        }
    }//GEN-LAST:event_btnVisualizarVendasActionPerformed

    private void tbComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbComprasMouseClicked
        if (tbCompras.getSelectedRow() != -1) {
            btnVisualizarCompras.setEnabled(true);
            btnAlterarCompras.setEnabled(true);
            btnExcluirCompras.setEnabled(true);
        }
    }//GEN-LAST:event_tbComprasMouseClicked

    private void tbIventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbIventarioMouseClicked
        
    }//GEN-LAST:event_tbIventarioMouseClicked

    private void tbVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVendasMouseClicked
         if (tbVendas.getSelectedRow() != -1) {
            btnVisualizarVendas.setEnabled(true);
            btnAlterarVendas.setEnabled(true);
            btnExcluirVendas.setEnabled(true);
        }
    }//GEN-LAST:event_tbVendasMouseClicked
    public void atualizarTabelas() {
        compraBO = new CompraDAO();
        tabelaInventario = new TableModelInventario(compraBO.buscarInventario());
        tabelaCompra = new TableModelCompra(compraBO.buscarCompras());
        tbIventario.setModel(tabelaInventario);
        tbCompras.setModel(tabelaCompra);
        tbIventario.clearSelection();
        tbCompras.clearSelection();
        btnVisualizarCompras.setEnabled(false);
        btnAlterarCompras.setEnabled(false);
        btnExcluirCompras.setEnabled(false);
        btnVisualizarVendas.setEnabled(false);
        btnAlterarVendas.setEnabled(false);
        btnExcluirVendas.setEnabled(false);
        lbResultadosIventario.setText(tbIventario.getModel().getRowCount() + " resultados, mostrando todos.");
        lbResultadosCompras.setText(tbCompras.getModel().getRowCount() + " resultados, mostrando todos.");
        
        vendaBO = new VendaDAO();
        tabelaVenda = new TableModelVenda(vendaBO.buscarVendas());

        //Definindo modelo de tabelas para as tabelas.
        tbVendas.setModel(tabelaVenda);

        //Definir tabelas como sem seleção.
        tbVendas.clearSelection();

        //Definindo botões Aleterar e Excluir como não habilitado.
        btnVisualizarVendas.setEnabled(false);
        btnAlterarVendas.setEnabled(false);
        btnExcluirVendas.setEnabled(false);

        //Definindo lbResultados
        lbResultadosVendas.setText(tbVendas.getModel().getRowCount() + " resultados, mostrando todos.");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarCompras;
    private javax.swing.JButton btnAlterarVendas;
    private javax.swing.JButton btnAtualizarIventario;
    private javax.swing.JToggleButton btnExcluirCompras;
    private javax.swing.JToggleButton btnExcluirVendas;
    private javax.swing.JButton btnNovaCompra;
    private javax.swing.JButton btnNovaVenda;
    private javax.swing.JButton btnVisualizarCompras;
    private javax.swing.JButton btnVisualizarVendas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lbResultadosCompras;
    private javax.swing.JLabel lbResultadosIventario;
    private javax.swing.JLabel lbResultadosVendas;
    private javax.swing.JPanel pnCompras;
    private javax.swing.JPanel pnInventario;
    private javax.swing.JPanel pnVendas;
    private javax.swing.JTable tbCompras;
    private javax.swing.JTable tbIventario;
    private javax.swing.table.JTableHeader cabecalho;
    private javax.swing.JTable tbVendas;
    // End of variables declaration//GEN-END:variables
}

package projetointegrador.apresentacao;

import java.awt.Cursor;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import projetointegrador.negocio.Compra;
import projetointegrador.persistencia.CompraDAO;
import projetointegrador.negocio.Itemcompra;
import projetointegrador.negocio.Itemvenda;
import projetointegrador.negocio.Pagamento;
import projetointegrador.tableModel.TableModelItemCompra;
import projetointegrador.tableModel.TableModelPagamento;

/**
 *
 * @author Felipe
 */
public class TelaCompra extends javax.swing.JDialog {

    private final Estoque viewEstoque;
    private TelaItemCompra viewItem;
    private Compra compraVO;
    private final ArrayList<Itemcompra> itens;
    private final ArrayList<Pagamento> pagamentos;
    private Itemvenda itemVenda;
    private CompraDAO compraBO;
    private TableModelItemCompra tabelaItens;
    private TableModelPagamento tabelaPagamento;

    public TelaCompra(Estoque viewEstoque) {
        this.viewEstoque = viewEstoque;
        this.compraBO = new CompraDAO();
        this.itens = new ArrayList<>();
        this.pagamentos = new ArrayList<>();
        initComponents();
        rbAVista.doClick();
        btnAlterar.setVisible(false);
        atualizarPagina();
    }

    public TelaCompra(Estoque viewEstoque, Compra compra, Boolean alterar) {
        //Inicialização dos componentes padrões do JDialog.
        this.viewEstoque = viewEstoque;
        this.compraBO = new CompraDAO();
        this.compraVO = compra;
        this.itens = compraBO.buscarItens(compra.getIdCompra());;
        this.pagamentos = new ArrayList<>();
        initComponents();
        rbAVista.doClick();
        btnFinalizarCompra.setVisible(false);

        //Definindo Modelo com Fornecedor para os JComboBox.
        ArrayList<String> array = new ArrayList<>();
        String[] Arr = new String[array.size()];
        if (compra.getFornecedor() != null) {
            array.add(compra.getFornecedor().getNomeFornecedor());
        } else {
            array.add("FORNECEDOR");
        }
        Arr = array.toArray(Arr);
        cbFornecedor.setModel(new javax.swing.DefaultComboBoxModel(Arr));

        //Definindo como não editável
        if (!alterar) {
            btnAlterar.setEnabled(false);
            cbFornecedor.setEnabled(false);
            btnNovoItem.setEnabled(false);
            btnAlterarItem.setEnabled(false);
            btnVisualizarItem.setEnabled(false);
            btnExcluirItem.setEnabled(false);
            pnPagamento.setEnabled(false);
            rbAVista.setEnabled(false);
            rbAPrazo.setEnabled(false);
        }
        atualizarPagina();
    }

    public void atualizarPagina() {
        calcularValores();
        calcularPagamento();
        calcularTroco();
        atualizarTabelas();
        calcularValores();
        calcularPagamento();
        calcularTroco();
    }

    public final void atualizarTabelas() {
        //Inicialização dos modelos de tabelas.
        compraBO = new CompraDAO();
        try {
            tabelaItens = new TableModelItemCompra(itens);
        } catch (Exception e) {
            tabelaItens = new TableModelItemCompra();
        }
        try {
            tabelaPagamento = new TableModelPagamento(pagamentos);
        } catch (Exception e) {
            tabelaPagamento = new TableModelPagamento();
        }

        //Definindo modelo de tabelas para as tabelas.
        tbItens.setModel(tabelaItens);
        tbPagamentos.setModel(tabelaPagamento);

        //Definir tabelas como sem seleção.
        tbItens.clearSelection();
        tbPagamentos.clearSelection();

        //Definindo botões Aleterar e Excluir como não habilitado.
        btnAlterarItem.setEnabled(false);
        btnExcluirItem.setEnabled(false);

        //Definindo valores da venda
        tfTotalVenda.setText("0.0");
    }

    public void calcularValores() {
        if (itens.size() > 0) {
            BigDecimal aux = new BigDecimal(0);
            for (Itemcompra iten : itens) {
                aux = aux.add(iten.getValorItemCompra());
            }
            tfTotalVenda.setText(aux.toString());
        }
    }

    public void calcularTroco() {
        try {
            BigDecimal troco = new BigDecimal(tfTotalPago.getText()).subtract(new BigDecimal(tfTotalAVista.getText()));
            tfTroco.setText(troco.toString());
        } catch (Exception e) {

        }
    }

    public void calcularPagamento() {
        if (rbAVista.isSelected()) {
            tfTotalAVista.setText(tfTotalVenda.getText());
        } else {
            BigDecimal valor = new BigDecimal(0);
            for (Pagamento recebimento : pagamentos) {
                if (recebimento.getStatusPagamento()) {
                    valor = valor.add(recebimento.getValorPagamento());
                }
            }
            tfTotalAVista.setText(valor.toString());
        }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCorpo = new javax.swing.JPanel();
        pnFornecedor = new javax.swing.JPanel();
        cbFornecedor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnPedido = new javax.swing.JPanel();
        btnNovoItem = new javax.swing.JButton();
        btnExcluirItem = new javax.swing.JButton();
        btnAlterarItem = new javax.swing.JButton();
        btnVisualizarItem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbItens = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        tfTotalVenda = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        btnFinalizarCompra = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        pnPagamento = new javax.swing.JPanel();
        rbAVista = new javax.swing.JRadioButton();
        rbAPrazo = new javax.swing.JRadioButton();
        pnAPrazo = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        sldParcelas = new javax.swing.JSlider();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPagamentos = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        cbVencimento = new javax.swing.JComboBox<>();
        pnAVista = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tfTotalAVista = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        tfTotalPago = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        tfTroco = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        pnCorpo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbFornecedor.setModel(new javax.swing.DefaultComboBoxModel(compraBO.buscarNomeFornecedores()));
        cbFornecedor.setFocusable(false);
        cbFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFornecedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFornecedorLayout = new javax.swing.GroupLayout(pnFornecedor);
        pnFornecedor.setLayout(pnFornecedorLayout);
        pnFornecedorLayout.setHorizontalGroup(
            pnFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnFornecedorLayout.setVerticalGroup(
            pnFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Fornecedor");

        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("(opcional)");

        btnNovoItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/novo.png"))); // NOI18N
        btnNovoItem.setText("Novo");
        btnNovoItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovoItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoItemActionPerformed(evt);
            }
        });

        btnExcluirItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/excluir.png"))); // NOI18N
        btnExcluirItem.setText("Excluir");
        btnExcluirItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluirItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirItemActionPerformed(evt);
            }
        });

        btnAlterarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/salvar.png"))); // NOI18N
        btnAlterarItem.setText("Editar");
        btnAlterarItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterarItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAlterarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarItemActionPerformed(evt);
            }
        });

        btnVisualizarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/buscar-foco.png"))); // NOI18N
        btnVisualizarItem.setText("Visualizar");
        btnVisualizarItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVisualizarItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        tbItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbItens.setFocusable(false);
        tbItens.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tbItens.setShowVerticalLines(false);
        tbItens.getTableHeader().setReorderingAllowed(false);
        tbItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbItensMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbItens);

        jLabel5.setText("Total do Pedido R$");

        javax.swing.GroupLayout pnPedidoLayout = new javax.swing.GroupLayout(pnPedido);
        pnPedido.setLayout(pnPedidoLayout);
        pnPedidoLayout.setHorizontalGroup(
            pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnPedidoLayout.createSequentialGroup()
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnPedidoLayout.createSequentialGroup()
                                .addComponent(btnNovoItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluirItem)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterarItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVisualizarItem))
                            .addGroup(pnPedidoLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnPedidoLayout.setVerticalGroup(
            pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoItem)
                    .addComponent(btnExcluirItem)
                    .addComponent(btnAlterarItem)
                    .addComponent(btnVisualizarItem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Pedido");

        btnFinalizarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/finalizar.png"))); // NOI18N
        btnFinalizarCompra.setText("Finalizar Compra");
        btnFinalizarCompra.setContentAreaFilled(false);
        btnFinalizarCompra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFinalizarCompra.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarCompraActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/salvar.png"))); // NOI18N
        btnAlterar.setText("Editar Compra");
        btnAlterar.setContentAreaFilled(false);
        btnAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        rbAVista.setText("A vista");
        rbAVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAVistaActionPerformed(evt);
            }
        });

        rbAPrazo.setText("A prazo");
        rbAPrazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAPrazoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Parcelas");

        sldParcelas.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        sldParcelas.setMajorTickSpacing(1);
        sldParcelas.setMaximum(12);
        sldParcelas.setPaintLabels(true);
        sldParcelas.setPaintTicks(true);
        sldParcelas.setSnapToTicks(true);
        sldParcelas.setValue(0);
        sldParcelas.setFocusable(false);
        sldParcelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sldParcelasMouseReleased(evt);
            }
        });

        tbPagamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbPagamentos.setFocusable(false);
        tbPagamentos.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tbPagamentos.setShowVerticalLines(false);
        tbPagamentos.getTableHeader().setReorderingAllowed(false);
        tbPagamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPagamentosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbPagamentos);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Vencimento");

        cbVencimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cbVencimento.setFocusable(false);
        cbVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVencimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnAPrazoLayout = new javax.swing.GroupLayout(pnAPrazo);
        pnAPrazo.setLayout(pnAPrazoLayout);
        pnAPrazoLayout.setHorizontalGroup(
            pnAPrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAPrazoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAPrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnAPrazoLayout.createSequentialGroup()
                        .addGroup(pnAPrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnAPrazoLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(sldParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnAPrazoLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 67, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnAPrazoLayout.setVerticalGroup(
            pnAPrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAPrazoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAPrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sldParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(pnAPrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnAPrazoLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel11))
                    .addGroup(pnAPrazoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setText("Total do Pagamento R$");

        tfTotalAVista.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        tfTotalAVista.setText("0.0");

        jLabel9.setText("Valor Pago R$");

        tfTotalPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTotalPagoKeyReleased(evt);
            }
        });

        jLabel10.setText("Troco R$");

        tfTroco.setText("0.0");

        javax.swing.GroupLayout pnAVistaLayout = new javax.swing.GroupLayout(pnAVista);
        pnAVista.setLayout(pnAVistaLayout);
        pnAVistaLayout.setHorizontalGroup(
            pnAVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAVistaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnAVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTotalAVista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTotalPago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTroco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnAVistaLayout.setVerticalGroup(
            pnAVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAVistaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfTotalAVista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnAVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnAVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tfTroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnPagamentoLayout = new javax.swing.GroupLayout(pnPagamento);
        pnPagamento.setLayout(pnPagamentoLayout);
        pnPagamentoLayout.setHorizontalGroup(
            pnPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPagamentoLayout.createSequentialGroup()
                .addGroup(pnPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPagamentoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnAPrazo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnPagamentoLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(rbAVista)
                        .addGap(18, 18, 18)
                        .addComponent(rbAPrazo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnPagamentoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnAVista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnPagamentoLayout.setVerticalGroup(
            pnPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAVista)
                    .addComponent(rbAPrazo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnAPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnAVista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Pagamento");

        javax.swing.GroupLayout pnCorpoLayout = new javax.swing.GroupLayout(pnCorpo);
        pnCorpo.setLayout(pnCorpoLayout);
        pnCorpoLayout.setHorizontalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addComponent(btnFinalizarCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAlterar))
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pnFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addComponent(pnPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnCorpoLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
        );
        pnCorpoLayout.setVerticalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCorpoLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnFinalizarCompra))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Nova Compra");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnCorpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoItemActionPerformed
        viewItem = new TelaItemCompra(this, itens);
        viewItem.setVisible(true);
    }//GEN-LAST:event_btnNovoItemActionPerformed

    private void tbItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbItensMouseClicked
        if (tbItens.getSelectedRow() != -1) {
            btnAlterarItem.setEnabled(true);
            btnExcluirItem.setEnabled(true);
        }
    }//GEN-LAST:event_tbItensMouseClicked

    private void rbAVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAVistaActionPerformed
        if (rbAVista.isSelected()) {
            pnAPrazo.setVisible(false);
            pnAVista.setVisible(true);
            atualizarPagina();
        }
    }//GEN-LAST:event_rbAVistaActionPerformed

    private void rbAPrazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAPrazoActionPerformed
        if (rbAPrazo.isSelected()) {
            pnAPrazo.setVisible(true);
            atualizarPagina();
        }
    }//GEN-LAST:event_rbAPrazoActionPerformed

    private void sldParcelasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sldParcelasMouseReleased
        sldParcelas.setEnabled(false);
        atualizarPagina();
        sldParcelas.setEnabled(true);
    }//GEN-LAST:event_sldParcelasMouseReleased

    private void cbVencimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVencimentoActionPerformed
        atualizarPagina();
    }//GEN-LAST:event_cbVencimentoActionPerformed

    private void tbPagamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPagamentosMouseClicked
        if (tbPagamentos.getSelectedRow() != -1) {
            if (pagamentos.get(tbPagamentos.getSelectedRow()).getStatusPagamento()) {
                pagamentos.get(tbPagamentos.getSelectedRow()).setStatusPagamento(false);
            } else {
                pagamentos.get(tbPagamentos.getSelectedRow()).setStatusPagamento(true);
            }
            atualizarTabelas();
            calcularValores();
            calcularPagamento();
            calcularTroco();
        }
    }//GEN-LAST:event_tbPagamentosMouseClicked

    private void tfTotalPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTotalPagoKeyReleased
        calcularTroco();
    }//GEN-LAST:event_tfTotalPagoKeyReleased

    private void btnAlterarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarItemActionPerformed
        if (tbItens.getSelectedRow() != -1) {
            viewItem = new TelaItemCompra(this, itens.get(tbItens.getSelectedRow()), true);
            viewItem.setVisible(true);
        }
    }//GEN-LAST:event_btnAlterarItemActionPerformed

    private void btnExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirItemActionPerformed
        if (tbItens.getSelectedRow() != -1) {
            itens.remove(tbItens.getSelectedRow());
            atualizarPagina();
        }
    }//GEN-LAST:event_btnExcluirItemActionPerformed

    private void btnFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarCompraActionPerformed
        btnFinalizarCompra.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (tbItens.getModel().getRowCount() > 0) {
            if (compraBO.verificarEstoque(itens)) {
                if (compraBO.finalizarCompra(cbFornecedor.getSelectedIndex(), tfTotalVenda.getText(), sldParcelas.getValue(), null, itens)) {
                    viewEstoque.atualizarTabelas();
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Quantidade maxima de produto no estoque.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Insira itens para a compra primeiro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnFinalizarCompra.setEnabled(true);
    }//GEN-LAST:event_btnFinalizarCompraActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        btnAlterar.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnAlterar.setEnabled(true);
        
        
        btnAlterar.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        
        if (compraBO.validarCampos(pnFornecedor)) {
            if (compraBO.alterarCompra(compraVO.getIdCompra(),cbFornecedor.getSelectedIndex(), tfTotalVenda.getText(), sldParcelas.getValue(), null, itens)) {
                viewEstoque.atualizarTabelas();
                this.dispose();
            }
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnAlterar.setEnabled(true);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void cbFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFornecedorActionPerformed
        
    }//GEN-LAST:event_cbFornecedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAlterarItem;
    private javax.swing.JButton btnExcluirItem;
    private javax.swing.JButton btnFinalizarCompra;
    private javax.swing.JButton btnNovoItem;
    private javax.swing.JButton btnVisualizarItem;
    private javax.swing.JComboBox<String> cbFornecedor;
    private javax.swing.JComboBox<String> cbVencimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnAPrazo;
    private javax.swing.JPanel pnAVista;
    private javax.swing.JPanel pnCorpo;
    private javax.swing.JPanel pnFornecedor;
    private javax.swing.JPanel pnPagamento;
    private javax.swing.JPanel pnPedido;
    private javax.swing.JRadioButton rbAPrazo;
    private javax.swing.JRadioButton rbAVista;
    private javax.swing.JSlider sldParcelas;
    private javax.swing.JTable tbItens;
    private javax.swing.JTable tbPagamentos;
    private javax.swing.JFormattedTextField tfTotalAVista;
    private javax.swing.JFormattedTextField tfTotalPago;
    private javax.swing.JFormattedTextField tfTotalVenda;
    private javax.swing.JFormattedTextField tfTroco;
    // End of variables declaration//GEN-END:variables
}

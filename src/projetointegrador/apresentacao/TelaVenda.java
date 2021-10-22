
package projetointegrador.apresentacao;

import java.awt.Cursor;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import projetointegrador.negocio.Itemvenda;
import projetointegrador.persistencia.ProdutoDAO;
import projetointegrador.negocio.Recebimento;
import projetointegrador.negocio.Venda;
import projetointegrador.persistencia.VendaDAO;
import projetointegrador.tableModel.TableModelItemVenda;
import projetointegrador.tableModel.TableModelRecebimento;

/**
 *
 * @author Felipe
 */
public class TelaVenda extends javax.swing.JDialog {

    private TelaItemVenda viewItem;
    private ProdutoDAO produtoBO=null;
    private Itemvenda itemVenda;
    private final Estoque viewEstoque;
    

    private Venda vendaVO;
    private final ArrayList<Itemvenda> itens;
    private final ArrayList<Recebimento> recebimentos;

    //Declaração de variáveis(Business Object).
    private VendaDAO vendaBO;

    //Declaração de variáveis(Tabelas).
    private TableModelItemVenda tabelaItens;
    private TableModelRecebimento tabelaRecebimento;
    
    
    public TelaVenda(Estoque viewEstoque) {
        
        this.viewEstoque = viewEstoque;
        this.vendaBO = new VendaDAO();
        this.itens = new ArrayList<>();
        this.recebimentos = new ArrayList<>();
        initComponents();
        rbAVista.doClick();
        btnAlterarVenda.setVisible(false);
        atualizarPagina();
    }
    
    public TelaVenda(Estoque viewEstoque, Venda venda, Boolean alterar) {
        //Inicialização dos componentes padrões do JDialog.
        this.viewEstoque = viewEstoque;
        this.vendaBO = new VendaDAO();
        this.vendaVO = venda;
        this.itens = vendaBO.buscarItens(venda.getIdVenda());;
        this.recebimentos = new ArrayList<>();
        initComponents();
        rbAVista.doClick();
        btnFinalizarVenda.setVisible(false);

        //Definindo Modelo com Fornecedor para os JComboBox.
        ArrayList<String> array = new ArrayList<>();
        String[] Arr = new String[array.size()];
        if (venda.getCliente() != null) {
            array.add(venda.getCliente().getNomeCliente());
        } else {
            array.add("CLIENTE");
        }
        Arr = array.toArray(Arr);
        cbCliente.setModel(new javax.swing.DefaultComboBoxModel(Arr));
        //Definindo como não editável
        if (!alterar) {
            btnAlterarVenda.setEnabled(false);
            cbCliente.setEnabled(false);
            btnNovoItem.setEnabled(false);
            btnAlterarItem.setEnabled(false);
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
        vendaBO = new VendaDAO();
        try {
            tabelaItens = new TableModelItemVenda(itens);
        } catch (Exception e) {
            tabelaItens = new TableModelItemVenda();
        }
        try {
            tabelaRecebimento = new TableModelRecebimento(recebimentos);
        } catch (Exception e) {
            tabelaRecebimento = new TableModelRecebimento();
        }

        //Definindo modelo de tabelas para as tabelas.
        tbItens.setModel(tabelaItens);
        tbRecebimentos.setModel(tabelaRecebimento);

        //Definir tabelas como sem seleção.
        tbItens.clearSelection();
        tbRecebimentos.clearSelection();

        //Definindo botões Aleterar e Excluir como não habilitado.
        btnAlterarItem.setEnabled(false);
        btnExcluirItem.setEnabled(false);

        //Definindo valores da venda
        tfTotalVenda.setText("0.0");
        tfValorProdutos.setText("0.0");
        
    }
    
    public void calcularValores() {
        if (itens.size() > 0) {
            BigDecimal aux = new BigDecimal(0);
            for (Itemvenda iten : itens) {
                aux = aux.add(iten.getValorItemVenda());
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
            for (Recebimento recebimento : recebimentos) {
                if (recebimento.getStatusRecebimento()) {
                    valor = valor.add(recebimento.getValorRecebimento());
                }
            }
            tfTotalAVista.setText(valor.toString());
        }
    }
    
    /*public void gerarRecebimentos() {
        recebimentos.clear();
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            if (rbAPrazo.isSelected()) {
                for (int cont = 0; cont < (Integer) sldParcelas.getValue(); cont++) {
                    calendar.add(Calendar.MONTH, +1);
                    if (((calendar.getTime().getMonth() + 1) == 2) && ((cbVencimento.getSelectedIndex() + 1) > 28)) {
                        calendar.set(Calendar.DAY_OF_MONTH, 28);
                    } else {
                        if (((calendar.getTime().getMonth() + 1) == 4) && ((cbVencimento.getSelectedIndex() + 1) > 30)) {
                            calendar.set(Calendar.DAY_OF_MONTH, 30);
                        } else {
                            if (((calendar.getTime().getMonth() + 1) == 6) && ((cbVencimento.getSelectedIndex() + 1) > 30)) {
                                calendar.set(Calendar.DAY_OF_MONTH, 30);
                            } else {
                                if (((calendar.getTime().getMonth() + 1) == 9) && ((cbVencimento.getSelectedIndex() + 1) > 30)) {
                                    calendar.set(Calendar.DAY_OF_MONTH, 30);
                                } else {
                                    if (((calendar.getTime().getMonth() + 1) == 11) && ((cbVencimento.getSelectedIndex() + 1) > 30)) {
                                        calendar.set(Calendar.DAY_OF_MONTH, 30);
                                    } else {
                                        calendar.set(Calendar.DAY_OF_MONTH, cbVencimento.getSelectedIndex() + 1);
                                    }
                                }
                            }
                        }
                    }
                    recebimentos.add(new Recebimento(null, null, vendaVO, "Venda", new BigDecimal(tfTotalVenda.getText()).divide(new BigDecimal(sldParcelas.getValue()), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_EVEN), calendar.getTime(), false, new Date(), new Date()));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCorpo = new javax.swing.JPanel();
        pnCliente = new javax.swing.JPanel();
        cbCliente = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        pnPedido = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnNovoItem = new javax.swing.JButton();
        btnAlterarItem = new javax.swing.JButton();
        btnExcluirItem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbItens = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfValorProdutos = new javax.swing.JFormattedTextField();
        tfTotalVenda = new javax.swing.JFormattedTextField();
        btnFinalizarVenda = new javax.swing.JButton();
        btnAlterarVenda = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        pnPagamento = new javax.swing.JPanel();
        pnAPrazo = new javax.swing.JPanel();
        rbAVista = new javax.swing.JRadioButton();
        rbAPrazo = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        sldParcelas = new javax.swing.JSlider();
        tfVencimento = new javax.swing.JLabel();
        cbVencimento = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbRecebimentos = new javax.swing.JTable();
        pnAVista = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfTotalAVista = new javax.swing.JFormattedTextField();
        tfTotalPago = new javax.swing.JFormattedTextField();
        tfTroco = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();

        pnCorpo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbCliente.setModel(new javax.swing.DefaultComboBoxModel(vendaBO.buscarNomeClientes()));
        cbCliente.setFocusable(false);
        cbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnClienteLayout = new javax.swing.GroupLayout(pnCliente);
        pnCliente.setLayout(pnClienteLayout);
        pnClienteLayout.setHorizontalGroup(
            pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnClienteLayout.setVerticalGroup(
            pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Cliente");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Pedido");

        btnNovoItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/novo.png"))); // NOI18N
        btnNovoItem.setText("Novo");
        btnNovoItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovoItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoItemActionPerformed(evt);
            }
        });

        btnAlterarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/salvar.png"))); // NOI18N
        btnAlterarItem.setText("Alterar");
        btnAlterarItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterarItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAlterarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarItemActionPerformed(evt);
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

        tbItens.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
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

        jLabel4.setText("Valor do Produtos R$");

        jLabel5.setText("Total da Venda R$");

        tfValorProdutos.setEditable(false);
        tfValorProdutos.setForeground(new java.awt.Color(102, 102, 102));
        tfValorProdutos.setText("0.0");
        tfValorProdutos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        tfTotalVenda.setEditable(false);
        tfTotalVenda.setForeground(new java.awt.Color(102, 102, 102));
        tfTotalVenda.setText("0.0");
        tfTotalVenda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnPedidoLayout = new javax.swing.GroupLayout(pnPedido);
        pnPedido.setLayout(pnPedidoLayout);
        pnPedidoLayout.setHorizontalGroup(
            pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addGroup(pnPedidoLayout.createSequentialGroup()
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(pnPedidoLayout.createSequentialGroup()
                                .addComponent(btnNovoItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAlterarItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluirItem)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnPedidoLayout.createSequentialGroup()
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfValorProdutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTotalVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnPedidoLayout.setVerticalGroup(
            pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoItem)
                    .addComponent(btnAlterarItem)
                    .addComponent(btnExcluirItem))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfValorProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnFinalizarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/finalizar.png"))); // NOI18N
        btnFinalizarVenda.setText("Finalizar Venda");
        btnFinalizarVenda.setContentAreaFilled(false);
        btnFinalizarVenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFinalizarVenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarVendaActionPerformed(evt);
            }
        });

        btnAlterarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/salvar.png"))); // NOI18N
        btnAlterarVenda.setText("Editar Venda");
        btnAlterarVenda.setContentAreaFilled(false);
        btnAlterarVenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterarVenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAlterarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarVendaActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel6.setText("Pagamento");

        rbAVista.setText("A Vista");
        rbAVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAVistaActionPerformed(evt);
            }
        });

        rbAPrazo.setText("A Prazo");
        rbAPrazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAPrazoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Parcelas");

        sldParcelas.setMajorTickSpacing(1);
        sldParcelas.setMaximum(12);
        sldParcelas.setPaintLabels(true);
        sldParcelas.setPaintTicks(true);
        sldParcelas.setSnapToTicks(true);
        sldParcelas.setValue(0);
        sldParcelas.setFocusable(false);

        tfVencimento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfVencimento.setForeground(new java.awt.Color(102, 102, 102));
        tfVencimento.setText("Vencimento nos dias");

        cbVencimento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbVencimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cbVencimento.setFocusable(false);

        tbRecebimentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbRecebimentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbRecebimentos.setFocusable(false);
        tbRecebimentos.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tbRecebimentos.setShowVerticalLines(false);
        tbRecebimentos.getTableHeader().setReorderingAllowed(false);
        tbRecebimentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRecebimentosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbRecebimentos);

        javax.swing.GroupLayout pnAPrazoLayout = new javax.swing.GroupLayout(pnAPrazo);
        pnAPrazo.setLayout(pnAPrazoLayout);
        pnAPrazoLayout.setHorizontalGroup(
            pnAPrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAPrazoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAPrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnAPrazoLayout.createSequentialGroup()
                        .addGroup(pnAPrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnAPrazoLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sldParcelas, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                            .addGroup(pnAPrazoLayout.createSequentialGroup()
                                .addComponent(rbAVista)
                                .addGap(18, 18, 18)
                                .addComponent(rbAPrazo))
                            .addGroup(pnAPrazoLayout.createSequentialGroup()
                                .addComponent(tfVencimento)
                                .addGap(27, 27, 27)
                                .addComponent(cbVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 28, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnAPrazoLayout.setVerticalGroup(
            pnAPrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAPrazoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAPrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAVista)
                    .addComponent(rbAPrazo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnAPrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(sldParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnAPrazoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfVencimento)
                    .addComponent(cbVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setText("Total do Pagamento R$");

        jLabel9.setText("Valor Pago R$");

        jLabel10.setText("Troco R$");

        tfTotalAVista.setEditable(false);
        tfTotalAVista.setForeground(new java.awt.Color(102, 102, 102));
        tfTotalAVista.setText("0.0");
        tfTotalAVista.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        tfTotalPago.setForeground(new java.awt.Color(102, 102, 102));
        tfTotalPago.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("########.##"))));
        tfTotalPago.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfTotalPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTotalPagoKeyReleased(evt);
            }
        });

        tfTroco.setEditable(false);
        tfTroco.setForeground(new java.awt.Color(102, 102, 102));
        tfTroco.setText("0.0");
        tfTroco.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnAVistaLayout = new javax.swing.GroupLayout(pnAVista);
        pnAVista.setLayout(pnAVistaLayout);
        pnAVistaLayout.setHorizontalGroup(
            pnAVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAVistaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnAVistaLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(tfTotalAVista, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnAVistaLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnAVistaLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnAVistaLayout.setVerticalGroup(
            pnAVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAVistaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfTotalAVista, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnAVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(pnAVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tfTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnPagamentoLayout = new javax.swing.GroupLayout(pnPagamento);
        pnPagamento.setLayout(pnPagamentoLayout);
        pnPagamentoLayout.setHorizontalGroup(
            pnPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnAPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnAVista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        pnPagamentoLayout.setVerticalGroup(
            pnPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnAPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnAVista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnCorpoLayout = new javax.swing.GroupLayout(pnCorpo);
        pnCorpo.setLayout(pnCorpoLayout);
        pnCorpoLayout.setHorizontalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(pnPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCorpoLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(pnPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addComponent(btnFinalizarVenda)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterarVenda)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnCorpoLayout.setVerticalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnCorpoLayout.createSequentialGroup()
                        .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCorpoLayout.createSequentialGroup()
                                .addComponent(pnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFinalizarVenda)
                            .addComponent(btnAlterarVenda))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Nova Venda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(767, 767, 767))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfTotalPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTotalPagoKeyReleased
        calcularTroco();
    }//GEN-LAST:event_tfTotalPagoKeyReleased

    private void tbRecebimentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRecebimentosMouseClicked
        if (tbRecebimentos.getSelectedRow() != -1) {
            if (recebimentos.get(tbRecebimentos.getSelectedRow()).getStatusRecebimento()) {
                recebimentos.get(tbRecebimentos.getSelectedRow()).setStatusRecebimento(false);
            } else {
                recebimentos.get(tbRecebimentos.getSelectedRow()).setStatusRecebimento(true);
            }
            atualizarTabelas();
            calcularValores();
            calcularPagamento();
            calcularTroco();
        }
    }//GEN-LAST:event_tbRecebimentosMouseClicked

    private void rbAPrazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAPrazoActionPerformed
       if (rbAPrazo.isSelected()) {
            pnAPrazo.setVisible(true);
            atualizarPagina();
        }
    }//GEN-LAST:event_rbAPrazoActionPerformed

    private void btnNovoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoItemActionPerformed
        viewItem = new TelaItemVenda(this, itens);
        viewItem.setVisible(true);
    }//GEN-LAST:event_btnNovoItemActionPerformed

    private void btnAlterarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarItemActionPerformed
        if (tbItens.getSelectedRow() != -1) {
            viewItem = new TelaItemVenda(this, itens.get(tbItens.getSelectedRow()), true);
            viewItem.setVisible(true);
        }
    }//GEN-LAST:event_btnAlterarItemActionPerformed

    private void btnExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirItemActionPerformed
        if (tbItens.getSelectedRow() != -1) {
            itens.remove(tbItens.getSelectedRow());
            atualizarPagina();
        }
    }//GEN-LAST:event_btnExcluirItemActionPerformed

    private void cbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClienteActionPerformed
        
    }//GEN-LAST:event_cbClienteActionPerformed

    private void btnFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarVendaActionPerformed
        btnFinalizarVenda.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (tbItens.getModel().getRowCount() > 0) {
            if (vendaBO.finalizarVenda(cbCliente.getSelectedIndex(), tfTotalVenda.getText(), sldParcelas.getValue(), null, itens)) {
                viewEstoque.atualizarTabelas();
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Insira itens para a venda primeiro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnFinalizarVenda.setEnabled(true);
    }//GEN-LAST:event_btnFinalizarVendaActionPerformed

    private void btnAlterarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarVendaActionPerformed
        btnAlterarVenda.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnAlterarVenda.setEnabled(true);
        
        if (vendaBO.validarCampos(pnCliente)) {
            if (vendaBO.alterarVenda(vendaVO.getIdVenda(),cbCliente.getSelectedIndex(), tfTotalVenda.getText(), sldParcelas.getValue(), null, itens)) {
                viewEstoque.atualizarTabelas();
                this.dispose();
            }
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnAlterarVenda.setEnabled(true);
    }//GEN-LAST:event_btnAlterarVendaActionPerformed

    private void rbAVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAVistaActionPerformed
       if (rbAVista.isSelected()) {
            pnAPrazo.setVisible(false);
            pnAVista.setVisible(true);
            atualizarPagina();
        }
    }//GEN-LAST:event_rbAVistaActionPerformed

    private void tbItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbItensMouseClicked
        if (tbItens.getSelectedRow() != -1) {
            btnAlterarItem.setEnabled(true);
            btnExcluirItem.setEnabled(true);
        }
    }//GEN-LAST:event_tbItensMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarItem;
    private javax.swing.JButton btnAlterarVenda;
    private javax.swing.JButton btnExcluirItem;
    private javax.swing.JButton btnFinalizarVenda;
    private javax.swing.JButton btnNovoItem;
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JComboBox<String> cbVencimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel pnCliente;
    private javax.swing.JPanel pnCorpo;
    private javax.swing.JPanel pnPagamento;
    private javax.swing.JPanel pnPedido;
    private javax.swing.JRadioButton rbAPrazo;
    private javax.swing.JRadioButton rbAVista;
    private javax.swing.JSlider sldParcelas;
    private javax.swing.JTable tbItens;
    private javax.swing.JTable tbRecebimentos;
    private javax.swing.JFormattedTextField tfTotalAVista;
    private javax.swing.JFormattedTextField tfTotalPago;
    private javax.swing.JFormattedTextField tfTotalVenda;
    private javax.swing.JFormattedTextField tfTroco;
    private javax.swing.JFormattedTextField tfValorProdutos;
    private javax.swing.JLabel tfVencimento;
    // End of variables declaration//GEN-END:variables
}

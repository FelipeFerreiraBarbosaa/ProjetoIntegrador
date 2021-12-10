
package projetointegrador.apresentacao;

import java.awt.Color;
import java.awt.Font;
import projetointegrador.persistencia.PainelControleDAO;
import projetointegrador.tableModel.TableModelCategoria;
import projetointegrador.tableModel.TableModelCliente;
import projetointegrador.tableModel.TableModelFornecedor;
import projetointegrador.tableModel.TableModelProduto;

/**
 *
 * @author Felipe
 */
public class TelaDeControle extends javax.swing.JInternalFrame {

    private CadastroCliente viewCliente;
    private CadastroFornecedor viewFornecedor;
    private CadastroCategoria viewCategoria;
    private CadastroProduto viewProduto;    
    private PainelControleDAO painelControleBO;
    private TableModelCliente tabelaCliente;
    private TableModelFornecedor tabelaFornecedor;
    private TableModelProduto tabelaProduto;
    private TableModelCategoria tabelaCategoria;
    
    public TelaDeControle() {
        initComponents();
        atualizarTabelas();
    }
    
    public final void atualizarTabelas() {
               //Inicialização dos modelos de tabelas.
        painelControleBO = new PainelControleDAO();
        
        tabelaCliente = new TableModelCliente(painelControleBO.buscarClientes());
        tabelaFornecedor = new TableModelFornecedor(painelControleBO.buscarFornecedores());
        tabelaProduto = new TableModelProduto(painelControleBO.buscarProdutos());
        tabelaCategoria = new TableModelCategoria(painelControleBO.buscarCategorias());

        //Definindo modelo de tabelas para as tabelas.
        
        tbCliente.setModel(tabelaCliente);
        tbFornecedor.setModel(tabelaFornecedor);
        tbProdutos.setModel(tabelaProduto);
        tbCategorias.setModel(tabelaCategoria);

        //Definir tabelas como sem seleção.
        tbCliente.clearSelection();
        tbFornecedor.clearSelection();
        tbProdutos.clearSelection();
        tbCategorias.clearSelection();

        //Definindo botões Aleterar e Excluir como não habilitado.
        btnVisualizarCliente.setEnabled(false);
        btnEditarCliente.setEnabled(false);
        btnExcluirCliente.setEnabled(false);
        btnVisualizarFornecedor.setEnabled(false);
        btnEditarFornecedor.setEnabled(false);
        btnExcluirFornecedor.setEnabled(false);
        btnVisualizarProduto.setEnabled(false);
        btnEditarProduto.setEnabled(false);
        btnExcluirProduto.setEnabled(false);
        btnVisualizarCategoria.setEnabled(false);
        btnEditarCategoria.setEnabled(false);
        btnExcluirCategoria.setEnabled(false);
        
        //Definindo lbResultados
        lbResultadosFornecedores.setText(tbFornecedor.getModel().getRowCount()+" resultados, mostrando todos.");
        lbResultadosClientes.setText(tbCliente.getModel().getRowCount()+" resultados, mostrando todos.");
        lbResultadosProdutos.setText(tbProdutos.getModel().getRowCount()+" resultados, mostrando todos.");
        lbResultadosCategorias.setText(tbCategorias.getModel().getRowCount()+" resultados, mostrando todos.");
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        tpnCorpo = new javax.swing.JTabbedPane();
        paneFornecedor = new javax.swing.JPanel();
        btnNovoFornecedor = new javax.swing.JButton();
        btnExcluirFornecedor = new javax.swing.JButton();
        btnEditarFornecedor = new javax.swing.JButton();
        btnVisualizarFornecedor = new javax.swing.JButton();
        tfBuscarFornecedor = new javax.swing.JTextField();
        btnBuscarFornecedor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFornecedor = new javax.swing.JTable();
        lbResultadosFornecedores = new javax.swing.JLabel();
        paneCliente = new javax.swing.JPanel();
        btnNovoCliente = new javax.swing.JButton();
        btnExcluirCliente = new javax.swing.JButton();
        btnVisualizarCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        tfBuscarCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        lbResultadosClientes = new javax.swing.JLabel();
        paneProduto = new javax.swing.JPanel();
        btnNovoProduto = new javax.swing.JButton();
        btnExcluirProduto = new javax.swing.JButton();
        btnVisualizarProduto = new javax.swing.JButton();
        btnEditarProduto = new javax.swing.JButton();
        tfBuscarProduto = new javax.swing.JTextField();
        btnBuscarProduto = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        lbResultadosProdutos = new javax.swing.JLabel();
        paneCategoria = new javax.swing.JPanel();
        btnNovaCategoria = new javax.swing.JButton();
        btnExcluirCategoria = new javax.swing.JButton();
        btnVisualizarCategoria = new javax.swing.JButton();
        btnEditarCategoria = new javax.swing.JButton();
        tfBuscarCategoria = new javax.swing.JTextField();
        btnBuscarCategoria = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbCategorias = new javax.swing.JTable();
        lbResultadosCategorias = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Controle");
        setFocusable(false);

        tpnCorpo.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tpnCorpo.setFocusable(false);
        tpnCorpo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tpnCorpo.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tpnCorpoAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        btnNovoFornecedor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnNovoFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/novo.png"))); // NOI18N
        btnNovoFornecedor.setText("Novo Fornecedor");
        btnNovoFornecedor.setContentAreaFilled(false);
        btnNovoFornecedor.setDefaultCapable(false);
        btnNovoFornecedor.setFocusable(false);
        btnNovoFornecedor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNovoFornecedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovoFornecedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovoFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoFornecedorActionPerformed(evt);
            }
        });

        btnExcluirFornecedor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnExcluirFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/excluir.png"))); // NOI18N
        btnExcluirFornecedor.setText("Excluir Fornecedor ");
        btnExcluirFornecedor.setContentAreaFilled(false);
        btnExcluirFornecedor.setDefaultCapable(false);
        btnExcluirFornecedor.setFocusable(false);
        btnExcluirFornecedor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExcluirFornecedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluirFornecedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluirFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirFornecedorActionPerformed(evt);
            }
        });

        btnEditarFornecedor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEditarFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/salvar.png"))); // NOI18N
        btnEditarFornecedor.setText("Editar");
        btnEditarFornecedor.setContentAreaFilled(false);
        btnEditarFornecedor.setDefaultCapable(false);
        btnEditarFornecedor.setFocusable(false);
        btnEditarFornecedor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEditarFornecedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditarFornecedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarFornecedorActionPerformed(evt);
            }
        });

        btnVisualizarFornecedor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnVisualizarFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/buscar-foco.png"))); // NOI18N
        btnVisualizarFornecedor.setText("Visualizar");
        btnVisualizarFornecedor.setContentAreaFilled(false);
        btnVisualizarFornecedor.setDefaultCapable(false);
        btnVisualizarFornecedor.setFocusable(false);
        btnVisualizarFornecedor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVisualizarFornecedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVisualizarFornecedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVisualizarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarFornecedorActionPerformed(evt);
            }
        });

        tfBuscarFornecedor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfBuscarFornecedor.setText("Pesquisar");
        tfBuscarFornecedor.setCaretPosition(8);

        btnBuscarFornecedor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuscarFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/buscar-foco.png"))); // NOI18N
        btnBuscarFornecedor.setText("Buscar");

        tbFornecedor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbFornecedor.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tbFornecedor.setRowHeight(30);
        tbFornecedor.setShowVerticalLines(false);
        tbFornecedor.getTableHeader().setReorderingAllowed(false);
        tbFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFornecedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbFornecedor);
        cabecalho = tbFornecedor.getTableHeader();
        cabecalho.setFont(new Font("Arial", Font.PLAIN, 12));
        cabecalho.setForeground(new Color(102,102,102));

        lbResultadosFornecedores.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbResultadosFornecedores.setForeground(new java.awt.Color(102, 102, 102));
        lbResultadosFornecedores.setText("0 resultados, mostrando todos.");

        javax.swing.GroupLayout paneFornecedorLayout = new javax.swing.GroupLayout(paneFornecedor);
        paneFornecedor.setLayout(paneFornecedorLayout);
        paneFornecedorLayout.setHorizontalGroup(
            paneFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(paneFornecedorLayout.createSequentialGroup()
                        .addGroup(paneFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneFornecedorLayout.createSequentialGroup()
                                .addComponent(btnNovoFornecedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluirFornecedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVisualizarFornecedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditarFornecedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfBuscarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarFornecedor))
                            .addComponent(lbResultadosFornecedores))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );
        paneFornecedorLayout.setVerticalGroup(
            paneFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneFornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcluirFornecedor)
                    .addComponent(btnEditarFornecedor)
                    .addComponent(btnVisualizarFornecedor)
                    .addComponent(btnNovoFornecedor)
                    .addGroup(paneFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfBuscarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lbResultadosFornecedores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpnCorpo.addTab("Fornecedor", paneFornecedor);

        btnNovoCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnNovoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/novo.png"))); // NOI18N
        btnNovoCliente.setText("Novo Cliente");
        btnNovoCliente.setContentAreaFilled(false);
        btnNovoCliente.setDefaultCapable(false);
        btnNovoCliente.setFocusable(false);
        btnNovoCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNovoCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovoCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoClienteActionPerformed(evt);
            }
        });

        btnExcluirCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnExcluirCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/excluir.png"))); // NOI18N
        btnExcluirCliente.setText("Excluir Cliente");
        btnExcluirCliente.setContentAreaFilled(false);
        btnExcluirCliente.setDefaultCapable(false);
        btnExcluirCliente.setFocusable(false);
        btnExcluirCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExcluirCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluirCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirClienteActionPerformed(evt);
            }
        });

        btnVisualizarCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnVisualizarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/buscar-foco.png"))); // NOI18N
        btnVisualizarCliente.setText("Visualizar");
        btnVisualizarCliente.setContentAreaFilled(false);
        btnVisualizarCliente.setDefaultCapable(false);
        btnVisualizarCliente.setFocusable(false);
        btnVisualizarCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVisualizarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVisualizarCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVisualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarClienteActionPerformed(evt);
            }
        });

        btnEditarCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEditarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/salvar.png"))); // NOI18N
        btnEditarCliente.setText("Editar");
        btnEditarCliente.setContentAreaFilled(false);
        btnEditarCliente.setDefaultCapable(false);
        btnEditarCliente.setFocusable(false);
        btnEditarCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEditarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditarCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });

        tfBuscarCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfBuscarCliente.setText("Pesquisar");
        tfBuscarCliente.setCaretPosition(8);

        btnBuscarCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/buscar-foco.png"))); // NOI18N
        btnBuscarCliente.setText("Buscar");

        tbCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbCliente.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tbCliente.setRowHeight(30);
        tbCliente.setShowVerticalLines(false);
        tbCliente.getTableHeader().setReorderingAllowed(false);
        tbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbCliente);
        cabecalho = tbCliente.getTableHeader();
        cabecalho.setFont(new Font("Arial", Font.PLAIN, 12));
        cabecalho.setForeground(new Color(102,102,102));

        lbResultadosClientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbResultadosClientes.setForeground(new java.awt.Color(102, 102, 102));
        lbResultadosClientes.setText("0 resultados, mostrando todos.");

        javax.swing.GroupLayout paneClienteLayout = new javax.swing.GroupLayout(paneCliente);
        paneCliente.setLayout(paneClienteLayout);
        paneClienteLayout.setHorizontalGroup(
            paneClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneClienteLayout.createSequentialGroup()
                        .addComponent(btnNovoCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluirCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVisualizarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(tfBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarCliente)
                        .addGap(23, 23, 23))
                    .addGroup(paneClienteLayout.createSequentialGroup()
                        .addComponent(lbResultadosClientes)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneClienteLayout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())))
        );
        paneClienteLayout.setVerticalGroup(
            paneClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneClienteLayout.createSequentialGroup()
                .addGroup(paneClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(paneClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNovoCliente)
                            .addComponent(btnExcluirCliente)
                            .addComponent(btnVisualizarCliente)
                            .addComponent(btnEditarCliente)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneClienteLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(paneClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(lbResultadosClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tpnCorpo.addTab("Cliente", paneCliente);

        btnNovoProduto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnNovoProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/novo.png"))); // NOI18N
        btnNovoProduto.setText("Novo Produto");
        btnNovoProduto.setContentAreaFilled(false);
        btnNovoProduto.setDefaultCapable(false);
        btnNovoProduto.setFocusable(false);
        btnNovoProduto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNovoProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovoProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProdutoActionPerformed(evt);
            }
        });

        btnExcluirProduto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnExcluirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/excluir.png"))); // NOI18N
        btnExcluirProduto.setText("Excluir Produto");
        btnExcluirProduto.setContentAreaFilled(false);
        btnExcluirProduto.setDefaultCapable(false);
        btnExcluirProduto.setFocusable(false);
        btnExcluirProduto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExcluirProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluirProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirProdutoActionPerformed(evt);
            }
        });

        btnVisualizarProduto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnVisualizarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/buscar-foco.png"))); // NOI18N
        btnVisualizarProduto.setText("Visualizar");
        btnVisualizarProduto.setContentAreaFilled(false);
        btnVisualizarProduto.setDefaultCapable(false);
        btnVisualizarProduto.setFocusable(false);
        btnVisualizarProduto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVisualizarProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVisualizarProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVisualizarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarProdutoActionPerformed(evt);
            }
        });

        btnEditarProduto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEditarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/salvar.png"))); // NOI18N
        btnEditarProduto.setText("Editar");
        btnEditarProduto.setContentAreaFilled(false);
        btnEditarProduto.setDefaultCapable(false);
        btnEditarProduto.setFocusable(false);
        btnEditarProduto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEditarProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditarProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProdutoActionPerformed(evt);
            }
        });

        tfBuscarProduto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfBuscarProduto.setText("Pesquisar");
        tfBuscarProduto.setCaretPosition(8);

        btnBuscarProduto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuscarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/buscar-foco.png"))); // NOI18N
        btnBuscarProduto.setText("Buscar");

        tbProdutos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbProdutos.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tbProdutos.setRowHeight(30);
        tbProdutos.setShowVerticalLines(false);
        tbProdutos.getTableHeader().setReorderingAllowed(false);
        tbProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProdutosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbProdutos);
        cabecalho = tbProdutos.getTableHeader();
        cabecalho.setFont(new Font("Arial", Font.PLAIN, 12));
        cabecalho.setForeground(new Color(102,102,102));

        lbResultadosProdutos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbResultadosProdutos.setForeground(new java.awt.Color(102, 102, 102));
        lbResultadosProdutos.setText("0 resultados, mostrando todos.");

        javax.swing.GroupLayout paneProdutoLayout = new javax.swing.GroupLayout(paneProduto);
        paneProduto.setLayout(paneProdutoLayout);
        paneProdutoLayout.setHorizontalGroup(
            paneProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(paneProdutoLayout.createSequentialGroup()
                        .addGroup(paneProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneProdutoLayout.createSequentialGroup()
                                .addComponent(btnNovoProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluirProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVisualizarProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditarProduto)
                                .addGap(18, 18, 18)
                                .addComponent(tfBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarProduto))
                            .addComponent(lbResultadosProdutos))
                        .addGap(0, 43, Short.MAX_VALUE)))
                .addContainerGap())
        );
        paneProdutoLayout.setVerticalGroup(
            paneProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditarProduto)
                    .addComponent(btnVisualizarProduto)
                    .addComponent(btnExcluirProduto)
                    .addComponent(btnNovoProduto)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbResultadosProdutos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tpnCorpo.addTab("Produto", paneProduto);

        btnNovaCategoria.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnNovaCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/novo.png"))); // NOI18N
        btnNovaCategoria.setText("Nova Categoria");
        btnNovaCategoria.setContentAreaFilled(false);
        btnNovaCategoria.setDefaultCapable(false);
        btnNovaCategoria.setFocusable(false);
        btnNovaCategoria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNovaCategoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovaCategoria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaCategoriaActionPerformed(evt);
            }
        });

        btnExcluirCategoria.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnExcluirCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/excluir.png"))); // NOI18N
        btnExcluirCategoria.setText("Excluir Categoria");
        btnExcluirCategoria.setContentAreaFilled(false);
        btnExcluirCategoria.setDefaultCapable(false);
        btnExcluirCategoria.setFocusable(false);
        btnExcluirCategoria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExcluirCategoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluirCategoria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluirCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirCategoriaActionPerformed(evt);
            }
        });

        btnVisualizarCategoria.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnVisualizarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/buscar-foco.png"))); // NOI18N
        btnVisualizarCategoria.setText("Visualizar");
        btnVisualizarCategoria.setContentAreaFilled(false);
        btnVisualizarCategoria.setDefaultCapable(false);
        btnVisualizarCategoria.setFocusable(false);
        btnVisualizarCategoria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVisualizarCategoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVisualizarCategoria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVisualizarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarCategoriaActionPerformed(evt);
            }
        });

        btnEditarCategoria.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEditarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/salvar.png"))); // NOI18N
        btnEditarCategoria.setText("Editar");
        btnEditarCategoria.setContentAreaFilled(false);
        btnEditarCategoria.setDefaultCapable(false);
        btnEditarCategoria.setFocusable(false);
        btnEditarCategoria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEditarCategoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditarCategoria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCategoriaActionPerformed(evt);
            }
        });

        tfBuscarCategoria.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tfBuscarCategoria.setText("Pesquisar");
        tfBuscarCategoria.setCaretPosition(8);

        btnBuscarCategoria.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuscarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/buscar-foco.png"))); // NOI18N
        btnBuscarCategoria.setText("Buscar");

        tbCategorias.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbCategorias.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tbCategorias.setRowHeight(30);
        tbCategorias.setShowVerticalLines(false);
        tbCategorias.getTableHeader().setReorderingAllowed(false);
        tbCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCategoriasMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbCategorias);
        cabecalho = tbCategorias.getTableHeader();
        cabecalho.setFont(new Font("Arial", Font.PLAIN, 12));
        cabecalho.setForeground(new Color(102,102,102));

        lbResultadosCategorias.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbResultadosCategorias.setForeground(new java.awt.Color(102, 102, 102));
        lbResultadosCategorias.setText("0 resultados, mostrando todos.");

        javax.swing.GroupLayout paneCategoriaLayout = new javax.swing.GroupLayout(paneCategoria);
        paneCategoria.setLayout(paneCategoriaLayout);
        paneCategoriaLayout.setHorizontalGroup(
            paneCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(paneCategoriaLayout.createSequentialGroup()
                        .addGroup(paneCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneCategoriaLayout.createSequentialGroup()
                                .addComponent(btnNovaCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluirCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVisualizarCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditarCategoria)
                                .addGap(18, 18, 18)
                                .addComponent(tfBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarCategoria))
                            .addComponent(lbResultadosCategorias))
                        .addGap(0, 23, Short.MAX_VALUE)))
                .addContainerGap())
        );
        paneCategoriaLayout.setVerticalGroup(
            paneCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paneCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnEditarCategoria)
                        .addComponent(btnVisualizarCategoria)
                        .addComponent(btnExcluirCategoria)
                        .addComponent(btnNovaCategoria)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(lbResultadosCategorias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tpnCorpo.addTab("Categoria", paneCategoria);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpnCorpo)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpnCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoClienteActionPerformed
        viewCliente = new CadastroCliente(this);
        viewCliente.setVisible(true);
    }//GEN-LAST:event_btnNovoClienteActionPerformed

    private void btnNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProdutoActionPerformed
        viewProduto = new CadastroProduto(this);
        viewProduto.setVisible(true);
    }//GEN-LAST:event_btnNovoProdutoActionPerformed

    private void btnNovaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaCategoriaActionPerformed
        viewCategoria = new CadastroCategoria(this);
        viewCategoria.setVisible(true);
    }//GEN-LAST:event_btnNovaCategoriaActionPerformed

    private void btnVisualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarClienteActionPerformed
        if (tbCliente.getSelectedRow() != -1) {
            TableModelCliente modelo = (TableModelCliente) tbCliente.getModel();
            viewCliente = new CadastroCliente(this, modelo.getCliente(tbCliente.getSelectedRow()), false);
            viewCliente.setVisible(true);
        }
    }//GEN-LAST:event_btnVisualizarClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        if (tbCliente.getSelectedRow() != -1) {
            TableModelCliente modelo = (TableModelCliente) tbCliente.getModel();
            viewCliente = new CadastroCliente(this, modelo.getCliente(tbCliente.getSelectedRow()), true);
            viewCliente.setVisible(true);
        }
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void btnExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirClienteActionPerformed
         if (tbCliente.getSelectedRow() != -1) {
            TableModelCliente modelo = (TableModelCliente) tbCliente.getModel();
            if (painelControleBO.excluirCliente(modelo.getCliente(tbCliente.getSelectedRow()).getIdCliente())) {
                atualizarTabelas();
            }
        }
    }//GEN-LAST:event_btnExcluirClienteActionPerformed

    private void btnNovoFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoFornecedorActionPerformed
        viewFornecedor = new CadastroFornecedor(this);
        viewFornecedor.setVisible(true);
    }//GEN-LAST:event_btnNovoFornecedorActionPerformed

    private void tbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClienteMouseClicked
        if (tbCliente.getSelectedRow() != -1) {
            btnVisualizarCliente.setEnabled(true);
            btnEditarCliente.setEnabled(true);
            btnExcluirCliente.setEnabled(true);
        }
    }//GEN-LAST:event_tbClienteMouseClicked

    private void btnExcluirFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirFornecedorActionPerformed
       if (tbFornecedor.getSelectedRow() != -1) {
            TableModelFornecedor modelo = (TableModelFornecedor) tbFornecedor.getModel();
            if (painelControleBO.excluirFornecedor(modelo.getFornecedor(tbFornecedor.getSelectedRow()).getIdFornecedor())) {
                atualizarTabelas();
            }
        }
    }//GEN-LAST:event_btnExcluirFornecedorActionPerformed

    private void btnVisualizarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarFornecedorActionPerformed
         if (tbFornecedor.getSelectedRow() != -1) {
            TableModelFornecedor modelo = (TableModelFornecedor) tbFornecedor.getModel();
            viewFornecedor = new CadastroFornecedor(this, modelo.getFornecedor(tbFornecedor.getSelectedRow()), false);
            viewFornecedor.setVisible(true);
        }
    }//GEN-LAST:event_btnVisualizarFornecedorActionPerformed

    private void btnEditarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarFornecedorActionPerformed
        if (tbFornecedor.getSelectedRow() != -1) {
            TableModelFornecedor modelo = (TableModelFornecedor) tbFornecedor.getModel();
            viewFornecedor = new CadastroFornecedor(this, modelo.getFornecedor(tbFornecedor.getSelectedRow()), true);
            viewFornecedor.setVisible(true);
        }
    }//GEN-LAST:event_btnEditarFornecedorActionPerformed

    private void tbFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFornecedorMouseClicked
         if (tbFornecedor.getSelectedRow() != -1) {
            btnVisualizarFornecedor.setEnabled(true);
            btnEditarFornecedor.setEnabled(true);
            btnExcluirFornecedor.setEnabled(true);
        }
    }//GEN-LAST:event_tbFornecedorMouseClicked

    private void tbProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProdutosMouseClicked
       if (tbProdutos.getSelectedRow() != -1) {
            btnVisualizarProduto.setEnabled(true);
            btnEditarProduto.setEnabled(true);
            btnExcluirProduto.setEnabled(true);
        }
    }//GEN-LAST:event_tbProdutosMouseClicked

    private void tbCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCategoriasMouseClicked
        if (tbCategorias.getSelectedRow() != -1) {
            btnVisualizarCategoria.setEnabled(true);
            btnEditarCategoria.setEnabled(true);
            btnExcluirCategoria.setEnabled(true);
        }
    }//GEN-LAST:event_tbCategoriasMouseClicked

    private void btnExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirProdutoActionPerformed
       if (tbProdutos.getSelectedRow() != -1) {
            TableModelProduto modelo = (TableModelProduto) tbProdutos.getModel();
            if (painelControleBO.excluirProduto(modelo.getProduto(tbProdutos.getSelectedRow()).getIdProduto())) {
                atualizarTabelas();
            }
        }
    }//GEN-LAST:event_btnExcluirProdutoActionPerformed

    private void btnVisualizarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarProdutoActionPerformed
       if (tbProdutos.getSelectedRow() != -1) {
            TableModelProduto modelo = (TableModelProduto) tbProdutos.getModel();
            viewProduto = new CadastroProduto(this, modelo.getProduto(tbProdutos.getSelectedRow()), false);
            viewProduto.setVisible(true);
        }
    }//GEN-LAST:event_btnVisualizarProdutoActionPerformed

    private void btnEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProdutoActionPerformed
        if (tbProdutos.getSelectedRow() != -1) {
            TableModelProduto modelo = (TableModelProduto) tbProdutos.getModel();
            viewProduto = new CadastroProduto(this, modelo.getProduto(tbProdutos.getSelectedRow()), true);
            viewProduto.setVisible(true);
        }
    }//GEN-LAST:event_btnEditarProdutoActionPerformed

    private void btnExcluirCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirCategoriaActionPerformed
         if (tbCategorias.getSelectedRow() != -1) {
            TableModelCategoria modelo = (TableModelCategoria) tbCategorias.getModel();
            if (painelControleBO.excluirCategoria(modelo.getCategoria(tbCategorias.getSelectedRow()).getIdCategoria())) {
                atualizarTabelas();
            }
        }
    }//GEN-LAST:event_btnExcluirCategoriaActionPerformed

    private void btnEditarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCategoriaActionPerformed
        if (tbCategorias.getSelectedRow() != -1) {
            TableModelCategoria modelo = (TableModelCategoria) tbCategorias.getModel();
            viewCategoria = new CadastroCategoria(this, modelo.getCategoria(tbCategorias.getSelectedRow()), true);
            viewCategoria.setVisible(true);
        }
    }//GEN-LAST:event_btnEditarCategoriaActionPerformed

    private void btnVisualizarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarCategoriaActionPerformed
        if (tbCategorias.getSelectedRow() != -1) {
            TableModelCategoria modelo = (TableModelCategoria) tbCategorias.getModel();
            viewCategoria = new CadastroCategoria(this, modelo.getCategoria(tbCategorias.getSelectedRow()), false);
            viewCategoria.setVisible(true);
        }
    }//GEN-LAST:event_btnVisualizarCategoriaActionPerformed

    private void tpnCorpoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tpnCorpoAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tpnCorpoAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCategoria;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarFornecedor;
    private javax.swing.JButton btnBuscarProduto;
    private javax.swing.JButton btnEditarCategoria;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEditarFornecedor;
    private javax.swing.JButton btnEditarProduto;
    private javax.swing.JButton btnExcluirCategoria;
    private javax.swing.JButton btnExcluirCliente;
    private javax.swing.JButton btnExcluirFornecedor;
    private javax.swing.JButton btnExcluirProduto;
    private javax.swing.JButton btnNovaCategoria;
    private javax.swing.JButton btnNovoCliente;
    private javax.swing.JButton btnNovoFornecedor;
    private javax.swing.JButton btnNovoProduto;
    private javax.swing.JButton btnVisualizarCategoria;
    private javax.swing.JButton btnVisualizarCliente;
    private javax.swing.JButton btnVisualizarFornecedor;
    private javax.swing.JButton btnVisualizarProduto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbResultadosCategorias;
    private javax.swing.JLabel lbResultadosClientes;
    private javax.swing.JLabel lbResultadosFornecedores;
    private javax.swing.JLabel lbResultadosProdutos;
    private javax.swing.JPanel paneCategoria;
    private javax.swing.JPanel paneCliente;
    private javax.swing.JPanel paneFornecedor;
    private javax.swing.JPanel paneProduto;
    private javax.swing.JTable tbCategorias;
    private javax.swing.JTable tbCliente;
    private javax.swing.JTable tbFornecedor;
    private javax.swing.table.JTableHeader cabecalho;
    private javax.swing.JTable tbProdutos;
    private javax.swing.JTextField tfBuscarCategoria;
    private javax.swing.JTextField tfBuscarCliente;
    private javax.swing.JTextField tfBuscarFornecedor;
    private javax.swing.JTextField tfBuscarProduto;
    private javax.swing.JTabbedPane tpnCorpo;
    // End of variables declaration//GEN-END:variables
}

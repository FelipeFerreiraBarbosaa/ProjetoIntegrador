
package projetointegrador.apresentacao;

import projetointegrador.negocio.Usuario;
import projetointegrador.persistencia.DataBaseException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import projetointegrador.HibernateUtil;
import projetointegrador.apresentacao.CadastroProduto;
import projetointegrador.negocio.Principal;
import projetointegrador.reports.Report;
import projetointegrador.reports.ReportManager;




public class Menu extends javax.swing.JFrame {
    
    private Usuario atual;
    
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TelaLogin.class.getName());

    public Menu(Usuario atual) {
        initComponents();
        this.atual = atual;
        labelUsuarioAtual.setText("Usuario: "+atual.getUsuario());
        System.out.println(atual.getCargo_id().getNivelPerm()+"ok");
        
        Dashboards c = new Dashboards(this.atual);
        desktopPane.add(c);
        c.setVisible(true);        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        desktopPane = new javax.swing.JDesktopPane();
        btnTelaControle = new javax.swing.JToggleButton();
        btnTelaEstoque = new javax.swing.JToggleButton();
        labelUsuarioAtual = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JToggleButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuControle = new javax.swing.JMenuItem();
        menuEstoqu = new javax.swing.JMenu();
        menuEstoque = new javax.swing.JMenuItem();
        jMenuBotaoUsuarios = new javax.swing.JMenu();
        jMenuCadUsu = new javax.swing.JMenuItem();
        jMenuSetores = new javax.swing.JMenuItem();
        menuEditarUsu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuListagemCliente = new javax.swing.JMenuItem();
        menuListagemFornecedor = new javax.swing.JMenuItem();
        menuListagemProduto = new javax.swing.JMenuItem();
        menuListagemCompra = new javax.swing.JMenuItem();
        menuListagemVenda = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuRelatorioCliente = new javax.swing.JMenuItem();
        menuRelatorioFornecedor = new javax.swing.JMenuItem();
        menuRelatorioCompra = new javax.swing.JMenuItem();
        menuRelatorioVenda = new javax.swing.JMenuItem();
        menuRelatorioProduto = new javax.swing.JMenuItem();
        jMenuSistema = new javax.swing.JMenu();
        jMenuDashboard = new javax.swing.JMenuItem();
        jMenuLogsAudit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemLogOut = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        desktopPane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 896, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );

        btnTelaControle.setBackground(new java.awt.Color(0, 0, 0));
        btnTelaControle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnTelaControle.setForeground(new java.awt.Color(255, 255, 255));
        btnTelaControle.setText("Tela De Controle");
        btnTelaControle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaControleActionPerformed(evt);
            }
        });

        btnTelaEstoque.setBackground(new java.awt.Color(0, 0, 0));
        btnTelaEstoque.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnTelaEstoque.setForeground(new java.awt.Color(255, 255, 255));
        btnTelaEstoque.setText("Tela Estoque");
        btnTelaEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaEstoqueActionPerformed(evt);
            }
        });

        btnDashboard.setBackground(new java.awt.Color(0, 0, 0));
        btnDashboard.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard.setText("Dashboard");
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });

        jMenu1.setText("Controle");
        jMenu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        menuControle.setText("Tela de Controle");
        menuControle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuControleActionPerformed(evt);
            }
        });
        jMenu1.add(menuControle);

        jMenuBar1.add(jMenu1);

        menuEstoqu.setText("Estoque");
        menuEstoqu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        menuEstoqu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEstoquActionPerformed(evt);
            }
        });

        menuEstoque.setText("Tela Estoque");
        menuEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEstoqueActionPerformed(evt);
            }
        });
        menuEstoqu.add(menuEstoque);

        jMenuBar1.add(menuEstoqu);

        jMenuBotaoUsuarios.setText("Usuários");
        jMenuBotaoUsuarios.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jMenuBotaoUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuBotaoUsuariosActionPerformed(evt);
            }
        });

        jMenuCadUsu.setText("Cadastro de Usuários");
        jMenuCadUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadUsuActionPerformed(evt);
            }
        });
        jMenuBotaoUsuarios.add(jMenuCadUsu);

        jMenuSetores.setText("Cadastro de Setores");
        jMenuSetores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSetoresActionPerformed(evt);
            }
        });
        jMenuBotaoUsuarios.add(jMenuSetores);

        menuEditarUsu.setText("Editar Usuário");
        menuEditarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarUsuActionPerformed(evt);
            }
        });
        jMenuBotaoUsuarios.add(menuEditarUsu);

        jMenuBar1.add(jMenuBotaoUsuarios);

        jMenu3.setText("Impressoes");
        jMenu3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        menuListagemCliente.setText("Listagem de Clientes");
        menuListagemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListagemClienteActionPerformed(evt);
            }
        });
        jMenu3.add(menuListagemCliente);

        menuListagemFornecedor.setText("Listagem de Fornecedores");
        menuListagemFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListagemFornecedorActionPerformed(evt);
            }
        });
        jMenu3.add(menuListagemFornecedor);

        menuListagemProduto.setText("Listagem de Produtos");
        menuListagemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListagemProdutoActionPerformed(evt);
            }
        });
        jMenu3.add(menuListagemProduto);

        menuListagemCompra.setText("Listagem de Compras");
        menuListagemCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListagemCompraActionPerformed(evt);
            }
        });
        jMenu3.add(menuListagemCompra);

        menuListagemVenda.setText("Listagem de Vendas");
        menuListagemVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListagemVendaActionPerformed(evt);
            }
        });
        jMenu3.add(menuListagemVenda);
        jMenu3.add(jSeparator1);

        menuRelatorioCliente.setText("Relatório de Cliente");
        menuRelatorioCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioClienteActionPerformed(evt);
            }
        });
        jMenu3.add(menuRelatorioCliente);

        menuRelatorioFornecedor.setText("Relatório de Fornecedor");
        menuRelatorioFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioFornecedorActionPerformed(evt);
            }
        });
        jMenu3.add(menuRelatorioFornecedor);

        menuRelatorioCompra.setText("Relatório de Compra");
        menuRelatorioCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioCompraActionPerformed(evt);
            }
        });
        jMenu3.add(menuRelatorioCompra);

        menuRelatorioVenda.setText("Relatório de Venda");
        menuRelatorioVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioVendaActionPerformed(evt);
            }
        });
        jMenu3.add(menuRelatorioVenda);

        menuRelatorioProduto.setText("Relatório de Produto");
        menuRelatorioProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioProdutoActionPerformed(evt);
            }
        });
        jMenu3.add(menuRelatorioProduto);

        jMenuBar1.add(jMenu3);

        jMenuSistema.setText("Sistema");
        jMenuSistema.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jMenuDashboard.setText("Dashboard");
        jMenuDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuDashboardActionPerformed(evt);
            }
        });
        jMenuSistema.add(jMenuDashboard);

        jMenuLogsAudit.setText("Logs e Audits");
        jMenuLogsAudit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuLogsAuditActionPerformed(evt);
            }
        });
        jMenuSistema.add(jMenuLogsAudit);

        jMenuBar1.add(jMenuSistema);

        jMenu2.setText("Sair");
        jMenu2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        itemLogOut.setText("Log-out");
        itemLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLogOutActionPerformed(evt);
            }
        });
        jMenu2.add(itemLogOut);

        menuSair.setText("Sair do Sistema");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        jMenu2.add(menuSair);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(desktopPane)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTelaControle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTelaEstoque)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDashboard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelUsuarioAtual)
                        .addGap(168, 168, 168))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTelaControle)
                        .addComponent(btnTelaEstoque)
                        .addComponent(btnDashboard))
                    .addComponent(labelUsuarioAtual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktopPane)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTelaControleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaControleActionPerformed
        if (atual.getCargo_id().getNivelPerm() >= 2) {
            TelaDeControle tela = new TelaDeControle();
            desktopPane.add(tela);
            tela.setVisible(true);
        } else {
            msgErro1();
        }
    }//GEN-LAST:event_btnTelaControleActionPerformed

    private void btnTelaEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaEstoqueActionPerformed
        if (atual.getCargo_id().getNivelPerm() >= 1) {
            Estoque estoque = new Estoque();
            desktopPane.add(estoque);
            estoque.setVisible(true);
        } else {
            msgErro1();
        }
    }//GEN-LAST:event_btnTelaEstoqueActionPerformed

    private void menuEstoquActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEstoquActionPerformed
        
    }//GEN-LAST:event_menuEstoquActionPerformed

    private void menuControleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuControleActionPerformed
        
        if (atual.getCargo_id().getNivelPerm() >= 2) {
            TelaDeControle tela = new TelaDeControle();
            desktopPane.add(tela);
            tela.setVisible(true);
        } else {
            msgErro1();
        }
    }//GEN-LAST:event_menuControleActionPerformed

    private void menuEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEstoqueActionPerformed
        if (atual.getCargo_id().getNivelPerm() >= 1) {
            Estoque estoque = new Estoque();
            desktopPane.add(estoque);
            estoque.setVisible(true);
        } else {
            msgErro1();
        }
    }//GEN-LAST:event_menuEstoqueActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSairActionPerformed

    private void jMenuCadUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadUsuActionPerformed
        if (atual.getCargo_id().getNivelPerm() >= 3) {
        try {
            log.info("Entrou no cadastro de usuários");
            TelaCadastroUsuarios c = new TelaCadastroUsuarios(this.atual);
            desktopPane.add(c);
            c.setVisible(true);
        } catch (DataBaseException ex) {
            log.error("Erro ao acessar cadastro de usuários");
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        } else {
            msgErro1();
        }
    }//GEN-LAST:event_jMenuCadUsuActionPerformed

    private void jMenuSetoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSetoresActionPerformed
        if (atual.getCargo_id().getNivelPerm() >= 3) {
        try {
            log.info("Entrou no cadastro de setores");
            TelaCadastroCargo c = new TelaCadastroCargo();
            desktopPane.add(c);
            c.setVisible(true);
        } catch (DataBaseException ex) {
            log.error("Erro ao acessar cadastro de setores");
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        } else {
            msgErro1();
        }
    }//GEN-LAST:event_jMenuSetoresActionPerformed

    private void jMenuBotaoUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuBotaoUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuBotaoUsuariosActionPerformed

    private void itemLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLogOutActionPerformed
        
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_itemLogOutActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        
        Dashboards c = new Dashboards(this.atual);
        desktopPane.add(c);
        c.setVisible(true);
         
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void jMenuDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuDashboardActionPerformed
        Dashboards c = new Dashboards(this.atual);
        desktopPane.add(c);
        c.setVisible(true);
    }//GEN-LAST:event_jMenuDashboardActionPerformed

    private void jMenuLogsAuditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuLogsAuditActionPerformed
        
        TelaTabelaLogs c = null;
        try {
            c = new TelaTabelaLogs();
        } catch (DataBaseException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        desktopPane.add(c);
        c.setVisible(true);
        
    }//GEN-LAST:event_jMenuLogsAuditActionPerformed

    private void menuEditarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarUsuActionPerformed
        TelaEditarUsuario c;
        try {
            c = new TelaEditarUsuario(this.atual);
            desktopPane.add(c);
            c.setVisible(true);
            
        } catch (DataBaseException ex) {
            log.error("Erro ao acessar o menu editar");
        }
    }//GEN-LAST:event_menuEditarUsuActionPerformed

    private void menuListagemFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListagemFornecedorActionPerformed
         Report r = new Report()
        {
            @Override
            public HashMap getParameters()
            {
                return new HashMap();
            }

            @Override
            public String getPath()
            {
                return "/projetointegrador/reports/ListagemFornecedoresPI.jrxml";
            }
        };

        ReportManager rm = new ReportManager();
        try
        {
            rm.setDataBaseConnection(HibernateUtil.getConnection());
        } catch (Exception ex)
        {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rm.createReport(r);
        } catch (HibernateException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuListagemFornecedorActionPerformed

    private void menuListagemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListagemClienteActionPerformed
        Report r = new Report()
        {
            @Override
            public HashMap getParameters()
            {
                return new HashMap();
            }

            @Override
            public String getPath()
            {
                return "/projetointegrador/reports/ListagemClientesPI.jrxml";
            }
        };

        ReportManager rm = new ReportManager();
        try
        {
            rm.setDataBaseConnection(HibernateUtil.getConnection());
        } catch (Exception ex)
        {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rm.createReport(r);
        } catch (HibernateException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuListagemClienteActionPerformed

    private void menuListagemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListagemProdutoActionPerformed
       Report r = new Report()
        {
            @Override
            public HashMap getParameters()
            {
                return new HashMap();
            }

            @Override
            public String getPath()
            {
                return "/projetointegrador/reports/ListagemProdutosPI.jrxml";
            }
        };

        ReportManager rm = new ReportManager();
        try
        {
            rm.setDataBaseConnection(HibernateUtil.getConnection());
        } catch (Exception ex)
        {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rm.createReport(r);
        } catch (HibernateException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuListagemProdutoActionPerformed

    private void menuListagemCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListagemCompraActionPerformed
        Report r = new Report()
        {
            @Override
            public HashMap getParameters()
            {
                return new HashMap();
            }

            @Override
            public String getPath()
            {
                return "/projetointegrador/reports/ListagemComprasPI.jrxml";
            }
        };

        ReportManager rm = new ReportManager();
        try
        {
            rm.setDataBaseConnection(HibernateUtil.getConnection());
        } catch (Exception ex)
        {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rm.createReport(r);
        } catch (HibernateException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuListagemCompraActionPerformed

    private void menuListagemVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListagemVendaActionPerformed
        Report r = new Report()
        {
            @Override
            public HashMap getParameters()
            {
                return new HashMap();
            }

            @Override
            public String getPath()
            {
                return "/projetointegrador/reports/ListagemVendasPI.jrxml";
            }
        };

        ReportManager rm = new ReportManager();
        try
        {
            rm.setDataBaseConnection(HibernateUtil.getConnection());
        } catch (Exception ex)
        {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rm.createReport(r);
        } catch (HibernateException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuListagemVendaActionPerformed

    private void menuRelatorioClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioClienteActionPerformed
       TelaRelatorioCliente tela = new TelaRelatorioCliente();
       tela.setVisible(true);
    }//GEN-LAST:event_menuRelatorioClienteActionPerformed

    private void menuRelatorioFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioFornecedorActionPerformed
        TelaRelatorioFornecedor tela = new TelaRelatorioFornecedor();
        tela.setVisible(true);
    }//GEN-LAST:event_menuRelatorioFornecedorActionPerformed

    private void menuRelatorioCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioCompraActionPerformed
        TelaRelatorioCompra tela = new TelaRelatorioCompra();
        tela.setVisible(true);
    }//GEN-LAST:event_menuRelatorioCompraActionPerformed

    private void menuRelatorioVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioVendaActionPerformed
        TelaRelatorioVenda tela = new TelaRelatorioVenda();
        tela.setVisible(true);
    }//GEN-LAST:event_menuRelatorioVendaActionPerformed

    private void menuRelatorioProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioProdutoActionPerformed
       TelaRelatorioProduto tela = new TelaRelatorioProduto();
        tela.setVisible(true);
    }//GEN-LAST:event_menuRelatorioProdutoActionPerformed

    public void msgErro1 () {
        JOptionPane.showMessageDialog(null, "Você não possui acesso a este recurso, contate o administrador do sistema caso acredite ser um engano");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnDashboard;
    private javax.swing.JToggleButton btnTelaControle;
    private javax.swing.JToggleButton btnTelaEstoque;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem itemLogOut;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuBotaoUsuarios;
    private javax.swing.JMenuItem jMenuCadUsu;
    private javax.swing.JMenuItem jMenuDashboard;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuLogsAudit;
    private javax.swing.JMenuItem jMenuSetores;
    private javax.swing.JMenu jMenuSistema;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel labelUsuarioAtual;
    private javax.swing.JMenuItem menuControle;
    private javax.swing.JMenuItem menuEditarUsu;
    private javax.swing.JMenu menuEstoqu;
    private javax.swing.JMenuItem menuEstoque;
    private javax.swing.JMenuItem menuListagemCliente;
    private javax.swing.JMenuItem menuListagemCompra;
    private javax.swing.JMenuItem menuListagemFornecedor;
    private javax.swing.JMenuItem menuListagemProduto;
    private javax.swing.JMenuItem menuListagemVenda;
    private javax.swing.JMenuItem menuRelatorioCliente;
    private javax.swing.JMenuItem menuRelatorioCompra;
    private javax.swing.JMenuItem menuRelatorioFornecedor;
    private javax.swing.JMenuItem menuRelatorioProduto;
    private javax.swing.JMenuItem menuRelatorioVenda;
    private javax.swing.JMenuItem menuSair;
    // End of variables declaration//GEN-END:variables
}

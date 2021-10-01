
package projetointegrador.apresentacao;

import projetointegrador.persistencia.DataBaseException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetointegrador.apresentacao.CadastroProduto;


public class Menu extends javax.swing.JFrame {
    
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TelaLogin.class.getName());

    public Menu() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        btnCadastroProduto = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuProduto = new javax.swing.JMenuItem();
        jMenuSistema = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBotaoUsuarios = new javax.swing.JMenu();
        jMenuCadUsu = new javax.swing.JMenuItem();
        jMenuSetores = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        desktopPane.setBackground(new java.awt.Color(255, 255, 255));
        desktopPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );

        btnCadastroProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/produto.png"))); // NOI18N
        btnCadastroProduto.setText("Cadastro Produto");
        btnCadastroProduto.setBorderPainted(false);
        btnCadastroProduto.setContentAreaFilled(false);
        btnCadastroProduto.setDefaultCapable(false);
        btnCadastroProduto.setFocusable(false);
        btnCadastroProduto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCadastroProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadastroProduto.setMaximumSize(new java.awt.Dimension(53, 41));
        btnCadastroProduto.setMinimumSize(new java.awt.Dimension(63, 43));
        btnCadastroProduto.setPreferredSize(new java.awt.Dimension(63, 43));
        btnCadastroProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroProdutoActionPerformed(evt);
            }
        });

        jMenu1.setText("Cadastros");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuProduto.setText("Cadastro Produto");
        jMenuProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuProduto);

        jMenuBar1.add(jMenu1);

        jMenuSistema.setText("Sistema");
        jMenuSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSistemaActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Sair do Sistema");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuSistema.add(jMenuItem1);

        jMenuBar1.add(jMenuSistema);

        jMenuBotaoUsuarios.setText("Usuários");
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

        jMenuBar1.add(jMenuBotaoUsuarios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(desktopPane)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroProdutoActionPerformed
        try {
            log.info("Entrou no cadastro de produto");
            CadastroProduto c = new CadastroProduto();
            desktopPane.add(c);        
            c.setVisible(true);
        } catch (DataBaseException ex) {
            log.error("Erro ao acessar cadastro de produto");
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCadastroProdutoActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSistemaActionPerformed
  
    }//GEN-LAST:event_jMenuSistemaActionPerformed

    private void jMenuProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProdutoActionPerformed
        try {
            log.info("Entrou no cadastro de produto");
            CadastroProduto c = new CadastroProduto();
            desktopPane.add(c);        
            c.setVisible(true);
        } catch (DataBaseException ex) {
            log.error("Erro ao acessar cadastro de produto");
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuProdutoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        log.info("Fechou o sistema");
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuSetoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSetoresActionPerformed
        try {
            log.info("Entrou no cadastro de setores");
            TelaCadastroCargo c = new TelaCadastroCargo();
            desktopPane.add(c);        
            c.setVisible(true);
        } catch (DataBaseException ex) {
            log.error("Erro ao acessar cadastro de setores");
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuSetoresActionPerformed

    private void jMenuBotaoUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuBotaoUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuBotaoUsuariosActionPerformed

    private void jMenuCadUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadUsuActionPerformed
        try {
            log.info("Entrou no cadastro de usuários");
            TelaCadastroUsuarios c = new TelaCadastroUsuarios();
            desktopPane.add(c);        
            c.setVisible(true);
        } catch (DataBaseException ex) {
            log.error("Erro ao acessar cadastro de usuários");
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuCadUsuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastroProduto;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuBotaoUsuarios;
    private javax.swing.JMenuItem jMenuCadUsu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuProduto;
    private javax.swing.JMenuItem jMenuSetores;
    private javax.swing.JMenu jMenuSistema;
    // End of variables declaration//GEN-END:variables
}

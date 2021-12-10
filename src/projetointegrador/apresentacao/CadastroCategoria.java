
package projetointegrador.apresentacao;

import java.awt.Cursor;
import projetointegrador.negocio.Categoria;
import projetointegrador.persistencia.CategoriaDAO;

/**
 *
 * @author Felipe
 */
public class CadastroCategoria extends javax.swing.JDialog {
    
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TelaLogin.class.getName());

    private final TelaDeControle viewPainelControle;
    private Categoria categoriaVO;
    private CategoriaDAO categoriaBO;
    
    public CadastroCategoria(TelaDeControle viewPainelControle) {
        initComponents();
        this.viewPainelControle = viewPainelControle;
        btnEditarCategoria.setVisible(false);
    }
    
    public CadastroCategoria( TelaDeControle viewPainelControle, Categoria categoria, Boolean alterar) {
        initComponents();
        this.viewPainelControle = viewPainelControle;
        btnCadastrarCategoria.setVisible(false);
        this.categoriaVO = categoria;
        this.categoriaBO = new CategoriaDAO();
        btnCadastrarCategoria.setVisible(false);
        lbTitulo.setText("Alterar Categoria");
        tfDescricao.setText(categoriaVO.getDescricaoCategoria());

        if (!alterar) {
            lbTitulo.setText("Categoria");
            btnEditarCategoria.setVisible(false);
            tfDescricao.setEditable(false);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        pnCorpo = new javax.swing.JPanel();
        pnObrigatorio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JFormattedTextField();
        btnCadastrarCategoria = new javax.swing.JButton();
        btnEditarCategoria = new javax.swing.JButton();

        lbTitulo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbTitulo.setText("Nova Categoria");

        pnObrigatorio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Descrição");

        javax.swing.GroupLayout pnObrigatorioLayout = new javax.swing.GroupLayout(pnObrigatorio);
        pnObrigatorio.setLayout(pnObrigatorioLayout);
        pnObrigatorioLayout.setHorizontalGroup(
            pnObrigatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnObrigatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnObrigatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnObrigatorioLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tfDescricao))
                .addContainerGap())
        );
        pnObrigatorioLayout.setVerticalGroup(
            pnObrigatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnObrigatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btnCadastrarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/novo.png"))); // NOI18N
        btnCadastrarCategoria.setText("Cadastrar");
        btnCadastrarCategoria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCadastrarCategoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadastrarCategoria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCadastrarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarCategoriaActionPerformed(evt);
            }
        });

        btnEditarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetointegrador/resources/images/salvar.png"))); // NOI18N
        btnEditarCategoria.setText("Editar");
        btnEditarCategoria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEditarCategoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditarCategoria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCorpoLayout = new javax.swing.GroupLayout(pnCorpo);
        pnCorpo.setLayout(pnCorpoLayout);
        pnCorpoLayout.setHorizontalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnObrigatorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCorpoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastrarCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarCategoria)
                .addGap(16, 16, 16))
        );
        pnCorpoLayout.setVerticalGroup(
            pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCorpoLayout.createSequentialGroup()
                .addComponent(pnObrigatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnCorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarCategoria)
                    .addComponent(btnEditarCategoria))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTitulo)
                        .addGap(0, 391, Short.MAX_VALUE))
                    .addComponent(pnCorpo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarCategoriaActionPerformed
       btnCadastrarCategoria.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        categoriaBO = new CategoriaDAO();
        if (categoriaBO.validarCampos(pnCorpo)) {
            if (categoriaBO.inserirCategoria(tfDescricao.getText())) {
                viewPainelControle.atualizarTabelas();
                this.dispose();
            }
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnCadastrarCategoria.setEnabled(true);
    }//GEN-LAST:event_btnCadastrarCategoriaActionPerformed

    private void btnEditarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCategoriaActionPerformed
        btnCadastrarCategoria.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        categoriaBO = new CategoriaDAO();
        if (categoriaBO.validarCampos(pnCorpo)) {
            if (categoriaBO.alterarCategoria(categoriaVO.getIdCategoria(), tfDescricao.getText())) {
                viewPainelControle.atualizarTabelas();
                this.dispose();
            }
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        btnCadastrarCategoria.setEnabled(true);
    }//GEN-LAST:event_btnEditarCategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarCategoria;
    private javax.swing.JButton btnEditarCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel pnCorpo;
    private javax.swing.JPanel pnObrigatorio;
    private javax.swing.JFormattedTextField tfDescricao;
    // End of variables declaration//GEN-END:variables
}

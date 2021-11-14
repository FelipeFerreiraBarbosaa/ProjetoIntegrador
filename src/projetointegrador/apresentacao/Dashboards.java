/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetointegrador.apresentacao;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import projetointegrador.negocio.Itemvenda;
import projetointegrador.negocio.Meta;
import projetointegrador.negocio.Produto;
import projetointegrador.negocio.Usuario;
import projetointegrador.persistencia.DaoGenerico;

/**
 *
 * @author enzob
 */
public class Dashboards extends javax.swing.JInternalFrame {

    
    Usuario atual = new Usuario();
    float meta;
    
    Meta metaFaturamento = null;
    
    public Dashboards(Usuario atual) {
        initComponents();
        this.atual = atual;
        carregarDashMetas();
        carregarDashValores();
        
        pnFat.setVisible(false);
        pnProdBaixo.setVisible(false);
        
        if (atual.getCargo_id().getNivelPerm() >= 2) {
            pnProdBaixo.setVisible(true);
        } 
        if (atual.getCargo_id().getNivelPerm() >= 3) {
            pnFat.setVisible(true);
        }  
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        pnFat = new javax.swing.JPanel();
        labelFaturamento = new javax.swing.JLabel();
        labelMetaFaturamento = new javax.swing.JLabel();
        btnAlterarMetaFaturamento = new javax.swing.JButton();
        labelMetaFalta = new javax.swing.JLabel();
        labelFaturamentoPorcentagem = new javax.swing.JLabel();
        pnUsuInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelInfoNome = new javax.swing.JLabel();
        labelInfoCargo = new javax.swing.JLabel();
        labelInfoEmail = new javax.swing.JLabel();
        btAtualizar = new javax.swing.JButton();
        pnProdBaixo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textBaixoProd = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        pnFat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelFaturamento.setText("Faturamento:");

        labelMetaFaturamento.setText("Meta:");

        btnAlterarMetaFaturamento.setText("Alterar Meta");
        btnAlterarMetaFaturamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarMetaFaturamentoActionPerformed(evt);
            }
        });

        labelMetaFalta.setText("Restante:");

        labelFaturamentoPorcentagem.setText("Porcentagem:");

        javax.swing.GroupLayout pnFatLayout = new javax.swing.GroupLayout(pnFat);
        pnFat.setLayout(pnFatLayout);
        pnFatLayout.setHorizontalGroup(
            pnFatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFatLayout.createSequentialGroup()
                        .addGroup(pnFatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelMetaFaturamento)
                            .addComponent(labelFaturamento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addGroup(pnFatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelFaturamentoPorcentagem)
                            .addComponent(labelMetaFalta))
                        .addGap(44, 44, 44))
                    .addGroup(pnFatLayout.createSequentialGroup()
                        .addComponent(btnAlterarMetaFaturamento)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnFatLayout.setVerticalGroup(
            pnFatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFatLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnFatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFaturamento)
                    .addComponent(labelMetaFalta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnFatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetaFaturamento)
                    .addComponent(labelFaturamentoPorcentagem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnAlterarMetaFaturamento)
                .addGap(20, 20, 20))
        );

        pnUsuInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnUsuInfo.setPreferredSize(new java.awt.Dimension(338, 136));

        jLabel1.setText("Informações de usuário");

        labelInfoNome.setText("Nome:");

        labelInfoCargo.setText("Cargo:");

        labelInfoEmail.setText("E-mail:");

        javax.swing.GroupLayout pnUsuInfoLayout = new javax.swing.GroupLayout(pnUsuInfo);
        pnUsuInfo.setLayout(pnUsuInfoLayout);
        pnUsuInfoLayout.setHorizontalGroup(
            pnUsuInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUsuInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnUsuInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(labelInfoNome)
                    .addComponent(labelInfoCargo)
                    .addComponent(labelInfoEmail))
                .addContainerGap())
        );
        pnUsuInfoLayout.setVerticalGroup(
            pnUsuInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUsuInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(labelInfoNome)
                .addGap(26, 26, 26)
                .addComponent(labelInfoCargo)
                .addGap(30, 30, 30)
                .addComponent(labelInfoEmail)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        btAtualizar.setText("Atualizar");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        pnProdBaixo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        textBaixoProd.setEditable(false);
        textBaixoProd.setColumns(20);
        textBaixoProd.setRows(5);
        jScrollPane1.setViewportView(textBaixoProd);

        jLabel2.setText("Produtos com estoque baixo:");

        javax.swing.GroupLayout pnProdBaixoLayout = new javax.swing.GroupLayout(pnProdBaixo);
        pnProdBaixo.setLayout(pnProdBaixoLayout);
        pnProdBaixoLayout.setHorizontalGroup(
            pnProdBaixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProdBaixoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnProdBaixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .addGroup(pnProdBaixoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnProdBaixoLayout.setVerticalGroup(
            pnProdBaixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnProdBaixoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btAtualizar)
                    .addComponent(pnUsuInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(pnFat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnProdBaixo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnFat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnUsuInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnProdBaixo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btAtualizar)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarMetaFaturamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarMetaFaturamentoActionPerformed
        JFrame f = new JFrame();
        try {
            this.meta = Integer.parseInt(JOptionPane.showInputDialog(f,"Digite um número:"));
            
            atualizarDashMeta(metaFaturamento, labelMetaFaturamento, this.meta);  
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(f,"Apenas números são aceitos");
        }   
    }//GEN-LAST:event_btnAlterarMetaFaturamentoActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        carregarDashValores();
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void atualizarDashMeta (Meta T, javax.swing.JLabel label, float meta) {
        
        DaoGenerico dao = new DaoGenerico();
        
        T.setValor(meta);
        dao.editar(T);
        
        label.setText("Meta: " + meta);
    }
    
    private void carregarDashMetas () {
        
        //Carrega DASH ao abrir
       
        DaoGenerico dao = new DaoGenerico();
        List<Meta> lista = dao.read(Meta.class, "FROM Meta");
        
        //Verifica se existem no BD
        
        boolean faturamentoExist = false;
        
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNome().equals("faturamento")) {
                this.metaFaturamento = lista.get(i);
                faturamentoExist = true;
            }
            //if >> continua, n precisa fzr outro for
        }
        
        //Se não existir, cria no BD
        
        if (faturamentoExist == false) {
            this.metaFaturamento = new Meta("faturamento", 0);
            dao.create(meta);
        }
        
        //Atualiza o Dash
        
        lista = dao.read(Meta.class, "FROM Meta");
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNome().equals("faturamento")) {
                this.metaFaturamento = lista.get(i);
                labelMetaFaturamento.setText("Meta: "+lista.get(i).getValor());
            }            
        }
        
    }
    
    private void carregarProdutosBaixoEstoque () {
        
        DaoGenerico dao = new DaoGenerico();
        List<Produto> listaProd = dao.read(Produto.class, "FROM Produto");
        // WHERE estoqueproduto - minimoproduto > '50'"
        
        String txt = "";
        
        for (int i = 0; i < listaProd.size(); i++) {
            if ((listaProd.get(i).getEstoqueProduto()/listaProd.get(i).getMinimoProduto())*100 < 125) {
                
                txt += listaProd.get(i).getDescricaoProduto()+"\n";
                
            }
        }
        
        textBaixoProd.setText(txt);
        
    }
    
    private void carregarDashValores () {
        
        //Método para atualizar todos os valores no dashboard
        
        DaoGenerico dao = new DaoGenerico();
        List<Itemvenda> listaItemVenda = dao.read(Itemvenda.class, "FROM Itemvenda");
        
        //Pega os valores do BD
        
        float valorFaturamento = 0;
        float tempPorcentagem = 0;
        
        for (int i = 0; i < listaItemVenda.size(); i++) {
            
            valorFaturamento+=listaItemVenda.get(i).getValorItemVenda().floatValue();
            
        }
        
        // Atualiza o bloco faturamento
        
        labelFaturamento.setText("Faturamento: "+valorFaturamento);
        tempPorcentagem = (valorFaturamento/metaFaturamento.getValor())*100;
        labelFaturamentoPorcentagem.setText("Porcentagem: "+tempPorcentagem+"%");
        labelMetaFalta.setText("Restante: "+(metaFaturamento.getValor()-valorFaturamento));;
        
        
        // Atualiza o bloco info
        
        labelInfoNome.setText("Nome: " + atual.getNomeCompleto());
        labelInfoCargo.setText("Cargo: " + atual.getCargo_id().getNome());
        labelInfoEmail.setText("E-mail: " + atual.getEmail());
        
        
       // Atualiza o bloco produtos com baixo estoque
       
       carregarProdutosBaixoEstoque ();
       
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btnAlterarMetaFaturamento;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFaturamento;
    private javax.swing.JLabel labelFaturamentoPorcentagem;
    private javax.swing.JLabel labelInfoCargo;
    private javax.swing.JLabel labelInfoEmail;
    private javax.swing.JLabel labelInfoNome;
    private javax.swing.JLabel labelMetaFalta;
    private javax.swing.JLabel labelMetaFaturamento;
    private javax.swing.JPanel pnFat;
    private javax.swing.JPanel pnProdBaixo;
    private javax.swing.JPanel pnUsuInfo;
    private javax.swing.JTextArea textBaixoProd;
    // End of variables declaration//GEN-END:variables
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetointegrador.apresentacao;

import java.awt.Color;
import java.io.UnsupportedEncodingException;
import static java.lang.Integer.parseInt;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import projetointegrador.HibernateUtil;
import projetointegrador.negocio.CriptografarSenha;
import projetointegrador.negocio.Usuario;
import projetointegrador.negocio.ValidacaoCpf;
import projetointegrador.persistencia.DaoGenerico;
import projetointegrador.persistencia.DataBaseException;
import projetointegrador.tabelas.UsuarioTableModel;

/**
 *
 * @author enzob
 */
public class TelaCadastroUsuarios extends javax.swing.JInternalFrame {
    
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TelaLogin.class.getName());

    Calendar dataNascCalendar = Calendar.getInstance();
    
    private Usuario usuarioSelecionado;
    
    //Booleans para verificação
    
    Boolean isDateOk = false;
    Boolean doesPasswordsMatch = false;
    Boolean isCpfOk = false;
    
    Color color;
    
    public TelaCadastroUsuarios() throws DataBaseException {
        initComponents();
        carregarTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpCadastrar = new javax.swing.JPanel();
        jtFone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtfCpf = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        btEnviar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfDataNasc = new javax.swing.JFormattedTextField();
        jpfSenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtEmail = new javax.swing.JTextField();
        jpfConfSenha = new javax.swing.JPasswordField();
        jtNome = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jtUsuario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jpEditar = new javax.swing.JPanel();
        jpLista = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuarios = new javax.swing.JTable();
        btReset = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setClosable(true);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jpCadastrar.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("CPF:");

        jLabel1.setText("Usuário:");

        try {
            jtfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfCpfFocusLost(evt);
            }
        });

        jLabel2.setText("Nome Completo:");

        btEnviar.setText("Enviar");
        btEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarActionPerformed(evt);
            }
        });

        jLabel3.setText("Data de Nascimento:");

        jLabel7.setText("Senha:");

        try {
            jtfDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfDataNasc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfDataNascFocusLost(evt);
            }
        });

        jLabel4.setText("E-mail:");

        jLabel8.setText("Confirmar Senha:");

        jpfConfSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jpfConfSenhaFocusLost(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setEnabled(false);

        jtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtUsuarioActionPerformed(evt);
            }
        });

        jLabel9.setText("Setor:");

        jLabel5.setText("Telefone:");

        javax.swing.GroupLayout jpCadastrarLayout = new javax.swing.GroupLayout(jpCadastrar);
        jpCadastrar.setLayout(jpCadastrarLayout);
        jpCadastrarLayout.setHorizontalGroup(
            jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastrarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadastrarLayout.createSequentialGroup()
                        .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jtEmail)
                            .addComponent(jtNome)
                            .addComponent(jtUsuario)
                            .addComponent(jtFone)
                            .addComponent(jtfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jpfSenha)
                            .addComponent(jpfConfSenha)
                            .addComponent(jComboBox1, 0, 176, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCadastrarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpCadastrarLayout.setVerticalGroup(
            jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastrarLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jtfDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jpfConfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(26, 26, 26)
                .addComponent(btEnviar)
                .addGap(53, 53, 53))
        );

        jTabbedPane1.addTab("Cadastrar", jpCadastrar);

        jpEditar.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpEditarLayout = new javax.swing.GroupLayout(jpEditar);
        jpEditar.setLayout(jpEditarLayout);
        jpEditarLayout.setHorizontalGroup(
            jpEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
        );
        jpEditarLayout.setVerticalGroup(
            jpEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Editar Usuário", jpEditar);

        jpLista.setBackground(new java.awt.Color(255, 255, 255));

        tabelaUsuarios.setModel(new UsuarioTableModel());
        tabelaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaUsuarios);

        btReset.setText("Resetar senha");

        btExcluir.setText("Excluir conta");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpListaLayout = new javax.swing.GroupLayout(jpLista);
        jpLista.setLayout(jpListaLayout);
        jpListaLayout.setHorizontalGroup(
            jpListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpListaLayout.createSequentialGroup()
                        .addGap(0, 191, Short.MAX_VALUE)
                        .addGroup(jpListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jpListaLayout.setVerticalGroup(
            jpListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(btReset)
                .addGap(18, 18, 18)
                .addComponent(btExcluir)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Lista de Usuários", jpLista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfDataNascFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfDataNascFocusLost

        //Função para obrigar a data do calendário ser válida

        dataNascCalendar.setLenient(false);

        try {

            //Funções para transformar a String digitada em valores INT para o objeto Calendar

            int dia = parseInt(jtfDataNasc.getText().substring(0, 2));
            int mes = parseInt(jtfDataNasc.getText().substring(3, 5)) - 1; //O -1 é importante pois o mês começa do 0 no Calendar
            int ano = parseInt(jtfDataNasc.getText().substring(6));

            //Verifica se o ano é maior que o ano atual

            if (ano > Calendar.getInstance(TimeZone.getTimeZone("Brazil/West")).get(Calendar.YEAR)) {
                throw new Exception();
            }

            //Setando o objeto calendar e verificando, caso ocorra um erro a caixa ficará vermelha e o boolean continuara falso

            dataNascCalendar.set(ano, mes, dia, 00, 00, 00);
            jtfDataNasc.setBackground(Color.white);
            isDateOk = true;
            log.info("Data digitada está de acordo");

        } catch (Exception Ex) {

            //Muda a cor do textField caso algo de errado

            jtfDataNasc.setBackground(color = new Color(255, 143, 112));
            JOptionPane.showMessageDialog(null, "A data digitada é inválida");
            isDateOk = false;
            log.warn("Data digitada é inválida");
        }
    }//GEN-LAST:event_jtfDataNascFocusLost

    private void jtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtUsuarioActionPerformed

    private void jtfCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfCpfFocusLost

        //Esquema para verificar se o CPF é válido pelos padrões brasileiros

        try {
            boolean cpfValido = ValidacaoCpf.validarCPF(jtfCpf.getText().replaceAll("[^0-9]",""));

            if (cpfValido == false) {
                throw new Exception();
            }

            jtfCpf.setBackground(color.white);
            isCpfOk = true;
            log.info("CPF válido");            

        } catch (Exception ex) {
            jtfCpf.setBackground(color = new Color(255, 143, 112));
            JOptionPane.showMessageDialog(null, "O CPF digitado é inválido");
            isCpfOk = false;
            log.warn("CPF inválido");
        }

    }//GEN-LAST:event_jtfCpfFocusLost

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed

        //Criação de um objeto usuário novo caso as condições estejam de acordo
        if (isDateOk == true && doesPasswordsMatch == true && isCpfOk == true) {

            Session sessao = null;
            try {
                
                CriptografarSenha cripto = new CriptografarSenha();
                String senhaCriptografada = cripto.cripto(jpfSenha.getText());

                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction transacao = sessao.beginTransaction();
                Usuario login = new Usuario(jtUsuario.getText(), jtNome.getText(), dataNascCalendar, jtEmail.getText(), jtFone.getText(), jtfCpf.getText(), senhaCriptografada);
                
                //Salva o novo usuário no banco de dados
                sessao.save(login);
                transacao.commit();
                JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
                log.info("Cadastro efetuado com sucesso, usuario: " + jtUsuario.getText());
                
            } catch (HibernateException hibEx) {
                hibEx.printStackTrace();
                log.error("Erro no hibernate ao cadastrar usuário");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(TelaCadastroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(TelaCadastroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                sessao.close();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Algum campo está inválido");
            log.error("Erro nos campos do cadastro");
        }
        
        try {
            carregarTabela();
        } catch (DataBaseException ex) {
            Logger.getLogger(TelaCadastroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btEnviarActionPerformed

    private void jpfConfSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpfConfSenhaFocusLost

        //Esquema para verificar se as senhas coincidem

        try {
            if (!jpfSenha.getText().equals(jpfConfSenha.getText())) {
                throw new Exception();
            }

            jpfConfSenha.setBackground (Color.white);
            doesPasswordsMatch = true;

        } catch (Exception ex) {
            jpfConfSenha.setBackground(color = new Color(255, 143, 112));
            JOptionPane.showMessageDialog(null, "As senhas não coincidem");
            doesPasswordsMatch = false;
            log.warn("Senhas digitadas não são iguais");
        }

    }//GEN-LAST:event_jpfConfSenhaFocusLost

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        try {
            carregarTabela();
        } catch (DataBaseException ex) {
            Logger.getLogger(TelaCadastroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void tabelaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaUsuariosMouseClicked
        
    }//GEN-LAST:event_tabelaUsuariosMouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        
        try {
            DaoGenerico <Usuario> dao = new DaoGenerico <> ();
            dao.delete(Usuario.class, "FROM Usuario WHERE id=" + usuarioSelecionado.getId());
            carregarTabela();
            log.info("Usuario deletado com sucesso: " + usuarioSelecionado.getUsuario());
        } catch (DataBaseException ex) {
            Logger.getLogger(TelaCadastroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            log.error("Não foi possivel deletar o usuário: " + usuarioSelecionado.getUsuario());
        }
        
    }//GEN-LAST:event_btExcluirActionPerformed

    public void carregarTabela() throws DataBaseException {
        
        //Método para carregar ou atualizar a tabela de usuarios        
        
        DaoGenerico <Usuario> dao = new DaoGenerico <>();
        UsuarioTableModel tm = (UsuarioTableModel) tabelaUsuarios.getModel();
        tabelaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        List<Usuario> lista = dao.read(Usuario.class, "FROM Usuario");
        
        try {
            tm.setDados(dao.read(Usuario.class, "FROM Usuario"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar grade.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        //Script para pegar o usuario selecionado na tabela
        //PS: eu não sei como funciona e ta dando erros com novas linhas e linhas excluidas
        
        ListSelectionModel selectionModel = tabelaUsuarios.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tabelaUsuarios.getSelectedRow();

                if (row >= 0) {
                    UsuarioTableModel tableModel = (UsuarioTableModel) tabelaUsuarios.getModel();
                    usuarioSelecionado = lista.get(tabelaUsuarios.getSelectedRow());
                }
                System.out.println(usuarioSelecionado.getId());
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEnviar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btReset;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpCadastrar;
    private javax.swing.JPanel jpEditar;
    private javax.swing.JPanel jpLista;
    private javax.swing.JPasswordField jpfConfSenha;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTextField jtFone;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTextField jtUsuario;
    private javax.swing.JFormattedTextField jtfCpf;
    private javax.swing.JFormattedTextField jtfDataNasc;
    private javax.swing.JTable tabelaUsuarios;
    // End of variables declaration//GEN-END:variables
}

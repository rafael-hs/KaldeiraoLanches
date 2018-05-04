/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;



import Controller.ControllerTelaCtFuncionario;
import Model.ArquivoExterno;
import View.CadastroDeProduto;
import View.Pedido;
import com.sun.awt.AWTUtilities;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author J.Pedro
 */
public class CadastroDeFuncionario extends javax.swing.JFrame implements Runnable{

    private int x=200,y=80,speed=30;
    Thread h1,h2;
    
    public CadastroDeFuncionario() {
        this.setUndecorated(true);
        initComponents();
        this.setSize(x, y);
        this.setLocationRelativeTo(null);
        this.setOpacity(0.9f);
        AWTUtilities.setWindowOpaque(this, false);
        new ControllerTelaCtFuncionario(this); 
        grupoButtonRB.add(rbNomeFuncionario);
        grupoButtonRB.add(rbCelularFuncionario);
        grupoButtonRB.add(rbTelefoneFuncionario);
        
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoButtonRB = new javax.swing.ButtonGroup();
        jbCadastroFuncionario = new javax.swing.JButton();
        jbCadastroCliente = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jbPedido = new javax.swing.JButton();
        jbCadastroProduto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        jbFechar = new javax.swing.JButton();
        jbMinimizar1 = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        label8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        label9 = new javax.swing.JLabel();
        label10 = new javax.swing.JLabel();
        ctNomeFuncionario = new javax.swing.JTextField();
        ctRuaFuncionario = new javax.swing.JTextField();
        ctBairroFuncionario = new javax.swing.JTextField();
        ctCidadeFuncionario = new javax.swing.JTextField();
        ctNumCasaFuncionario = new javax.swing.JTextField();
        jbLimpar = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabDadosFuncionario = new javax.swing.JTable();
        rbTelefoneFuncionario = new javax.swing.JRadioButton();
        rbNomeFuncionario = new javax.swing.JRadioButton();
        ctPesquisaFuncionario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jbPesquisaCliente = new javax.swing.JButton();
        rbCelularFuncionario = new javax.swing.JRadioButton();
        ctCpfFormatadoFuncionario = new javax.swing.JFormattedTextField();
        ctCelularFormatadoFuncionario = new javax.swing.JFormattedTextField();
        ctTelefoneFormatadoFuncionario = new javax.swing.JFormattedTextField();
        ctNascimentoFormatadoFuncionario = new javax.swing.JFormattedTextField();
        ctCepFormatadoFuncionario = new javax.swing.JFormattedTextField();
        Logo = new javax.swing.JLabel();
        BarraDeMenu = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        Manual = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jbCadastroFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnLista.fw.png"))); // NOI18N
        jbCadastroFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastroFuncionarioActionPerformed(evt);
            }
        });

        jbCadastroCliente.setBackground(new java.awt.Color(255, 204, 102));
        jbCadastroCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnCadastro.fw.png"))); // NOI18N
        jbCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastroClienteActionPerformed(evt);
            }
        });

        jbBuscar.setBackground(new java.awt.Color(255, 204, 102));
        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnBusca.fw.png"))); // NOI18N
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbPedido.setBackground(new java.awt.Color(255, 204, 102));
        jbPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnPedido.fw.png"))); // NOI18N
        jbPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPedidoActionPerformed(evt);
            }
        });

        jbCadastroProduto.setBackground(new java.awt.Color(255, 204, 102));
        jbCadastroProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnProduto.fw.png"))); // NOI18N
        jbCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastroProdutoActionPerformed(evt);
            }
        });

        jPanel1.setLayout(null);

        Titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Titulo.setForeground(new java.awt.Color(232, 112, 4));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Cadastro De Funcionario");
        jPanel1.add(Titulo);
        Titulo.setBounds(10, 10, 300, 29);

        jbFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnClose.fw.png"))); // NOI18N
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });
        jPanel1.add(jbFechar);
        jbFechar.setBounds(875, 0, 25, 19);

        jbMinimizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnMinimize.fw.png"))); // NOI18N
        jbMinimizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMinimizar1ActionPerformed(evt);
            }
        });
        jPanel1.add(jbMinimizar1);
        jbMinimizar1.setBounds(844, 0, 25, 19);

        label1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label1.setForeground(new java.awt.Color(51, 51, 51));
        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setText("*Nome:");
        jPanel1.add(label1);
        label1.setBounds(10, 70, 50, 25);

        label2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label2.setForeground(new java.awt.Color(51, 51, 51));
        label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label2.setText("CPF:");
        jPanel1.add(label2);
        label2.setBounds(20, 120, 34, 15);

        label3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label3.setForeground(new java.awt.Color(51, 51, 51));
        label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label3.setText("*Telefone:");
        jPanel1.add(label3);
        label3.setBounds(10, 200, 64, 15);

        label4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label4.setForeground(new java.awt.Color(51, 51, 51));
        label4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label4.setText("*Celular:");
        jPanel1.add(label4);
        label4.setBounds(10, 160, 53, 15);

        label5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label5.setForeground(new java.awt.Color(51, 51, 51));
        label5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label5.setText("*Rua:");
        jPanel1.add(label5);
        label5.setBounds(10, 280, 36, 15);

        label6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label6.setForeground(new java.awt.Color(51, 51, 51));
        label6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label6.setText("*Bairro:");
        jPanel1.add(label6);
        label6.setBounds(10, 320, 48, 15);

        label7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label7.setForeground(new java.awt.Color(51, 51, 51));
        label7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label7.setText("*Cep:");
        jPanel1.add(label7);
        label7.setBounds(10, 360, 35, 15);

        label8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label8.setForeground(new java.awt.Color(51, 51, 51));
        label8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label8.setText("*Cidade:");
        label8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(label8);
        label8.setBounds(10, 400, 53, 15);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("(*) Campos Obrigatorios");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 50, 138, 14);

        label9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label9.setForeground(new java.awt.Color(51, 51, 51));
        label9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label9.setText("*Nº casa:");
        jPanel1.add(label9);
        label9.setBounds(10, 440, 56, 15);

        label10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label10.setForeground(new java.awt.Color(51, 51, 51));
        label10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label10.setText("Nasc.:");
        jPanel1.add(label10);
        label10.setBounds(10, 240, 35, 15);
        jPanel1.add(ctNomeFuncionario);
        ctNomeFuncionario.setBounds(80, 70, 210, 30);
        jPanel1.add(ctRuaFuncionario);
        ctRuaFuncionario.setBounds(80, 270, 210, 30);
        jPanel1.add(ctBairroFuncionario);
        ctBairroFuncionario.setBounds(80, 310, 210, 30);
        jPanel1.add(ctCidadeFuncionario);
        ctCidadeFuncionario.setBounds(80, 390, 210, 30);
        jPanel1.add(ctNumCasaFuncionario);
        ctNumCasaFuncionario.setBounds(80, 430, 210, 30);

        jbLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnLimpar.fw.png"))); // NOI18N
        jbLimpar.setText("Limpar - Atualizar");
        jPanel1.add(jbLimpar);
        jbLimpar.setBounds(590, 430, 180, 40);

        jbCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnSalvar.fw.png"))); // NOI18N
        jbCadastrar.setText("Cadastrar");
        jPanel1.add(jbCadastrar);
        jbCadastrar.setBounds(770, 430, 120, 40);

        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnAtualizar.fw.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });
        jPanel1.add(jbEditar);
        jbEditar.setBounds(470, 430, 120, 40);

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnDel.fw.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jPanel1.add(jbExcluir);
        jbExcluir.setBounds(350, 430, 120, 40);

        tabDadosFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Celular", "Telefone", "Nasc."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabDadosFuncionario.setSelectionBackground(new java.awt.Color(232, 112, 4));
        tabDadosFuncionario.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tabDadosFuncionario);
        if (tabDadosFuncionario.getColumnModel().getColumnCount() > 0) {
            tabDadosFuncionario.getColumnModel().getColumn(0).setMinWidth(30);
            tabDadosFuncionario.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabDadosFuncionario.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(310, 170, 580, 250);

        rbTelefoneFuncionario.setText("Telefone");
        jPanel1.add(rbTelefoneFuncionario);
        rbTelefoneFuncionario.setBounds(380, 140, 80, 23);

        rbNomeFuncionario.setText("Nome");
        jPanel1.add(rbNomeFuncionario);
        rbNomeFuncionario.setBounds(310, 140, 70, 23);
        jPanel1.add(ctPesquisaFuncionario);
        ctPesquisaFuncionario.setBounds(310, 110, 217, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(232, 112, 4));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Busca Funcionario");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(310, 80, 170, 22);

        jbPesquisaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnPesquisar.fw.png"))); // NOI18N
        jbPesquisaCliente.setText("Pesquisar");
        jPanel1.add(jbPesquisaCliente);
        jbPesquisaCliente.setBounds(530, 110, 120, 29);

        rbCelularFuncionario.setText("Celular");
        jPanel1.add(rbCelularFuncionario);
        rbCelularFuncionario.setBounds(460, 140, 70, 23);

        try {
            ctCpfFormatadoFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(ctCpfFormatadoFuncionario);
        ctCpfFormatadoFuncionario.setBounds(80, 110, 210, 30);

        try {
            ctCelularFormatadoFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(ctCelularFormatadoFuncionario);
        ctCelularFormatadoFuncionario.setBounds(80, 150, 210, 30);

        try {
            ctTelefoneFormatadoFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(ctTelefoneFormatadoFuncionario);
        ctTelefoneFormatadoFuncionario.setBounds(80, 190, 210, 30);

        try {
            ctNascimentoFormatadoFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(ctNascimentoFormatadoFuncionario);
        ctNascimentoFormatadoFuncionario.setBounds(80, 230, 210, 30);

        try {
            ctCepFormatadoFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(ctCepFormatadoFuncionario);
        ctCepFormatadoFuncionario.setBounds(80, 350, 210, 30);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/66.fw.png"))); // NOI18N
        Logo.setOpaque(true);
        jPanel1.add(Logo);
        Logo.setBounds(230, 180, 439, 119);

        jMenu2.setText("Ajuda");

        Manual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        Manual.setSelected(true);
        Manual.setText("Manual");
        Manual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Manual(evt);
            }
        });
        jMenu2.add(Manual);

        BarraDeMenu.add(jMenu2);

        setJMenuBar(BarraDeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbCadastroCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCadastroFuncionario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbPedido)
                .addContainerGap(364, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jbCadastroCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCadastroFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jbPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastroFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastroFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbCadastroFuncionarioActionPerformed

    private void jbCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastroClienteActionPerformed
        sair();
        new Thread(new CadastroDeCliente()).start();
    }//GEN-LAST:event_jbCadastroClienteActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        sair();
        new Thread(new Buscar()).start();
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPedidoActionPerformed
       JOptionPane.showMessageDialog(rootPane,"Vá a tela de Pedido\n"
                + "Selecione Um funcionario e um Cliente para habilitar as funcões");
        sair();
        new Thread(new Pedido()).start();
        
    }//GEN-LAST:event_jbPedidoActionPerformed

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        sair();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jbMinimizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMinimizar1ActionPerformed
        setExtendedState(getExtendedState()| CadastroDeCliente.ICONIFIED);
    }//GEN-LAST:event_jbMinimizar1ActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastroProdutoActionPerformed
        sair();
        new Thread(new CadastroDeProduto()).start();
    }//GEN-LAST:event_jbCadastroProdutoActionPerformed

    private void Manual(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Manual
        abrirAjuda();
    }//GEN-LAST:event_Manual

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroDeFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroDeFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroDeFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroDeFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Thread(new CadastroDeFuncionario()).start();
            }
        });
    }
    
    public void sair(){
        try{
           this.setVisible(true);
           for (int i=0; i<7; i++ ){
               h1.sleep(speed);
               this.setSize(x, y);
               this.setLocationRelativeTo(null);
               x = x - 100;
               
               if(x == 200){
                   for(int j=0; j<6; j++){
                       h2.sleep(speed);
                       this.setSize(x, y);
                       this.setLocationRelativeTo(null);
                       y = y - 100;
                   }
               }
           }
           
        }catch(InterruptedException e){
            
        }
        
        this.dispose();
    }
    
    public void run(){
        try{
           this.setVisible(true);
           for (int i=0; i<7; i++ ){
               h1.sleep(speed);
               this.setSize(x, y);
               this.setLocationRelativeTo(null);
               x = x + 100;
               
               if(x == 900){
                   for(int j=0; j<6; j++){
                       h2.sleep(speed);
                       this.setSize(x, y);
                       this.setLocationRelativeTo(null);
                       y = y + 100;
                   }
               }
           }
           
        }catch(InterruptedException e){
            
        }
        
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        AWTUtilities.setWindowShape(this, forma);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraDeMenu;
    private javax.swing.JLabel Logo;
    private javax.swing.JRadioButtonMenuItem Manual;
    private javax.swing.JLabel Titulo;
    private javax.swing.JTextField ctBairroFuncionario;
    private javax.swing.JFormattedTextField ctCelularFormatadoFuncionario;
    private javax.swing.JFormattedTextField ctCepFormatadoFuncionario;
    private javax.swing.JTextField ctCidadeFuncionario;
    private javax.swing.JFormattedTextField ctCpfFormatadoFuncionario;
    private javax.swing.JFormattedTextField ctNascimentoFormatadoFuncionario;
    private javax.swing.JTextField ctNomeFuncionario;
    private javax.swing.JTextField ctNumCasaFuncionario;
    private javax.swing.JTextField ctPesquisaFuncionario;
    private javax.swing.JTextField ctRuaFuncionario;
    private javax.swing.JFormattedTextField ctTelefoneFormatadoFuncionario;
    private javax.swing.ButtonGroup grupoButtonRB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbCadastroCliente;
    private javax.swing.JButton jbCadastroFuncionario;
    private javax.swing.JButton jbCadastroProduto;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbMinimizar1;
    private javax.swing.JButton jbPedido;
    private javax.swing.JButton jbPesquisaCliente;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JRadioButton rbCelularFuncionario;
    private javax.swing.JRadioButton rbNomeFuncionario;
    private javax.swing.JRadioButton rbTelefoneFuncionario;
    private javax.swing.JTable tabDadosFuncionario;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTextField getCtBairroFuncionario() {
        return ctBairroFuncionario;
    }

    public void setCtBairroFuncionario(javax.swing.JTextField ctBairroFuncionario) {
        this.ctBairroFuncionario = ctBairroFuncionario;
    }

    

    public javax.swing.JTextField getCtCidadeFuncionario() {
        return ctCidadeFuncionario;
    }

    public void setCtCidadeFuncionario(javax.swing.JTextField ctCidadeFuncionario) {
        this.ctCidadeFuncionario = ctCidadeFuncionario;
    }

   

    public javax.swing.JTextField getCtNomeFuncionario() {
        return ctNomeFuncionario;
    }

    public void setCtNomeFuncionario(javax.swing.JTextField ctNomeFuncionario) {
        this.ctNomeFuncionario = ctNomeFuncionario;
    }

    public javax.swing.JTextField getCtNumCasaFuncionario() {
        return ctNumCasaFuncionario;
    }

    public void setCtNumCasaFuncionario(javax.swing.JTextField ctNumCasaFuncionario) {
        this.ctNumCasaFuncionario = ctNumCasaFuncionario;
    }

    public javax.swing.JTextField getCtPesquisaFuncionario() {
        return ctPesquisaFuncionario;
    }

    public void setCtPesquisaFuncionario(javax.swing.JTextField ctPesquisaFuncionario) {
        this.ctPesquisaFuncionario = ctPesquisaFuncionario;
    }

    public javax.swing.JTextField getCtRuaFuncionario() {
        return ctRuaFuncionario;
    }

    public void setCtRuaFuncionario(javax.swing.JTextField ctRuaFuncionario) {
        this.ctRuaFuncionario = ctRuaFuncionario;
    }

    

    public javax.swing.JRadioButton getRbNomeFuncionario() {
        return rbNomeFuncionario;
    }

    public void setRbNomeFuncionario(javax.swing.JRadioButton rbNomeFuncionario) {
        this.rbNomeFuncionario = rbNomeFuncionario;
    }

    public javax.swing.JRadioButton getRbTelefoneFuncionario() {
        return rbTelefoneFuncionario;
    }

    public void setRbTelefoneFuncionario(javax.swing.JRadioButton rbTelefoneFuncionario) {
        this.rbTelefoneFuncionario = rbTelefoneFuncionario;
    }

    public JRadioButton getRbCelularFuncionario() {
        return rbCelularFuncionario;
    }

    public void setRbCelularFuncionario(JRadioButton rbCelularFuncionario) {
        this.rbCelularFuncionario = rbCelularFuncionario;
    }

    public javax.swing.JButton getJbCadastrar() {
        return jbCadastrar;
    }

    public javax.swing.JButton getJbEditar() {
        return jbEditar;
    }

    public javax.swing.JButton getJbExcluir() {
        return jbExcluir;
    }

    public javax.swing.JButton getJbLimpar() {
        return jbLimpar;
    }

    public javax.swing.JTable getTabDadosFuncionario() {
        return tabDadosFuncionario;
    }

    public javax.swing.JButton getJbPesquisaCliente() {
        return jbPesquisaCliente;
    }

    public javax.swing.ButtonGroup getGrupoButtonRB() {
        return grupoButtonRB;
    }

    private ArquivoExterno argex;
    
    private void abrirAjuda(){
        argex = new ArquivoExterno("Manual.pdf");
    }

    public JFormattedTextField getCtCelularFormatadoFuncionario() {
        return ctCelularFormatadoFuncionario;
    }

    public void setCtCelularFormatadoFuncionario(JFormattedTextField ctCelularFormatadoFuncionario) {
        this.ctCelularFormatadoFuncionario = ctCelularFormatadoFuncionario;
    }

    public JFormattedTextField getCtCepFormatadoFuncionario() {
        return ctCepFormatadoFuncionario;
    }

    public void setCtCepFormatadoFuncionario(JFormattedTextField ctCepFormatadoFuncionario) {
        this.ctCepFormatadoFuncionario = ctCepFormatadoFuncionario;
    }

    public JFormattedTextField getCtCpfFormatadoFuncionario() {
        return ctCpfFormatadoFuncionario;
    }

    public void setCtCpfFormatadoFuncionario(JFormattedTextField ctCpfFormatadoFuncionario) {
        this.ctCpfFormatadoFuncionario = ctCpfFormatadoFuncionario;
    }

    public JFormattedTextField getCtNascimentoFormatadoFuncionario() {
        return ctNascimentoFormatadoFuncionario;
    }

    public void setCtNascimentoFormatadoFuncionario(JFormattedTextField ctNascimentoFormatadoFuncionario) {
        this.ctNascimentoFormatadoFuncionario = ctNascimentoFormatadoFuncionario;
    }

    public JFormattedTextField getCtTelefoneFormatadoFuncionario() {
        return ctTelefoneFormatadoFuncionario;
    }

    public void setCtTelefoneFormatadoFuncionario(JFormattedTextField ctTelefoneFormatadoFuncionario) {
        this.ctTelefoneFormatadoFuncionario = ctTelefoneFormatadoFuncionario;
    }
 
    
    
}

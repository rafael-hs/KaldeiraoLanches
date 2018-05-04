/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import Controller.ControllerTelaCtBuscar;
import Dao.ClienteDAO;
import Model.ArquivoExterno;
import com.sun.awt.AWTUtilities;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author J.Pedro
 */
public class Buscar extends javax.swing.JFrame implements Runnable{

    private int x=200,y=80,speed=30;
    Thread h1,h2;
    
    public Buscar() {
        this.setUndecorated(true);
        initComponents();
        this.setSize(x, y);
        this.setLocationRelativeTo(null);
        this.setOpacity(0.9f);
        AWTUtilities.setWindowOpaque(this, false);
        try {
            new ControllerTelaCtBuscar(this);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        GrupoRB.add(rbNomeCliente);
        GrupoRB.add(rbTelefoneCliente);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoRB = new javax.swing.ButtonGroup();
        jbBuscar = new javax.swing.JButton();
        jbCadastroFuncionario = new javax.swing.JButton();
        jbCadastroCliente = new javax.swing.JButton();
        jbPedido = new javax.swing.JButton();
        jbCadastroProduto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        ctPesquisaCliente = new javax.swing.JTextField();
        rbNomeCliente = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jbPesquisaCliente = new javax.swing.JButton();
        jbMinimizar = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabDadosClienteBuscar = new javax.swing.JTable();
        jbFazerPedido = new javax.swing.JButton();
        jbEditarPedido = new javax.swing.JButton();
        jbExcluirPedido = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabDadosFuncionarioBuscar = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabPedidosBuscar = new javax.swing.JTable();
        jbGerarRelatorio = new javax.swing.JButton();
        rbTelefoneCliente = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ptDetalhesPedidoEndereco = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JbLimpar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabBuscarComanda = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        BarraDeMenu = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        Manual = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnBusca.fw.png"))); // NOI18N
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbCadastroFuncionario.setBackground(new java.awt.Color(255, 204, 102));
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
        jPanel1.add(ctPesquisaCliente);
        ctPesquisaCliente.setBounds(10, 40, 217, 30);

        rbNomeCliente.setText("Nome");
        jPanel1.add(rbNomeCliente);
        rbNomeCliente.setBounds(10, 70, 70, 23);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(232, 112, 4));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Busca Cliente");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 10, 160, 29);

        jbPesquisaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnPesquisar.fw.png"))); // NOI18N
        jbPesquisaCliente.setText("Pesquisar");
        jPanel1.add(jbPesquisaCliente);
        jbPesquisaCliente.setBounds(230, 40, 120, 29);

        jbMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnMinimize.fw.png"))); // NOI18N
        jbMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMinimizarActionPerformed(evt);
            }
        });
        jPanel1.add(jbMinimizar);
        jbMinimizar.setBounds(844, 0, 25, 19);

        jbFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnClose.fw.png"))); // NOI18N
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });
        jPanel1.add(jbFechar);
        jbFechar.setBounds(875, 0, 25, 19);

        tabDadosClienteBuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Celular", "Telefone", "Nasc."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabDadosClienteBuscar.setGridColor(new java.awt.Color(0, 0, 0));
        tabDadosClienteBuscar.setOpaque(false);
        tabDadosClienteBuscar.setSelectionBackground(new java.awt.Color(232, 112, 4));
        tabDadosClienteBuscar.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane4.setViewportView(tabDadosClienteBuscar);
        if (tabDadosClienteBuscar.getColumnModel().getColumnCount() > 0) {
            tabDadosClienteBuscar.getColumnModel().getColumn(0).setMinWidth(30);
            tabDadosClienteBuscar.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabDadosClienteBuscar.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(10, 120, 390, 120);

        jbFazerPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnAtualizar.fw.png"))); // NOI18N
        jbFazerPedido.setText("Fazer Pedido");
        jPanel1.add(jbFazerPedido);
        jbFazerPedido.setBounds(750, 400, 140, 40);

        jbEditarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnEditar.fw.png"))); // NOI18N
        jbEditarPedido.setText("Editar Pedido");
        jPanel1.add(jbEditarPedido);
        jbEditarPedido.setBounds(620, 400, 130, 40);

        jbExcluirPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnDel.fw.png"))); // NOI18N
        jbExcluirPedido.setText("Excluir Pedido");
        jPanel1.add(jbExcluirPedido);
        jbExcluirPedido.setBounds(480, 400, 140, 40);

        tabDadosFuncionarioBuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Celular", "Telefone", "Nasc."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabDadosFuncionarioBuscar.setSelectionBackground(new java.awt.Color(232, 112, 4));
        tabDadosFuncionarioBuscar.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(tabDadosFuncionarioBuscar);
        if (tabDadosFuncionarioBuscar.getColumnModel().getColumnCount() > 0) {
            tabDadosFuncionarioBuscar.getColumnModel().getColumn(0).setMinWidth(30);
            tabDadosFuncionarioBuscar.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabDadosFuncionarioBuscar.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(10, 270, 390, 110);

        tabPedidosBuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Data", "Status", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabPedidosBuscar.setSelectionBackground(new java.awt.Color(232, 112, 4));
        tabPedidosBuscar.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tabPedidosBuscar);
        if (tabPedidosBuscar.getColumnModel().getColumnCount() > 0) {
            tabPedidosBuscar.getColumnModel().getColumn(0).setMinWidth(30);
            tabPedidosBuscar.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabPedidosBuscar.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(412, 120, 240, 140);

        jbGerarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnRelatorio.png"))); // NOI18N
        jbGerarRelatorio.setText("Gerar Relatorio");
        jbGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGerarRelatorioActionPerformed(evt);
            }
        });
        jPanel1.add(jbGerarRelatorio);
        jbGerarRelatorio.setBounds(10, 400, 140, 40);

        rbTelefoneCliente.setText("Telefone");
        jPanel1.add(rbTelefoneCliente);
        rbTelefoneCliente.setBounds(80, 70, 80, 23);

        ptDetalhesPedidoEndereco.setEditable(false);
        ptDetalhesPedidoEndereco.setColumns(20);
        ptDetalhesPedidoEndereco.setRows(5);
        jScrollPane2.setViewportView(ptDetalhesPedidoEndereco);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(420, 290, 480, 90);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Tabela de Funcionários");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(130, 250, 150, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Tabela de Clientes");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(130, 100, 120, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Comanda");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(750, 100, 60, 15);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Endereço");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(640, 270, 60, 15);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/66.fw.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(230, 184, 439, 119);

        JbLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnLimpar.fw_1.png"))); // NOI18N
        JbLimpar.setText("Limpar Tela");
        jPanel1.add(JbLimpar);
        JbLimpar.setBounds(340, 400, 140, 40);

        tabBuscarComanda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Obs"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabBuscarComanda.setSelectionBackground(new java.awt.Color(232, 112, 4));
        tabBuscarComanda.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane5.setViewportView(tabBuscarComanda);

        jPanel1.add(jScrollPane5);
        jScrollPane5.setBounds(660, 120, 240, 140);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Tabela de Pedidos");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(480, 100, 120, 15);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jbCadastroCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCadastroFuncionario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbPedido)
                .addContainerGap(386, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbCadastroFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbCadastroFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastroFuncionarioActionPerformed
        sair();
        new Thread(new CadastroDeFuncionario()).start();
    }//GEN-LAST:event_jbCadastroFuncionarioActionPerformed

    private void jbCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastroClienteActionPerformed
        sair();
        new Thread(new CadastroDeCliente()).start();
    }//GEN-LAST:event_jbCadastroClienteActionPerformed

    private void jbPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPedidoActionPerformed
       JOptionPane.showMessageDialog(rootPane,"Um funcionario e um Cliente deve está selecionado para habilitar as funcões");
        sair();
        new Thread(new Pedido()).start();
        
    }//GEN-LAST:event_jbPedidoActionPerformed

    private void jbMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMinimizarActionPerformed
        setExtendedState(getExtendedState()| Buscar.ICONIFIED);
    }//GEN-LAST:event_jbMinimizarActionPerformed

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        sair();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jbCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastroProdutoActionPerformed
        sair();
        new Thread(new CadastroDeProduto()).start();
    }//GEN-LAST:event_jbCadastroProdutoActionPerformed

    private void Manual(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Manual
        abrirAjuda();
    }//GEN-LAST:event_Manual

    private void jbGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGerarRelatorioActionPerformed
        
    }//GEN-LAST:event_jbGerarRelatorioActionPerformed

    
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
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Thread(new Buscar()).start();
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
    private javax.swing.ButtonGroup GrupoRB;
    private javax.swing.JButton JbLimpar;
    private javax.swing.JRadioButtonMenuItem Manual;
    private javax.swing.JTextField ctPesquisaCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCadastroCliente;
    private javax.swing.JButton jbCadastroFuncionario;
    private javax.swing.JButton jbCadastroProduto;
    private javax.swing.JButton jbEditarPedido;
    private javax.swing.JButton jbExcluirPedido;
    private javax.swing.JButton jbFazerPedido;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbGerarRelatorio;
    private javax.swing.JButton jbMinimizar;
    private javax.swing.JButton jbPedido;
    private javax.swing.JButton jbPesquisaCliente;
    private javax.swing.JTextArea ptDetalhesPedidoEndereco;
    private javax.swing.JRadioButton rbNomeCliente;
    private javax.swing.JRadioButton rbTelefoneCliente;
    private javax.swing.JTable tabBuscarComanda;
    private javax.swing.JTable tabDadosClienteBuscar;
    private javax.swing.JTable tabDadosFuncionarioBuscar;
    private javax.swing.JTable tabPedidosBuscar;
    // End of variables declaration//GEN-END:variables

    public JTextField getCtPesquisaCliente() {
        return ctPesquisaCliente;
    }

    public void setCtPesquisaCliente(JTextField ctPesquisaCliente) {
        this.ctPesquisaCliente = ctPesquisaCliente;
    }

    public javax.swing.JButton getJbEditarPedido() {
        return jbEditarPedido;
    }

    public javax.swing.JButton getJbExcluirPedido() {
        return jbExcluirPedido;
    }

    public javax.swing.JButton getJbFazerPedido() {
        return jbFazerPedido;
    }

   


    public javax.swing.JRadioButton getRbNomeCliente() {
        return rbNomeCliente;
    }

    public javax.swing.JRadioButton getRbTelefoneCliente() {
        return rbTelefoneCliente;
    }

    public javax.swing.JTable getTabDadosClienteBuscar() {
        return tabDadosClienteBuscar;
    }

    public javax.swing.JTable getTabPedidosBuscar() {
        return tabPedidosBuscar;
    }

    public javax.swing.JTable getTabDadosFuncionarioBuscar() {
        return tabDadosFuncionarioBuscar;
    }

    public javax.swing.JButton getJbGerarRelatorio() {
        return jbGerarRelatorio;
    }

    public javax.swing.JButton getJbPesquisaCliente() {
        return jbPesquisaCliente;
    }


  

    public javax.swing.JMenuBar getBarraDeMenu() {
        return BarraDeMenu;
    }

    public javax.swing.JButton getJbLimpar() {
        return JbLimpar;
    }

    public javax.swing.ButtonGroup getGrupoRB() {
        return GrupoRB;
    }

    public void setGrupoRB(javax.swing.ButtonGroup GrupoRB) {
        this.GrupoRB = GrupoRB;
    }

    public javax.swing.JTextArea getPtDetalhesPedidoEndereco() {
        return ptDetalhesPedidoEndereco;
    }

    public void setPtDetalhesPedidoEndereco(javax.swing.JTextArea ptDetalhesPedidoEndereco) {
        this.ptDetalhesPedidoEndereco = ptDetalhesPedidoEndereco;
    }

    public javax.swing.JButton getJbPedido() {
        return jbPedido;
    }

    public javax.swing.JPanel getjPanel1() {
        return jPanel1;
    }

    public javax.swing.JTable getTabBuscarComanda() {
        return tabBuscarComanda;
    }

    private ArquivoExterno argex;
    
    private void abrirAjuda(){
        argex = new ArquivoExterno("Manual.pdf");
    }
    
   

   

    
    

}

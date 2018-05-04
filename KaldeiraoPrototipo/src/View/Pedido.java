/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import Model.ArquivoExterno;
import com.sun.awt.AWTUtilities;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author J.Pedro
 */
public class Pedido extends javax.swing.JFrame implements Runnable{

    private int x=200,y=80,speed=30;
    Thread h1,h2;
  
    public Pedido() {
        this.setUndecorated(true);
        initComponents();
        this.setSize(x, y);
        this.setLocationRelativeTo(null);
        this.setOpacity(0.9f);
        AWTUtilities.setWindowOpaque(this, false);
//        new ControllerTelaPedido(this);
    }

   

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbPedido = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jbCadastroFuncionario = new javax.swing.JButton();
        jbCadastroCliente = new javax.swing.JButton();
        jbCadastroProduto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabMenuLanches = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabPedidosCliente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ctNomeFuncionario = new javax.swing.JTextField();
        jbFechar = new javax.swing.JButton();
        jbMinimizar = new javax.swing.JButton();
        jbAdcionaPedido = new javax.swing.JButton();
        jbRetiraPedido = new javax.swing.JButton();
        jbFinalizaPedido = new javax.swing.JButton();
        cbStatusPedido = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ctNomeCliente = new javax.swing.JTextField();
        ctTotalPedidos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        BarraDeMenu = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        Manual = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jbPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnPedido.fw.png"))); // NOI18N
        jbPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPedidoActionPerformed(evt);
            }
        });

        jbBuscar.setBackground(new java.awt.Color(255, 204, 102));
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

        jbCadastroProduto.setBackground(new java.awt.Color(255, 204, 102));
        jbCadastroProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnProduto.fw.png"))); // NOI18N
        jbCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastroProdutoActionPerformed(evt);
            }
        });

        jPanel1.setLayout(null);

        tabMenuLanches.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Lanche", "Desc.", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabMenuLanches.setSelectionBackground(new java.awt.Color(232, 112, 4));
        tabMenuLanches.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tabMenuLanches);
        if (tabMenuLanches.getColumnModel().getColumnCount() > 0) {
            tabMenuLanches.getColumnModel().getColumn(0).setMinWidth(30);
            tabMenuLanches.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabMenuLanches.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 100, 420, 280);

        tabPedidosCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Lanche", "Obs.", "Preço"
            }
        ));
        tabPedidosCliente.setSelectionBackground(new java.awt.Color(232, 112, 4));
        tabPedidosCliente.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(tabPedidosCliente);
        if (tabPedidosCliente.getColumnModel().getColumnCount() > 0) {
            tabPedidosCliente.getColumnModel().getColumn(0).setMinWidth(30);
            tabPedidosCliente.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabPedidosCliente.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(480, 100, 410, 280);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Lista De Lanches");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(600, 70, 160, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("Menu");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(210, 70, 60, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Total:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(480, 390, 70, 25);

        ctNomeFuncionario.setEditable(false);
        ctNomeFuncionario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(ctNomeFuncionario);
        ctNomeFuncionario.setBounds(140, 390, 160, 30);

        jbFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnClose.fw.png"))); // NOI18N
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });
        jPanel1.add(jbFechar);
        jbFechar.setBounds(870, 0, 28, 18);

        jbMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnMinimize.fw.png"))); // NOI18N
        jbMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMinimizarActionPerformed(evt);
            }
        });
        jPanel1.add(jbMinimizar);
        jbMinimizar.setBounds(850, 0, 21, 18);

        jbAdcionaPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnAdcionar.fw.png"))); // NOI18N
        jPanel1.add(jbAdcionaPedido);
        jbAdcionaPedido.setBounds(440, 130, 30, 29);

        jbRetiraPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnRetirar.fw.png"))); // NOI18N
        jPanel1.add(jbRetiraPedido);
        jbRetiraPedido.setBounds(440, 170, 30, 29);

        jbFinalizaPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnEditar.fw.png"))); // NOI18N
        jbFinalizaPedido.setText("Finalizar Pedido");
        jbFinalizaPedido.setPreferredSize(new java.awt.Dimension(121, 29));
        jPanel1.add(jbFinalizaPedido);
        jbFinalizaPedido.setBounds(730, 390, 160, 40);

        cbStatusPedido.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-----------", "Em Aberto", "Saiu Para Entrega", "Entregue" }));
        jPanel1.add(cbStatusPedido);
        cbStatusPedido.setBounds(770, 60, 130, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(232, 112, 4));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Status Do Pedido");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(770, 40, 130, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Cliente:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 20, 80, 25);

        ctNomeCliente.setEditable(false);
        ctNomeCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(ctNomeCliente);
        ctNomeCliente.setBounds(90, 20, 160, 30);

        ctTotalPedidos.setEditable(false);
        ctTotalPedidos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ctTotalPedidos.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(ctTotalPedidos);
        ctTotalPedidos.setBounds(550, 390, 90, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Funcionário:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 390, 130, 25);

        BarraDeMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
                .addContainerGap()
                .addComponent(jbCadastroCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCadastroFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jbCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jbBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbPedido)
                .addContainerGap(364, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbCadastroFuncionario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbCadastroCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbCadastroProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastroClienteActionPerformed
        sair();
        new Thread(new CadastroDeCliente()).start();
    }//GEN-LAST:event_jbCadastroClienteActionPerformed

    private void jbCadastroFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastroFuncionarioActionPerformed
        sair();
        new Thread(new CadastroDeFuncionario()).start();
    }//GEN-LAST:event_jbCadastroFuncionarioActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        sair();
        new Thread(new Buscar()).start();
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbPedidoActionPerformed

    private void jbMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMinimizarActionPerformed
        setExtendedState(getExtendedState()| Pedido.ICONIFIED);
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
            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Thread(new Pedido()).start();
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
    private javax.swing.JRadioButtonMenuItem Manual;
    private javax.swing.JComboBox cbStatusPedido;
    private javax.swing.JTextField ctNomeCliente;
    private javax.swing.JTextField ctNomeFuncionario;
    private javax.swing.JTextField ctTotalPedidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAdcionaPedido;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCadastroCliente;
    private javax.swing.JButton jbCadastroFuncionario;
    private javax.swing.JButton jbCadastroProduto;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbFinalizaPedido;
    private javax.swing.JButton jbMinimizar;
    private javax.swing.JButton jbPedido;
    private javax.swing.JButton jbRetiraPedido;
    private javax.swing.JTable tabMenuLanches;
    private javax.swing.JTable tabPedidosCliente;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTextField getCtNomeCliente() {
        return ctNomeCliente;
    }

    public void setCtNomeCliente(javax.swing.JTextField ctNomeCliente) {
        this.ctNomeCliente = ctNomeCliente;
    }

    public javax.swing.JTextField getCtNomeFuncionario() {
        return ctNomeFuncionario;
    }

    public void setCtNomeFuncionario(javax.swing.JTextField ctNomeFuncionario) {
        this.ctNomeFuncionario = ctNomeFuncionario;
    }

    public javax.swing.JTable getTabMenuLanches() {
        return tabMenuLanches;
    }

    public void setTabMenuLanches(javax.swing.JTable tabMenuLanches) {
        this.tabMenuLanches = tabMenuLanches;
    }

    public javax.swing.JTable getTabPedidosCliente() {
        return tabPedidosCliente;
    }

    public void setTabPedidosCliente(javax.swing.JTable tabPedidosCliente) {
        this.tabPedidosCliente = tabPedidosCliente;
    }

    public javax.swing.JComboBox getCbStatusPedido() {
        return cbStatusPedido;
    }

    public javax.swing.JButton getJbAdcionaPedido() {
        return jbAdcionaPedido;
    }

    public javax.swing.JButton getJbFinalizaPedido() {
        return jbFinalizaPedido;
    }

    public javax.swing.JButton getJbRetiraPedido() {
        return jbRetiraPedido;
    }

    public javax.swing.JTextField getCtTotalPedidos() {
        return ctTotalPedidos;
    }

    public void setCtTotalPedidos(javax.swing.JTextField ctTotalPedidos) {
        this.ctTotalPedidos = ctTotalPedidos;
    }
    
    private ArquivoExterno argex;
    
    private void abrirAjuda(){
        argex = new ArquivoExterno("Manual.pdf");
    }

  

    
    

}

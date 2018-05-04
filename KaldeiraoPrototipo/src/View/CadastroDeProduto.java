/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import Controller.ControllerTelaCtCliente;
import Controller.ControllerTelaCtProduto;
import Model.ArquivoExterno;
import View.Pedido;
import com.sun.awt.AWTUtilities;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author J.Pedro
 */
public class CadastroDeProduto extends javax.swing.JFrame implements Runnable{

    private int x=200,y=80,speed=30;
    Thread h1,h2;
    
    public CadastroDeProduto() {
        this.setUndecorated(true);
        initComponents();
        this.setSize(x, y);
        this.setLocationRelativeTo(null);
        this.setOpacity(0.9f);
        AWTUtilities.setWindowOpaque(this, false);
        new ControllerTelaCtProduto(this);
        grupoButtonRB.add(rbNomeLanche);
        grupoButtonRB.add(rbNumLanche);
        
    }

    
    

   

    
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoButtonRB = new javax.swing.ButtonGroup();
        jbCadastroCliente = new javax.swing.JButton();
        jbCadastroFuncionario = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jbPedido = new javax.swing.JButton();
        jbCadastroProduto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jbFechar = new javax.swing.JButton();
        jbMinimizar1 = new javax.swing.JButton();
        Titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabProdutos = new javax.swing.JTable();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        ctNumLanche = new javax.swing.JTextField();
        ctNomeLanche = new javax.swing.JTextField();
        ctDescricaoLanche = new javax.swing.JTextField();
        ctPrecoLanche = new javax.swing.JTextField();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbAdcionar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbLimpar = new javax.swing.JButton();
        rbNumLanche = new javax.swing.JRadioButton();
        rbNomeLanche = new javax.swing.JRadioButton();
        ctPesquisarTabelaLanches = new javax.swing.JTextField();
        jbPesquisaLanche = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        BarraDeMenu = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        Manual = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jbCadastroCliente.setBackground(new java.awt.Color(255, 204, 102));
        jbCadastroCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnCadastro.fw.png"))); // NOI18N
        jbCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastroClienteActionPerformed(evt);
            }
        });

        jbCadastroFuncionario.setBackground(new java.awt.Color(255, 204, 102));
        jbCadastroFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnLista.fw.png"))); // NOI18N
        jbCadastroFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastroFuncionarioActionPerformed(evt);
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

        jbCadastroProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnProduto.fw.png"))); // NOI18N
        jbCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastroProdutoActionPerformed(evt);
            }
        });

        jPanel1.setLayout(null);

        jbFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnClose.fw.png"))); // NOI18N
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });
        jPanel1.add(jbFechar);
        jbFechar.setBounds(870, 0, 25, 19);

        jbMinimizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnMinimize.fw.png"))); // NOI18N
        jbMinimizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMinimizar1ActionPerformed(evt);
            }
        });
        jPanel1.add(jbMinimizar1);
        jbMinimizar1.setBounds(840, 0, 25, 19);

        Titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Titulo.setForeground(new java.awt.Color(232, 112, 4));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Cadastro De Produtos");
        jPanel1.add(Titulo);
        Titulo.setBounds(10, 10, 270, 29);

        TabProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nº", "Lanche", "Descrição", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
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
        TabProdutos.setSelectionBackground(new java.awt.Color(232, 112, 4));
        TabProdutos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(TabProdutos);
        if (TabProdutos.getColumnModel().getColumnCount() > 0) {
            TabProdutos.getColumnModel().getColumn(0).setMinWidth(30);
            TabProdutos.getColumnModel().getColumn(0).setMaxWidth(30);
            TabProdutos.getColumnModel().getColumn(1).setMinWidth(30);
            TabProdutos.getColumnModel().getColumn(1).setPreferredWidth(30);
            TabProdutos.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(370, 90, 520, 310);

        label1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label1.setForeground(new java.awt.Color(51, 51, 51));
        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setText("*Preço:");
        jPanel1.add(label1);
        label1.setBounds(10, 360, 50, 25);

        label2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label2.setForeground(new java.awt.Color(51, 51, 51));
        label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label2.setText("*Nº :");
        jPanel1.add(label2);
        label2.setBounds(10, 240, 30, 25);

        label3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label3.setForeground(new java.awt.Color(51, 51, 51));
        label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label3.setText("*Produto:");
        jPanel1.add(label3);
        label3.setBounds(10, 280, 63, 25);

        label4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label4.setForeground(new java.awt.Color(51, 51, 51));
        label4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label4.setText("*Descrição:");
        jPanel1.add(label4);
        label4.setBounds(10, 320, 70, 25);
        jPanel1.add(ctNumLanche);
        ctNumLanche.setBounds(90, 240, 210, 30);
        jPanel1.add(ctNomeLanche);
        ctNomeLanche.setBounds(90, 280, 210, 30);
        jPanel1.add(ctDescricaoLanche);
        ctDescricaoLanche.setBounds(90, 320, 210, 30);
        jPanel1.add(ctPrecoLanche);
        ctPrecoLanche.setBounds(90, 360, 210, 30);

        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnAtualizar.fw.png"))); // NOI18N
        jbEditar.setText("Editar");
        jPanel1.add(jbEditar);
        jbEditar.setBounds(470, 410, 120, 40);

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnDel.fw.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jPanel1.add(jbExcluir);
        jbExcluir.setBounds(350, 410, 120, 40);

        jbAdcionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnSalvar.fw.png"))); // NOI18N
        jbAdcionar.setText("Adcionar");
        jPanel1.add(jbAdcionar);
        jbAdcionar.setBounds(770, 410, 120, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("(*) Campos Obrigatorios");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 170, 138, 14);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(232, 112, 4));
        jLabel2.setText("Lanches Cadastrados");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(520, 60, 200, 22);

        jbLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnLimpar.fw.png"))); // NOI18N
        jbLimpar.setText("Limpar - Atualizar");
        jPanel1.add(jbLimpar);
        jbLimpar.setBounds(590, 410, 180, 40);

        rbNumLanche.setText("Nº Do Lanche");
        jPanel1.add(rbNumLanche);
        rbNumLanche.setBounds(80, 120, 100, 23);

        rbNomeLanche.setText("Nome");
        jPanel1.add(rbNomeLanche);
        rbNomeLanche.setBounds(10, 120, 70, 23);
        jPanel1.add(ctPesquisarTabelaLanches);
        ctPesquisarTabelaLanches.setBounds(10, 90, 217, 30);

        jbPesquisaLanche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icnPesquisar.fw.png"))); // NOI18N
        jbPesquisaLanche.setText("Pesquisar");
        jPanel1.add(jbPesquisaLanche);
        jbPesquisaLanche.setBounds(230, 90, 120, 29);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(232, 112, 4));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Busca De Produto");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 60, 170, 22);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbCadastroCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCadastroFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbCadastroFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
        JOptionPane.showMessageDialog(rootPane,"Vá a tela de Pedido\n"
                + "Selecione Um funcionario e um Cliente para habilitar as funcões");
        sair();
        new Thread(new Pedido()).start();
        
    }//GEN-LAST:event_jbPedidoActionPerformed

    private void jbCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastroProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbCadastroProdutoActionPerformed

    private void jbMinimizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMinimizar1ActionPerformed
        setExtendedState(getExtendedState()| CadastroDeProduto.ICONIFIED);
    }//GEN-LAST:event_jbMinimizar1ActionPerformed

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        sair();
    }//GEN-LAST:event_jbFecharActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroDeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroDeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroDeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroDeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Thread(new CadastroDeProduto()).start();
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
    private javax.swing.JTable TabProdutos;
    private javax.swing.JLabel Titulo;
    private javax.swing.JTextField ctDescricaoLanche;
    private javax.swing.JTextField ctNomeLanche;
    private javax.swing.JTextField ctNumLanche;
    private javax.swing.JTextField ctPesquisarTabelaLanches;
    private javax.swing.JTextField ctPrecoLanche;
    private javax.swing.ButtonGroup grupoButtonRB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAdcionar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCadastroCliente;
    private javax.swing.JButton jbCadastroFuncionario;
    private javax.swing.JButton jbCadastroProduto;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbMinimizar1;
    private javax.swing.JButton jbPedido;
    private javax.swing.JButton jbPesquisaLanche;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JRadioButton rbNomeLanche;
    private javax.swing.JRadioButton rbNumLanche;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTextField getCtDescricaoLanche() {
        return ctDescricaoLanche;
    }

    public void setCtDescricaoLanche(javax.swing.JTextField ctDescricaoLanche) {
        this.ctDescricaoLanche = ctDescricaoLanche;
    }

    public javax.swing.JTextField getCtNomeLanche() {
        return ctNomeLanche;
    }

    public void setCtNomeLanche(javax.swing.JTextField ctNomeLanche) {
        this.ctNomeLanche = ctNomeLanche;
    }

  

    public javax.swing.JTextField getCtPesquisarTabelaLanches() {
        return ctPesquisarTabelaLanches;
    }

    public void setCtPesquisarTabelaLanches(javax.swing.JTextField ctPesquisarTabelaLanches) {
        this.ctPesquisarTabelaLanches = ctPesquisarTabelaLanches;
    }

    public javax.swing.JTextField getCtPrecoLanche() {
        return ctPrecoLanche;
    }

    public void setCtPrecoLanche(javax.swing.JTextField ctPrecoLanche) {
        this.ctPrecoLanche = ctPrecoLanche;
    }

    public javax.swing.JButton getJbAdcionar() {
        return jbAdcionar;
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

    public javax.swing.JRadioButton getRbNomeLanche() {
        return rbNomeLanche;
    }

    public javax.swing.JRadioButton getRbNumLanche() {
        return rbNumLanche;
    }

    public javax.swing.JTable getTabProdutos() {
        return TabProdutos;
    }

    public javax.swing.JButton getJbPesquisaLanche() {
        return jbPesquisaLanche;
    }

    public javax.swing.ButtonGroup getGrupoButtonRB() {
        return grupoButtonRB;
    }

    public javax.swing.JTextField getCtNumLanche() {
        return ctNumLanche;
    }

    public void setCtNumLanche(javax.swing.JTextField ctNumLanche) {
        this.ctNumLanche = ctNumLanche;
    }

    private ArquivoExterno argex;
    
    private void abrirAjuda(){
        argex = new ArquivoExterno("Manual.pdf");
    }
    
}

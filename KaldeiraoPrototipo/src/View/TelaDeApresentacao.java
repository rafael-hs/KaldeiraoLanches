/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.sun.awt.AWTUtilities;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import static java.lang.Thread.sleep;

/**
 *
 * @author J.Pedro
 */
public class TelaDeApresentacao extends javax.swing.JFrame implements Runnable {

    private int porcentagem;
    private int x = 200, y = 80, speed = 30;
    Thread h1, h2;

    public TelaDeApresentacao() {
        this.setUndecorated(true);
        initComponents();
        this.setSize(x, y);
        this.setLocationRelativeTo(null);
        this.setOpacity(0.9f);
        AWTUtilities.setWindowOpaque(this, false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbFechar = new javax.swing.JButton();
        jbMinimizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar = new javax.swing.JProgressBar();
        lblCarregando = new javax.swing.JLabel();
        jbIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setLayout(null);

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/66.fw.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(240, 140, 477, 150);

        jProgressBar.setForeground(new java.awt.Color(255, 102, 0));
        jPanel1.add(jProgressBar);
        jProgressBar.setBounds(140, 370, 650, 30);

        lblCarregando.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(lblCarregando);
        lblCarregando.setBounds(390, 340, 160, 20);

        jbIniciar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbIniciar.setText("Iniciar");
        jbIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIniciarActionPerformed(evt);
            }
        });
        jPanel1.add(jbIniciar);
        jbIniciar.setBounds(400, 450, 110, 31);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                .addGap(92, 92, 92))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIniciarActionPerformed
        jbIniciar.setEnabled(false);
        new Thread() {
            public void run() {
                
                for (int i = 0; i < 101; i++) {
                    try {

                        sleep(60);
                        jProgressBar.setValue(i);

                        if (jProgressBar.getValue() <= 25) {
                            lblCarregando.setText("Carregando Sistema.");
                        } else if (jProgressBar.getValue() <= 50) {
                            lblCarregando.setText("Carregando Sistema..");
                        } else if (jProgressBar.getValue() <= 75) {
                            lblCarregando.setText("Carregando Sistema...");
                        }else if (jProgressBar.getValue() <=95){
                            lblCarregando.setText("Carregando Sistema....");
                        }
                        else {
                            lblCarregando.setText("      Bem Vindo!");

                        }

                    } catch (InterruptedException ex) {

                    }
                }
                
                sair();
                new Thread(new CadastroDeCliente()).start();
                
            }
            
            
           
        }.start();

 
    }//GEN-LAST:event_jbIniciarActionPerformed

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        sair();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jbMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMinimizarActionPerformed
        setExtendedState(getExtendedState() | TelaDeApresentacao.ICONIFIED);
    }//GEN-LAST:event_jbMinimizarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDeApresentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeApresentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeApresentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeApresentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Thread(new TelaDeApresentacao()).start();
            }
        });
    }

    public void sair() {
        try {
            this.setVisible(true);
            for (int i = 0; i < 7; i++) {
                h1.sleep(speed);
                this.setSize(x, y);
                this.setLocationRelativeTo(null);
                x = x - 100;

                if (x == 200) {
                    for (int j = 0; j < 6; j++) {
                        h2.sleep(speed);
                        this.setSize(x, y);
                        this.setLocationRelativeTo(null);
                        y = y - 100;
                    }
                }
            }

        } catch (InterruptedException e) {

        }

        this.dispose();
    }

    public void run() {
        try {
            this.setVisible(true);
            for (int i = 0; i < 7; i++) {
                h1.sleep(speed);
                this.setSize(x, y);
                this.setLocationRelativeTo(null);
                x = x + 100;

                if (x == 900) {
                    for (int j = 0; j < 6; j++) {
                        h2.sleep(speed);
                        this.setSize(x, y);
                        this.setLocationRelativeTo(null);
                        y = y + 100;
                    }
                }
            }

        } catch (InterruptedException e) {

        }

        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        AWTUtilities.setWindowShape(this, forma);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbIniciar;
    private javax.swing.JButton jbMinimizar;
    private javax.swing.JLabel lblCarregando;
    // End of variables declaration//GEN-END:variables
}

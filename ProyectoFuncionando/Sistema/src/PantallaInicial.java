
// package com.sistematransaccional.GUI;

// import java.awt.Color;
// import java.awt.Graphics2D;
// import java.awt.Image;
// import java.awt.RenderingHints;
// import java.awt.image.BufferedImage;
// import javax.swing.Icon;
// import javax.swing.ImageIcon;
// import javax.swing.JLabel;

// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
//  */

// /**
//  *
//  * @author Usuario
//  */
// public class PantallaInicial extends javax.swing.JFrame {
//     /**
//      * Creates new form PantallaInicial
//      */
//     public PantallaInicial() {
//         initComponents();

//         jLabel2.setIcon(new ImageIcon(new ImageIcon("src/imagenes/click1.png").getImage()
//                 .getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH)));

//     }

//     /**
//      * This method is called from within the constructor to initialize the form.
//      * WARNING: Do NOT modify this code. The content of this method is always
//      * regenerated by the Form Editor.
//      */
//     @SuppressWarnings("unchecked")
//     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
//     private void initComponents() {

//         jPanel1 = new javax.swing.JPanel();
//         jButton1 = new javax.swing.JButton();
//         jButton2 = new javax.swing.JButton();
//         jButton3 = new javax.swing.JButton();
//         jLabel1 = new javax.swing.JLabel();
//         jLabel2 = new javax.swing.JLabel();

//         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

//         jPanel1.setBackground(new java.awt.Color(204, 203, 189));

//         jButton1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
//         jButton1.setText("Módulo Transaccional");
//         jButton1.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 jButton1ActionPerformed(evt);
//             }
//         });

//         jButton2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
//         jButton2.setText("Módulo de Préstamos");
//         jButton2.setDoubleBuffered(true);
//         jButton2.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 jButton2ActionPerformed(evt);
//             }
//         });

//         jButton3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
//         jButton3.setText("Salir");
//         jButton3.addActionListener(new java.awt.event.ActionListener() {
//             public void actionPerformed(java.awt.event.ActionEvent evt) {
//                 jButton3ActionPerformed(evt);
//             }
//         });

//         jLabel1.setFont(new java.awt.Font("Elephant", 1, 95)); // NOI18N
//         jLabel1.setForeground(new java.awt.Color(102, 102, 102));
//         jLabel1.setText("ClickPago");

//         javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
//         jPanel1.setLayout(jPanel1Layout);
//         jPanel1Layout.setHorizontalGroup(
//             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGroup(jPanel1Layout.createSequentialGroup()
//                 .addGap(148, 148, 148)
//                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                     .addGroup(jPanel1Layout.createSequentialGroup()
//                         .addComponent(jButton1)
//                         .addGap(50, 50, 50)
//                         .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
//                     .addComponent(jLabel1))
//                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                     .addGroup(jPanel1Layout.createSequentialGroup()
//                         .addGap(45, 45, 45)
//                         .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
//                     .addGroup(jPanel1Layout.createSequentialGroup()
//                         .addGap(18, 18, 18)
//                         .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                 .addContainerGap(129, Short.MAX_VALUE))
//         );
//         jPanel1Layout.setVerticalGroup(
//             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
//                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                     .addGroup(jPanel1Layout.createSequentialGroup()
//                         .addGap(147, 147, 147)
//                         .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
//                     .addGroup(jPanel1Layout.createSequentialGroup()
//                         .addGap(173, 173, 173)
//                         .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                 .addGap(59, 59, 59)
//                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                     .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
//                     .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
//                     .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
//                 .addContainerGap(193, Short.MAX_VALUE))
//         );

//         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//         getContentPane().setLayout(layout);
//         layout.setHorizontalGroup(
//             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//         );
//         layout.setVerticalGroup(
//             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//             .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//         );

//         pack();
//     }// </editor-fold>//GEN-END:initComponents

//     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

//     }//GEN-LAST:event_jButton2ActionPerformed

//     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

//     }//GEN-LAST:event_jButton1ActionPerformed

//     private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//         Login lg = new Login();

//         lg.setVisible(true);
//        this.dispose(); //Cierra el jform actual

//     }//GEN-LAST:event_jButton3ActionPerformed

//     /**
//      * @param args the command line arguments
//      */
//     public static void main(String args[]) {
//         /* Set the Nimbus look and feel */
//         //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//         /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//          * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//          */
//         try {
//             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                 if ("Nimbus".equals(info.getName())) {
//                     javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                     break;
//                 }
//             }
//         } catch (ClassNotFoundException ex) {
//             java.util.logging.Logger.getLogger(PantallaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//         } catch (InstantiationException ex) {
//             java.util.logging.Logger.getLogger(PantallaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//         } catch (IllegalAccessException ex) {
//             java.util.logging.Logger.getLogger(PantallaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//             java.util.logging.Logger.getLogger(PantallaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//         }
//         //</editor-fold>

//         /* Create and display the form */
//         java.awt.EventQueue.invokeLater(new Runnable() {
//             public void run() {
//                 new PantallaInicial().setVisible(true);
//             }
//         });
//     }

//     // Variables declaration - do not modify//GEN-BEGIN:variables
//     private javax.swing.JButton jButton1;
//     private javax.swing.JButton jButton2;
//     private javax.swing.JButton jButton3;
//     private javax.swing.JLabel jLabel1;
//     private javax.swing.JLabel jLabel2;
//     private javax.swing.JPanel jPanel1;
//     // End of variables declaration//GEN-END:variables
// }
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class PantallaInicial extends javax.swing.JFrame {
    /**
     * Constructor de la clase PantallaInicial.
     * Inicializa los componentes de la interfaz gráfica y carga una imagen en jLabel2.
     */
    public PantallaInicial() {
        initComponents();
        jLabel2.setIcon(new ImageIcon(new ImageIcon("archivosPrestamos\\click1.png").getImage()
                .getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH)));
    }
    /**
     * Método para inicializar y configurar los componentes de la interfaz gráfica.
     * Define el diseño de la ventana, sus botones, etiquetas y paneles.
     */
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 650);
        setLocationRelativeTo(null);

        jPanel1.setBackground(new java.awt.Color(204, 203, 189));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Elephant", 1, 95));
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("ClickPago");
        jLabel1.setBounds(150, 140, 550, 150);
        jPanel1.add(jLabel1);

        jLabel2.setBounds(700, 140, 120, 120);
        jPanel1.add(jLabel2);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 22));
        jButton1.setText("Módulo Transaccional");
        jButton1.setBounds(80, 350, 280, 55);
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));
        jPanel1.add(jButton1);

        jButton2.setFont(new java.awt.Font("Dialog", 1, 22));
        jButton2.setText("Módulo de Préstamos");
        jButton2.setBounds(380, 350, 280, 55);
        jButton2.addActionListener(evt -> jButton2ActionPerformed(evt));
        jPanel1.add(jButton2);

        jButton3.setFont(new java.awt.Font("Dialog", 1, 22));
        jButton3.setText("Salir");
        jButton3.setBounds(700, 350, 180, 55);
        jButton3.addActionListener(evt -> jButton3ActionPerformed(evt));
        jPanel1.add(jButton3);

        getContentPane().setLayout(null);
        jPanel1.setBounds(0, 0, 1000, 650);
        getContentPane().add(jPanel1);
    }
    /**
     * Método que se ejecuta cuando se presiona el botón "Módulo Transaccional".
     * Abre la ventana GUIModuloTransaccional y cierra la pantalla actual.
     *
     * @param evt Evento de acción generado al presionar el botón.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        SwingUtilities.invokeLater(() -> {
            new GUIModuloTransaccional().setVisible(true);
            this.dispose();
        });

    }
    /**
     * Método que se ejecuta cuando se presiona el botón "Módulo de Préstamos".
     * Abre la ventana Prestamo y cierra la pantalla actual.
     *
     * @param evt Evento de acción generado al presionar el botón.
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(() -> {
            new Prestamo().setVisible(true);
            this.dispose();
        });
    }

    /**
     * Método que se ejecuta cuando se presiona el botón "Salir".
     * Abre la ventana de Login y cierra la pantalla actual.
     *
     * @param evt Evento de acción generado al presionar el botón.
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        Login lg = new Login();
        lg.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new PantallaInicial().setVisible(true));
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
}

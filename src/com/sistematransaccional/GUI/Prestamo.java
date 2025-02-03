/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.sistematransaccional.GUI;

import com.sistematransaccional.Logica.*;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class Prestamo extends javax.swing.JFrame {

    /**
     * Creates new form Prestamo
     */
    
     DefaultTableModel tm = new DefaultTableModel();
    
     public Prestamo() {
        initComponents();
        String ids[] = {"NoCuotas", "Capital", "Interes", " Seguro de desgravamen","Saldo","Seguro Incendios", "Valor total de cuota"};
        tm.setColumnIdentifiers(ids);
        //jTable1.setModel(tm);
        jPanel5.setVisible(false);
        jPanel2.setVisible(false);
        jPanel4.setVisible(false);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txtCostoAuto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPrestamoSoli = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        tbtFrances = new javax.swing.JToggleButton();
        tbtAleman = new javax.swing.JToggleButton();
        jButton2 = new javax.swing.JButton();
        prueba = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1500, 800));

        jPanel1.setPreferredSize(new java.awt.Dimension(1500, 800));

        jLabel1.setText("jLabel1");

        jButton10.setText("jButton10");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10)
                    .addComponent(jLabel1))
                .addGap(60, 60, 60))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(86, 86, 86)
                .addComponent(jButton10)
                .addContainerGap(237, Short.MAX_VALUE))
        );

        jLabel2.setText("jLabel2");

        jButton11.setText("jButton11");

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(274, 274, 274))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jButton11)
                .addGap(47, 47, 47)
                .addComponent(jLabel3)
                .addContainerGap(338, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jButton11))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel3)))
                .addContainerGap(306, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(496, 496, 496)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(369, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un Tipo", "Automotriz", "Hipotecario", "Emergente", "Consumo", " ", " " }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("¿QUE TIPO DE CREDITO NECESITAS?");

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 631, -1, -1));
        jPanel5.add(txtCostoAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 74, 185, -1));

        jLabel6.setText("¿Cuanto dinero soliticitas?");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 140, 185, -1));

        jLabel7.setText("¿En cuantos meses deseas pagarlo?");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 243, -1, -1));
        jPanel5.add(txtPrestamoSoli, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 174, 185, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una fecha", "12 meses(1año)", "18 meses(1.5años)", "24 meses(2años)", "30 meses(2.5años)", "36 meses(3años)", "42 meses (3.5años)", "48 meses(4años)", "54 meses(4.5años)", "60 meses(5años)" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel5.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 292, -1, -1));

        jLabel8.setText("¿Como quieres pagar tus intereses?");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 346, -1, -1));

        tbtFrances.setText("Metodo Frances");
        tbtFrances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtFrancesActionPerformed(evt);
            }
        });
        jPanel5.add(tbtFrances, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 399, -1, 55));

        tbtAleman.setText("MetodoAleman");
        tbtAleman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtAlemanActionPerformed(evt);
            }
        });
        jPanel5.add(tbtAleman, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 399, -1, 55));

        jButton2.setText("Simular");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 508, -1, -1));

        prueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pruebaActionPerformed(evt);
            }
        });
        jPanel5.add(prueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 110, -1));

        jLabel21.setText("¿Cuanto cuesta el la casa?");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(469, 469, 469)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(530, 530, 530)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addGap(3, 3, 3)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 45, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1997, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String name = (String)jComboBox1.getSelectedItem();
        switch (name) {
            case "Automotriz":
                jPanel4.setVisible(true);
            jPanel2.setVisible(false);
             jPanel5.setVisible(true);
            
            break;
            case "Hipotecario":
                 jPanel4.setVisible(true);
                jPanel5.setVisible(false);
                jPanel2.setVisible(true);
                
            default:
            throw new AssertionError();
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tm.setRowCount(0);
        double costoAuto = Double.parseDouble(txtCostoAuto.getText());
        //int  meses = Integer.parseInt(txtMeses.getText());
        double entrada =Double.parseDouble(txtPrestamoSoli.getText());
        /*
        if(costoAuto == entrada){
            PrestamoAuto p1 = new PrestamoAuto(entrada, meses);
            for(int i = 0 ; i<= meses ; i++){
                tm.addRow(new Object[]{

                    i,
                    p1.calcularCapital(),

                    p1.calcularInteres(),
                    p1.calcularSeguroDesgravemen(),
                    p1.saldoTotal(),

                    p1.calcularSeguroIncendio(),
                    p1.calcularCuotaFrances(),
                });
            }
        }else{
            PrestamoAuto p1 = new PrestamoAuto(costoAuto, meses, entrada);
            for(int i = 0 ; i<= meses ; i++){
                tm.addRow(new Object[]{

                    i,
                    p1.calcularCapital(),

                    p1.calcularInteres(),
                    p1.calcularSeguroDesgravemen(),
                    p1.saldoTotal(),

                    p1.calcularSeguroIncendio(),
                    p1.calcularCuotaFrances(),

                });
            }
        }

        jTable1.setModel(tm);
        */
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void tbtFrancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtFrancesActionPerformed
       ButtonGroup  bg= new ButtonGroup();
       bg.add(tbtAleman);
       bg.add(tbtFrances);
      if(tbtAleman.isSelected()){
          prueba.setText("aleman");
      }else if(tbtFrances.isSelected() ){
          prueba.setText("frances");
      }
       
    }//GEN-LAST:event_tbtFrancesActionPerformed

    private void pruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pruebaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pruebaActionPerformed

    private void tbtAlemanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtAlemanActionPerformed
       if(tbtAleman.isSelected()){
          prueba.setText("aleman");
      }else if(tbtFrances.isSelected() ){
          prueba.setText("frances");
      }
    }//GEN-LAST:event_tbtAlemanActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Prestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prestamo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField prueba;
    private javax.swing.JToggleButton tbtAleman;
    private javax.swing.JToggleButton tbtFrances;
    private javax.swing.JTextField txtCostoAuto;
    private javax.swing.JTextField txtPrestamoSoli;
    // End of variables declaration//GEN-END:variables
}

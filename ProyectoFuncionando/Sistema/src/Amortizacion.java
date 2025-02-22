/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.text.MessageFormat;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class Amortizacion extends javax.swing.JFrame {

    /**
     * Creates new form Amortizacion
     */
    DefaultTableModel tm = new DefaultTableModel();
    private Prestamo p3;
    private double interes;
    private double capital;
    private double saldoTotal;
    private double MontoEstatico;
    private static double INTERES_MENSUAL;
    private static final double INTERES_NOMINAL = (11.03) / (12 * 100); // 11.03% nominal anual
    private static final double INTERES_ANUAL = (11.61) / (12 * 100); // 11.61% anual
    private double InteresFinal;

    public double getInteresFinal() {
        return InteresFinal;
    }

    public void setInteresFinal(double InteresFinal) {
        this.InteresFinal = InteresFinal;
    }

    public static double getINTERES_MENSUAL() {
        return INTERES_MENSUAL;
    }

    public static void setINTERES_MENSUAL(double INTERES_MENSUAL) {
        Amortizacion.INTERES_MENSUAL = INTERES_MENSUAL;
    }

    public double getMontoEstatico() {
        return MontoEstatico;
    }

    public void setMontoEstatico(double MontoEstatico) {
        this.MontoEstatico = MontoEstatico;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public Amortizacion() {
        initComponents();
        p3 = new Prestamo();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lbl1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));

        jTable1.setBackground(new java.awt.Color(102, 204, 255));
        jTable1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "No.Cuota", "Capital", "Interes", "Saldo de Capital", "Seguro de Desgravamen",
                        "Seguro Incendios", "Valor total de cuota"
                }) {
            Class[] types = new Class[] {
                    java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class,
                    java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("SI DESEA DESCARGAR LA TABLA DE CLICK AQUI");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("TABLA DE AMORTIZACION ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 904,
                                                Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                layout.createSequentialGroup()
                                                                        .addComponent(jLabel1)
                                                                        .addGap(261, 261, 261))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(jButton2,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 291,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(69, 69, 69)
                                                                .addComponent(lbl1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 84,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(84, 84, 84)))))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(23, 23, 23))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addComponent(jButton2)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void mostrarTablaFrancesa(double monto, double meses) {
        tm.setRowCount(0);
        // String ids[] = {"NoCuotas", "Saldo Final", "Capital Fija","Intereses", "
        // Valor de cuota","Seguro de Incendios", "Seguro de desgravamen"};
        String ids[] = { "NoCuotas", "Capital", "Interes", " Saldo Final", "Seguro de Desgravamen", "Seguro Incendios",
                "Valor cuota" };
        tm.setColumnIdentifiers(ids);
        PrestamoUno p1 = new PrestamoUno(monto, meses);

        for (int i = 1; i <= meses; i++) {
            tm.addRow(new Object[] {
                    i,

                    String.format("%.3f", p1.calcularAmortizacionPeriodo()),

                    String.format("%.3f", p1.calcularInteresPeriodo()),
                    String.format("%.3f", p1.calcularNuevoSaldo()),
                    String.format("%.3f", p1.calcularSeguroDesgravamen()),
                    String.format("%.3f", p1.calcularSeguroIncendios()),
                    String.format("%.3f", p1.calcularCuotaFija()),

            });
        }

        jTable1.setModel(tm);
        setjTable1(jTable1);
    }

    public void mostrarTablaAleman(double monto, double meses) {
        tm.setRowCount(0);
        String ids[] = { "NoCuotas", "Saldo Final", "Capital Fija", "Intereses", " Valor de cuota",
                "Seguro de Incendios", "Seguro de desgravamen" };
        tm.setColumnIdentifiers(ids);
        PrestamoDos p2 = new PrestamoDos(monto, meses);
        for (int i = 1; i <= meses; i++) {
            tm.addRow(new Object[] {
                    i,
                    String.format("%.3f", p2.calcularSaldoFinal()),
                    String.format("%.3f", p2.capitalFija()),
                    String.format("%.3f", p2.calcularInteres()),
                    String.format("%.3f", p2.calcularCuota()),
                    String.format("%.3f", p2.calcularSeguroIncendios()),
                    String.format("%.3f", p2.calcularSeguroDesgravamen()),

            });
        }

        jTable1.setModel(tm);
        setjTable1(jTable1);
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed

        MessageFormat m1 = new MessageFormat("Tabla De Amortizacion");

        MessageFormat m2 = new MessageFormat(" 1");
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.LANDSCAPE);
            jTable1.print(JTable.PrintMode.FIT_WIDTH, m1, m2, true, set, true);
            JOptionPane.showMessageDialog(null, "Pritned");
        } catch (java.awt.print.PrinterException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }// GEN-LAST:event_jButton2ActionPerformed

    public JTable getjTable1() {
        return jTable1;
    }

    public double sumarIntereses() {
        double Intereses = sumarColumna(getjTable1(), 2);
        return (Intereses / 1000);
    }

    public double sumarSeguroDesravamen() {
        double seguroDes = sumarColumna(getjTable1(), 4);
        return (seguroDes / 1000);
    }

    public double sumarColumna(JTable table, int columnIndex) {
        int total = 0;
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                // Obtener el valor de la celda, eliminar comas y convertir a número
                String valor = model.getValueAt(i, columnIndex).toString().replace(",", "");
                total += Double.parseDouble(valor);
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir fila " + i + ": " + e.getMessage());
            }
        }
        return total;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Amortizacion.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Amortizacion.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Amortizacion.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Amortizacion.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Amortizacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl1;
    // End of variables declaration//GEN-END:variables
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JButton botonEntrar;
    private JLabel jLabel1, jLabel5, jLabel6, txtError, fondo;
    private JTextField txtUser;
    private JPasswordField txtPass;

    public Login() {
        setTitle("Login");
        setSize(600, 450);
        setLocation(350,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        fondo = new JLabel(new ImageIcon("archivosPrestamos\\fondo2.jpg"));
        fondo.setBounds(0, 0, 600, 450);
        add(fondo);

        jLabel1 = new JLabel(new ImageIcon("archivosPrestamos\\Picture.jpg"));
        jLabel1.setBounds(230, 60, 100, 100);
        fondo.add(jLabel1);

        jLabel5 = new JLabel(new ImageIcon("archivosPrestamos\\userLogin.PNG"));
        jLabel5.setBounds(160, 180, 50, 40);
        fondo.add(jLabel5);

        jLabel6 = new JLabel(new ImageIcon("archivosPrestamos\\passwordLogin.PNG"));
        jLabel6.setBounds(160, 240, 50, 40);
        fondo.add(jLabel6);

        txtUser = new JTextField("Username");
        txtUser.setBounds(210, 180, 180, 40);
        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUser.setText("");
            }
        });
        fondo.add(txtUser);

        txtPass = new JPasswordField("Password");
        txtPass.setBounds(210, 240, 180, 40);
        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPass.setText("");
            }
        });
        fondo.add(txtPass);

        botonEntrar = new JButton(new ImageIcon("archivosPrestamos\\login.PNG"));
        botonEntrar.setBounds(180, 320, 200, 40);
        botonEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonEntrarActionPerformed();
            }
        });
        fondo.add(botonEntrar);

        txtError = new JLabel();
        txtError.setBounds(160, 410, 270, 20);
        txtError.setForeground(new java.awt.Color(255, 51, 51));
        fondo.add(txtError);
    }

    private void botonEntrarActionPerformed() {
        String user = txtUser.getText();
        String pass = txtPass.getText();
        LoginLogic l1 = new LoginLogic(user,pass);
       
        if(l1.isAutorized()){//verifica que el usuario este autorizado
      
         PantallaInicial pantalla1 = new PantallaInicial();
         pantalla1.setVisible(true);
         this.dispose();
        
           
        }else{
           JOptionPane.showMessageDialog(null,"Datos incorrectos","Error",0);        
        }
    }

   
}



// * @author oscar
// /
 
// ublic class Login extends javax.swing.JFrame {

// /**
// * Creates new form Login
// 
// c Login() {
// omponents();
// 
 
// 
// * This method is called from within the constructor to initialize the form.
// RNING: Do NOT modify this code. The content of this method is always
// enerated by the Form Editor.
// 
// ressWarnings("unchecked")
// ditor-fold defaultstate="collapsed" desc="Generated
// ">//GEN-BEGIN:initComponents
// ate void initComponents() {
// 
 
// botonEntrar = new javax.swing.JButton();
// = new javax.swing.JLabel();
// = new javax.swing.JLabel();
// = new javax.swing.JLabel();
// = new javax.swing.JTextField();
// = new javax.swing.JTextField();
//  = new javax.swing.JLabel();
// = new javax.swing.JLabel();
// ld1 = new javax.swing.JTextField();
 
// setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
// ntPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
 
// botonEntrar.setIcon(new
// ing.ImageIcon(getClass(
// .getResource("/com/sistematransaccional/GUI/login.PNG")));
// 
// N
// addActionListener(new java.awt.event.ActionListener() {
// onPerformed(java.awt.event.ActionEvent evt) {
// ctionPerformed(evt);
// 
// 
// 
// getContentPane().add(botonEntrar, new
// eans.lib.awtextra.A
// soluteConstraints(180, 320, 200, 40));
// 
 
// 
// jLabel1.setIcon(new
// ing.ImageIcon(getCl
// ss().getResource("/com/sistematransaccional/GUI/Picture.jpg")));
// 
// N
// 
// getContentPane().add(jLabel1, new
// eans.lib.awtextra.A
// soluteConstraints(230, 60, -1, -1));
// 
 
// 
// jLabel5.setIcon(new
// ing.ImageIcon(getClass().getResource("/com/sistematransaccional/GUI/userLogin.PNG")));
// N
// ne().add(jLabel5, new
// .awtextra.AbsoluteConstraints(160, 180, 50, 40));
 
// con(new
// eIcon(getClass().getResource("/com/sistematransaccional/GUI/passwordLogin.PNG")));
// 
// ntPane().add(jLabel6, new
// eans.lib.awtextra.AbsoluteConstraints(160, 240, 50, 40));
 
// "Username");
// ocusListener(new java.awt.event.FocusAdapter() {
// oid focusGained(java.awt.event.FocusEvent evt) {
// ocusGained(evt);
// 
// }
// oid focusLost(java.awt.event.FocusEvent evt) {
// ocusLost(evt);
// 
// 
// ctionListener(new java.awt.event.ActionListener() {
// oid actionPerformed(java.awt.event.ActionEvent evt) {
// ctionPerformed(evt);
// 
// 
// ne().add(txtUser, new
// eans.lib.awtextra.AbsoluteConstraints(210, 180, 180, 40));
 
// 
// txtPass.setText("Password");
// addFocusListener(new java.awt.event.FocusAdapter() {
// oid focusGained(java.awt.event.FocusEvent evt) {
// ocusGained(evt);
// 
// }
// 
// 
// 
// addActionListener(new java.awt.ev
// nt.ActionListener() {
// public void actionPerformed(java.awt.event.ActionEvent evt) {
// ctionPerformed(evt);
// 
// 
// });
// ntPane().add(txtPass, new
// netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 180, 40));

// rror.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
// 

// ontentPane().add(txtError, new
// org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 270, -1));
 
// 

// x.swing.ImageIcon(getClass().getResource("/com/sistematransaccional/GUI/fondo2.jpg")));
// // NOI18N
// ontentPane().add(jLabel2, new
// 
// eans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 470));
 
// jTextField1.setText("jTextField1");
// ontentPane().add(jTextField1, new
// 
// eans.lib.awtextra.AbsoluteConstraints(500, 160, 20, -1));
 
// pack();
// </editor-fold>//GEN-END:initComponents
// 

// ate void txtUserActionPerformed(java.awt.event.ActionEvent evt)
// {//GEN-FIRST:event_txtUserActionPerformed
 
// 
// //GEN-LAST:e
 
// ate void txtPassActionPerformed(java.awt.event.ActionEvent evt)
// 
// IRST:event_txtPassActionPerformed
 
// AST:event_txtPassActionPerformed

// void txtUserFocusGained(java.awt.event.FocusEvent evt)

// etText("");
// ST:event_txtUserFocusGained
 

// setText("");
// event_txtPassFocusGained

// void txtUserFocusLost(java.awt.event.FocusEvent evt)
// EN-FIRST:event_txtUserFocusLost

// EN-LAST:event_txtUserFocusLost
// 
// e metodo va a hacer que el usuario entre al sigueinte pantalla inciial ,
// ndiendo si esta autorizado o no
//  evt
// 
// 
// void botonEntrarActionPerformed(java.awt.event.ActionEvent evt)
// 
// RST:event_botonEn
// rarActionPerformed
// er = txtUser.getText();
// ass = txtPass.getText();
// 1 = new LoginLogic(user,pass);
// 
 
// {//verifica que el usuario este autorizado
 
// pantalla1 = new PantallaInicial();
// tVisible(true);
// pose();
 
// 
// 
// Text("Datos Incorrectos");
// 
 
// 
// 
// AST:event_botonEntrarActionPerformed
 
// 
// 
//  args the command line arguments
// */
// tatic void main(String args[]) {
// he Nimbus look and feel */
// ld defaultstate="collapsed" desc=" Look and feel setting code
// 
//  (introduced in Java SE 6) is not available, stay with the
// look and feel.
// r details see
// http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
// 
// {
// (javax.swing.UIManager.LookAndFeelInfo info :
// x.swing.UIManager.getInstalledLookAndFeels()) {
// "Nimbus".equals(info.getName())) {
// x.swing.UIManager.setLookAndFeel(info.getClassName());
// k;
// 
// 
// tch (ClassNotFoundException ex) {
// .util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
// nll, ex);
// } catch (InstantiationException ex) {
// java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
// null, ex);
// } catch (IllegalAccessException ex) {
// java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
// null, ex);
// } catch (javax.swing.UnsupportedLookAndFeelException ex) {
// java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
// null, ex);
// }
// //</editor-fold>

// /* Create and display the form */
// java.awt.EventQueue.invokeLater(new Runnable() {
// public void run() {
// new Login().setVisible(true);
// }
// });
// }

// // Variables declaration - do not modify//GEN-BEGIN:variables
// private javax.swing.JButton botonEntrar;
// private javax.swing.JLabel jLabel1;
// private javax.swing.JLabel jLabel2;
// private javax.swing.JLabel jLabel5;
// private javax.swing.JLabel jLabel6;
// private javax.swing.JTextField jTextField1;
// private javax.swing.JLabel txtError;
// private javax.swing.JTextField txtPass;
// private javax.swing.JTextField txtUser;
// // End of variables declaration//GEN-END:variables
// }